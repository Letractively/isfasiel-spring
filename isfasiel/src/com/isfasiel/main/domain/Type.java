package com.isfasiel.main.domain;
 
public enum Type {
	ADMIN(1, "administrator"), MEMBER(2, "user"), GUEST(3, "guest");
	
	private int value;
	private String name;

	private Type(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static Type valueOf(int value) {
		switch(value) {
		case 1 : return ADMIN;
		case 2 : return MEMBER;
		case 3: return GUEST;
		}
		throw new IllegalArgumentException("잘못된 id 값입니다");
	}
}
