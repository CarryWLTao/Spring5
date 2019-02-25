package com.wlt.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
public class C3P0Utils {
private static ComboPooledDataSource ds = new ComboPooledDataSource();
	

	

	public static DataSource getDataSource(){
		return ds;
	}
	
	

	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}

	public static void main(String[] args) {
		System.out.println(getDataSource());
	}

}
