package client;

import java.util.*;
import java.text.SimpleDateFormat;

public class clientMenu {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		//clientMenu cm = new clientMenu();
		menu();
	}
	public clientMenu(){};
	public static void menu(){
		CustomerController controller = new CustomerController();
		Customer me; //entity
		System.out.println("Hello guest");
		System.out.println("Select one of the two options\n(write the digit and press enter):\n");
		System.out.println("1 - Register \n2 - Log in\n3 - Exit");
		int input = sc.nextInt();
		sc.nextLine();
		switch (input){
		case 1: //Register
			System.out.println("Enter your name");
			String name = sc.nextLine();
			System.out.println("Enter your id");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your email");
			String email = sc.nextLine();
			System.out.println("Enter your car number");
			int carNum = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your arrival date");
			String arrivalDate = sc.nextLine();
			System.out.println("Enter your arrival time");
			String arrivalTime = sc.nextLine();
			System.out.println("Enter your finishing time");
			String finishingTime = sc.nextLine();
			System.out.println("Select one of the two parking lots (write the digit and press enter):\n");
			System.out.println("1 - Kibbutz Yagur parking lot \n2- HaKarmel parking lot");
			int parkingLotNum = sc.nextInt();
			sc.nextLine();
			String dateOfRegistration = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			boolean a = CustomerController.addCustomer(id, carNum,  finishingTime, email, parkingLotNum, 0, dateOfRegistration, arrivalDate, arrivalTime);
			if (a == false){
				System.out.println("Registration failed. Try again");
				menu();
				break;
			}
			me = new Customer(id, carNum,  finishingTime, email, parkingLotNum, 0, dateOfRegistration, arrivalDate, arrivalTime);
			clientLoggedIn.menu(me);
			break;
		case 2: //Log in
			System.out.println("Enter your client ID");
			int ID = sc.nextInt();
			sc.nextLine();
			CustomerController.trackReservation(ID,"LogIn");
			/*if (check == false){
				System.out.println("Wrong client ID");
				menu();
			}*/
			//clientLoggedIn.menu(me);
			break;
		case 3 :
			System.out.println("**** GOODBYE ****");
			sc.close();
			System.exit(1);
		default :
			System.out.println("\nWrong input, Please insert a valid number\n");
			System.out.println("********************************************");
			menu();
		}
		
		
	}
}
