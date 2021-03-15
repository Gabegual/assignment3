package com.meritamerica.assignment3;
import java.util.*;
import java.text.*;
//CheckingAccount
//Create appropriate constructors
//static CheckingAccount readFromString(String accountData) throws ParseException
//Should throw a java.lang.NumberFormatException if String cannot be correctly parsed

//1,1000,0.0001,01/01/2020
public class CheckingAccount extends BankAccount{
	
		private static double balance;
		private static double interestRate = 0.0001;
		private static Date date;
		
		
		public CheckingAccount(double openingBalance, double interestRate) {
			super(openingBalance, interestRate);
		}
		
		public CheckingAccount(long accountNumber, double openingBalance, double interestRate, Date date) {
			super(accountNumber, openingBalance, interestRate, date);
		}
		
		public static CheckingAccount readFromString(String accountData) throws ParseException {
			
			SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/DD/YYYY");
			
				String[] CHA = accountData.split(",");
			
			long accountNumber = Long.parseLong(CHA[0]);
			double balance = Double.parseDouble(CHA[1]);
			double interestRate = Double.parseDouble(CHA[2]);
			Date date = dateFormatter.parse(CHA[3]);
			
			CheckingAccount newCheckingAccountInfo = new CheckingAccount(accountNumber, balance, interestRate, date);
			
			return newCheckingAccountInfo;
			
		}
}
