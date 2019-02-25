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
	 * �����˻�
	 * @param account
	 */
	void save(Account account);
	/**
	 * �����˻�
	 * @param account
	 */
	void update(Account account);
	/**
	 * ɾ���˻�
	 * @param accountId
	 */
	void delete(Integer accountId);
	/**
	 * ����id��ѯ�˻�
	 * @param accountId
	 * @return
	 */
	Account findById(Integer accountId);
	/**
	 * ��ѯ�����˻�
	 * @return
	 */
	List<Account> findAll();
	/**
	 * �������Ʋ�ѯ�˻���Ϣ
	 * @param accountName
	 * @return  ����������Ʋ鵽Ψһ�Ķ���,�ͷ���
	 * 			���û�в鵽�ͷ���null
	 * 			����鵽�Ľ����Ψһ,�����쳣
	 */
	Account findByName(String accountName);

}
