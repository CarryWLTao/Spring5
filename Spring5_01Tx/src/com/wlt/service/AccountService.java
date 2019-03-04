package com.wlt.service;

import com.wlt.domain.Account;

/**
 * �˻���ҵ���ӿ�
 * @author Administrator
 *
 */
public interface AccountService {
	/**
	 * ת��
	 * @param sourceName ת���˻�����
	 * @param targetName ת���˻�����
	 * @param money ת�˽��
	 */
	void transfer(String sourceName,String targetName,Float money);
	/**
	 * ����id��ѯ�˻���Ϣ
	 * @param accountId
	 * @return
	 */
	Account findAccountById(Integer accountId);

}
