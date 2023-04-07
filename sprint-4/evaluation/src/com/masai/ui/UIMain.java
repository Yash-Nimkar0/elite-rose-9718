package com.masai.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.CarDAO;
import com.masai.dao.CarDAOImpl;
import com.masai.dto.Car;
import com.masai.dto.CarImpl;
import com.masai.exceptions.someexceptions;

public class UIMain {
	
	static void addui(Scanner sc) throws someexceptions {
		System.out.print("enter car id");
		String cid =sc.next();
		System.out.print("enter model name");
		String name =sc.next();
		System.out.print("enter price");
		int price =sc.nextInt();
		System.out.print("enter seats");
		int seats =sc.nextInt();
		System.out.print("enter company id");
		String comid=sc.next();
		
		Car car=new CarImpl(cid,name,price,seats,comid);
		
		CarDAO carDAO=new CarDAOImpl();
		
		
			carDAO.add(car);
			System.out.println("success");
			
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws someexceptions {
		Scanner sc =new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("0 exit");
			System.out.println("1 add");
			System.out.println("2 update");
			System.out.println("3 display");
			System.out.println("4 delete");
			System.out.println("5 search");
			System.out.print("Enter selection ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				addui(sc);
				break;
			case 2:
				//update(sc);
				break;
			case 3:
				//display(sc);
				break;
			case 4:
				//delete(sc);
				break;
			case 5:
				//search(sc);
				break;
			case 0:
				System.out.println("Bye bye");
				break;
			default:
				System.out.println("Invalid");
			}
		}while(choice!=0);
		sc.close();
	}
}
