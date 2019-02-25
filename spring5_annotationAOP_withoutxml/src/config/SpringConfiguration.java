package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring的配置类 相当于bean.xml
 * @author Administrator
 *
 */
@Configuration
/*
 * <!-- 告知spring创建容器时要扫描的包 --> 
 *  <context:component-scan base-package="com.wlt"></context:component-scan>
 *      
 */
@ComponentScan("com.wlt")
/*
 * 
 * 		<!-- 开启spring对注解AOP的支持 -->
 *       <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 *
 */
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
