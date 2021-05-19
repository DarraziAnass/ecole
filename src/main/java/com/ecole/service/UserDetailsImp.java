package com.ecole.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecole.beans.Directeur;
import com.ecole.beans.Etudiant;
import com.ecole.beans.Person;
import com.ecole.beans.Professeur;

public class UserDetailsImp implements UserDetails{
	
	private Person user;

	public UserDetailsImp(Person user) {
		this.user=user;
	}
	
	public UserDetailsImp() {	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if(user instanceof Etudiant)
			authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
		if(user instanceof Professeur)
			authorities.add(new SimpleGrantedAuthority("ROLE_PROF"));
		if(user instanceof Directeur)
			authorities.add(new SimpleGrantedAuthority("ROLE_DIRE"));
		return authorities;
	}
	
	public Long getId() {
		return user.getId();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
