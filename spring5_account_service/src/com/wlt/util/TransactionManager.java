package com.wlt.util;

import java.sql.SQLException;

import com.wlt.dbAssit.DBAssit;

/**
 * �����������صĹ�����
 * 
 * @author Administrator
 *
 */
public class TransactionManager {

	private static DBAssit dbAssit = new DBAssit(C3P0Util.getDataSource(), true);

	/**
	 * ��������(���Զ��ύ����)
	 */
	public static void beginTransaction() {
		try {
			dbAssit.getCurrentConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ύ����
	 */
	public static void commit() {
		try {
			dbAssit.getCurrentConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ع�����
	 */
	public static void rollback() {
		try {
			dbAssit.getCurrentConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ͷ���Դ
	 */
	public static void release() {
		try {
			dbAssit.releaseConnection();;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
