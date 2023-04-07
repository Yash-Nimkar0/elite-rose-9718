package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import com.masai.dto.BillBean;
import com.masai.dto.ConsumerBean;
import com.masai.exception.EmptySet;
import com.masai.exception.InputMisMatch;
import com.masai.exception.NoConsumerFound;

import utils.DButils;

public class AdminDAO implements AdminInterface{
	@Override
	public List<ConsumerBean> displayAllConsumers() throws EmptySet {
		
		Connection con = null;
		
		try {
			con = DButils.linkBetween();
			
			String query = "Select * from Consumer";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			if(DButils.checkIsEmptyOrNot(rs)) throw new EmptySet("No records found");
			else {
				List<ConsumerBean> list = new ArrayList<>();
				
				while(rs.next()) {
					
					list.add(new ConsumerBean(rs.getInt("consumer_id") ,rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"), rs.getString("password"), rs.getString("address"), rs.getString("mobile_number"), rs.getString("email")));
					
				}
				return list;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new EmptySet("No records found");
		}
		finally {
			try {
				DButils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<BillBean> displayBillofConsumer(int cid) throws EmptySet {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DButils.linkBetween();
			
			String query = "Select bill_no,amount,bill_from,bill_to,first_name,last_name from bill b join consumer c on b.consumer_id = c.consumer_id where c.consumer_id ="+cid;
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			if(DButils.checkIsEmptyOrNot(rs)) throw new EmptySet("No Bills ");
			else {
				List<BillBean> list = new ArrayList<>();
				
				while(rs.next()) {
					list.add(new BillBean(rs.getInt("bill_no"), rs.getDouble("amount"), rs.getDate("bill_from").toLocalDate() , rs.getDate("bill_to").toLocalDate(),(rs.getString("first_name")+" "+rs.getString("last_name"))));
				}
				
				return list;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new EmptySet("No Bills");
		}
		
	}

	@Override
	public List<BillBean> displayAllBill() throws EmptySet {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {
			con = DButils.linkBetween();
			
			String query = "Select bill_no,amount,bill_from,bill_to,first_name,last_name from bill b join consumer c on b.consumer_id = c.consumer_id where c.is_active = 1";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			if(DButils.checkIsEmptyOrNot(rs)) throw new EmptySet("No Bills");
			else {
				List<BillBean> list = new ArrayList<>();
				
				while(rs.next()) {
					list.add(new BillBean(rs.getInt("bill_no"), rs.getDouble("amount"), rs.getDate("bill_from").toLocalDate() , rs.getDate("bill_to").toLocalDate(), rs.getString("first_name")+" "+rs.getString("last_name")));
				}
				
				return list;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new EmptySet("No Bills"+e.getMessage());
		}
	}

	@Override
	public void deleteConsumer(int cid) throws NoConsumerFound {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try {
			con = DButils.linkBetween();
			
			String query = "Update consumer set is_active = 0 where consumer_id = ?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, cid);
			
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new NoConsumerFound("Consumer not found");
		}
		
		
	}

	@Override
	public void generateBill(BillBean bill) throws InputMisMatch {
		// TODO Auto-generated method stub
		
		double amt = bill.getAmount()*10;
		amt = amt+((amt*2.5)/100);
		
		Connection con = null;
		try {
			con = DButils.linkBetween();
			
			String query = "Insert into bill(consumer_id,amount,bill_from,bill_to) Values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, bill.getConsumer_id());
			pst.setDouble(2, amt);
			pst.setDate(3, Date.valueOf(bill.getFromDate()));
			pst.setDate(4, Date.valueOf(bill.getToDate()));
			
			pst.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new InputMisMatch("Input mis-match "+e.getMessage());
		}
		
	}

	@Override
	public List<BillBean> paidAndPendingBills(int status) throws EmptySet {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try {
			con = DButils.linkBetween();
			
			String query = "Select bill_no,amount,bill_from,bill_to,first_name,last_name from bill b join consumer c on b.consumer_id = c.consumer_id where c.is_active = 1 and b.status = ?";
			
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, status);
			
			ResultSet rs = pst.executeQuery();
			
			if(DButils.checkIsEmptyOrNot(rs)) throw new EmptySet("No Consumer");
			else {
				List<BillBean> list = new ArrayList<>();
				
				while(rs.next()) {
					list.add(new BillBean(rs.getInt("bill_no"), rs.getDouble("amount"), rs.getDate("bill_from").toLocalDate() , rs.getDate("bill_to").toLocalDate(), (rs.getString("first_name")+" "+rs.getString("last_name"))));
				}
				
				return list;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
