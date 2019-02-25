package com.wlt.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wlt.dao.AccountDao;
import com.wlt.service.AccountService;
/**
 * 账户业务层实现类
 * @author Administrator
 *<bean id="accountService" class="com.wlt.service.impl.AccountServiceImpl">
 			<property name="accountDao" ref="accountDao"></property>
  </bean>
      	用于创建对象的:
      		@Component:
      			作用:就相当于在spring的xml配置文件中写了一个bean标签
      			属性:
      				value:用于指定bean的id.当不写时,默认值是当前类名,首字母改小写.例如accountServiceImpl
      		由此注解衍生的三个注解:
      			@Controller一般用于表现层
      			@Service一般用于业务层
      			@Repository一般用于持久层
      			他们的作用以及属性和@Component的作用是一模一样的.他们的出现是spring框架为我们提供更明确的语义化来
      			指定不同层的bean对象
  		用于注入其他bean类型数据的:
  			@Autowired
  				作用:自动按照类型注入,只要容器中有唯一的类型匹配,则可以直接注入成功.如果没有匹配的对象就报错
  					如果有多个类型匹配时,会先按照类型找到符合条件的对象,然后在用变量名称作为bean的id,
  					从里面继续查找,如果找到仍然可以注入成功,如果没有匹配的id,则报错.
  				当使用此注解注入时,set方法就可以省略了
  				属性:
  					required:是否必须注入成功.取值是true(默认值)/false.当取值是true的时候,没有匹配的对象就报错.
  			@Qualifier
  				作用:在自动按照类型注入的基础之上,在按照bean的id注入.在给类成员注入时,他不能够独立使用
  				属性:
  					value:用于指定bean的id
  			@Resource
  				作用:直接按照bean的id注入.
  				属性:
  					name:用于指定bean的id
  			以上三个注解,都只能用于注入其他bean类型,而不能注入基本类型和String
       	用于注入基本类型和String类型的注解:
       		@Value
       			作用:用于注入基本类型和String类型
       			属性:
       				value:用于指定要注入的数据,它支持使用spring的el表达式
       					spring的el表达式写法:
       						${表达式}
  			
  		用于改变作用范围的:
  			@Scope
  				作用:用于改变bean的作用范围,范围取值和xml的配置是一样的
  				属性:
  					value:用于指定范围
  		和生命周期相关的:
  			@PostContruct
  				作用:用于指定初始化方法,和配置文件中init-method属性是一样的
  			@PreDestory
  				作用:用于指定销毁方法,和配置文件中destory-method属性是一样的
 */
//@Component(value="accountService")
//@Service(value="accountService")只有一个属性可以不写
@Service("accountService")
@Scope("prototype")
public class AccountServiceImpl implements AccountService {
	/*@Autowired
	@Qualifier("accountDao2")*/
	@Resource(name="accountDao2")
	private AccountDao accountDao;
	@Value("${jdbc.driver}")
	private String dirver;
	@PostConstruct
	public void init() {
		System.out.println("对象初始化了");
	}
	@PreDestroy
	public void destory() {
		System.out.println("对象销毁了");
	}
	@Override
	public void saveAccount() {
		// TODO Auto-generated method stub
		System.out.println(dirver);
		accountDao.saveAccount();
	}

}
