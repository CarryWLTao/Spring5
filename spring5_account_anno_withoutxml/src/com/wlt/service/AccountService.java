package com.wlt.service;

import java.util.List;

import com.wlt.domain.Account;

/**
 * �˻���ҵ���ӿ�
 * @author Administrator
 *
 */
public interface AccountService {
	/**
	 * �����˻�
	 * @param account
	 */
	void saveAccount(Account account);
	/**
	 * �����˻�
	 * @param account
	 */
	void updateAccount(Account account);
	/**
	 * ɾ���û�
	 * @param account
	 */
	void deleteAccount(Integer accountId);
	/**
	 * ����id��ѯ�û�
	 * @param account
	 * @return
	 */
	Account findAccountById(Integer accountId);
	/**
	 * ��ѯ�����˻�
	 * @return
	 */
	List<Account> findAllAccount();

}
