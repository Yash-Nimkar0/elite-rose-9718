package com.masai.dto;

import java.time.LocalDate;

public interface Car {
	public String getCid();
	public void setCid(String cid);
	public String getName();
	public void setName(String name);
	public int getPrice();
	public void setPrice(int price);
	public int getSeats();
	public void setSeats(int seats) ;
	public String getComid();
	public void setComid(String comid) ;
}
