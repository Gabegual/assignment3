package com.meritamerica.assignment3;

import java.util.Date;
import java.util.Date;
public class CDAccount extends BankAccount {
	
	CDOffering offering;
	Date date;
	
	public CDAccount(CDOffering offering, double balance) {
		super(balance);
		this.date = new Date();
		this.offering = offering;
	}
	
//	public double getBalance() {
//		return this.balance;
//	}
	
	public double getInterestRate() {
		return this.offering.getInterestRate();
	}
	
	public int getTerm() {
		return this.offering.getTerm();
	}
	
	public double futureValue() {
		return getBalance()*Math.pow(getInterestRate(), getTerm());
	}
}
