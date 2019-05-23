package com.chainsys.external.bank;

import java.math.BigDecimal;
import java.util.Map;



public interface IPaymentGateway {

	Map<String,String> executePayment(Payee payee);
	Map<String, String> executeCardPayment(Payee payee);
	Map<String, String> executeWalletPayment(Payee payee); 
	BigDecimal getAccountBalance(Payee payee) throws Exception;
	
}
