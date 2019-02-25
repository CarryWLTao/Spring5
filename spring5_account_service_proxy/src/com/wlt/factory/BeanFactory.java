package com.wlt.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.wlt.service.AccountService;
import com.wlt.service.impl.AccountServiceImpl;
import com.wlt.util.TransactionManager;

/**
 * 用于生产业务层代理对象的工厂类
 * @author Administrator
 *
 */
public class BeanFactory {
	/**
	 * 用于创建代理对象
	 * @return
	 */
	public static AccountService getProxyAccountService(){
		 final AccountService accountService=new AccountServiceImpl();
		AccountService proxyAccountService=(AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),new InvocationHandler() {
					/**
					 * 添加事务的支持
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if("test".equals(method.getName())) {
							return method.invoke(accountService, args);
						}
						Object rtValue=null;
						try {
							//开启事务
							TransactionManager.beginTransaction();
							//执行调用业务层方法
							rtValue=method.invoke(accountService, args);
							//提交事务
							TransactionManager.commit();
						} catch (Exception e) {
							//回滚事务
							TransactionManager.rollback();
							e.printStackTrace();
						}finally {
							//释放资源
							TransactionManager.release();
						}
						return rtValue;
					}
				});
		return proxyAccountService;
	}

}
