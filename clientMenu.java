package client;

import java.util.*;
import java.text.SimpleDateFormat;

public class clientMenu {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		//clientMenu cm = new clientMenu();
		menu();
	}
	/*input tests*/
	public static boolean checkDateFormat(String date){
		if (date.charAt(0) < 48 ||  date.charAt(0) > 51 || date.charAt(1) < 48 ||  date.charAt(1) > 57 ||
				date.charAt(3) < 48 ||  date.charAt(3) > 49 || date.charAt(4) < 48 ||  date.charAt(4) > 57 ||
				date.charAt(6) < 48 ||  date.charAt(6) > 57 || date.charAt(7) < 48 ||  date.charAt(7) > 57||
				date.charAt(2) != 45 || date.charAt(5) != 45 || date.length() != 8 ){
			return false;
		}
		return true;
	}
	public static boolean checkTimeFormat(String time){
		if (time.charAt(0) < 48 || time.charAt(0) > 50 || time.charAt(1) < 48 ||
				time.charAt(1) < 48 || time.charAt(1) > 57 | time.charAt(2) != ':' ||
				time.charAt(3) < 48 || time.charAt(3) > 53 || time.charAt(4) < 48 ||
				time.charAt(4) > 57 || time.length() != 5){
			return false;
		}
		return true;	
	}
	public static boolean checkDigitsOnly(String id){
		if (id.length() > 9){
			return false;
		}
		for (int i = 0; i < id.length(); i++){
			if (id.charAt(i) < 48 || id.charAt(i) > 57){
				return false;
			}
		}
		return true;
	}
	//input tests finished
	public clientMenu(){};
	public static void menu(){ //interface
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
			String id = sc.nextLine();
			boolean bool = checkDigitsOnly(id);
			while (bool == false) {
				System.out.println("Id must contain up to nine digits only. Enter id again");
				id = sc.nextLine();
				bool = checkDigitsOnly(id);
			}
			int ID = Integer.parseInt(id);
			System.out.println("Enter your email");
			String email = sc.nextLine();
			System.out.println("Enter your car number");
			String carnum = sc.nextLine();
			bool = checkDigitsOnly(carnum);
			while (bool == false) {
				System.out.println("Car number must contain up to nine digits only. Try again");
				carnum = sc.nextLine();
				bool = checkDigitsOnly(carnum);
			}
			int carNum = Integer.parseInt(carnum);
			System.out.println("Enter your arrival date in format dd-mm-yy");
			String arrivalDate = sc.nextLine();
			bool = checkDateFormat(arrivalDate);
			while (bool == false) {
				System.out.println("Date format is wrong. Try again (dd-mm-yy)");
				arrivalDate = sc.nextLine();
				bool = checkDateFormat(arrivalDate);
			}
			System.out.println("Enter your arrival time in format hh:mm");
			String arrivalTime = sc.nextLine();
			bool = checkTimeFormat(arrivalTime);
			while (bool == false) {
				System.out.println("Time format is wrong. Try again (hh:mm)");
				arrivalTime = sc.nextLine();
				bool = checkTimeFormat(arrivalTime);
			}
			System.out.println("Enter your finishing time in format hh:mm");
			String finishingTime = sc.nextLine();
			bool = checkTimeFormat(finishingTime);
			while (bool == false) {
				System.out.println("Time format is wrong. Try again (hh:mm)");
				finishingTime = sc.nextLine();
				bool = checkTimeFormat(finishingTime);
			}
			System.out.println("Select one of the two parking lots (write the digit and press enter):\n");
			System.out.println("1 - Kibbutz Yagur parking lot \n2 - HaKarmel parking lot");
			int parkingLotNum = sc.nextInt();
			sc.nextLine();
			while (parkingLotNum != 1 && parkingLotNum != 2){
				System.out.println("Wrong input. Select 1 or 2");
				System.out.println("1 - Kibbutz Yagur parking lot \n2 - HaKarmel parking lot");
				parkingLotNum = sc.nextInt();
				sc.nextLine();
			}
			String dateOfRegistration = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			boolean a = CustomerController.addCustomer(id, carNum,  finishingTime, email, parkingLotNum, 0, dateOfRegistration, arrivalDate, arrivalTime);
			if (a == false){
				System.out.println("Registration failed. Try again");
				menu();
				break;
			}
			me = new Customer(ID, carNum,  finishingTime, email, parkingLotNum, 0, dateOfRegistration, arrivalDate, arrivalTime);
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