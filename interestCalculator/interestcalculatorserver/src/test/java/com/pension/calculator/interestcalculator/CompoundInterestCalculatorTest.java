package com.pension.calculator.interestcalculator;

import com.pension.calculator.interestcalculator.CompoundInterestCalculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompoundInterestCalculatorTest {
	
	private static final double ACCEPTEDDELTA = 0.0000001;
	
	@Test
    public void calculateYearlyInterestOnePaymentCalculatesCorrect() throws Exception {
		double payment = 10000.;
		double yearlyInterestAsFraction = 0.06;
		double numberOfYears = 3.;
        CompoundInterestCalculator simpleInterestCalculator = new CompoundInterestCalculator();
        double expectedInterest = 11910.16;
        double calculatedInterest = simpleInterestCalculator.
        		calculateYearlyAmountOnePayment(payment, yearlyInterestAsFraction, numberOfYears);
        String failureMessage = "The expected interest for initial payment: " + 
        		payment + ", yearly interest: " + yearlyInterestAsFraction + ", and number of years: " + numberOfYears +
        		" is: " + expectedInterest + ".";
        assertEquals(failureMessage, expectedInterest, calculatedInterest, ACCEPTEDDELTA);
    }
	
	@Test
    public void calculateMonthlyInterestOnePaymentCalculatesCorrect() throws Exception {
		double payment = 10000.;
		double yearlyInterestAsFraction = 0.06;
		double numberOfMonths = 3.;
        CompoundInterestCalculator simpleInterestCalculator = new CompoundInterestCalculator();
        double expectedInterest = 10150.75124999;
        double calculatedInterest = simpleInterestCalculator.
        		calculateMonthlyAmountOnePayment(payment, yearlyInterestAsFraction, numberOfMonths);
        String failureMessage = "The expected interest for initial payment: " + 
        		payment + ", yearly interest: " + yearlyInterestAsFraction + ", and number of years: " + numberOfMonths +
        		" is: " + expectedInterest + ".";
        assertEquals(failureMessage, expectedInterest, calculatedInterest, ACCEPTEDDELTA);
    }

}
