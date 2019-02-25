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
 * 一个通知类,用于对业务层方法增强,模拟记录日志
 * @author Administrator
 *
 */
@Component("logger")
@Aspect//把当前类配置成一个切面
public class Logger {
	
	@Pointcut("execution(* com.wlt.service.impl.*.*(..))")
	private void pt1() {
		
	}
	/**
	 * 计划让其在切入点方法执行之前执行
	 * 前置通知
	 */
	@Before("pt1()")
	public void beforePrintLog() {
		System.out.println("Logger类中的beforePrintLog方法开始记录日志了....前置");
	}
	/**
	 * 后置通知
	 */
	@AfterReturning("pt1()")
	public void afterReturningPrintLog() {
		System.out.println("Logger类中的afterReturningPrintLog方法开始记录日志了....后置");
	}
	/**
	 * 异常通知
	 */
	@AfterThrowing("pt1()")
	public void afterThrowingPrintLog() {
		System.out.println("Logger类中的afterThrowingPrintLog方法开始记录日志了....异常");
	}
	/**
	 * 最终通知
	 */
	@After("pt1()")
	public void afterPrintLog() {
		System.out.println("Logger类中的afterPrintLog方法开始记录日志了....最终");
	}
	/**
	 * 环绕通知
	 * 		问题:
	 * 			当我们配置了环绕通知后,执行切入点方法时,最终的结果是环绕通知代码执行了,而切入点方法却没有执行.
	 * 		分析:
	 * 			根据动态代理的代码分析,可以看到invoke方法中有一个明确的调用切入点方法的代码,而我们spring中的环绕通知
	 * 			目前没有调用切入点方法
	 * 		解决办法:
	 * 			思路:我们也需要在环绕通知里明确调用一下切入点方法
	 * 			Spring框架为我们提供了一个接口:ProceedingJoinPoint.该接口可以作为环绕通知的方法参数来使用
	 * 			在程序运行时spring框架会为我们注入该接口的实现类提供我们使用
	 * 		该接口有个方法:
	 * 			proceed()方法:他就相当于明确调用切入点方法
	 * 
	 * 		他是spring为我们提供的一种可以在代码中手动控制通知何时执行的方式
	 * 	
	 * 
	 */
	@Around("execution(* com.wlt.service.impl.*.*(..))")
	public Object aroundPrintLog(ProceedingJoinPoint pjp) {
		Object rtValue=null;
		try {
			System.out.println("Logger类中的aroundPrintLog方法开始记录日志了....前置");
			//获取方法所需的参数
			Object[] args = pjp.getArgs();
			rtValue = pjp.proceed(args);
			System.out.println("Logger类中的aroundPrintLog方法开始记录日志了....后置");
		} catch (Throwable e) {
			System.out.println("Logger类中的aroundPrintLog方法开始记录日志了....异常");
			e.printStackTrace();
		}finally {
			System.out.println("Logger类中的aroundPrintLog方法开始记录日志了....最终");
		}
		return rtValue;
		
	}
	

}
