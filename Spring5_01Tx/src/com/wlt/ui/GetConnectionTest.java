package com.wlt.ui;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 获取JdbcTemplate中的Connection
 * @author Administrator
 *
 */
public class GetConnectionTest {
	public static void main(String[] args) {
		//获取容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		
		//获取数据源
		DataSource ds = ac.getBean("dataSource",DataSource.class);
		//使用Spring提供事务同步管理器对象实现把Connection和线程绑定
		TransactionSynchronizationManager.initSynchronization();
		//使用spring提供的工具类根据数据源获取Connection
		Connection conn=DataSourceUtils.getConnection(ds);
		Connection conn1=DataSourceUtils.getConnection(ds);
		System.out.println(conn==conn1);
		System.out.println(conn1);
		Thread th=new Thread(new Runnable() {
			
			@Override
			public void run() {
				Connection conn2=DataSourceUtils.getConnection(ds);
				System.out.println(conn2);
				
			}
		});
		th.start();
	}

}
