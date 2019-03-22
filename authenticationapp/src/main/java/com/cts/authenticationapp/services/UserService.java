package com.cts.authenticationapp.services;

import com.cts.authenticationapp.exception.UserAlreadyExsitsException;
import com.cts.authenticationapp.exception.UserNotFoundException;
import com.cts.authenticationapp.model.User;



public interface UserService {

	boolean saveUser(User user) throws UserAlreadyExsitsException;

	User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;
}
