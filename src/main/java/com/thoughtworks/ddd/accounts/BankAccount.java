package com.thoughtworks.ddd.accounts;

public class BankAccount {
    Long accountNumber;
    CustomerAddress customerAddress;

    public BankAccount(Long accountNumber, CustomerAddress customerAddress) {
        this.accountNumber = accountNumber;
        this.customerAddress = customerAddress;
    }

    public void updateAddress(CustomerAddress updatedAddress) {
        this.customerAddress = updatedAddress;
    }
}
