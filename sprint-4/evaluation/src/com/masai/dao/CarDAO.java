package com.masai.dao;

import java.util.List;

import com.masai.dto.Car;
import com.masai.exceptions.norecord;
import com.masai.exceptions.someexceptions;

public interface CarDAO {
	public void add(Car car)throws someexceptions;
//	public void update(Car car)throws someexceptions;
//	public void delete(Car car)throws someexceptions;
//	public List<Car> display(Car car)throws someexceptions,norecord;
//	public List<Car> search(Car car)throws someexceptions,norecord;
}
