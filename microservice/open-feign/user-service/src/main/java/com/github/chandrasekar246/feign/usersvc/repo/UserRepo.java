package com.github.chandrasekar246.feign.usersvc.repo;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.feign.usersvc.model.User;

@Repository
public class UserRepo {
	private static final Set<User> userSet = new HashSet<>();

	private static final Random random = new SecureRandom();

	private static final int BOUND = 100;

	static {
		userSet.addAll(Arrays.asList(new User(random.nextInt(BOUND), "Anand", "anand@xyz.com", null),
				new User(random.nextInt(BOUND), "Balaji", "balaji@xyz.com", null)));
	}

	public Optional<User> create(User user) {
		user.setId(random.nextInt(BOUND));
		boolean status = userSet.add(user);
		if (status) {
			return Optional.of(user);
		}
		return Optional.empty();
	}

	public Optional<User> read(Integer id) {
		return userSet.stream().filter(p -> p.getId().equals(id)).findFirst();
	}

	public Set<User> readAll() {
		return userSet;
	}
}