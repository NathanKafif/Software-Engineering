package protoType;

import java.util.*;
import java.beans.Customizer;
import java.text.SimpleDateFormat;

public class clientLoggedIn {
	public clientLoggedIn(){}
	public static void menu(Customer me){
		//customerController controller;
		System.out.println("Hello "+ me.getName());
		System.out.println("What would you like to do? Select the digit and press enter");
		System.out.println("1- Track reservation");
		System.out.println("2- Add reservation");
		System.out.println("3- Back to main menu");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();	
		switch(input){
		case 1: //track reservation
			Customer reservation = controller.trackReservation(me.getID());
			break;
		case 2: //add reservation
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
			Customer check = controller.addCustomer(me.getID(), me.getName(), carNum,  finishingTime, me.getEmail(), parkingLotNum, dateOfRegistration, 0, arrivalDate, arrivalTime);
			if (check == null){
				System.out.println("Adding reservation failed");
			}
			else
				System.out.println("Reservation added successfully");
			menu(me);
			break;
		case 3:
			clientMenu.menu();
		}
	}
	public static void displayReservation(Customer reservation){
		System.out.println("This is your reservation");
		System.out.println("Car number: "+reservation.getCarNum()+
					" Parking lot number: "+reservation.getParkingLotNum()+" Arrival date: "
					+reservation.getArrivalDate()+" Arrival time: "+ reservation.getArrivalTime()+
					" Finishing time: "+ reservation.getExitTime());
		menu(reservation);
	}
}
