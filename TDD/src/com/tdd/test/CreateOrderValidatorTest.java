package com.tdd.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.tdd.model.Order;
import com.tdd.main.CreateOrderValidator;




@RunWith(Parameterized.class)
public class CreateOrderValidatorTest {

	
	Order ord;
	Boolean success;

	public CreateOrderValidatorTest(Order ord, Boolean success) {
		super();
		this.ord = ord;
		this.success = success;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> testdata() {
		ArrayList<Order> orders = new ArrayList<Order>();
		for (int i = 0; i < 16; i++) {
			orders.add(new Order());
		}
		//0: empty, 1-8: +1 mandatory correct field each; ie index 8 is correct
		for (int i = 1; i < orders.size(); i++) {
			orders.get(i).setQuantity(2); //another with <= 0
			if (i >= 2)
				orders.get(i).setCustname("custname");
			if (i >= 3)
				orders.get(i).setStreet("street");
			if (i >= 4)
				orders.get(i).setCity("city");
			if (i >= 5)
				orders.get(i).setZip("123"); //another with non digits
			if (i >= 6)
				orders.get(i).setCard("Visa"); //another with no supported
			if (i >= 7)
				orders.get(i).setCardnr("123"); //another with non digits
			if (i >= 8)
				orders.get(i).setCardexp("12/34"); //another with wrong num chars and /
		}
		//9 has wrong quantity, 10 has wrong zip, 11 has wrong card, 12 has wrong cardnr, 13 14 15 have wrong cardexp
		orders.get(9).setQuantity(-1);
		orders.get(10).setZip("haha");
		orders.get(11).setCard("haha");
		orders.get(12).setCardnr("haha");
		orders.get(13).setCardexp("hahah");
		orders.get(14).setCardexp("1/23");
		orders.get(15).setCardexp("ab/cd");
		return Arrays.asList(new Object[][] {
			{orders.get(0), false},
			{orders.get(1), false},
			{orders.get(2), false},
			{orders.get(3), false},
			{orders.get(4), false},
			{orders.get(5), false},
			{orders.get(6), false},
			{orders.get(7), false},
			{orders.get(8), true},
			
			{orders.get(9), false},
			{orders.get(10), false},
			{orders.get(11), false},
			{orders.get(12), false},
			{orders.get(13), false},
			{orders.get(14), false},
			{orders.get(15), false}
		});
	}
	
	@Test
	public void test() {
		CreateOrderValidator cv = new CreateOrderValidator();
		assertEquals(success, cv.isCreateOrder(ord));
	}

}
