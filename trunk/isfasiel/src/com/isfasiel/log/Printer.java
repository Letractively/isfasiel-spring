package com.isfasiel.log;

public class Printer {
	public void print() {
		System.out.println("print is executed");
	}
	
	public void printMessage(String message) {
		System.out.println("print is executed. Message is " + message);
		
	}
	
	public String printMessageAndReturn(String message) {
		printMessage(message);
		return message;
	}
	
}
