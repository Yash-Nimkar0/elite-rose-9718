package com.masai.UI;
import java.util.Scanner;

import com.masai.exception.WrongCredentials;

public class UIMain {
	static void displaylogin() {
		System.out.println("+---------------------------------------+\n"
		         + "|    0 -> Exit                     	|\n"
		         + "|    1 -> Admin Login              	|\n"
		         + "|    2 -> Consumer Login/SignUp         |\n"
		         + "|                                       |\n"
		         + "+---------------------------------------+");
	}
	
	public static void main(String[] args) throws WrongCredentials {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
			
		do {
			displaylogin();
			System.out.println("Enter Your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				AdminUI.adminLogin(sc);
				break;
			}
			case 2: {
				ConsumerUI.consumerMain(sc);
				break;
			}
			case 0: {
				System.out.println("Thank you , BYE");
				break;
			}
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}while(choice != 0);
	}
}
