package com.spring.workshop.carsspringbootdemo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		switch (username) {
		case "user":
			grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
			break;
		case "admin":
			grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
			grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
			break;
		}

		return new org.springframework.security.core.userdetails.User(username, new BCryptPasswordEncoder().encode("password"), grantedAuthorities);
	}
}
