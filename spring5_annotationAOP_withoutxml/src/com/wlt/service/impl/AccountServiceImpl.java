package com.wlt.service.impl;

import org.springframework.stereotype.Service;

import com.wlt.service.AccountService;

/**
 * ģ���˻���ҵ���ʵ����
 * @author Administrator
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Override
	public void saveAccount() {
		System.out.println("�������˻�");

	}

	@Override
	public void updateAccount(int i) {
		System.out.println("�������˻�"+i);

	}

	@Override
	public int deleteAccount() {
		System.out.println("ɾ�����˻�");
		return 0;
	}

}
