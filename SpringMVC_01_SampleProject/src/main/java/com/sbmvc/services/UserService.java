package com.sbmvc.services;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbmvc.pojo.User;
import com.sbmvc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	EntityManager entityManager;

	public Boolean validateUser(User user) {
		TypedQuery<User> query = entityManager.createQuery("from User where email = :email AND password = :password", User.class);
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		if (query.getResultList().size() > 0)
			return true;
		else
			return false;
	}

	public void saveUser(User user) {
		userRepo.save(user);
	}

}
