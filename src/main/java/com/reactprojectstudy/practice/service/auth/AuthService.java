package com.reactprojectstudy.practice.service.auth;

import com.reactprojectstudy.practice.pojo.SignupRequest;

public interface AuthService {
	String createUser(SignupRequest signupRequest);
}
