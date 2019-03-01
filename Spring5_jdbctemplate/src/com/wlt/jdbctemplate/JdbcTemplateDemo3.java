package com.wlt.jdbctemplate;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wlt.dao.AccountDao;
import com.wlt.domain.Account;

/**
 * JdbcTemplate的最基本使用
 * @author Administrator
 * 
 *
 */
public class JdbcTemplateDemo3 {
	
	public static void main(String[] args) throws PropertyVetoException {
		
		//获取容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		//获取对象
		AccountDao accountDao=ac.getBean("accountDao",AccountDao.class);
		
		
		Account account = accountDao.findAccountById(1);
		System.out.println(account);
		
		/*Account account2 = accountDao.findAccountByName("bbb");
		System.out.println(account2);*/
		account.setName("ccc");
		account.setMoney(7893f);
		
		accountDao.updateAccount(account);
		
	}

}
