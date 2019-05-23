package com.chainsys.external.bank;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PaymentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paymentMode = request.getParameter("payment");
		String returnUrl = request.getParameter("retUrl");
		if ("bankPayment".equals(paymentMode)) {
			long accountNumber = 0;
			String strAccountNumber = request.getParameter("accountnumber");
			Payee payee = new Payee();
			if (!strAccountNumber.isEmpty() && strAccountNumber != null) {
				accountNumber = Long.parseLong(strAccountNumber);

			}

			BigDecimal amount = new BigDecimal(0);
			String strAmount = request.getParameter("amount");
			if (!strAmount.isEmpty() && strAmount != null) {
				amount = new BigDecimal(strAmount);

			}
			if (accountNumber > 0 && String.valueOf(accountNumber).length() == 12) {
				payee.setAccountnumber(accountNumber);
			}

			if (amount.longValue() > 0) {
				payee.setAmount(amount);
			}
			payee.setPayee_accountnumber(620410100000L);
			payee.setPayee_name("Aathi");
			payee.setPayee_ifsc("ATEK000138");
			IPaymentGateway paymentServ = new PaymentGatewayImpl();
			Map<String, String> trasactionStatus = paymentServ.executePayment(payee);
			request.setAttribute("transactionStatus", trasactionStatus);
			System.out.println(trasactionStatus.get("TransactionStatus"));
			/*
			 * RequestDispatcher requestDispatcher = request.getRequestDispatcher(
			 * "http://localhost:8081/Admission/ApplyNowServlet?\r\n.jsp");
			 */
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String trn_status = gson.toJson(trasactionStatus);
			response.getWriter().write(trn_status);
			response.sendRedirect(returnUrl+"?acc_holder_name="
					+ trasactionStatus.get("FromAccountName") + "&trn_status="
							+ trasactionStatus.get("TransactionStatus") +"&trn_id=" + trasactionStatus.get("TransactionId"));

		} else if ("CardPayment".equals(paymentMode)) {

			// call cardpayment method

		} else if ("Wallet".equals(paymentMode)) {

			// calll wallet payment method

		} else if ("getAccountBal".equals(paymentMode)) {

			long accountNumber = 0;
			String strAccountNumber = request.getParameter("accountnumber");
			Payee payee = new Payee();
			if (!strAccountNumber.isEmpty() && strAccountNumber != null) {
				accountNumber = Long.parseLong(strAccountNumber);

			}
			if (accountNumber > 0 && String.valueOf(accountNumber).length() == 12) {
				payee.setAccountnumber(accountNumber);
			}

			IPaymentGateway paymentServ = new PaymentGatewayImpl();
			String accountBalance = "";
			try {
				accountBalance = String.valueOf(paymentServ.getAccountBalance(payee));

			} catch (Exception e) {
				accountBalance = e.getMessage();
			}

			response.getWriter().write(String.valueOf(accountBalance));
		}
	}

}
