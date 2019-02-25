package com.wlt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
		 * ���ི����ǻ��ڽӿڵĶ�̬����
		 * 	�ṩ��:JDK�ٷ� 
		 * 	�漰����:Proxy 
		 * 	�����������ķ���:newProxyInstance 
		 * 	��������:
		 * 		ClassLoader:��������ͱ��������ʹ����ͬ���������.�ò����ǹ̶�д��
		 * 		Class[]:�ֽ�������.�ͱ�������������ͬ����Ϊ.ʵ����ͬ�Ľӿ�.�ò��� Ҳ�ǹ̶�д��
		 * 		InvocationHandler:����һ���ӿ�.�ṩ��δ���Ĵ���.Ҳ������ǿ�Ĵ���.
		 * 						     �ò���һ�㶼д�������ڲ��� �������ǲ���ģʽ������ 
		 * 			����ģʽ:
		 * 				Ҫ��:�����Ѿ�����,Ŀ����ȷ ���Ŀ��Ĺ��̾��ǲ��� �ò�����˭��˭д 
		 * ʹ��Ҫ��: ������������ʵ��һ���ӿ�
		 */
		IAgent proxyFactory = (IAgent) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
				factory.getClass().getInterfaces(), new InvocationHandler() {
					/**
					 * �÷���������: ִ�б����������κη���,���ᾭ���÷���.�÷��������ص��ص� ��������: Object proxy:������������ Method
					 * method:��ǰִ�еķ��� Object[] args:��ǰִ�з�������Ĳ��� �����ķ���ֵ: Object:�ͱ��������ķ�������ֵһ��.
					 * 
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
		proxyFactory.sale(7000f);
		proxyFactory.afterService(1500f);

		/*
		 * factory.sale(5000f);
		 * 
		 * factory.afterService(1000f);
		 */
	}

}
