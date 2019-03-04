package com.wlt.service.impl;

import com.wlt.dao.AccountDao;
import com.wlt.domain.Account;
import com.wlt.service.AccountService;
/**
 * �˻���ҵ���ʵ����
 * @author Administrator
 *
 */
public class AccountServiceImpl implements AccountService {
	
	 private AccountDao accountDao;
	 
	 

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String sourceName, String targetName, Float money) {
		// �����û����Ʋ�ѯ�����˻�
		Account source=accountDao.findAccountByName(sourceName);
		Account target=accountDao.findAccountByName(targetName);
		//ת���˻���Ǯת���˻���Ǯ
		source.setMoney(source.getMoney()-money);
		target.setMoney(target.getMoney()+money);
		
		//���������˻�
		accountDao.updateAccount(source);
		//ģ��ת���쳣
		int i=1/0;
		accountDao.updateAccount(target);

	}

	@Override
	public Account findAccountById(Integer accountId) {
		// TODO Auto-generated method stub
		return accountDao.findAccountById(accountId);
	}

}
