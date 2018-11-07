package com.pension.calculator.amount;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AmountFromPaymentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void displayMonthlyPayout() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/monthlyPayout?monthlyPayment=5000.&interestRate=0.04&yearsToPaymentStop=35&yearsToPayoutStop=20")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("The monthly payout is: 27807.73")));
    }

    @Test
    public void displayTotalAmountAfterNYears() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/totalAmount?monthlyPayment=5000.&interestRate=0.04&yearsToPaymentStop=35")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("The total amount after 35 of monthly payments is: 4588883.62")));
    }
}