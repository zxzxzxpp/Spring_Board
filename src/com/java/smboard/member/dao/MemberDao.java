package com.java.smboard.member.dao;

import com.java.smboard.member.model.MemberModel;

public interface MemberDao { 
	boolean addMember(MemberModel memberModel);
	MemberModel findByUserId(String userId); 
}