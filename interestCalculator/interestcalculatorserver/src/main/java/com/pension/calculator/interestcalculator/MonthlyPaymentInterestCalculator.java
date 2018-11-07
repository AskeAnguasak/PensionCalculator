package com.pension.calculator.interestcalculator;

import org.apache.commons.math3.util.Precision;

public class MonthlyPaymentInterestCalculator extends CompoundInterestCalculator {
	
	public double calculateAmountAfterNYears(
			double monthlyPayment, 
			double interestRate, 
			int yearsToPaymentStop
			) {
		double finalAmount = 0.;
		for(int i = 0; i <= yearsToMonths(yearsToPaymentStop); i++) {
			finalAmount += calculateRoundedMonthlyAmountOnePayment(monthlyPayment, interestRate, i);
		}
		return Precision.round(finalAmount, 2);
	}
	
	public double calculateMonthlyPayoutAfterNYears(
			double monthlyPayment, 
			double interestRate, 
			int yearsToPaymentStop,
			int yearsToPayoutStop
			) {
		double startingBalance = calculateAmountAfterNYears(monthlyPayment, interestRate, yearsToPaymentStop);
		double numerator = calculateRoundedMonthlyAmountOnePayment(startingBalance, interestRate, 
				yearsToMonths(yearsToPayoutStop));
		double denominator = 0;
		for(int i = 0; i < yearsToMonths(yearsToPayoutStop); i++) {
			denominator += monthlyInterestRate(interestRate, i);
		}
		return Precision.round(numerator/denominator, 2);
	}
	
	private int yearsToMonths(int years) {
		return 12*years;
	}

}