package com.wlt.util;

import java.sql.SQLException;

import com.wlt.dbAssit.DBAssit;

/**
 * 和事务管理相关的工具类   定义了公共方法的类称为通知类  里面的的方法叫通知方法
 * 
 * @author Administrator
 *
 */
public class TransactionManager {

	private  DBAssit dbAssit;
	

	public  void setDbAssit(DBAssit dbAssit) {
		this.dbAssit = dbAssit;
	}

	/**
	 * 开启事务(把自动提交关了)
	 */
	public  void beginTransaction() {
		try {
			dbAssit.getCurrentConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 提交事务
	 */
	public  void commit() {
		try {
			dbAssit.getCurrentConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 回滚事务
	 */
	public  void rollback() {
		try {
			dbAssit.getCurrentConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 释放资源
	 */
	public  void release() {
		try {
			dbAssit.releaseConnection();;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
