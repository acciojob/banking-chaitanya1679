package com.driver;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId;
    //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000.0);
        if(balance<5000) throw new Exception("Insufficient Balance");
        this.tradeLicenseId=tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char[]arr=tradeLicenseId.toCharArray();
        int[]freq=new int[26];
        if(isValid(arr)) return;
        int n=tradeLicenseId.length();
        int maxm=0, letter=0;
        for(int i=0;i<n;i++){
            int x=arr[i]-'A';
            freq[x]++;
            if(freq[x]>maxm){
                maxm=freq[x];
                letter=x;
            }
        }
        if(maxm>(n+1)/2) throw new Exception("Valid License can not be generated");
        char []res=new char[n];
        int idx=0;
        while(idx<n && freq[letter]-->0){
            res[idx]=(char)(letter+'A');
            idx+=2;
        }
        for(int i=0;i<26;i++){
            while(freq[i]-->0){
                if(idx>=n) idx=1;
                res[idx]=(char)(i+'A');
                idx+=2;
            }

        }
        this.tradeLicenseId=String.copyValueOf(res);
    }
    private boolean isValid(char[]arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]) return false;
        }
        return true;
    }
}