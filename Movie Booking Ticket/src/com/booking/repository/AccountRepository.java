package com.booking.repository;


import com.booking.entity.AccountEntity;

public interface AccountRepository {
	AccountEntity checkAccount(String username, String password);
	
}
