package com.wlt.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 抽取重复代码
 * @author Administrator
 *
 */
public class JdbcDaoSupport {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		if(jdbcTemplate ==null) {
			createJdbcTemplate(dataSource);
		}
	}
	private void createJdbcTemplate(DataSource dataSource) {
		jdbcTemplate =new JdbcTemplate(dataSource);
		
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	

}
