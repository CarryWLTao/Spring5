package com.wlt.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import oracle.jrockit.jfr.events.EventHandlerCreator;

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
		 * 	此类讲解的是基于子类的动态代理 
		 * 		提供者:cglib 
		 * 		涉及的类:Ehancer 
		 * 		创建代理对象的方法:create 
		 * 		方法参数:
		 * 			Class:字节码.指定被代理对象的字节码
		 * 			Callback:如何代理
		 * 			
		 * 		使用要求: 被代理类不能是最终类
		 */
		Callback cb=null;
		ComputerFactory cglibFactory = (ComputerFactory) Enhancer.create(factory.getClass(), new MethodInterceptor() {
			/**
			 * 它和InvocationHandler的invoke方法作用是一样的
			 * 该方法的前三个参数和invoke方法的三个参数作用是一样的
			 * 该方法的返回值和invoke方法的返回值作用也是一样的
			 * 
			 * MethodProxy:他是当前执行方法的代理对象
			 * 
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
		cglibFactory.sale(10000f);
		cglibFactory.afterService(6000f);
	}
}