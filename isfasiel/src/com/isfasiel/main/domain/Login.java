package com.isfasiel.main.domain;
import javax.validation.constraints.Size;

public class Login {
	@Size(min=4, max=12)
	String password;
	
	String email;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
