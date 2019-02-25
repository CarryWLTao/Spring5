package com.wlt.dao.impl;

import java.util.List;


import com.wlt.dao.AccountDao;
import com.wlt.dbAssit.DBAssit;
import com.wlt.domain.Account;
import com.wlt.handler.impl.BeanHandler;
import com.wlt.handler.impl.BeanListHandler;
import com.wlt.util.C3P0Util;

public class AccountDaoImpl implements AccountDao {
	//需要把连接和线程绑定
	private DBAssit dbAssit = new DBAssit(C3P0Util.getDataSource(),true);

	@Override
	public void save(Account account) {
		dbAssit.update("insert into account(name,money)"
				+ "values(?,?)", account.getName(),account.getMoney());

	}

	@Override
	public void update(Account account) {
		dbAssit.update("update account set name=?,money=?"
				+ "where id=?", account.getName(),account.getMoney(),account.getId());
	}

	@Override
	public void delete(Integer accountId) {
		dbAssit.update("delete from account where id=?", accountId);

		
	}

	@Override
	public Account findById(Integer accountId) {
		return (Account) dbAssit.query("select * from account where id=?", new BeanHandler<Account>(Account.class), accountId);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return  (List<Account>) dbAssit.query("select * from account",new BeanListHandler<Account>(Account.class));
	}

	@Override
	public Account findByName(String accountName) {
		@SuppressWarnings("unchecked")
		List<Account> accounts = (List<Account>) dbAssit.query("select * from account where name=?",new BeanListHandler<Account>(Account.class),accountName);
		if(accounts.isEmpty()) {
			return null;
		}
		if (accounts.size()>1) {
			throw new RuntimeException("结果不唯一,程序逻辑有问题");
		}
		return accounts.get(0);
	}

	

}
