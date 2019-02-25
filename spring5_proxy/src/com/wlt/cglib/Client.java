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
 * һ��������
 * 
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		final ComputerFactory factory = new ComputerFactory();
		// �о�����Ϊ������ϵ�����ṩ����
		/**
		 * ��̬���� 
		 * 	�ص�:
		 * 		�ֽ��������洴��,��������� 
		 * 	����:
		 * 		���ڽӿڵ� ��������� 
		 * 	����: 
		 * 		�ڲ��ı�Դ��Ļ����϶����з�����ǿ
		 * 	���ི����ǻ�������Ķ�̬���� 
		 * 		�ṩ��:cglib 
		 * 		�漰����:Ehancer 
		 * 		�����������ķ���:create 
		 * 		��������:
		 * 			Class:�ֽ���.ָ�������������ֽ���
		 * 			Callback:��δ���
		 * 			
		 * 		ʹ��Ҫ��: �������಻����������
		 */
		Callback cb=null;
		ComputerFactory cglibFactory = (ComputerFactory) Enhancer.create(factory.getClass(), new MethodInterceptor() {
			/**
			 * ����InvocationHandler��invoke����������һ����
			 * �÷�����ǰ����������invoke��������������������һ����
			 * �÷����ķ���ֵ��invoke�����ķ���ֵ����Ҳ��һ����
			 * 
			 * MethodProxy:���ǵ�ǰִ�з����Ĵ������
			 * 
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				Object rtValue = null;
				// ��ȡ����ִ�з����Ĳ���
				Float money = (Float) args[0];
				// �ж�����ִ�еķ���
				if ("sale".equals(method.getName())) {
					// ����������һ̨������2000ԪǮ
					if (money > 7000) {
						rtValue = method.invoke(factory, money / 2);
					}

				}
				if ("afterService".equals(method.getName())) {
					// ����������һ̨������600Ԫ
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