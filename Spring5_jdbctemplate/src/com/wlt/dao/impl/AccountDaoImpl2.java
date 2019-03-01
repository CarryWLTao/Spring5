package com.wlt.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.wlt.dao.AccountDao;
import com.wlt.domain.Account;

public class AccountDaoImpl2 extends JdbcDaoSupport implements AccountDao {
	


	@Override
	public Account findAccountById(Integer accountId) {
		 List<Account> list = getJdbcTemplate().query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class),accountId);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public Account findAccountByName(String name) {
		List<Account> list = getJdbcTemplate().query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class),name);
		if(list.isEmpty()) {
			return null;
		}else if(list.size()>1) {
			throw new RuntimeException("账户名称不唯一,程序逻辑又问题");
		}
		
		return list.get(0);
	}

	@Override
	public void updateAccount(Account account) {
		
		getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());

	}

}
