package com.wlt.dao;

import java.util.List;

import com.wlt.domain.Account;
/**
 * 账户的持久层接口
 * @author Administrator
 *
 */

public interface AccountDao {
	/**
	 * 保存操作
	 * @param account
	 */
	void save(Account account);
	/**
	 * 更新操作
	 * @param account
	 */
	void update(Account account);
	/**
	 * 删除操作
	 * @param account
	 */
	void delete(Integer accountId);
	/**
	 * 根据id查询操作
	 * @param account
	 * @return
	 */
	Account findById(Integer accountId);
	/**
	 * 查询所有操作
	 * @return
	 */
	List<Account> findAll();

}
