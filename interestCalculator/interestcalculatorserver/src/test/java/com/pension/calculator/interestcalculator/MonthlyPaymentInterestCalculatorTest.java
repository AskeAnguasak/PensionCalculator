package com.pension.calculator.interestcalculator;

import static org.junit.Assert.assertEquals;

import com.pension.calculator.interestcalculator.MonthlyPaymentInterestCalculator;
import org.junit.Test;

public class MonthlyPaymentInterestCalculatorTest {
	
	private static final double ACCEPTEDDELTA = 0.0000001;
	
	@Test
    public void calculateAmountAfterNYearsCalculatesCorrect() throws Exception {
		double payment = 7000.;
		double yearlyInterestAsFraction = 0.06;
		int numberOfYears = 45;
        MonthlyPaymentInterestCalculator monthlyPaymentInterestCalculator = new MonthlyPaymentInterestCalculator();
        double expectedFinalAmount = 19395408.04;
        double calculatedFinalAmount = monthlyPaymentInterestCalculator.
        		calculateAmountAfterNYears(payment, yearlyInterestAsFraction, numberOfYears);
        String failureMessage = "The expected final com.pension.calculator.amount for initial payment: " +
        		payment + ", yearly interest: " + yearlyInterestAsFraction + ", and number of years: " + numberOfYears +
        		" is: " + expectedFinalAmount + ".";
        assertEquals(failureMessage, expectedFinalAmount, calculatedFinalAmount, ACCEPTEDDELTA);
    }
	
	@Test
    public void calculateMonthlyPayoutAfterNYearsCalculatesCorrect() throws Exception {
		double payment = 5000.;
		double yearlyInterestAsFraction = 0.05;
		int numberOfYearsPayment = 45;
		int numberOfYearsPayout = 25;
        MonthlyPaymentInterestCalculator monthlyPaymentInterestCalculator = new MonthlyPaymentInterestCalculator();
        double expectedMonthlyPayout = 59507.78;
        double calculatedMonthlyPayout = monthlyPaymentInterestCalculator.
        		calculateMonthlyPayoutAfterNYears(payment, yearlyInterestAsFraction, numberOfYearsPayment, numberOfYearsPayout);
        String failureMessage = "The expected monthly payout for initial payment: " + 
        		payment + ", yearly interest: " + yearlyInterestAsFraction + ", and number of years: " + numberOfYearsPayment +
        		" is: " + expectedMonthlyPayout + ".";
        assertEquals(failureMessage, expectedMonthlyPayout, calculatedMonthlyPayout, ACCEPTEDDELTA);
    }

}
