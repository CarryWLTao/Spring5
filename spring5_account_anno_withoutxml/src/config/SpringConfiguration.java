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
 * spring的配置类,作用就相当于bean.xml
 * @author Administrator
 *
 */
/*
 * 它就相当于表明当前类是spring的配置类,如果只是写到AnnotationConfigApplicationContext
 * 构造函数中的字节码,可以不写
 * 如果是加载要扫描的包时,需要读到此类配置,同时又没把此类的字节码提供给
 * AnnotationConfigApplicationContext构造函数时,则必须写@Configuration
 * 
 */
@Configuration
//@ComponentScan({"com.wlt","config"})
@ComponentScan("com.wlt")
@Import(JdbcConfig.class)
@PropertySource("classpath:config/jdbcConfig.properties")
public class SpringConfiguration {
	/**
	 * 在spring4.3以前的版本,需要手动配置
	 * @return
	 
	@Bean
	public static PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
		
	}
	*/
	
}
