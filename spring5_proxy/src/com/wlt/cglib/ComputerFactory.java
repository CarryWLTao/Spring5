package com.wlt.cglib;

/**
 * һ��������������
 * @author Administrator
 *
 */
public class ComputerFactory {
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
