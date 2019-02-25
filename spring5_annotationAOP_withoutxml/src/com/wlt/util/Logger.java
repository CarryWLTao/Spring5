package com.wlt.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * һ��֪ͨ��,���ڶ�ҵ��㷽����ǿ,ģ���¼��־
 * @author Administrator
 *
 */
@Component("logger")
@Aspect//�ѵ�ǰ�����ó�һ������
public class Logger {
	
	@Pointcut("execution(* com.wlt.service.impl.*.*(..))")
	private void pt1() {
		
	}
	/**
	 * �ƻ�����������㷽��ִ��֮ǰִ��
	 * ǰ��֪ͨ
	 */
	@Before("pt1()")
	public void beforePrintLog() {
		System.out.println("Logger���е�beforePrintLog������ʼ��¼��־��....ǰ��");
	}
	/**
	 * ����֪ͨ
	 */
	@AfterReturning("pt1()")
	public void afterReturningPrintLog() {
		System.out.println("Logger���е�afterReturningPrintLog������ʼ��¼��־��....����");
	}
	/**
	 * �쳣֪ͨ
	 */
	@AfterThrowing("pt1()")
	public void afterThrowingPrintLog() {
		System.out.println("Logger���е�afterThrowingPrintLog������ʼ��¼��־��....�쳣");
	}
	/**
	 * ����֪ͨ
	 */
	@After("pt1()")
	public void afterPrintLog() {
		System.out.println("Logger���е�afterPrintLog������ʼ��¼��־��....����");
	}
	/**
	 * ����֪ͨ
	 * 		����:
	 * 			�����������˻���֪ͨ��,ִ������㷽��ʱ,���յĽ���ǻ���֪ͨ����ִ����,������㷽��ȴû��ִ��.
	 * 		����:
	 * 			���ݶ�̬����Ĵ������,���Կ���invoke��������һ����ȷ�ĵ�������㷽���Ĵ���,������spring�еĻ���֪ͨ
	 * 			Ŀǰû�е�������㷽��
	 * 		����취:
	 * 			˼·:����Ҳ��Ҫ�ڻ���֪ͨ����ȷ����һ������㷽��
	 * 			Spring���Ϊ�����ṩ��һ���ӿ�:ProceedingJoinPoint.�ýӿڿ�����Ϊ����֪ͨ�ķ���������ʹ��
	 * 			�ڳ�������ʱspring��ܻ�Ϊ����ע��ýӿڵ�ʵ�����ṩ����ʹ��
	 * 		�ýӿ��и�����:
	 * 			proceed()����:�����൱����ȷ��������㷽��
	 * 
	 * 		����springΪ�����ṩ��һ�ֿ����ڴ������ֶ�����֪ͨ��ʱִ�еķ�ʽ
	 * 	
	 * 
	 */
	@Around("execution(* com.wlt.service.impl.*.*(..))")
	public Object aroundPrintLog(ProceedingJoinPoint pjp) {
		Object rtValue=null;
		try {
			System.out.println("Logger���е�aroundPrintLog������ʼ��¼��־��....ǰ��");
			//��ȡ��������Ĳ���
			Object[] args = pjp.getArgs();
			rtValue = pjp.proceed(args);
			System.out.println("Logger���е�aroundPrintLog������ʼ��¼��־��....����");
		} catch (Throwable e) {
			System.out.println("Logger���е�aroundPrintLog������ʼ��¼��־��....�쳣");
			e.printStackTrace();
		}finally {
			System.out.println("Logger���е�aroundPrintLog������ʼ��¼��־��....����");
		}
		return rtValue;
		
	}
	

}
