package com.wlt.util;

/**
 * 一个通知类,用于对业务层方法增强,模拟记录日志
 * @author Administrator
 *
 */
public class Logger {
	/**
	 * 计划让其在切入点方法执行之前执行
	 */
	public void beforePrintLog() {
		System.out.println("Logger类中的beforePrintLog方法开始记录日志了....");
	}

}
