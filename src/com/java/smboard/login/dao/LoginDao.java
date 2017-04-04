package com.java.smboard.login.dao;

import com.java.smboard.login.model.LoginSessionModel;

public interface LoginDao {	
	LoginSessionModel checkUserId(String userId);
}