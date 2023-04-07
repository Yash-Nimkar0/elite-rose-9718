package com.masai.dao;

import java.util.List;

import com.masai.dto.BillBean;
import com.masai.dto.ConsumerBean;
import com.masai.dto.TransactionBean;
import com.masai.exception.EmptySet;
import com.masai.exception.InputMisMatch;
import com.masai.exception.NoBillFound;
import com.masai.exception.WrongCredentials;

public interface ConsumerInterface {
public void signUpConsumer(ConsumerBean consumer) throws InputMisMatch;
	
	public ConsumerBean loginConsumer(String userName,String password) throws WrongCredentials;
	
	public List<BillBean> displayBillofConsumer(int cid) throws EmptySet;
	
	public double billAmount(int billNo) throws NoBillFound;
	
	public void updateStatus(int billNo) throws NoBillFound;
	
	public void updateTransection(int cId, double amount) throws InputMisMatch;
	
	public List<TransactionBean> transactionHistory(int cid) throws EmptySet;
}
