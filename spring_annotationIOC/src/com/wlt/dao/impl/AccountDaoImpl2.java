package com.wlt.dao.impl;

import org.springframework.stereotype.Repository;

import com.wlt.dao.AccountDao;
/**
 * �˻��ĳ־ò�ʵ����
 * @author Administrator
 *
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {

	@Override
	public void saveAccount() {
		// TODO Auto-generated method stub
		System.out.println("ִ�����˻��������222222");
	}

}
