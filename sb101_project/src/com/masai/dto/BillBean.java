package com.masai.dto;

import java.time.LocalDate;

public class BillBean {
	private int bill_No;
	private double amount;
	private int consumer_id;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String name;
	public int getBill_No() {
		return bill_No;
	}
	public void setBill_No(int bill_No) {
		this.bill_No = bill_No;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getConsumer_id() {
		return consumer_id;
	}
	public void setConsumer_id(int consumer_id) {
		this.consumer_id = consumer_id;
	}
	@Override
	public String toString() {
		return "BillBean [bill_No=" + bill_No + ", amount=" + amount + ", consumer_id=" + consumer_id + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", name=" + name + "]";
	}
	public BillBean(int bill_No, double amount, int consumer_id, LocalDate fromDate, LocalDate toDate, String name) {
		super();
		this.bill_No = bill_No;
		this.amount = amount;
		this.consumer_id = consumer_id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.name = name;
	}
	public BillBean(int bill_No, double amount,  LocalDate fromDate, LocalDate toDate, String name) {
		super();
		this.bill_No = bill_No;
		this.amount = amount;
		
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.name = name;
	}
	
	public BillBean(int consumer_id, double amount, LocalDate fromDate, LocalDate toDate) {
		super();
		this.consumer_id = consumer_id ;
		this.amount = amount;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
