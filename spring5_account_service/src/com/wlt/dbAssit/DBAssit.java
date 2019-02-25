package com.wlt.dbAssit;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.wlt.handler.ResultSetHandler;

/**
 * 数据库操作助手
 * 
 * @author Administrator
 *
 */
public class DBAssit {
	// 定义一个数据源
	private DataSource dataSource;

	// 提供一个set方法注入
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// 定义一个变量,用于设置Connection和线程是否绑定
	private boolean useCurrentConnection = false;//默认值:不绑定

	// 提供一个set方法,用于设置是否需要线程绑定Connection
	public void setUseCurrentConnection(boolean useCurrentConnection) {
		this.useCurrentConnection = useCurrentConnection;
	}

	/**
	 * 获取当前正在使用的Connection对象 是否和线程绑定需要看userCurrentConnection变量和取值
	 * 
	 * @return
	 */
	public Connection getCurrentConnection() {
		return DataSourceUtils.getCurrentConnection(this.dataSource, this.useCurrentConnection);
	}
	/**
	 * 释放Connection
	 */
	public void releaseConnection() {
		DataSourceUtils.releaseConnection(getCurrentConnection());
	}

	// 默认构造函数
	public DBAssit() {
	}

	/**
	 * 每条语句独立事务的带参构造
	 * 
	 * @param dataSource
	 *            数据源
	 */
	public DBAssit(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 需要多条语句公用同一事务的带参构造
	 * 
	 * @param dataSource
	 *            数据源
	 * @param useCurrentConnection
	 *            是否需要线程绑定
	 */
	public DBAssit(DataSource dataSource, boolean useCurrentConnection) {
		this.dataSource = dataSource;
		this.useCurrentConnection = useCurrentConnection;
	}

	/**
	 * 增删改方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object... params) {
		//对象的定义
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			//获取Connection
			conn = getCurrentConnection();
			//获取预处理操作对象
			pstm = conn.prepareStatement(sql);
			//通过数据库的元信息
			ParameterMetaData pmd = pstm.getParameterMetaData();
			//获取语句的参数个数
			int count = pmd.getParameterCount();
			//判断参数是否匹配
			setParameter(pstm, count, params);
			
			return pstm.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			close(conn, pstm, Boolean.valueOf(this.useCurrentConnection));
		}
	}

	public <T> Object query(String sql, ResultSetHandler rsh, Object... params) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = this.dataSource.getConnection();

			pstm = conn.prepareStatement(sql);

			ParameterMetaData pmd = pstm.getParameterMetaData();

			int count = pmd.getParameterCount();

			setParameter(pstm, count, params);
			return rsh.handler(pstm.executeQuery());
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			close(conn, pstm, Boolean.valueOf(this.useCurrentConnection));
		}
	}

	private void setParameter(PreparedStatement pstm, int count, Object[] params) throws SQLException {
		if (count > 0) {
			if (params == null) {
				throw new IllegalArgumentException("没有传入有效参数");
			}
			if (count != params.length) {
				throw new IllegalArgumentException("占位符个数和参数个数不匹配");
			}
			for (int i = 0; i < count; i++) {
				pstm.setObject(i + 1, params[i]);
			}
		}
	}

	private void close(Connection conn, PreparedStatement pstm, Object o) {
		if (this.useCurrentConnection) {
			return;
		}
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
			if (!pstm.isClosed()) {
				pstm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
