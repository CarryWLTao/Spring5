package config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wangyu.dbassit.DBAssit;

/**
 * spring��������,���þ��൱��bean.xml
 * @author Administrator
 *
 */
/*
 * �����൱�ڱ�����ǰ����spring��������,���ֻ��д��AnnotationConfigApplicationContext
 * ���캯���е��ֽ���,���Բ�д
 * ����Ǽ���Ҫɨ��İ�ʱ,��Ҫ������������,ͬʱ��û�Ѵ�����ֽ����ṩ��
 * AnnotationConfigApplicationContext���캯��ʱ,�����д@Configuration
 * 
 */
@Configuration
//@ComponentScan({"com.wlt","config"})
@ComponentScan("com.wlt")
@Import(JdbcConfig.class)
@PropertySource("classpath:config/jdbcConfig.properties")
public class SpringConfiguration {
	/**
	 * ��spring4.3��ǰ�İ汾,��Ҫ�ֶ�����
	 * @return
	 
	@Bean
	public static PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
		
	}
	*/
	
}
