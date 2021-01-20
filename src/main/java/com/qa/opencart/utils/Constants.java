package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
	//***************Common Components*****************
	public static List<String> getCommonHeadersList(){
		List<String> headersList=Arrays.asList(new String[] {"Desktops","Laptops & Notebooks","Components","Tablets","Software","Phones & PDAs","Cameras","MP3 Players"});
		return headersList;
	}
	
	
	//*****************Login Page*******************
	public static final String LOGIN_PAGE_TITLE="Account Login";
	
	
	//*****************Accounts Page*******************
	public static final String ACCOUNTS_PAGE_TITLE="My Account";
	public static final String ACCOUNTS_PAGE_HEADER = "Your Store";
	public static final int ACCOUNTS_SECTIONS = 4;
	
	public static List<String> getAccountSecHeadersList(){
		List<String> accountsList = new ArrayList<String>();
		accountsList.add("My Account");
		accountsList.add("My Orders");
		accountsList.add("My Affiliate Account");
		accountsList.add("Newsletter");		
		return accountsList;		
	}
	
	//***************Register Page****************************
	public static final String REGISTER_SHEET_NAME="registeration";
	public static final String ACCOUNT_CREATION_SUCCESS_MSG="Your Account Has Been Created";
}
