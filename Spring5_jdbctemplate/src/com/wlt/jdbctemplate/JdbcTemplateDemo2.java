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
import com.wlt.domain.Account;

/**
 * JdbcTemplate的最基本使用
 * @author Administrator
 * 		用于增删改的方法
 * 				update(String sql,Object...args);
 * 				参数的含义:
 * 					String sql:要执行的sql语句,该语句可以有占位符.占位符用问好替代
 * 					Object...args:当前执行语句所需的参数
 * 
 * 	用于查询一个实体和查询多个实体的方法:
 * 		query(String sql,RowMapper,Object...args);
 * 	BeanPropertyRowMapper的使用要求:
 * 			要求:实体类中的set方法和数据库表中的列名保持一致
 * 					setName =name
 *
 */
public class JdbcTemplateDemo2 {
	
	public static void main(String[] args) throws PropertyVetoException {
		
		//获取容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		//获取对象
		JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
		//执行操作
		//保存
		//jt.update("insert into account(name,money)values(?,?)","jtAAA",1221);
		//更新
		//jt.update("update account set name=?,money=? where id=? ","qieqieqie",7894,6);
		//删除
		//jt.update("delete from account where id=?", 6);
		//查询所有
		//List<Account> list=jt.query("select * from account where money >?", new AccountRowMapper(), 1000);
		/*List<Account> list=jt.query("select * from account where money >?", new BeanPropertyRowMapper<Account>(Account.class), 1000);
		for(Account account : list) {
			System.out.println(account);
		}*/
		//查询一个
	/*	List<Account> list = jt.query("select * from account where id = ?", new AccountRowMapper(), 1);
		System.out.println(list.get(0));
		Account account = jt.query("select * from account where id = ?", new AccountResultSetExtractor(), 1);
		System.out.println(account);*/
		//查询返回一行一列:当我们的sql语句使用了聚合函数,并且没有group by字句时,返回的都是一行一列的结果
		Long count = jt.queryForObject("select count(*) from account where money >?", Long.class,1000);
		System.out.println(count);
	}

}
class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account=new Account();
		account.setId(rs.getInt("id"));
		account.setName(rs.getString("name"));
		account.setMoney(rs.getFloat("money"));
		return account;
	}

}
class AccountResultSetExtractor implements  ResultSetExtractor<Account>{

	@Override
	public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
		Account account=null;
		if(rs.next()) {
			account =new Account();
			account.setId(rs.getInt("id"));
			account.setName(rs.getString("name"));
			account.setMoney(rs.getFloat("money"));
		}
		return account;
	}
	
}