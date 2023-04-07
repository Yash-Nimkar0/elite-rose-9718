package com.masai.UI;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.AdminDAO;
import com.masai.dao.AdminInterface;
import com.masai.dao.ConsumerDAO;
import com.masai.dao.ConsumerInterface;
import com.masai.dto.BillBean;
import com.masai.dto.ConsumerBean;
import com.masai.dto.TransactionBean;
import com.masai.exception.EmptySet;
import com.masai.exception.InputMisMatch;
import com.masai.exception.NoBillFound;
import com.masai.exception.NoConsumerFound;
import com.masai.exception.WrongCredentials;
import java.sql.SQLException;

public class ConsumerUI {
public static void consumerMain(Scanner sc) {
		
		int choice = 0;
		
		do {
			System.out.println("+------------------------------------+\n"
			         + "|                                    |\n" 
			         + "| ->  0 -> Exit                 	 |\n" 
			         + "| ->  1 -> New Consumer SignUp  	 |\n"
			         + "| ->  2 -> Consumer Login       	 |\n"
			         + "|                                    |\n"
			         + "+------------------------------------+");
			System.out.println("Enter Your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {			
				signUpConsumer(sc) ;
				break;
			}
			case 2: {
				logInConsumer(sc);
				break;
			}
			case 0: {
				System.out.println("Thank you,BYE BYE");
				break;
			}
			default: {
				System.out.println("Invalid choice");
				break;
			}	
		    }
		} while (choice != 0 );
		
		
	}
	
	public static void signUpConsumer(Scanner sc) {
		System.out.println("For creating new customer");
		System.out.println();
		System.out.println("Enter First Name");
		String fname = sc.next();
		System.out.println("Enter Last Name");
		String lnameString = sc.next();
		System.out.println("Enter username of consumer");
		String userName = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		System.out.println("Enter address");
		String address = sc.next();
		System.out.println("Enter Mobile-Number");
		String mobNo = sc.next();
		System.out.println("Enter your email");
		String email = sc.next();
		
		ConsumerInterface ci = new ConsumerDAO();
		try {
			ci.signUpConsumer(new ConsumerBean(fname, lnameString, userName, password, address, mobNo, email));
			System.out.println("Welcome now you are a consumer of Electricity Bill Payment System");
		} catch (InputMisMatch e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());		}
	}
	
	public static void logInConsumer(Scanner sc) {
		System.out.println("Enter User-Name");
		String userName = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		System.out.println();
		ConsumerInterface ci = new ConsumerDAO();
		

		try {
			ConsumerBean consumer = ci.loginConsumer(userName, password);
			
			if(consumer.isValid()) {
				System.out.println("Hey "+consumer.getName()+" Welcome\n"
						+ "Please let me know how can I help you\n"
						+ "Please Enter your choice");
				consumerFunctionalities(sc,consumer.getConsumer_id());
				
			}
		} catch (WrongCredentials e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void consumerFunctionalities(Scanner sc, int consumerId) {
		int choice = 0;
		do {
			System.out.println("+-------------------------------------+\n"
			         + "|                                     |\n" 
			         + "| -> Press 0 For Exit                 |\n" 
			         + "| -> Press 1 To Pay Bill 			  |\n"
			         + "| -> Press 2 To View All Transaction  |\n"
			         + "|                                     |\n"
			         + "+-------------------------------------+");
			System.out.println("Enter Your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				payBill(consumerId,sc);
				break;
			}
			case 2: {
				transactionHistory(consumerId);
				break;
			}
			case 0: {
				System.out.println("Consumer LocOut");
				break;
			}
			default:
				System.out.println("Invalid choice");
				break;
			}
			
		} while (choice != 0);
	}
	
	public static void payBill(int cid,Scanner sc) {
		
		ConsumerInterface ci = new ConsumerDAO();
		
		try {
			List<BillBean> list = ci.displayBillofConsumer(cid);
			System.out.println("----------All pending Bills----------");
			double totalAmount = 0;
			for(int i=0;i<list.size();i++) {
				if(i%2 == 0) {
					System.out.println(list.get(i).toString());
					totalAmount += list.get(i).getAmount();
				}
				
				else {
					System.out.println(list.get(i).toString());
					totalAmount += list.get(i).getAmount();
				}
			}
			System.out.println("Your total pending amount: "+totalAmount);
			
			System.out.println("Please enter the bill number for the payment you wish to make at this moment.");
			int billNo = sc.nextInt();
			
			double amount = ci.billAmount(billNo);
			
			
			System.out.println("Please confirm your payment by entering 'y' or decline it by entering 'n' \nYour payment Amount is : "+amount);
			
			String payOrNot = sc.next();
			
			if(payOrNot.equals("y")) {
				ci.updateStatus(billNo);
				System.out.println("Payment Successful");
				totalAmount = (totalAmount-amount);
				System.out.println("Now your total pending amount: "+totalAmount);
				
				ci.updateTransection(cid, amount);
			}
			else {
				System.out.println("Our payment has been declined. Thank you for considering our services.");
			}
		} catch (EmptySet | NoBillFound | InputMisMatch e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void transactionHistory(int cid) {
		
		ConsumerInterface ci = new ConsumerDAO();
		
		try {
			List<TransactionBean> list = ci.transactionHistory(cid);
			
			for(int i=0;i<list.size();i++) {
				if(i%2 == 0) System.out.println(list.get(i).toString());
				
				else System.out.println(list.get(i).toString());
			}
			
			System.out.println();
		} catch (EmptySet e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
}
