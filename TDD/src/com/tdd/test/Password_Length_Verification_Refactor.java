package com.tdd.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tdd.main.PasswordValidator;



public class Password_Length_Verification_Refactor {

	@Test
	public void TestPwLenAll() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(true,  pv.isValid("Ts123"));
		assertEquals(true,  pv.isValid("Testing123"));
		assertEquals(false,  pv.isValid("Test"));
		assertEquals(false,  pv.isValid("Testing1234"));
		assertEquals(false,  pv.isValid(""));
	}
}
