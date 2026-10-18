package com.jilaba.jwtsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jilaba.jwtsecurity.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository <UserInfo, Integer>  {
	Optional<UserInfo> findByPassword(String password); 
	Optional<UserInfo> findByEmail(String email); // Use 'email' if that is the correct field for login
}
