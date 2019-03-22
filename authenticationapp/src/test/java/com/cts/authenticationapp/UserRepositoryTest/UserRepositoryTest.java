package com.cts.authenticationapp.UserRepositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.authenticationapp.model.User;
import com.cts.authenticationapp.repository.UserRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class UserRepositoryTest {

	@Autowired
	private transient UserRepository userRepository;

	private User user;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Before
	public void  setUp() throws Exception {
		user = new User("Sourav", "sourav", "Ghosh", "123456", new Date());
	}

	@Test
	public void testRegisterUserSuccess() {
		userRepository.save(user);
		Optional<User> object = userRepository.findById(user.getUserId());
		assertThat(object.get().equals(user));
		userRepository.delete(user);
	}
}

