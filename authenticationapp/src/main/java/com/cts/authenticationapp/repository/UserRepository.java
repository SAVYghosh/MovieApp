package com.cts.authenticationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.authenticationapp.model.User;



public interface UserRepository extends JpaRepository<User, String> {

	@Query("Select user from User user where user.userId = (?1) and user.password = (?2)")
	User validate(String userId, String password);

	User findByUserIdAndPassword(String userId, String password);
}

