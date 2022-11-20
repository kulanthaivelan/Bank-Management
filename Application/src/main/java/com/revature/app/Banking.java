package com.revature.app;

public class Banking {

	public Banking(int ACCOUNT_ID, int USER_ID, double BALANCE, int ACCOUNT_TYPE) {
		super();
	}

	public Banking(int ACCOUNT_ID, int ACCOUNT_TYPE,double BALANCE) {
		super();

		this.acctype = ACCOUNT_TYPE;
		this.balance = BALANCE;

	}

	

	private int acctype;
	private double balance;

	@Override
	public String toString() {
		if(acctype == 1) {return "ACCOUNT: SAVINGS "+ "|BALANCE: " + balance;}
		if(acctype == 0) {return "ACCOUNT: CHECKING "+ "|BALANCE: " + balance;}
		return Integer.toString(acctype);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banking other = (Banking) obj;
		if (acctype != other.acctype)
			return false;
		return true;

	}

	public int getAcctype() {
		return acctype;
	}

	public void setAcctype(int acctype) {
		this.acctype = acctype;
	}

}