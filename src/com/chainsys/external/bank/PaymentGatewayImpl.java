package com.chainsys.external.bank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;



public class PaymentGatewayImpl implements IPaymentGateway {

	@Override
	public Map<String, String> executePayment(Payee payee) {
		Map<String, String> transactionStatement = new HashMap<String, String>();
		BankDAO bankDAO = new BankDAO();
		Bank bank = new Bank();
		bank.setAccountnumber(payee.getAccountnumber());
		BigDecimal bal = bankDAO.balanceEnquiryExtensionMethod(bank);
		BigDecimal amount = payee.getAmount();
		Bank getAccountInformation = bankDAO.getAccountInformation(payee);
		payee.setId(getAccountInformation.getId());
		if (bal != null) {
			int n = (bal.compareTo(amount));
			if (n > 0 || n == 0) {
				payee.setBalance(bal.subtract(amount));
				int count = bankDAO.NEFTTransfer(payee);
				if (count == 3) {
					Payee transactionInfo = bankDAO.getTransactionInformation(payee);
					transactionStatement.put("TransactionId", transactionInfo.getTransactionid());
					transactionStatement.put("FromAccount", String.valueOf(payee.getAccountnumber()));
					transactionStatement.put("FromAccountName", getAccountInformation.getName());
					transactionStatement.put("ToAccount", String.valueOf(payee.getPayee_accountnumber()));
					transactionStatement.put("ToAccountName", payee.getPayee_name());
					transactionStatement.put("TransactionAmount", String.valueOf(payee.getAmount()));
					transactionStatement.put("RemainingBalanceAmount", String.valueOf(bal.subtract(amount)));
					transactionStatement.put("TransactionType", "NEFT");
					transactionStatement.put("TransactionStatus", "Success");
				} else {
					transactionStatement.put("FromAccount", String.valueOf(payee.getAccountnumber()));
					transactionStatement.put("FromAccountName", getAccountInformation.getName());
					transactionStatement.put("ToAccount", String.valueOf(payee.getPayee_accountnumber()));
					transactionStatement.put("ToAccountName", payee.getPayee_name());
					transactionStatement.put("TransactionAmount", String.valueOf(payee.getAmount()));
					transactionStatement.put("TransactionType", "NEFT");
					transactionStatement.put("TransactionStatus", "Failed");
				}
			}
		} else {
			transactionStatement.put("FromAccount", String.valueOf(payee.getAccountnumber()));
			transactionStatement.put("FromAccountName", getAccountInformation.getName());
			transactionStatement.put("ToAccount", String.valueOf(payee.getPayee_accountnumber()));
			transactionStatement.put("ToAccountName", payee.getPayee_name());
			transactionStatement.put("TransactionAmount", String.valueOf(payee.getAmount()));
			transactionStatement.put("TransactionType", "NEFT");
			transactionStatement.put("TransactionStatus", "Failed");
		}

		return transactionStatement;
	}

	@Override
	public Map<String, String> executeCardPayment(Payee payee) {
		return null;
	}

	@Override
	public Map<String, String> executeWalletPayment(Payee payee) {
		return null;
	}

	@Override
	public BigDecimal getAccountBalance(Payee payee) throws Exception {
		Bank bank = new Bank();
		bank.setAccountnumber(payee.getAccountnumber());
		BankDAO bankDAO = new BankDAO();
		BigDecimal bal = bankDAO.balanceEnquiryExtensionMethod(bank);
		if(bal==null)
		{
			throw new Exception("Invalid Account number");
		}
		return bal;
	}
	
	
}
