package com.wlt.service;

import org.springframework.stereotype.Service;

/**
 * �˻���ҵ���ӿ�
 * @author Administrator
 *
 */

public interface AccountService {
	/**
	 * ģ�Ᵽ�淽��:�޷���ֵ�޲���
	 */
	void saveAccount();
	/**
	 * ģ����·���:�޷���ֵ�в���
	 * @param i
	 */
	void updateAccount(int i);
	/**
	 * ģ��ɾ������:�з���ֵ�޲���
	 * @return
	 */
	int deleteAccount();

}
