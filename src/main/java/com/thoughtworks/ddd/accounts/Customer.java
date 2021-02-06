package com.thoughtworks.ddd.accounts;

import java.util.List;

public class Customer {
    List<BankAccount> bankAccounts;

    public Customer(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public void updateCustomerAddress(CustomerAddress customerAddress) {
        bankAccounts.forEach(account ->
                account.customerAddress = customerAddress
        );
    }
}
