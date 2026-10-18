package com.jilaba.jwtsecurity.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jilaba.jwtsecurity.entity.UserInfo;

public interface UserInfoService {

	String addUser(UserInfo userInfo);
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException ;

	List<UserInfo> getAllUserInfo();
	
}
