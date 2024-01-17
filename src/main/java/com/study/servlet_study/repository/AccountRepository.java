package com.study.servlet_study.repository;

import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.entity.Account;

public class AccountRepository {
	private List<Account> accountList;
	private static AccountRepository instance;

	private AccountRepository() {
		accountList = new ArrayList<>();
	}

	public static AccountRepository getInstance() {
		if (instance == null) {
			instance = new AccountRepository();
		}
		return instance;
	}

	public int saveAccount(Account account) {
		accountList.add(account);
		return 1; // 1을 리턴하는 이유 : DB
	}

}
