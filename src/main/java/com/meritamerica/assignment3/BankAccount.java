package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount {

	public double balance;
	public double interestRate;
	public long accountNumber;
	double bankAccount;
	protected java.util.Date accountOpenedOn;
//
	protected SimpleDateFormat dateOpened = new SimpleDateFormat("MM/DD/YYYY");

	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn) {
		this.accountOpenedOn = accountOpenedOn;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public BankAccount(long accountNumber, double blance, double interestRate, java.util.Date accountOpenedOn) {
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;

	}
//
	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public long setAccountNumber() {
		return this.accountNumber;
	}

	public java.util.Date getOpenedOn() {
		return this.accountOpenedOn;
	}
//
	protected boolean widthdraw(double amount) {
		if (balance <= amount) {
			System.out.println("Sorry you do not have that much in your account, you have $; ");
			return false;
		} else {
			balance += amount;
			System.out.println("Your new balance is $: " + balance);
			return true;
		}
	}
//
	protected boolean deposit(double amount) {
		if (0 < amount) {
			System.out.println("Deposit amount: " + amount);
			this.balance = this.balance + amount;
			return true;
		} else {
			System.out.println("more than 25_000");
			return false;
		}
	}
//
	protected double futureValue(int years) {
		double futureBalance = balance * Math.pow(1 + getInterestRate(), years);
		return futureBalance;
	}
//
	public static BankAccount readFromString(String accountData) throws ParseException {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/DD/YYYY");

		try {

			String storage1[] = accountData.split(",");

			int formattedAccount = Integer.parseInt(storage1[0]);
			double formattedBalance = Double.parseDouble(storage1[1]);
			double formattedInterest = Double.parseDouble(storage1[2]);
			Date formattedDate = (Date) dateFormatter.parse(storage1[3]);

			BankAccount formattedBank = new BankAccount(formattedAccount, formattedBalance, formattedInterest,
					formattedDate);

			return formattedBank;
		} catch (ParseException e) {
			return null;
		}

	}

	public String writeToSTring() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/DD/YYYY");

		return this.accountNumber + "," + this.balance + "," + this.interestRate + ","
				+ dateFormatter.format(this.accountOpenedOn);
	}
}
