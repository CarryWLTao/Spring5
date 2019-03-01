package com.wlt.jdbctemplate;

import java.beans.PropertyVetoException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JdbcTemplate的最基本使用
 * @author Administrator
 *
 */
public class JdbcTemplateDemo {
	
	public static void main(String[] args) throws PropertyVetoException {
		
		//获取容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		
		JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
		jt.execute("insert into account(name,money)values('SpringIOCJdbcTemplate',1000)");
		
		/*ComboPooledDataSource ds=new ComboPooledDataSource();
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring5");
		ds.setUser("root");
		ds.setPassword("root");
		//获取JDBCTemplate
		JdbcTemplate jt=new JdbcTemplate();
		//JdbcTemplate jt=new JdbcTemplate(ds);
		//给JdbcTemplate设置数据源
		jt.setDataSource(ds);
		//调用方法操作
		jt.execute("insert into account(name,money)values('jdbcTemplate',1000)");
		*/
	}

}
