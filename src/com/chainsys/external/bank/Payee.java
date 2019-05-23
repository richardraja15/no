package com.chainsys.external.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payee {

	private String payee_name;
	private long payee_mmid;
	private BigDecimal payee_balance;
	private boolean flag;
	private String payee_ifsc;
	private LocalDate transferDate;
	private LocalDate compareDate;
	private String remarks;
	private String payee_trans_id;
	private Long payee_phonenumber;
	private Long accountnumber;
	private Long payee_accountnumber;
	private BigDecimal count;
	private String id;
	private String transactionid;
	private BigDecimal balance;
	private BigDecimal amount;
	
	
	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public Long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Long getPayee_accountnumber() {
		return payee_accountnumber;
	}

	public void setPayee_accountnumber(Long payee_accountnumber) {
		this.payee_accountnumber = payee_accountnumber;
	}

	public Long getPayee_phonenumber() {
		return payee_phonenumber;
	}

	public void setPayee_phonenumber(Long payee_phonenumber) {
		this.payee_phonenumber = payee_phonenumber;
	}
	
	public String getPayee_name() {
		return payee_name;
	}

	public void setPayee_name(String payee_name) {
		this.payee_name = payee_name;
	}

	public long getPayee_mmid() {
		return payee_mmid;
	}

	public void setPayee_mmid(long payee_mmid) {
		this.payee_mmid = payee_mmid;
	}

	public BigDecimal getPayee_balance() {
		return payee_balance;
	}

	public void setPayee_balance(BigDecimal payee_balance) {
		this.payee_balance = payee_balance;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getPayee_ifsc() {
		return payee_ifsc;
	}

	public void setPayee_ifsc(String payee_ifsc) {
		this.payee_ifsc = payee_ifsc;
	}

	public LocalDate getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}

	public LocalDate getCompareDate() {
		return compareDate;
	}

	public void setCompareDate(LocalDate compareDate) {
		this.compareDate = compareDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPayee_trans_id() {
		return payee_trans_id;
	}

	public void setPayee_trans_id(String payee_trans_id) {
		this.payee_trans_id = payee_trans_id;
	}

	@Override
	public String toString() {
		return "Payee [payee_name=" + payee_name + ", payee_mmid=" + payee_mmid + ", payee_balance=" + payee_balance
				+ ", flag=" + flag + ", payee_ifsc=" + payee_ifsc + ", transferDate=" + transferDate + ", compareDate="
				+ compareDate + ", remarks=" + remarks + ", payee_trans_id=" + payee_trans_id + ", payee_phonenumber="
				+ payee_phonenumber + ", accountnumber=" + accountnumber + ", payee_accountnumber="
				+ payee_accountnumber + ", count=" + count + ", id=" + id + ", transactionid=" + transactionid
				+ ", balance=" + balance + ", amount=" + amount + ", getTransactionid()=" + getTransactionid()
				+ ", getAmount()=" + getAmount() + ", getBalance()=" + getBalance() + ", getId()=" + getId()
				+ ", getCount()=" + getCount() + ", getAccountnumber()=" + getAccountnumber()
				+ ", getPayee_accountnumber()=" + getPayee_accountnumber() + ", getPayee_phonenumber()="
				+ getPayee_phonenumber() + ", getPayee_name()=" + getPayee_name() + ", getPayee_mmid()="
				+ getPayee_mmid() + ", getPayee_balance()=" + getPayee_balance() + ", isFlag()=" + isFlag()
				+ ", getPayee_ifsc()=" + getPayee_ifsc() + ", getTransferDate()=" + getTransferDate()
				+ ", getCompareDate()=" + getCompareDate() + ", getRemarks()=" + getRemarks() + ", getPayee_trans_id()="
				+ getPayee_trans_id() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountnumber == null) ? 0 : accountnumber.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((compareDate == null) ? 0 : compareDate.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + (flag ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((payee_accountnumber == null) ? 0 : payee_accountnumber.hashCode());
		result = prime * result + ((payee_balance == null) ? 0 : payee_balance.hashCode());
		result = prime * result + ((payee_ifsc == null) ? 0 : payee_ifsc.hashCode());
		result = prime * result + (int) (payee_mmid ^ (payee_mmid >>> 32));
		result = prime * result + ((payee_name == null) ? 0 : payee_name.hashCode());
		result = prime * result + ((payee_phonenumber == null) ? 0 : payee_phonenumber.hashCode());
		result = prime * result + ((payee_trans_id == null) ? 0 : payee_trans_id.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((transactionid == null) ? 0 : transactionid.hashCode());
		result = prime * result + ((transferDate == null) ? 0 : transferDate.hashCode());
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
		Payee other = (Payee) obj;
		if (accountnumber == null) {
			if (other.accountnumber != null)
				return false;
		} else if (!accountnumber.equals(other.accountnumber))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (compareDate == null) {
			if (other.compareDate != null)
				return false;
		} else if (!compareDate.equals(other.compareDate))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (flag != other.flag)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (payee_accountnumber == null) {
			if (other.payee_accountnumber != null)
				return false;
		} else if (!payee_accountnumber.equals(other.payee_accountnumber))
			return false;
		if (payee_balance == null) {
			if (other.payee_balance != null)
				return false;
		} else if (!payee_balance.equals(other.payee_balance))
			return false;
		if (payee_ifsc == null) {
			if (other.payee_ifsc != null)
				return false;
		} else if (!payee_ifsc.equals(other.payee_ifsc))
			return false;
		if (payee_mmid != other.payee_mmid)
			return false;
		if (payee_name == null) {
			if (other.payee_name != null)
				return false;
		} else if (!payee_name.equals(other.payee_name))
			return false;
		if (payee_phonenumber == null) {
			if (other.payee_phonenumber != null)
				return false;
		} else if (!payee_phonenumber.equals(other.payee_phonenumber))
			return false;
		if (payee_trans_id == null) {
			if (other.payee_trans_id != null)
				return false;
		} else if (!payee_trans_id.equals(other.payee_trans_id))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (transactionid == null) {
			if (other.transactionid != null)
				return false;
		} else if (!transactionid.equals(other.transactionid))
			return false;
		if (transferDate == null) {
			if (other.transferDate != null)
				return false;
		} else if (!transferDate.equals(other.transferDate))
			return false;
		return true;
	}

}
