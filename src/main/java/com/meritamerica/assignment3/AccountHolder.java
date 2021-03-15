package com.meritamerica.assignment3;

import java.util.Arrays;
import com.meritamerica.assignment3.CheckingAccount;
import com.meritamerica.assignment3.SavingsAccount;

public class AccountHolder {

	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	CheckingAccount[] checkingArray = new CheckingAccount[10];
	SavingsAccount[] savingsArray = new SavingsAccount[10];
	CDAccount[] CDAArray = new CDAccount[10];
	private static final double CHECKINGFEE = 250000;

	// Constructors
	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	// Account GETTERS and SETTERS

	// First name setter & getter

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String getFirstName() {
		return firstName;
	}

	// Middle name setter & getter

	protected void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	protected String getMiddleName() {
		return middleName;
	}

	// Last name setter & getter

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected String getLastName() {
		return lastName;
	}

	// SSN setter & getter

	protected void setSSN(String ssn) {
		this.ssn = ssn;
	}

	protected String getSSN() {
		return ssn;
	}

	public CheckingAccount addCheckingAccount(double openingBalance) {
		if (getCombinedBalance() - getCDBalance() + openingBalance <= CHECKINGFEE) {
			System.out.println("pass checking fee: ");
			CheckingAccount cac = new CheckingAccount(openingBalance);
			if (cac != null) {
				System.out.println("Account created: ");
				return addCheckingAccount(cac);
			}
		}
		return null;
	}

	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		if (getCombinedBalance() - getCDBalance() + checkingAccount.getBalance() <= CHECKINGFEE) {
			System.out.println("Account fee acepted: ");
			for (int i = 0; i < checkingArray.length; i++) {
				if (checkingArray[i] == null) {
					checkingArray[i] = checkingAccount;
					System.out.println(checkingArray.length + " add checking account");
					return checkingArray[i];
				}
			}
		}
		return null;
	}

	public CheckingAccount[] getCheckingAccounts() {
		return checkingArray;
	}

	public int getNumberOfCheckingAccount() {
		return checkingArray.length;
	}

	public double getCheckingBalance() {
		if (checkingArray != null) {
			double checkingBalance = 0.0;
			for (int i = 0; i < checkingArray.length; i++) {
				if (checkingArray[i] != null) {
					checkingBalance += checkingArray[i].getBalance();
				}
			}
			return checkingBalance;
		} else
			return 0;
	}

	public SavingsAccount addSavingsAccount(double openingBalance) {
		if (getCombinedBalance() - getCDBalance() + openingBalance <= CHECKINGFEE) {
			return addSavingsAccount(new SavingsAccount(openingBalance));
		}
		return null;
	}

	public SavingsAccount addSavingsAccount(SavingsAccount openingBalance) {
		if (getCombinedBalance() - getCDBalance() + openingBalance.getBalance() <= CHECKINGFEE) {
			for (int i = 0; i < savingsArray.length; i++) {
				if (savingsArray[i] == null) {
					savingsArray[i] = openingBalance;
					break;
				}
			}
		}
		return null;
	}

	public SavingsAccount[] getSavingsAccounts() {
		return savingsArray;
	}

	public int getNumberOfSavingsAccounts() {
		return savingsArray.length;
	}

	public double getSavingsBalance() {
		if (savingsArray != null) {
			double savingsBalance = 0.0;
			for (int i = 0; i < savingsArray.length; i++) {
				if (savingsArray[i] != null) {
					savingsBalance += savingsArray[i].getBalance();
				}
			}
			return savingsBalance;
		}
		return 0;
	}

	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		if (MeritBank.getCDOfferings() != null) {
			return addCDAccount(new CDAccount(offering, openingBalance));
		}
		return null;
	}

	public CDAccount addCDAccount(CDAccount cdAccount) {
		for (int i = 0; i < CDAArray.length; i++) {
			if (CDAArray[i] == null) {
				CDAArray[i] = cdAccount;
				return cdAccount;
			}
		}

		return null;
	}

	public CDAccount[] getCDAccounts() {
		return CDAArray;
	}

	public int getNumberOfCDAccounts() {
		return CDAArray.length;
	}

	public double getCDBalance() {
		if (CDAArray != null) {
			double CDBalance = 0.0;
			for (int i = 0; i < CDAArray.length; i++) {
				if (CDAArray[i] != null) {
					CDBalance += CDAArray[i].getBalance();
				}
			}
			return CDBalance;
		}
		return 0;
	}

	public double getCombinedBalance() {
		double res = getCheckingBalance() + getSavingsBalance() + getCDBalance();
		System.out.println(res);
		return res;
	}
}