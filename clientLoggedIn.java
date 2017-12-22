package protoType;

import java.util.Scanner;

public class clientLoggedIn {
	public static void menu(customer me){
		System.out.println("Hello "& me.name);
		System.out.println("What would you like to do? Select the digit and press enter");
		System.out.println("1- File complaint");
		System.out.println("2- Track reservation");
		System.out.println("3- Add reservation");
		System.out.println("4- Cancel reservation");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();	
		switch(input){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}
}
