package com.wlt.util;

import java.sql.SQLException;

import com.wlt.dbAssit.DBAssit;

/**
 * �����������صĹ�����   �����˹������������Ϊ֪ͨ��  ����ĵķ�����֪ͨ����
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
	 * ��������(���Զ��ύ����)
	 */
	public  void beginTransaction() {
		try {
			dbAssit.getCurrentConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ύ����
	 */
	public  void commit() {
		try {
			dbAssit.getCurrentConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ع�����
	 */
	public  void rollback() {
		try {
			dbAssit.getCurrentConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ͷ���Դ
	 */
	public  void release() {
		try {
			dbAssit.releaseConnection();;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
