package com.wlt.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.wlt.service.AccountService;
import com.wlt.service.impl.AccountServiceImpl;
import com.wlt.util.TransactionManager;

/**
 * ��������ҵ���������Ĺ�����
 * @author Administrator
 *
 */
public class BeanFactory {
	/**
	 * ���ڴ����������
	 * @return
	 */
	public static AccountService getProxyAccountService(){
		 final AccountService accountService=new AccountServiceImpl();
		AccountService proxyAccountService=(AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),new InvocationHandler() {
					/**
					 * ��������֧��
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if("test".equals(method.getName())) {
							return method.invoke(accountService, args);
						}
						Object rtValue=null;
						try {
							//��������
							TransactionManager.beginTransaction();
							//ִ�е���ҵ��㷽��
							rtValue=method.invoke(accountService, args);
							//�ύ����
							TransactionManager.commit();
						} catch (Exception e) {
							//�ع�����
							TransactionManager.rollback();
							e.printStackTrace();
						}finally {
							//�ͷ���Դ
							TransactionManager.release();
						}
						return rtValue;
					}
				});
		return proxyAccountService;
	}

}
