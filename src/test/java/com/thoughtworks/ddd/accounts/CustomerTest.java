package com.thoughtworks.ddd.accounts;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CustomerTest {

    @Test
    public void shouldUpdateBankAccountAddress() {
        CustomerAddress customerAddress = new CustomerAddress("Pune");
        BankAccount bankAccount1 = new BankAccount(12345L, customerAddress);
        BankAccount bankAccount2 = new BankAccount(12346L, customerAddress);
        Customer customer = new Customer(new ArrayList<BankAccount>() {{
            add(bankAccount1);
            add(bankAccount2);
        }});

        CustomerAddress updatedAddress = new CustomerAddress("Bombay");
        customer.updateCustomerAddress(updatedAddress);

        Assert.assertEquals(updatedAddress, customer.bankAccounts.get(0).customerAddress);
        Assert.assertEquals(updatedAddress, customer.bankAccounts.get(1).customerAddress);
    }
}