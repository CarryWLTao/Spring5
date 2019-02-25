package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wangyu.dbassit.DBAssit;

/**
 * 和jdbc相关的配置类
 * @author Administrator
 *
 */
//@Configuration
public class JdbcConfig {
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	/**
	 * @Bean注解:
	 * 		作用:把当前方法的返回值作为bean对象存入spring容器中
	 * 		属性:
	 * 			name:用于指定bean的id,如果没写该属性的话,默认值是当前的方法名
	 * Spring框架给带有bean注解的方法创建对象时,如果方法有参数,会用方法参数的数据类型前往容器中查找
	 * 如果能找到唯一的一个类型匹配,则直接给方法的参数注入
	 * 如果找不到就报错
	 * 如果找到多个,就需要借助@Qualifier注解,此时它可以独立使用
	 * @param dataSource
	 * @return
	 */
	@Bean(name="dbAssit")
	public DBAssit createDBAssit(@Qualifier("ds1")DataSource dataSource) {
		return  new DBAssit(dataSource);
		
	}
	/**
	 * 创建数据源
	 * @return
	 */
	@Bean(name="ds1")
	public DataSource createDataSource1() {
		ComboPooledDataSource ds=new ComboPooledDataSource();
		try {
			ds.setDriverClass(driver);
			ds.setJdbcUrl(url);
			ds.setUser(username);
			ds.setPassword(password);
			return ds;
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	@Bean(name="ds2")
	public DataSource createDataSource2() {
		ComboPooledDataSource ds=new ComboPooledDataSource();
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring5");
			ds.setUser("root");
			ds.setPassword("root");
			return ds;
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}


}
