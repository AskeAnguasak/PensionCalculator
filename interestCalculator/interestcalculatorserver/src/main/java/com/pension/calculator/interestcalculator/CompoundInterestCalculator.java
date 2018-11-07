package com.pension.calculator.interestcalculator;

import java.lang.Math;
import org.apache.commons.math3.util.Precision;

public class CompoundInterestCalculator {
	
	public double calculateRoundedYearlyAmountOnePayment(
			double payment, 
			double yearlyInterestAsFraction, 
			double numberOfYears
			) {
		
		return Precision.round(payment*yearlyInterestRate(yearlyInterestAsFraction, 
				numberOfYears), 2);
	}
	
	public double calculateRoundedMonthlyAmountOnePayment(
			double payment, 
			double yearlyInterest, 
			double numberOfMonths
			) {
		
		return Precision.round(payment*monthlyInterestRate(yearlyInterest, 
				numberOfMonths), 2);
	}
	
	public double calculateYearlyAmountOnePayment(
			double payment, 
			double yearlyInterestAsFraction, 
			double numberOfYears
			) {
		
		return payment*yearlyInterestRate(yearlyInterestAsFraction, 
				numberOfYears);
	}
	
	public double calculateMonthlyAmountOnePayment(
			double payment, 
			double yearlyInterest, 
			double numberOfMonths
			) {
		
		return payment*monthlyInterestRate(yearlyInterest, 
				numberOfMonths);
	}
	
	private double yearlyInterestRate(
			double yearlyInterest,
			double numberOfYears
			) {
		return Math.pow((1 + yearlyInterest), numberOfYears);
	}
	
	protected double monthlyInterestRate(
			double yearlyInterest,
			double numberOfMonths
			) {
		return Math.pow((1 + yearlyInterest/12), numberOfMonths);
	}

}
