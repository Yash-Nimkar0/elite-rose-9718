package com.masai.UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masai.dao.AdminDAO;
import com.masai.dao.AdminInterface;
import com.masai.dto.BillBean;
import com.masai.dto.ConsumerBean;
import com.masai.exception.EmptySet;
import com.masai.exception.InputMisMatch;
import com.masai.exception.NoConsumerFound;
import com.masai.exception.WrongCredentials;
import java.sql.SQLException;

public class AdminUI {
	public static void displayAdminFunctions() {
		System.out.println("+-------------------------------------------------------------------+\n"
		          +"|                                                                   |\n"
				  +"| ->  Press 0 -> Log-Out Admin.                                     |\n"
				  +"| ->  Press 1 -> Display All consumers.                             |\n"
				  +"| ->  Press 2 -> View bill of the consumer.                     	|\n"
				  +"| ->  Press 3 -> View all the bills.                                |\n"
				  +"| ->  Press 4 -> View all bills paid and pending.                    |\n"
				  +"| ->  Press 5 -> Delete consumer.                                    |\n"
				  +"| ->  Press 6 -> generate bill.                                      |\n"
				  +"|                                                                   |\n"
				  +"+-------------------------------------------------------------------+");
	}
	
	public static void adminLogin(Scanner sc) throws WrongCredentials{
		System.out.println("Enter Admin User-Name");
		String adName = sc.next();
		System.out.println("Enter Password");
		String adPassword = sc.next();
		
		
		
		if(adName.equals("admin") && adPassword.equals("admin")){
			System.out.println("Admin Login Successful");
			adminFunctions(sc);
		}
		
	}
	
	public static void displayAllConsumers() {
		
		AdminInterface ai = new AdminDAO();
		
		try {
			List<ConsumerBean> list = ai.displayAllConsumers();
			
			for(int i=0;i<list.size();i++) {
				if(i%2 == 0) System.out.println(list.get(i).toString());
				
				else System.out.println(list.get(i).toString());
			}
			
		} catch (EmptySet e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void displayBillOfConsumerByID(Scanner sc) {
		System.out.println("Enter the Consumer ID of consumer you want to get bill details");
		int consumerID = sc.nextInt();
		
		AdminInterface ai = new AdminDAO();
		
		try {
			List<BillBean> list = ai.displayBillofConsumer(consumerID);
			
			for(int i=0;i<list.size();i++) {
				if(i%2 == 0) System.out.println(list.get(i).toString());
				
				else System.out.println(list.get(i).toString());
			}
		} catch (EmptySet e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void displayAllBills() {
		AdminInterface ai = new AdminDAO();
		
		try {
			List<BillBean> list = ai.displayAllBill();
			
			for(int i=0;i<list.size();i++) {
				if(i%2 == 0) System.out.println(list.get(i).toString());
				
				else System.out.println(list.get(i).toString());
			}
		} catch (EmptySet e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteConsumer(Scanner sc) {
		System.out.println("Enter the Consumer ID you want to remove from consumer list");
		int cid = sc.nextInt();
		
		AdminInterface ai = new AdminDAO();
		
		try {
			ai.deleteConsumer(cid);
			System.out.println("Consumer record is now in active");
		} catch (NoConsumerFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void generateBill(Scanner sc) {
		System.out.println("Enter Consumer-ID");
		int cId = sc.nextInt();
		System.out.println("Enter Unit Consumed");
		int unit = sc.nextInt();
		System.out.println("Enter the Date of Bill in From(YYYY-MM-DD) To(YYYY-MM-DD)");
		LocalDate fDate = LocalDate.parse(sc.next());
		LocalDate toDate = LocalDate.parse(sc.next());
		
		BillBean bill = new BillBean(cId, unit, fDate, toDate);
		
		AdminInterface ai = new AdminDAO();
		
		try {
			ai.generateBill(bill);
			System.out.println("Bill generated successfully");
		} catch (InputMisMatch e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void paidAndPandingBills() {
		
		AdminInterface ai = new AdminDAO();
		
		try {
			List<BillBean> list1 =  ai.paidAndPandigBills(0);
			System.out.println("----------Pending Bills----------");
			for(int i=0;i<list1.size();i++) {
				if(i%2 == 0) System.out.println(list1.get(i).toString());
				
				else System.out.println(list1.get(i).toString());
			}
			
			List<BillBean> list2 =  ai.paidAndPandigBills(1);
			
			System.out.println();
			System.out.println("----------Paid Bills----------");
			for(int i=0;i<list2.size();i++) {
				if(i%2 == 0) System.out.println(list2.get(i).toString());
				
				else System.out.println(list2.get(i).toString());
			}
			
		} catch (EmptySet e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void adminFunctions(Scanner sc) {
		System.out.println("Go ahead you are admin now");
		int choice = 0;
		
		do {
			displayAdminFunctions();
			System.out.println("Enter Your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				displayAllConsumers();
 				break;
			}
			case 2: {
				displayBillOfConsumerByID(sc);
				break;
			}
			case 3: {
				displayAllBills();
				break;
			}
			case 4: {
				paidAndPandingBills();
				break;
			}
			case 5: {
				deleteConsumer(sc);
				break;
			}
			case 6: {
				generateBill(sc);
				break;
			}
			case 0: {
				System.out.println("Log-Out Successful");
				break;
			}
			default:
				throw new IllegalArgumentException("Invalid value: " + choice);
			}
		}while(choice != 0);
	}
}
