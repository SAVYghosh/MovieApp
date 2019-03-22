package com.cts.authenticationapp.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.authenticationapp.exception.UserAlreadyExsitsException;
import com.cts.authenticationapp.exception.UserNotFoundException;
import com.cts.authenticationapp.model.User;
import com.cts.authenticationapp.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;


	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExsitsException {
		Optional<User> existingUser = userRepo.findById(user.getUserId());
		if (existingUser.isPresent()) {
			throw new UserAlreadyExsitsException("User with id already exists");
		}
		userRepo.save(user);
		return true;
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
		User user = userRepo.findByUserIdAndPassword(userId, password);
		if (null == user) {
			throw new UserNotFoundException("UserId and Password mismatch");
		}
		return user;
	}



}