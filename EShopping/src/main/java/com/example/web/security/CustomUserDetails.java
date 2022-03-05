package com.example.web.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.web.model.Address;
import com.example.web.model.User;

public class CustomUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7705372376820691794L;
	private User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	public Long getId() {
		return user.getId();
	}
	
	public String getFirstName() {
		return user.getFirstName();
	}
	public String getLastNmae() {
		return user.getLastName();
	}
	public String getMobile() {
		return user.getMobileNo();
	}
	
	public Address getAddress() {
		return user.getAddress();
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
		return true;
	}
	
	public String getFullName() {
		return user.getFirstName() + " " + user.getLastName();
	}

}
