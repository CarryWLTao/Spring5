package com.wlt.dao.impl;

import java.util.List;

import com.wangyu.dbassit.DBAssit;
import com.wangyu.result.impl.BeanHandler;
import com.wangyu.result.impl.BeanListHandler;
import com.wlt.dao.AccountDao;
import com.wlt.domain.Account;
/**
 * 账户的持久层实现类
 * @author Administrator
 *
 */
public class AccountDaoImpl implements AccountDao {
	private DBAssit dbAssit;
	

	public void setDbAssit(DBAssit dbAssit) {
		this.dbAssit = dbAssit;
	}

	@Override
	public void save(Account account) {
		// TODO Auto-generated method stub
		dbAssit.update("insert into account(name,money)"
				+ "values(?,?)", account.getName(),account.getMoney());

	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub
		dbAssit.update("update account set name=?,money=?"
				+ "where id=?", account.getName(),account.getMoney(),account.getId());
	}

	@Override
	public void delete(Integer accountId) {
		// TODO Auto-generated method stub
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
		return (List<Account>) dbAssit.query("select * from account",new BeanListHandler<Account>(Account.class));
	}

}
