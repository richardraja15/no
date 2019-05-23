package com.chainsys.external.bank;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.chainsys.fd.util.ConnectionUtil;


public class BankDAO {

	// Bal enquiry--Extension method
	/* start */
	public BigDecimal balanceEnquiryExtensionMethod(Bank bank) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "select Balance from trn_customers where account_number=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setLong(1, bank.getAccountnumber());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bank.setBalance(resultSet.getBigDecimal("balance"));
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get Balance");
		}
		return bank.getBalance();
	}

	public Bank getAccountInformation(Payee payee) {
		Bank accountInformation = new Bank();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql8 = "select customer_name,customer_id from trn_customers where account_number=?";
			PreparedStatement preparedStatement8;
			preparedStatement8 = connection.prepareStatement(sql8);
			preparedStatement8.setLong(1, payee.getAccountnumber());
			ResultSet resultSet = preparedStatement8.executeQuery();
			while (resultSet.next()) {
				accountInformation.setName(resultSet.getString("customer_name"));
				accountInformation.setId(resultSet.getString("customer_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountInformation;

	}

	public Payee getTransactionInformation(Payee payee) {
		Payee transactionInformation = new Payee();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql9 = "select transaction_id from TRN_TRNSC_LIST where customer_id=? order by transaction_id asc";
			PreparedStatement preparedStatement9;
			preparedStatement9 = connection.prepareStatement(sql9);
			preparedStatement9.setString(1, payee.getId());
			ResultSet resultSet2 = preparedStatement9.executeQuery();
			while (resultSet2.next()) {
				transactionInformation.setTransactionid(resultSet2.getString("transaction_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactionInformation;
	}

	/* end */
	public int NEFTTransfer(Payee payee) {
		int r1 = 0,  r3 = 0, r5 = 0;
		try {
			System.out.println("payee details : " + payee);
			Connection connection = ConnectionUtil.getConnection();

			String sql5 = "update trn_customers set balance=balance+? where account_number=? and ifsc_code=?";
			System.out.println("Add money Query : " + sql5);
			PreparedStatement preparedStatement5 = connection.prepareStatement(sql5);
			preparedStatement5.setBigDecimal(1, payee.getAmount());
			preparedStatement5.setLong(2, payee.getPayee_accountnumber());
			preparedStatement5.setString(3, payee.getPayee_ifsc());
			r5 = preparedStatement5.executeUpdate();
			System.out.println("Add money Query Result : " + r5);

			String sql3 = "insert into TRN_TRNSC_LIST(customer_id,transaction_id,current_balance,amount,benf_ac_number,mmid,transaction_date)values(?,Trn_translist_transid_seq03.nextval,?,?,?,?,?)";
			System.out.println(" Transaction List Query :" + sql3);
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setString(1, payee.getId());
			preparedStatement3.setBigDecimal(2, payee.getBalance());
			preparedStatement3.setBigDecimal(3, payee.getAmount());
			preparedStatement3.setLong(4, payee.getPayee_accountnumber());
			preparedStatement3.setLong(5, payee.getPayee_mmid());
			preparedStatement3.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
			r3 = preparedStatement3.executeUpdate();
			System.out.println(" Transaction List execute result :" + r3);

			String sql1 = "update trn_customers set balance=balance-? where account_number=?";
			System.out.println(" Minus from acc bal query :" + sql1);
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setBigDecimal(1, payee.getAmount());
			preparedStatement1.setLong(2, payee.getAccountnumber());
			r1 = preparedStatement1.executeUpdate();
			System.out.println(" Minus from acc bal result :" + r1);
			ConnectionUtil.close(connection, preparedStatement1, null);
			ConnectionUtil.close(connection, preparedStatement3, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (r1 + r3 + r5);

	}

}
