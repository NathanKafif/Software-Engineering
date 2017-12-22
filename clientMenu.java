package protoType;

import java.util.*;

public class clientMenu {
	public static void main(){
		menu();
	}
	public static void menu(){
		customerController controller;
		customer me; //entity
		clientLoggedIn logged; //next boundary/interface
		System.out.println("Select one of the two options (write the digit and press enter):\n");
		System.out.println("1 - Register \n2- Log in");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		switch (input){
		case 1: //Register
			System.out.println("Enter your name");
			String name = sc.nextLine();
			System.out.println("Enter your arrival time");
			String arrivalTime = sc.nextLine();
			System.out.println("Enter your finishing time");
			String finishingTime = sc.nextLine();
			System.out.println("Select one of the two parking lots (write the digit and press enter):\n");
			System.out.println("1 - Kibbutz Yagur parking lot \n2- HaKarmel parking lot");
			int parkingLotNum = sc.nextInt();
			me = controller.addClient(name,arrivalTime,finishingTime, parkingLotNum);
			if (me == null){
				System.out.println("Registration failed. Try again");
				menu();
				break;
			}
			logged.menu(me);
			break;
		case 2: //Log in
			System.out.println("Enter your client ID");
			int id = sc.nextInt();
			me = controller.findCustomer(id);
			if (me == null){
				System.out.println("Wrong client ID. \n");
				menu();
				break;
			}
			logged.menu(me);
			break;
		}
		
	}
}