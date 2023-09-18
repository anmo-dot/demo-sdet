package com.tdd.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.tdd.main.PasswordValidator;


@RunWith(Parameterized.class)
public class PWLenTest_Params {
	String pw;
	Boolean success;
	
	public PWLenTest_Params(String pw, Boolean success) {
		super();
		this.pw = pw;
		this.success = success;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> testdata() {
		return Arrays.asList(new Object[][] {
			{"Ts123", true},
			{"testing123", true},
			{"Test", false},
			{"Testing1234",false},
			{"",false}
		});
	}
	
	@Test
	public void test() {
		PasswordValidator pv =new PasswordValidator ();
		assertEquals(success, pv.isValid(pw));
	}

}
