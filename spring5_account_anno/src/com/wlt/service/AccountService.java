package com.wlt.service;

import java.util.List;

import com.wlt.domain.Account;

/**
 * 账户的业务层接口
 * @author Administrator
 *
 */
public interface AccountService {
	/**
	 * 保存账户
	 * @param account
	 */
	void saveAccount(Account account);
	/**
	 * 更新账户
	 * @param account
	 */
	void updateAccount(Account account);
	/**
	 * 删除用户
	 * @param account
	 */
	void deleteAccount(Integer accountId);
	/**
	 * 根据id查询用户
	 * @param account
	 * @return
	 */
	Account findAccountById(Integer accountId);
	/**
	 * 查询所有账户
	 * @return
	 */
	List<Account> findAllAccount();

}
