package com.tdd.main;

public class LoginFieldValidator {

	public Boolean isLogin(String un, String pw) {
		return un.equals("Tester") && pw.equals("test");
	}

}
