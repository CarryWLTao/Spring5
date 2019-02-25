package com.wlt.service.impl;

import org.springframework.stereotype.Service;

import com.wlt.service.AccountService;

/**
 * 模拟账户的业务层实现类
 * @author Administrator
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Override
	public void saveAccount() {
		System.out.println("保存了账户");

	}

	@Override
	public void updateAccount(int i) {
		System.out.println("更新了账户"+i);

	}

	@Override
	public int deleteAccount() {
		System.out.println("删除了账户");
		return 0;
	}

}
