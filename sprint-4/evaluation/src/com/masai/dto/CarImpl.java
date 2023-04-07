package com.masai.dto;

import java.time.LocalDate;

public class CarImpl implements Car{
	private String cid;
	private String name;
	private int price;
	private int seats;
	
	private String comid;
	public CarImpl(String cid, String name, int price, int seats, String comid) {
		super();
		this.cid = cid;
		this.name = name;
		this.price = price;
		this.seats = seats;
		this.comid = comid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	
	
	
	
	
}
