package com.WebOrder;

import org.testng.annotations.DataProvider;

public class WebOrder_TestData {

	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() {
		return new Object[][] { { "Tester", "test" }, { "Tester", "test" }, { "Tester", "test" }, };
	}

	@DataProvider(name = "WebOrder_Login_All_TCs")
	public Object[][] getLogin_All_TCs_Scenarios() {
		return new Object[][] { { "Tester", "test", "Logout" }, { "Tester1", "test", "Invalid Login or Password." },
				{ "Tester", "test1", "Invalid Login or Password." }, { "", "test", "Invalid Login or Password." },
				{ "Tester", "", "Invalid Login or Password." }, };
	}

	@DataProvider(name = "WebOrder_CreateOrder_All_TCs")
	public Object[][] createOrder_All_TCs() {
		return new Object[][] {
				{ "MyMoney", "5", "Minh", "123 Main St", "Dallas", "75000", "Visa", "123456789", "12/23", "valid" },
				{ "MyMoney", "5", "Nguyen", "123 Main St", "Dallas", "75000", "MasterCard", "123456789", "12/23",
						"valid" },
				{ "MyMoney", "", "Minh", "123 Main St", "Dallas", "75000", "Visa", "123456789", "12/23",
						"empty_quantity" },
				{ "MyMoney", "0", "Minh", "123 Main St", "Dallas", "75000", "Visa", "123456789", "12/23",
						"invalid_quantity" },
				{ "MyMoney", "5", "", "123 Main St", "Dallas", "75000", "Visa", "123456789", "12/23", "empty_name" },
				{ "MyMoney", "5", "Minh", "", "Dallas", "75000", "Visa", "123456789", "12/23", "empty_street" },
				{ "MyMoney", "5", "Minh", "123 Main St", "", "75000", "Visa", "123456789", "12/23", "empty_city" },
				{ "MyMoney", "5", "Minh", "123 Main St", "Dallas", "", "Visa", "123456789", "12/23", "empty_zip" },
				{ "MyMoney", "5", "Minh", "123 Main St", "Dallas", "abcde", "Visa", "123456789", "12/23",
						"invalid_zip" },
				{ "MyMoney", "5", "Minh", "123 Main St", "Dallas", "75000", "", "123456789", "12/23", "empty_card" },
				{ "MyMoney", "5", "Minh", "123 Main St", "Dallas", "75000", "Visa", "", "12/23", "empty_cardnr" },
				{ "MyMoney", "5", "Minh", "123 Main St", "Dallas", "75000", "Visa", "abcdef", "12/23",
						"invalid_cardnr" },
				{ "MyMoney", "5", "Minh", "123 Main St", "Dallas", "75000", "Visa", "123456789", "", "empty_expdate" },
				{ "MyMoney", "5", "Minh", "123 Main St", "Dallas", "75000", "Visa", "123456789", "abcdef",
						"invalid_date" },
				{ "MyMoney", "5", "Minh", "123 Main St", "Dallas", "75000", "Visa", "123456789", "12-23",
						"invalid_date" }, };
	}

	@DataProvider(name = "LoginExcelData")
	public Object[][] ReadDataFromExcel() throws Exception {
		ReadExcel excel = new ReadExcel();
		// String RelativePath = System.getProperty("user.dir");
		Object[][] testObjArray = excel.getExcelData(
				"C:\\MinhEclipse\\SeleniumWebDriver\\TestDataFiles\\WebOrder_Login.xlsx",
				"Sheet1");
		// Object[][] testObjArray =
		// excel.getExcelData(RelativePath+"\\OrangeHRM_TestData.xls","SignIn");
		System.out.println(testObjArray);
		return testObjArray;

	}

}
