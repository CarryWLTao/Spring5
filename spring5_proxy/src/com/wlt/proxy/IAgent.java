package com.wlt.proxy;

/**
 * 一个经销商,可能会代理很多厂家
 * @author Administrator
 *
 */
public interface IAgent {
	
	/**
	 * 销售电脑
	 * @param money
	 */
	public void sale(Float money);
	/**
	 * 售后服务
	 * @param money
	 */
	public void afterService(Float money);

}
