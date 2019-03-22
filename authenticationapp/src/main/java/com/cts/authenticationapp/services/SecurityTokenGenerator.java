package com.cts.authenticationapp.services;

import java.util.Map;

import com.cts.authenticationapp.model.User;


public interface SecurityTokenGenerator {

	Map<String, String> generateToken(User user);
}

