package com.java.smboard.login.service;


import org.springframework.orm.ibatis.SqlMapClientTemplate;
import com.java.smboard.login.dao.LoginDao;
import com.java.smboard.login.model.LoginSessionModel;

public class LoginService implements LoginDao {
	private SqlMapClientTemplate sqlMapClientTemplate;  
	
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;  
	}

	@Override
	public LoginSessionModel checkUserId(String userId) { 
		return (LoginSessionModel) sqlMapClientTemplate.queryForObject("login.loginCheck", userId);

	}	
}