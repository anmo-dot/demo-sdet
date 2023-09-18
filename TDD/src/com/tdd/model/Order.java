package com.tdd.model;

public class Order {
	private String product;
	private int quantity;
	private double price;
	private int discount;
	private String custname;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String card;
	private String cardnr;
	private String cardexp;

	public Order() {
		super();
		this.product = "MyMoney";
		this.quantity = 0;
		this.price = 100;
		this.discount = 0;
		this.custname = "";
		this.street = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.card = "";
		this.cardnr = "";
		this.cardexp = "";
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getCardnr() {
		return cardnr;
	}
	public void setCardnr(String cardnr) {
		this.cardnr = cardnr;
	}
	public String getCardexp() {
		return cardexp;
	}
	public void setCardexp(String cardexp) {
		this.cardexp = cardexp;
	}
	
	
}
