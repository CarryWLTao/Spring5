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
 * �˻�ҵ���ʵ����
 * @author Administrator
 *<bean id="accountService" class="com.wlt.service.impl.AccountServiceImpl">
 			<property name="accountDao" ref="accountDao"></property>
  </bean>
      	���ڴ��������:
      		@Component:
      			����:���൱����spring��xml�����ļ���д��һ��bean��ǩ
      			����:
      				value:����ָ��bean��id.����дʱ,Ĭ��ֵ�ǵ�ǰ����,����ĸ��Сд.����accountServiceImpl
      		�ɴ�ע������������ע��:
      			@Controllerһ�����ڱ��ֲ�
      			@Serviceһ������ҵ���
      			@Repositoryһ�����ڳ־ò�
      			���ǵ������Լ����Ժ�@Component��������һģһ����.���ǵĳ�����spring���Ϊ�����ṩ����ȷ�����廯��
      			ָ����ͬ���bean����
  		����ע������bean�������ݵ�:
  			@Autowired
  				����:�Զ���������ע��,ֻҪ��������Ψһ������ƥ��,�����ֱ��ע��ɹ�.���û��ƥ��Ķ���ͱ���
  					����ж������ƥ��ʱ,���Ȱ��������ҵ����������Ķ���,Ȼ�����ñ���������Ϊbean��id,
  					�������������,����ҵ���Ȼ����ע��ɹ�,���û��ƥ���id,�򱨴�.
  				��ʹ�ô�ע��ע��ʱ,set�����Ϳ���ʡ����
  				����:
  					required:�Ƿ����ע��ɹ�.ȡֵ��true(Ĭ��ֵ)/false.��ȡֵ��true��ʱ��,û��ƥ��Ķ���ͱ���.
  			@Qualifier
  				����:���Զ���������ע��Ļ���֮��,�ڰ���bean��idע��.�ڸ����Աע��ʱ,�����ܹ�����ʹ��
  				����:
  					value:����ָ��bean��id
  			@Resource
  				����:ֱ�Ӱ���bean��idע��.
  				����:
  					name:����ָ��bean��id
  			��������ע��,��ֻ������ע������bean����,������ע��������ͺ�String
       	����ע��������ͺ�String���͵�ע��:
       		@Value
       			����:����ע��������ͺ�String����
       			����:
       				value:����ָ��Ҫע�������,��֧��ʹ��spring��el���ʽ
       					spring��el���ʽд��:
       						${���ʽ}
  			
  		���ڸı����÷�Χ��:
  			@Scope
  				����:���ڸı�bean�����÷�Χ,��Χȡֵ��xml��������һ����
  				����:
  					value:����ָ����Χ
  		������������ص�:
  			@PostContruct
  				����:����ָ����ʼ������,�������ļ���init-method������һ����
  			@PreDestory
  				����:����ָ�����ٷ���,�������ļ���destory-method������һ����
 */
//@Component(value="accountService")
//@Service(value="accountService")ֻ��һ�����Կ��Բ�д
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
		System.out.println("�����ʼ����");
	}
	@PreDestroy
	public void destory() {
		System.out.println("����������");
	}
	@Override
	public void saveAccount() {
		// TODO Auto-generated method stub
		System.out.println(dirver);
		accountDao.saveAccount();
	}

}
