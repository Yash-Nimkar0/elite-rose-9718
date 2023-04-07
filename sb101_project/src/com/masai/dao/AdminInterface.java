package com.masai.dao;

import java.util.List;

import com.masai.dto.BillBean;
import com.masai.dto.ConsumerBean;
import com.masai.exception.EmptySet;
import com.masai.exception.InputMisMatch;
import com.masai.exception.NoConsumerFound;

public interface AdminInterface {

	public List<ConsumerBean> displayAllConsumers() throws EmptySet;
	
	public List<BillBean> displayBillofConsumer(int cid) throws EmptySet;
	
	public List<BillBean> displayAllBill() throws EmptySet;
	
	public void deleteConsumer(int cid) throws NoConsumerFound;
	
	public void generateBill(BillBean bill) throws InputMisMatch;
	
	public List<BillBean> paidAndPandigBills(int status) throws EmptySet;
	
}
