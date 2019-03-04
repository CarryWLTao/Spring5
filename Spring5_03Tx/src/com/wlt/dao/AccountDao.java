package com.wlt.dao;

import com.wlt.domain.Account;

/**
 * 账户操作Dao
 * @author Administrator
 *
 */
public interface AccountDao {
	/**
	 * 根据id查询账户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Account  findAccountById(Integer accountId);
	
	Account  findAccountByName(String name);
	/**
	 * 更新账户信息
	 * @param account
	 */
	void updateAccount(Account account);

}
