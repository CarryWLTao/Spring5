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
	 * 保存账户
	 * @param account
	 */
	void save(Account account);
	/**
	 * 更新账户
	 * @param account
	 */
	void update(Account account);
	/**
	 * 删除账户
	 * @param accountId
	 */
	void delete(Integer accountId);
	/**
	 * 根据id查询账户
	 * @param accountId
	 * @return
	 */
	Account findById(Integer accountId);
	/**
	 * 查询所有账户
	 * @return
	 */
	List<Account> findAll();
	/**
	 * 根据名称查询账户信息
	 * @param accountName
	 * @return  如果根据名称查到唯一的对象,就返回
	 * 			如果没有查到就返回null
	 * 			如果查到的结果不唯一,就抛异常
	 */
	Account findByName(String accountName);

}
