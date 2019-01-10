package com.spring.workshop.carsspringbootdemo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.workshop.carsspringbootdemo.model.Role;
import com.spring.workshop.carsspringbootdemo.model.User;
import com.spring.workshop.carsspringbootdemo.repository.RoleJpaRepository;
import com.spring.workshop.carsspringbootdemo.repository.UserJpaRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserJpaRepository userRepository;
	@Autowired
    private RoleJpaRepository roleRepository;
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(new ArrayList<Role>(roleRepository.findAll()));
		userRepository.save(user);
	}

}
