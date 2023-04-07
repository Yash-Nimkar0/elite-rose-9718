package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.BillBean;
import com.masai.dto.ConsumerBean;
import com.masai.dto.TransactionBean;
import com.masai.exception.EmptySet;
import com.masai.exception.InputMisMatch;
import com.masai.exception.NoBillFound;
import com.masai.exception.NoConsumerFound;
import com.masai.exception.WrongCredentials;
import java.sql.SQLException;

import utils.DButils;

public class ConsumerDAO implements ConsumerInterface{

	@Override
	public void signUpConsumer(ConsumerBean consumer) throws InputMisMatch {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DButils.linkBetween();
			String query = "Insert into consumer(first_name,last_name,username,password,address,mobile_number,email) Values(?,?,?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, consumer.getFirst_name());
			pst.setString(2, consumer.getLast_name());
			pst.setString(3, consumer.getUsername());
			pst.setString(4, consumer.getPassword());
			pst.setString(5, consumer.getAddress());
			pst.setString(6, consumer.getMobile_number());
			pst.setString(7, consumer.getEmail());
			
			pst.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new InputMisMatch("Unable to signup because "+e.getMessage());
		}
		
	}

	@Override
	public ConsumerBean loginConsumer(String userName, String password) throws WrongCredentials {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DButils.linkBetween();
			
			String query = "Select * from consumer where username = ? AND password = ?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, userName);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			if(DButils.checkIsEmptyOrNot(rs)) throw new WrongCredentials("Log-In error");
			
			else {
				while(rs.next()) {
					int cid = rs.getInt("consumer_id");
					boolean valid = true;
					String name = rs.getString("first_name")+" "+rs.getString("last_name");
					
					ConsumerBean consumer = new ConsumerBean(cid, valid, name);
					
					return consumer;
				}
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new WrongCredentials("Log-In error because of"+e.getMessage());
		}
		return null;
	}

	@Override
	public List<BillBean> displayBillofConsumer(int cid) throws EmptySet {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DButils.linkBetween();
			
			String query = "Select bill_no,amount,bill_from,bill_to,first_name,last_name from bill b join consumer c on b.consumer_id = c.consumer_id where c.consumer_id ="+cid+" AND b.status = 0";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			if(DButils.checkIsEmptyOrNot(rs)) throw new EmptySet("No pending bills");
			else {
				List<BillBean> list = new ArrayList<>();
				
				while(rs.next()) {
					list.add(new BillBean(rs.getInt("bill_no"), rs.getDouble("amount"), rs.getDate("bill_from").toLocalDate() , rs.getDate("bill_to").toLocalDate(), ""+rs.getString("first_name")+" "+rs.getString("last_name")));
				}
				
				return list;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new EmptySet("No pending bills");
		}
		
	}

	@Override
	public double billAmount(int billNo) throws NoBillFound {
		// TODO Auto-generated method stub
		
		Connection con = null;
		
		try {
			con = DButils.linkBetween();
			
			String query = "Select amount from bill where bill_no = ?";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, billNo);
			
			ResultSet rs = pst.executeQuery();
			
			double amt = 0;
			if(DButils.checkIsEmptyOrNot(rs)) throw new NoBillFound("Incorrect Bill Number");
			else {
				while(rs.next()) {
					amt = rs.getDouble("amount");
				}
				return amt;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new NoBillFound("Incorrect Bill Number");
		}
	}

	@Override
	public void updateStatus(int billNo) throws NoBillFound {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {
			con = DButils.linkBetween();
			
			String query = "Update bill set status = 1 where bill_no = ?";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, billNo);
			
			pst.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new NoBillFound("Incorrect Bill Number");
		}
		
	}

	@Override
	public void updateTransection(int cId, double amount) throws InputMisMatch {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {
			con = DButils.linkBetween();
			
			String query = "Insert into transaction(consumer_id,amount) Values(?,?)";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, cId);
			pst.setDouble(2, amount);
			
			pst.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new InputMisMatch("Input Mis-Match"+e.getMessage());
		}
	}

	@Override
	public List<TransactionBean> transactionHistory(int cid) throws EmptySet {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try {
			con = DButils.linkBetween();
			
			String query = "Select transaction_id, amount, payment_date from transaction where consumer_id = ?";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, cid);
			
			ResultSet rs = pst.executeQuery();
			
			List<TransactionBean> list = new ArrayList<>();
			
			if(DButils.checkIsEmptyOrNot(rs)) throw new EmptySet("No Transections Still");
			else {
				while(rs.next()) {
					list.add(new TransactionBean(rs.getInt("transaction_id"), rs.getDouble("amount"), rs.getDate("payment_date").toLocalDate()));
				}
				return list;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new EmptySet(e.getMessage());
		}
	}
}
