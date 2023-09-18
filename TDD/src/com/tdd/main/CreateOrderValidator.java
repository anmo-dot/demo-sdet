package com.tdd.main;

import com.tdd.model.Order;

public class CreateOrderValidator {

	private Boolean isNumber(String str) {
		try {
			int i = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	public Boolean isCreateOrder(Order ord) {
		// TODO Auto-generated method stub
		return 
				(ord.getProduct().equals("MyMoney") || 
						ord.getProduct().equals("FamilyAlbum") || ord.getProduct().equals("ScreenSaver"))
				&&
				(ord.getQuantity() > 0)
				&&
				(!ord.getCustname().equals(""))
				&&
				(!ord.getStreet().equals(""))
				&&
				(!ord.getCity().equals(""))
				&&
				(!ord.getZip().equals("") && isNumber(ord.getZip()))
				&&
				(ord.getCard().equals("Visa") || 
						ord.getCard().equals("MasterCard") || ord.getCard().equals("American Express"))
				&&
				(!ord.getCardnr().equals("") && isNumber(ord.getCardnr()))
				&&
				(ord.getCardexp().length()==5 && 
						isNumber(ord.getCardexp().substring(0,2)) && isNumber(ord.getCardexp().substring(3)) 
						&& ord.getCardexp().charAt(2) == '/')
				;
		
	}

}
