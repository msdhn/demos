package com.hcl.ingbootcamp.javadesignpattern.builder;

/**
 * @author masud
 */
public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private String bankName;
    private String branch;
    private double rate;
    private double openingBalance;

    // Fields omitted for brevity.
    private BankAccount() {
        // Constructor is now private.
    }

    public static BankAccountBuilder builder(String accountNumber) {
        return new BankAccountBuilder(accountNumber);
    }

    public static class BankAccountBuilder {

        private String accountNumber;
        private String accountHolder;
        private String bankName;
        private String branch;
        private double rate;
        private double openingBalance;

        public BankAccountBuilder(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public BankAccountBuilder holder(String holderNmae) {
            this.accountHolder = holderNmae;
            return this;
        }

        public BankAccountBuilder with(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public BankAccountBuilder withRate(double rate) {
            this.rate = rate;
            return this;
        }

        public BankAccountBuilder inBranch(String branch) {
            this.branch = branch;
            return this;
        }

        public BankAccountBuilder openingWith(double openingBalance) {
            this.openingBalance = openingBalance;
            return this;
        }

        public BankAccount build() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.accountHolder = this.accountHolder;
            bankAccount.accountNumber = this.accountNumber;
            bankAccount.bankName = this.bankName;
            bankAccount.branch = this.branch;
            bankAccount.openingBalance = this.openingBalance;
            bankAccount.rate = this.rate;
            return bankAccount;
        }
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return the accountHolder
     */
    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @return the openingBalance
     */
    public double getOpeningBalance() {
        return openingBalance;
    }

}
