package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wangyu.dbassit.DBAssit;

/**
 * ��jdbc��ص�������
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
	 * @Beanע��:
	 * 		����:�ѵ�ǰ�����ķ���ֵ��Ϊbean�������spring������
	 * 		����:
	 * 			name:����ָ��bean��id,���ûд�����ԵĻ�,Ĭ��ֵ�ǵ�ǰ�ķ�����
	 * Spring��ܸ�����beanע��ķ�����������ʱ,��������в���,���÷�����������������ǰ�������в���
	 * ������ҵ�Ψһ��һ������ƥ��,��ֱ�Ӹ������Ĳ���ע��
	 * ����Ҳ����ͱ���
	 * ����ҵ����,����Ҫ����@Qualifierע��,��ʱ�����Զ���ʹ��
	 * @param dataSource
	 * @return
	 */
	@Bean(name="dbAssit")
	public DBAssit createDBAssit(@Qualifier("ds1")DataSource dataSource) {
		return  new DBAssit(dataSource);
		
	}
	/**
	 * ��������Դ
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
