package com.wlt.util;

import java.sql.SQLException;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wlt.dbAssit.DBAssit;



/**
 * �����������صĹ�����   �����˹������������Ϊ֪ͨ��  ����ĵķ�����֪ͨ����
 * 
 * @author Administrator
 *
 */
@Component("transactionManager")
@Aspect
public class TransactionManager {
	@Autowired
	private  DBAssit dbAssit;
	@Pointcut("execution(* com.wlt.service.impl.*.*(..))")
	private void pt1(){
		
	}
	/**
	 * ��������(���Զ��ύ����)
	 */
	@Before("pt1()")
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
	@AfterReturning("pt1()")
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
	@AfterThrowing("pt1()")
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
	@After("pt1()")
	public  void release() {
		try {
			dbAssit.releaseConnection();;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
