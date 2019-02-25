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
public class AccountServiceImpl_OLD implements AccountService {
	
	private AccountDao accountDao =new AccountDaoImpl();
	@Override
	public void saveAccount(Account account) {
		try {
			//��������
			TransactionManager.beginTransaction();
			//ִ�е���ҵ��㷽��
			accountDao.save(account);
			//�ύ����
			TransactionManager.commit();
		} catch (Exception e) {
			//�ع�����
			TransactionManager.rollback();
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			TransactionManager.release();
		}
	}

	@Override
	public void updateAccount(Account account) {
		try {
			//��������
			TransactionManager.beginTransaction();
			//ִ�е���ҵ��㷽��
			accountDao.update(account);
			//�ύ����
			TransactionManager.commit();
		} catch (Exception e) {
			//�ع�����
			TransactionManager.rollback();
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			TransactionManager.release();
		}

	}

	@Override
	public void deleteAccount(Integer accountId) {
		try {
			//��������
			TransactionManager.beginTransaction();
			//ִ�е���ҵ��㷽��
			accountDao.delete(accountId);
			//�ύ����
			TransactionManager.commit();
		} catch (Exception e) {
			//�ع�����
			TransactionManager.rollback();
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			TransactionManager.release();
		}

	}

	@Override
	public Account findAccountById(Integer accountId) {
		try {
			//��������
			TransactionManager.beginTransaction();
			//ִ�е���ҵ��㷽��
			Account account = accountDao.findById(accountId);
			//�ύ����
			TransactionManager.commit();
			return account;
		} catch (Exception e) {
			//�ع�����
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			TransactionManager.release();
		}
		
	}

	@Override
	public List<Account> findAllAccount() {
		try {
			//��������
			TransactionManager.beginTransaction();
			//ִ�е���ҵ��㷽��
			List<Account> accounts = accountDao.findAll();
			//�ύ����
			TransactionManager.commit();
			return accounts;
		} catch (Exception e) {
			//�ع�����
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			TransactionManager.release();
		}
	}

	@Override
	public void transfer(String sourceName, String targetName, Float money) {
		try {
			//��������
			TransactionManager.beginTransaction();
			//ִ�е���ҵ��㷽��
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
			//�ύ����
			TransactionManager.commit();
		} catch (Exception e) {
			//�ع�����
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			TransactionManager.release();
		}
		
	}

}
