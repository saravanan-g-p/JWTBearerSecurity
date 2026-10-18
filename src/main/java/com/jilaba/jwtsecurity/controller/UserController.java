package com.jilaba.jwtsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jilaba.jwtsecurity.entity.AuthRequest;
import com.jilaba.jwtsecurity.entity.UserInfo;
import com.jilaba.jwtsecurity.service.JwtService;
import com.jilaba.jwtsecurity.service.UserInfoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

	@Autowired
    private UserInfoService service;

	@Autowired
    private JwtService jwtService;

	@Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    // Removed the role checks here as they are already managed in SecurityConfig

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
    	try {
			
    		Authentication authentication = authenticationManager.authenticate(
    				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
    				);
    		if (authentication.isAuthenticated()) {
    			return jwtService.generateToken(authRequest.getUsername());
    		} else {
    			throw new UsernameNotFoundException("Invalid user request!");
    		}
		} catch (Exception e) {
			throw e;
		}
    }
    
    @PostMapping("/user/userProfile")
    public ResponseEntity<List<UserInfo>> getUserInfo(){
    	return ResponseEntity.ok(service.getAllUserInfo());
    }
}
