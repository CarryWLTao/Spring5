package com.wlt.proxy;

/**
 * һ��������,���ܻ����ܶ೧��
 * @author Administrator
 *
 */
public interface IAgent {
	
	/**
	 * ���۵���
	 * @param money
	 */
	public void sale(Float money);
	/**
	 * �ۺ����
	 * @param money
	 */
	public void afterService(Float money);

}
