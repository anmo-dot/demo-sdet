package com.tdd.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tdd.main.PasswordValidator;

import junit.framework.Assert;

public class Password_Length_Verification {

	@Test
	public void TestPwLen5() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(true,  pv.isValid("Ts123"));
		System.out.println("Accepting 10 char");
	}
	@Test
	public void TestPwLen10() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(true,  pv.isValid("Testing123"));
		System.out.println("Accepting 10 char");
		
	}
	@Test
	public void TestPwLenLess5() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(false,  pv.isValid("Test"));
		System.out.println("Not accepting <5 char");
	}
	@Test
	public void TestPwLenMore5() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(false,  pv.isValid("Testing1234"));
		System.out.println("Not accepting >10 char");
	}
	@Test
	public void TestPwLen0() {

		PasswordValidator pv = new PasswordValidator();
		assertEquals(false,  pv.isValid(""));
		System.out.println("Not accepting 0 char");
	}
}
