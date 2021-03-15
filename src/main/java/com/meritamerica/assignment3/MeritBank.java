package com.meritamerica.assignment3;

import java.util.Arrays;
import java.util.Random;

public class MeritBank {

	public static AccountHolder[] myAccountHolder = new AccountHolder[10];
	public static CDOffering[] myCDOffering = new CDOffering[10];
	public static CDAccount myCDAccount[] = new CDAccount[10];
	private static long nextAccount;

//	public static void addAccountHolder(AccountHolder accountHolder) {
////		AccountHolder[] myAccountHolder1 = new AccountHolder[myAccountHolder.length + 1];
//		for (int i = 0; i < myAccountHolder.length; i++) {
//			myAccountHolder1[i] = myAccountHolder[i];
//		}
//		myAccountHolder = myAccountHolder1;
//		myAccountHolder[myAccountHolder.length - 1] = accountHolder;
//	}
	public static void addAccountHolder(AccountHolder accountHolder) {
		for(int i = 0; i < myAccountHolder.length - 1; i++) {
			if(myAccountHolder[i] == null) {
				myAccountHolder[i] = accountHolder;
				break;
			}
			if(myAccountHolder.length > 10) {
				System.out.println("Sorry you cannot create more create more accounts");
			}
		}
	}
	public static AccountHolder[] getAccountHolders() {
		System.out.println("account Holder" + myAccountHolder[0]);
		return myAccountHolder;
	}

	public static CDOffering[] getCDOfferings() {
		return myCDOffering;
	}

	public static CDOffering getBestCDOffering(double depositAmount) {
		double best = 0.0;
		CDOffering CDO = null;
		if (myCDOffering == null) {
			return null;
		}
		for (int i = 0; i < myCDOffering.length; i++) {
			if (futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm()) > best) {
				CDO = myCDOffering[i];
				best = futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm());
			}
		}
		return CDO;
	}

	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		double secondBest = 00;
		CDOffering CDO = null;
		CDOffering CDB = null;
		if (myCDOffering == null) {
			return null;
		}
		for (int i = 0; i < myCDOffering.length; i++) {
			if (futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm()) > secondBest) {
				CDB = CDO;
				CDO = myCDOffering[i];
				secondBest = futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm());
			}
		}
		return CDB;
	}

	public static void clearCDOfferings() {
		myCDOffering = null;
	}

	public static void setCDOfferings(CDOffering[] offerings) {
		myCDOffering = offerings;
	}

	public static long getNextAccountNumber() {
		return nextAccount;
	}

	public static double totalBalances() {
		double total = 0;
		for (int i = 0; i < myAccountHolder.length; i++) {
			total += myAccountHolder[i].getCombinedBalance();
		}
		return total;
	}

	static double futureValue(double presentValue, double interestRate, int term) {
		double futureValue = presentValue * Math.pow(1 + interestRate, term);
		return futureValue;
	}

}
