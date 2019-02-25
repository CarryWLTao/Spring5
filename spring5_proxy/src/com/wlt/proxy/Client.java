package com.wlt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 一个消费者
 * 
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		final ComputerFactory factory = new ComputerFactory();
		// 有经销商为我们联系厂家提供电脑
		/**
		 * 动态代理 
		 * 	特点:
		 * 		字节码随用随创建,随用随加载 
		 * 	分类:
		 * 		基于接口的 基于子类的 
		 * 	作用: 
		 * 		在不改变源码的基础上对已有方法增强 
		 * 此类讲解的是基于接口的动态代理
		 * 	提供者:JDK官方 
		 * 	涉及的类:Proxy 
		 * 	创建代理对象的方法:newProxyInstance 
		 * 	方法参数:
		 * 		ClassLoader:类加载器和被代理对象使用相同的类加载器.该参数是固定写法
		 * 		Class[]:字节码数组.和被代理对象具有相同的行为.实现相同的接口.该参数 也是固定写法
		 * 		InvocationHandler:它是一个接口.提供如何代理的代码.也就是增强的代码.
		 * 						     该参数一般都写成匿名内部类 并且他是策略模式的体现 
		 * 			策略模式:
		 * 				要求:数据已经有了,目的明确 达成目标的过程就是策略 该参数是谁用谁写 
		 * 使用要求: 被代理类最少实现一个接口
		 */
		IAgent proxyFactory = (IAgent) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
				factory.getClass().getInterfaces(), new InvocationHandler() {
					/**
					 * 该方法的特征: 执行被代理对象的任何方法,都会经过该方法.该方法有拦截的特点 方法参数: Object proxy:代理对象的引用 Method
					 * method:当前执行的方法 Object[] args:当前执行方法所需的参数 方法的返回值: Object:和被代理对象的方法返回值一致.
					 * 
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object rtValue = null;
						// 获取正在执行方法的参数
						Float money = (Float) args[0];
						// 判断正在执行的方法
						if ("sale".equals(method.getName())) {
							// 经销商最少一台电脑挣2000元钱
							if (money > 7000) {
								rtValue = method.invoke(factory, money / 2);
							}

						}
						if ("afterService".equals(method.getName())) {
							// 经销商最少一台电脑挣600元
							if (money > 1600) {
								rtValue = method.invoke(factory, money / 4 * 3);
							}
						}
						return rtValue;
					}
				});
		proxyFactory.sale(7000f);
		proxyFactory.afterService(1500f);

		/*
		 * factory.sale(5000f);
		 * 
		 * factory.afterService(1000f);
		 */
	}

}
