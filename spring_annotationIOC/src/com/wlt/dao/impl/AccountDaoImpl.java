package com.wlt.dao.impl;

import org.springframework.stereotype.Repository;

import com.wlt.dao.AccountDao;
/**
 * �˻��ĳ־ò�ʵ����
 * @author Administrator
 *
 */
@Repository("accountDao1")
public class AccountDaoImpl implements AccountDao {

	@Override
	public void saveAccount() {
		// TODO Auto-generated method stub
		System.out.println("ִ�����˻��������11111111");
	}

}
