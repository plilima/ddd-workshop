package com.thoughtworks.ddd.accounts;

import java.util.List;
import java.util.UUID;

//Aggregate
public class Customer {
    private final UUID identifier;
    List<BankAccount> bankAccounts;

    public Customer(List<BankAccount> bankAccounts) {
        this.identifier = UUID.randomUUID();
        this.bankAccounts = bankAccounts;
    }

    public void updateCustomerAddress(CustomerAddress customerAddress) {
        bankAccounts.forEach(account ->
                account.updateAddress(customerAddress)
        );
    }
}
