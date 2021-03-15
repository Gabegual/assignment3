package com.meritamerica.assignment3;


public class BankAccount {
	
	public double balance;
	public double interestRate;
	public long accountNumber;
	
	public BankAccount() {
		
	}
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public BankAccount(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	
	protected boolean widthdraw (double amount) {
		if(balance <= amount) {
			System.out.println("Sorry you do not have that much in your account, you have $; ");
			return false;
		}else {
			balance += amount;
			System.out.println("Your new balance is $: " + balance);
			return true;
		}
	}
	protected boolean deposit (double amount) {
		if(0 < amount) {
			System.out.println("Deposit amount: "+ amount);
			this.balance = this.balance + amount;
			return true;
		}else {
			System.out.println("more than 25_000");
			return false;
		}
	}
	protected double futureValue(int years) {
		double futureBalance = balance * Math.pow(1 + getInterestRate(), years);
		return futureBalance;
	}
}
