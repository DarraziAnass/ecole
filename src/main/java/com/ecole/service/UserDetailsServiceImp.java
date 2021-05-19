package com.ecole.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecole.beans.Person;
import com.ecole.dao.PersonRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
	
	@Autowired
	private PersonRepository personRepo;

	@Override
	public UserDetails loadUserByUsername(String email) {
		Optional<Person> user = personRepo.findByEmail(email);
		user.orElseThrow(()-> new UsernameNotFoundException("User Not Found!!"));
		return new UserDetailsImp(user.get());
	}

}
