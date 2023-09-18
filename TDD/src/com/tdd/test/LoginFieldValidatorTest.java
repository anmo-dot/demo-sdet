package com.tdd.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.tdd.main.LoginFieldValidator;
import com.tdd.main.PasswordValidator;

@RunWith(Parameterized.class)
public class LoginFieldValidatorTest {
	String un, pw;
	Boolean success;

	public LoginFieldValidatorTest(String un, String pw, Boolean success) {
		super();
		this.un = un;
		this.pw = pw;
		this.success = success;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> testdata() {
		return Arrays.asList(new Object[][] {
			{"Tester", "test", true},
			{"Test", "test", false},
			{"Tester", "tester", false},
			{"Tester", "", false},
			{"", "test", false},
		});
	}
	
	@Test
	public void test() {
		LoginFieldValidator lv =new LoginFieldValidator ();
		assertEquals(success, lv.isLogin(un, pw));
	}

}
