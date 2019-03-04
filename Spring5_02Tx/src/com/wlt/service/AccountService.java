package com.wlt.service;

import com.wlt.domain.Account;

/**
 * 账户的业务层接口
 * @author Administrator
 *
 */
public interface AccountService {
	/**
	 * 转账
	 * @param sourceName 转出账户名称
	 * @param targetName 转入账户名称
	 * @param money 转账金额
	 */
	void transfer(String sourceName,String targetName,Float money);
	/**
	 * 根据id查询账户信息
	 * @param accountId
	 * @return
	 */
	Account findAccountById(Integer accountId);

}
