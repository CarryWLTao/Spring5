package com.wlt.dao.impl;

import org.springframework.stereotype.Repository;

import com.wlt.dao.AccountDao;
/**
 * 账户的持久层实现类
 * @author Administrator
 *
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {

	@Override
	public void saveAccount() {
		// TODO Auto-generated method stub
		System.out.println("执行了账户保存操作222222");
	}

}
