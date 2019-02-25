package com.wlt.proxy;

/**
 * 一个电脑生产厂家
 * @author Administrator
 *
 */
public class ComputerFactory implements IAgent{
	/**
	 * 销售电脑
	 * @param money
	 */
	public void sale(Float money) {
		System.out.println("收到钱,把电脑给消费者"+money);
	}
	/**
	 * 售后服务
	 * @param money
	 */
	public void afterService(Float money) {
		System.out.println("收到钱,开始给消费者提供售后服务"+money);
	}

}
