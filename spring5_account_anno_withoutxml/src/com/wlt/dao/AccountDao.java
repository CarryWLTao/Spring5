package com.wlt.dao;

import java.util.List;

import com.wlt.domain.Account;
/**
 * �˻��ĳ־ò�ӿ�
 * @author Administrator
 *
 */

public interface AccountDao {
	/**
	 * �������
	 * @param account
	 */
	void save(Account account);
	/**
	 * ���²���
	 * @param account
	 */
	void update(Account account);
	/**
	 * ɾ������
	 * @param account
	 */
	void delete(Integer accountId);
	/**
	 * ����id��ѯ����
	 * @param account
	 * @return
	 */
	Account findById(Integer accountId);
	/**
	 * ��ѯ���в���
	 * @return
	 */
	List<Account> findAll();

}
