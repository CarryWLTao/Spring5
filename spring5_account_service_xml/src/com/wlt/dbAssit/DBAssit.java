package com.wlt.dbAssit;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.wlt.handler.ResultSetHandler;

/**
 * ���ݿ��������
 * 
 * @author Administrator
 *
 */
public class DBAssit {
	// ����һ������Դ
	private DataSource dataSource;

	// �ṩһ��set����ע��
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// ����һ������,��������Connection���߳��Ƿ��
	private boolean useCurrentConnection = false;//Ĭ��ֵ:����

	// �ṩһ��set����,���������Ƿ���Ҫ�̰߳�Connection
	public void setUseCurrentConnection(boolean useCurrentConnection) {
		this.useCurrentConnection = useCurrentConnection;
	}

	/**
	 * ��ȡ��ǰ����ʹ�õ�Connection���� �Ƿ���̰߳���Ҫ��userCurrentConnection������ȡֵ
	 * 
	 * @return
	 */
	public Connection getCurrentConnection() {
		return DataSourceUtils.getCurrentConnection(this.dataSource, this.useCurrentConnection);
	}
	/**
	 * �ͷ�Connection
	 */
	public void releaseConnection() {
		DataSourceUtils.releaseConnection(getCurrentConnection());
	}

	// Ĭ�Ϲ��캯��
	public DBAssit() {
	}

	/**
	 * ÿ������������Ĵ��ι���
	 * 
	 * @param dataSource
	 *            ����Դ
	 */
	public DBAssit(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * ��Ҫ������乫��ͬһ����Ĵ��ι���
	 * 
	 * @param dataSource
	 *            ����Դ
	 * @param useCurrentConnection
	 *            �Ƿ���Ҫ�̰߳�
	 */
	public DBAssit(DataSource dataSource, boolean useCurrentConnection) {
		this.dataSource = dataSource;
		this.useCurrentConnection = useCurrentConnection;
	}

	/**
	 * ��ɾ�ķ���
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object... params) {
		//����Ķ���
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			//��ȡConnection
			conn = getCurrentConnection();
			//��ȡԤ�����������
			pstm = conn.prepareStatement(sql);
			//ͨ�����ݿ��Ԫ��Ϣ
			ParameterMetaData pmd = pstm.getParameterMetaData();
			//��ȡ���Ĳ�������
			int count = pmd.getParameterCount();
			//�жϲ����Ƿ�ƥ��
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
				throw new IllegalArgumentException("û�д�����Ч����");
			}
			if (count != params.length) {
				throw new IllegalArgumentException("ռλ�������Ͳ���������ƥ��");
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
