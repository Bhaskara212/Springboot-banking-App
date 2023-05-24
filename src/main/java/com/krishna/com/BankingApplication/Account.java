package com.krishna.com.BankingApplication;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Account {
	
	@Id
	private int AccountId;
	private String AccountHolderName;
	private int MobileNumber;
	private String Branch;
	private double BalanceAmount;
	
	
    public Account() {
		
	}
	public Account(int AccountId,String AccountHolderName,int MobileNumber ,String Branch,double BalanceAmount) {
		this.AccountId=AccountId;
		this.AccountHolderName=AccountHolderName;
		this.MobileNumber=MobileNumber;
		this.Branch=Branch;
		this.BalanceAmount=BalanceAmount;
	}
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	public String getAccountHolderName() {
		return AccountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}
	public int getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public double getBalanceAmount() {
		return BalanceAmount;
	}
	public void setBalanceAmount(double balanceAmount) {
		BalanceAmount = balanceAmount;
	}
	

}
