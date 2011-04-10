package com.isfasiel.main.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class User {
	long id;
	
	String email;
	
	@Size(min=4, max=12)
	String password;
	
	@NotNull
	Type type;
	
	public User() {
	}
	
	public User(long id, String email, String password,
			Type type) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.type = type;
	}
	
	public User(Login login) {
		this.email = login.getEmail();
		this.password = login.getPassword();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "User [" + ", id=" + id
				+ ", password=" + password + ", type=" + type
				+ "]";
	}

	@Override
	public int hashCode() {
		final long prime = 31;
		long result = 1;
		result = prime * result + id;
		return (int)result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		User other = (User) obj;
		if (id != other.id) return false;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
