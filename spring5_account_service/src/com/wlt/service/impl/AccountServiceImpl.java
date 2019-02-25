package com.wlt.service.impl;

import java.util.List;

import com.wlt.dao.AccountDao;
import com.wlt.dao.impl.AccountDaoImpl;
import com.wlt.domain.Account;
import com.wlt.service.AccountService;
import com.wlt.util.TransactionManager;
/**
 * �˻���ҵ���ʵ����
 * @author Administrator
 * ��javaee�ֲ㿪����,����һ�㶼�ǳ���ҵ����
 *
 */
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao =new AccountDaoImpl();
	@Override
	public void saveAccount(Account account) {
			accountDao.save(account);
	}

	@Override
	public void updateAccount(Account account) {
			accountDao.update(account);

	}

	@Override
	public void deleteAccount(Integer accountId) {
			accountDao.delete(accountId);
	}

	@Override
	public Account findAccountById(Integer accountId) {
			return accountDao.findById(accountId);
	}

	@Override
	public List<Account> findAllAccount() {
			List<Account> accounts = accountDao.findAll();
			return accounts;
	}

	@Override
	public void transfer(String sourceName, String targetName, Float money) {
			//�������Ʋ�ѯת���˻�
			Account source=accountDao.findByName(sourceName);
			//�������Ʋ�ѯת���˻�
			Account target=accountDao.findByName(targetName);
			//ת���˻���Ǯ
			source.setMoney(source.getMoney()-money);
			//ת���˻���Ǯ
			target.setMoney(target.getMoney()+money);
			//����ת���˻�
			accountDao.update(source);
			//int i=1/0;
			//����ת���˻�
			accountDao.update(target);
	}

}
