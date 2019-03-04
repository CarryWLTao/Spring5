package com.wlt.ui;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * ��ȡJdbcTemplate�е�Connection
 * @author Administrator
 *
 */
public class GetConnectionTest {
	public static void main(String[] args) {
		//��ȡ����
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		
		//��ȡ����Դ
		DataSource ds = ac.getBean("dataSource",DataSource.class);
		//ʹ��Spring�ṩ����ͬ������������ʵ�ְ�Connection���̰߳�
		TransactionSynchronizationManager.initSynchronization();
		//ʹ��spring�ṩ�Ĺ������������Դ��ȡConnection
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
