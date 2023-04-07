package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.masai.dao.*;
import com.masai.dto.*;
import com.masai.exceptions.norecord;
import com.masai.exceptions.someexceptions;

public class CarDAOImpl implements CarDAO{

	public void add(Car car) throws someexceptions {
		
		Connection conn=null;
		try {
			conn=DBUtils.getconn();
			String query="Insert into car (car_id,model_name,price,total_seats,company_id) values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, car.getCid());
			ps.setString(2, car.getName());
			ps.setInt(3, car.getPrice());
			ps.setInt(4, car.getSeats());
			ps.setString(5, car.getComid());
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new someexceptions("unable to insert");
		}
		
	}


}
