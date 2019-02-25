package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring�������� �൱��bean.xml
 * @author Administrator
 *
 */
@Configuration
/*
 * <!-- ��֪spring��������ʱҪɨ��İ� --> 
 *  <context:component-scan base-package="com.wlt"></context:component-scan>
 *      
 */
@ComponentScan("com.wlt")
/*
 * 
 * 		<!-- ����spring��ע��AOP��֧�� -->
 *       <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 *
 */
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
