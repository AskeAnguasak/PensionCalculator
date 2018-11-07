package com.pension.calculator.amount;

import org.springframework.web.bind.annotation.RestController;

import com.pension.calculator.interestcalculator.MonthlyPaymentInterestCalculator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AmountFromPaymentController {

    @RequestMapping("/monthlyPayout")
    public String displayMonthlyPayout(
    		@RequestParam("monthlyPayment") double monthlyPayment, 
    		@RequestParam("interestRate") double interestRate,
    		@RequestParam("yearsToPaymentStop") int yearsToPaymentStop,
    		@RequestParam("yearsToPayoutStop") int yearsToPayoutStop
    		) {
        return "The monthly payout is: " + monthlyPayout(
        		monthlyPayment, 
    			interestRate, 
    			yearsToPaymentStop, 
    			yearsToPayoutStop);
    }
    
    @RequestMapping("/totalAmount")
    public String displayTotalAmountAfterNYears(
    		@RequestParam("monthlyPayment") double monthlyPayment, 
    		@RequestParam("interestRate") double interestRate,
    		@RequestParam("yearsToPaymentStop") int yearsToPaymentStop
    		) {
        return "The total amount after " + yearsToPaymentStop + " of monthly payments is: " +
				totalAmountAfterNYears(monthlyPayment, interestRate, yearsToPaymentStop);
    }


    private double monthlyPayout(double monthlyPayment,
								 double interestRate,
								 int yearsToPaymentStop,
								 int yearsToPayoutStop) {
    	MonthlyPaymentInterestCalculator monthlyPaymentInterestCalculator = 
    			new MonthlyPaymentInterestCalculator();
    	return monthlyPaymentInterestCalculator.calculateMonthlyPayoutAfterNYears(
    			monthlyPayment, 
    			interestRate, 
    			yearsToPaymentStop, 
    			yearsToPayoutStop);
    }

	private double totalAmountAfterNYears(double monthlyPayment,
									double interestRate,
									int yearsToPaymentStop) {
		MonthlyPaymentInterestCalculator monthlyPaymentInterestCalculator =
				new MonthlyPaymentInterestCalculator();
		return monthlyPaymentInterestCalculator.calculateAmountAfterNYears(
				monthlyPayment,
				interestRate,
				yearsToPaymentStop);
	}
    
}