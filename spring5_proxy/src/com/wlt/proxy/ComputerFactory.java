package com.wlt.proxy;

/**
 * һ��������������
 * @author Administrator
 *
 */
public class ComputerFactory implements IAgent{
	/**
	 * ���۵���
	 * @param money
	 */
	public void sale(Float money) {
		System.out.println("�յ�Ǯ,�ѵ��Ը�������"+money);
	}
	/**
	 * �ۺ����
	 * @param money
	 */
	public void afterService(Float money) {
		System.out.println("�յ�Ǯ,��ʼ���������ṩ�ۺ����"+money);
	}

}
