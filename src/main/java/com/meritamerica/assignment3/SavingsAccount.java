package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccount extends BankAccount {
	private static double balance;
	private static double interestRate = 0.0001;
	private static Date date;
	
	
	public SavingsAccount(double openingBalance, double interestRate) {
		super(openingBalance, interestRate);
	}
	
	public SavingsAccount(long accountNumber, double openingBalance, double interestRate, Date date) {
		super(accountNumber, openingBalance, interestRate, date);
	}
	
	public static SavingsAccount readFromString(String accountData) throws ParseException {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/DD/YYYY");
		
			String[] CHA = accountData.split(",");
		
		long accountNumber = Long.parseLong(CHA[0]);
		double balance = Double.parseDouble(CHA[1]);
		double interestRate = Double.parseDouble(CHA[2]);
		Date date = dateFormatter.parse(CHA[3]);
		
		SavingsAccount newSavingsAccountInfo = new SavingsAccount(accountNumber, balance, interestRate, date);
		
		return newSavingsAccountInfo;
		
	}
}
