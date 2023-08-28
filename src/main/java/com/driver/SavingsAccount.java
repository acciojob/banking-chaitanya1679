package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;

    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>maxWithdrawalLimit)throw new Exception("Maximum Withdraw Limit Exceeded");
        if(getBalance()<amount) throw new Exception("Insufficient Balance");

        setBalance(getBalance()-amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest= (getBalance()*rate*years)/100.0;
//        setBalance(getBalance()+interest);
        return getBalance()+interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double finalamount=0.0;// this.getBalance()*((100.0+rate)/100.0)^(times*years);
        finalamount=Math.pow(((100.0+rate/times)/100.0),(times*years)*1.0)*getBalance();
//        setBalance(finalamount);
        return finalamount;
    }

}