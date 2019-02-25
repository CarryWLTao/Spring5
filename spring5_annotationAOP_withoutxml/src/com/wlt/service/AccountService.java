package com.wlt.service;

import org.springframework.stereotype.Service;

/**
 * 账户的业务层接口
 * @author Administrator
 *
 */

public interface AccountService {
	/**
	 * 模拟保存方法:无返回值无参数
	 */
	void saveAccount();
	/**
	 * 模拟更新方法:无返回值有参数
	 * @param i
	 */
	void updateAccount(int i);
	/**
	 * 模拟删除方法:有返回值无参数
	 * @return
	 */
	int deleteAccount();

}
