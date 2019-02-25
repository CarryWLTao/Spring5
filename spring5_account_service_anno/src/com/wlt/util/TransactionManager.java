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
 * 和事务管理相关的工具类   定义了公共方法的类称为通知类  里面的的方法叫通知方法
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
	 * 开启事务(把自动提交关了)
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
	 * 提交事务
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
	 * 回滚事务
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
	 * 释放资源
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
