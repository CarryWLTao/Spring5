package com.wlt.service;

import java.util.List;

import com.wlt.domain.Account;

/**
 * �˻���ҵ���ӿ�    ȫ��AOP���ӵ�  ����ǿ�ķ�����Ϊ�����
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
	 * ɾ���˻�
	 * @param accountId
	 */
	void deleteAccount(Integer accountId);
	/**
	 * ����id��ѯ�˻���Ϣ
	 * @param accountId
	 * @return
	 */
	Account findAccountById(Integer accountId);
	/**
	 * ��ѯ�����˻�
	 * @return
	 */
	List<Account> findAllAccount();
	/**
	 * ת��
	 * @param sourceName ת���˻�
	 * @param targetName ת���˻�
	 * @param money ת�˽��
	 */
	void transfer(String sourceName,String targetName,Float money);
	/**
	 * �������ֻ�������ӵ㲻���������
	 */
	void test();

}
