package com.chainsys.external.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bank {

	private String username;
	private String password;
	private boolean flag;
	private String id;
	private String name;
	private String fathersName;
	private String email;
	private Long phonenumber;
	private String gender;
	private BigDecimal balance;
	private Long accountnumber;
	private LocalDate dob;
	private String p_Address;
	private String p_City;
	private String c_Address;
	private String c_City;
	private String state;
	private String ifsc;
	private LocalDate createdDate;
	private LocalDate ModifiedDate;
	private long mmid;
	private long TransactionID;
	private String cbal;
	private String amt;
	private String tdate;
	
	
	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getCbal() {
		return cbal;
	}

	public void setCbal(String cbal) {
		this.cbal = cbal;
	}

	public long getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(long transactionID) {
		TransactionID = transactionID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public long getMmid() {
		return mmid;
	}

	public void setMmid(long mmid) {
		this.mmid = mmid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getP_Address() {
		return p_Address;
	}

	public void setP_Address(String p_Address) {
		this.p_Address = p_Address;
	}

	public String getP_City() {
		return p_City;
	}

	public void setP_City(String p_City) {
		this.p_City = p_City;
	}

	public String getC_Address() {
		return c_Address;
	}

	public void setC_Address(String c_Address) {
		this.c_Address = c_Address;
	}

	public String getC_City() {
		return c_City;
	}

	public void setC_City(String c_City) {
		this.c_City = c_City;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Bank [username=" + username + ", password=" + password + ", flag=" + flag + ", id=" + id + ", name="
				+ name + ", fathersName=" + fathersName + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", gender=" + gender + ", balance=" + balance + ", accountnumber=" + accountnumber + ", dob=" + dob
				+ ", p_Address=" + p_Address + ", p_City=" + p_City + ", c_Address=" + c_Address + ", c_City=" + c_City
				+ ", state=" + state + ", ifsc=" + ifsc + ", createdDate=" + createdDate + ", ModifiedDate="
				+ ModifiedDate + ", mmid=" + mmid + ", TransactionID=" + TransactionID + ", cbal=" + cbal + ", amt="
				+ amt + ", tdate=" + tdate + ", getTdate()=" + getTdate() + ", getAmt()=" + getAmt() + ", getCbal()="
				+ getCbal() + ", getTransactionID()=" + getTransactionID() + ", getId()=" + getId()
				+ ", getAccountnumber()=" + getAccountnumber() + ", getPhonenumber()=" + getPhonenumber()
				+ ", getMmid()=" + getMmid() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", isFlag()=" + isFlag() + ", getName()=" + getName() + ", getFathersName()=" + getFathersName()
				+ ", getEmail()=" + getEmail() + ", getGender()=" + getGender() + ", getBalance()=" + getBalance()
				+ ", getDob()=" + getDob() + ", getP_Address()=" + getP_Address() + ", getP_City()=" + getP_City()
				+ ", getC_Address()=" + getC_Address() + ", getC_City()=" + getC_City() + ", getState()=" + getState()
				+ ", getIfsc()=" + getIfsc() + ", getCreatedDate()=" + getCreatedDate() + ", getModifiedDate()="
				+ getModifiedDate() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ModifiedDate == null) ? 0 : ModifiedDate.hashCode());
		result = prime * result + (int) (TransactionID ^ (TransactionID >>> 32));
		result = prime * result + ((accountnumber == null) ? 0 : accountnumber.hashCode());
		result = prime * result + ((amt == null) ? 0 : amt.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((c_Address == null) ? 0 : c_Address.hashCode());
		result = prime * result + ((c_City == null) ? 0 : c_City.hashCode());
		result = prime * result + ((cbal == null) ? 0 : cbal.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fathersName == null) ? 0 : fathersName.hashCode());
		result = prime * result + (flag ? 1231 : 1237);
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ifsc == null) ? 0 : ifsc.hashCode());
		result = prime * result + (int) (mmid ^ (mmid >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((p_Address == null) ? 0 : p_Address.hashCode());
		result = prime * result + ((p_City == null) ? 0 : p_City.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((tdate == null) ? 0 : tdate.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (ModifiedDate == null) {
			if (other.ModifiedDate != null)
				return false;
		} else if (!ModifiedDate.equals(other.ModifiedDate))
			return false;
		if (TransactionID != other.TransactionID)
			return false;
		if (accountnumber == null) {
			if (other.accountnumber != null)
				return false;
		} else if (!accountnumber.equals(other.accountnumber))
			return false;
		if (amt == null) {
			if (other.amt != null)
				return false;
		} else if (!amt.equals(other.amt))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (c_Address == null) {
			if (other.c_Address != null)
				return false;
		} else if (!c_Address.equals(other.c_Address))
			return false;
		if (c_City == null) {
			if (other.c_City != null)
				return false;
		} else if (!c_City.equals(other.c_City))
			return false;
		if (cbal == null) {
			if (other.cbal != null)
				return false;
		} else if (!cbal.equals(other.cbal))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fathersName == null) {
			if (other.fathersName != null)
				return false;
		} else if (!fathersName.equals(other.fathersName))
			return false;
		if (flag != other.flag)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ifsc == null) {
			if (other.ifsc != null)
				return false;
		} else if (!ifsc.equals(other.ifsc))
			return false;
		if (mmid != other.mmid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (p_Address == null) {
			if (other.p_Address != null)
				return false;
		} else if (!p_Address.equals(other.p_Address))
			return false;
		if (p_City == null) {
			if (other.p_City != null)
				return false;
		} else if (!p_City.equals(other.p_City))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phonenumber == null) {
			if (other.phonenumber != null)
				return false;
		} else if (!phonenumber.equals(other.phonenumber))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (tdate == null) {
			if (other.tdate != null)
				return false;
		} else if (!tdate.equals(other.tdate))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
