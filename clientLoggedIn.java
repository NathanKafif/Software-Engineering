package client;

import java.util.*;
import java.beans.Customizer;
import java.text.SimpleDateFormat;
import client.*;
public class clientLoggedIn {
	public clientLoggedIn(){}
	public static void menu(Customer me){
		CustomerController controller = new CustomerController();
		System.out.println("********************************************");
		System.out.println("What would you like to do?\nSelect the digit and press enter");
		System.out.println("1 - Track reservation");
		System.out.println("2 - Add reservation");
		System.out.println("3 - Cancel reservation");
		System.out.println("4 - Back to main menu");
		System.out.println("********************************************\n");
		//Scanner sc = new Scanner(System.in);
		int input = clientMenu.sc.nextInt();	
		clientMenu.sc.nextLine();
		switch(input){
		case 1: //track reservation
			CustomerController.trackReservation(me.getID(),"trackReservation");
			break;
		case 2: //add reservation
			System.out.println("Enter your car number");
			int carNum = clientMenu.sc.nextInt();
			clientMenu.sc.nextLine();
			System.out.println("Enter your arrival date");
			String arrivalDate = clientMenu.sc.nextLine();
			System.out.println("Enter your arrival time");
			String arrivalTime = clientMenu.sc.nextLine();
			System.out.println("Enter your finishing time");
			String finishingTime = clientMenu.sc.nextLine();
			System.out.println("Select one of the two parking lots (write the digit and press enter):\n");
			System.out.println("1 - Kibbutz Yagur parking lot \n2- HaKarmel parking lot");
			int parkingLotNum = clientMenu.sc.nextInt();
			clientMenu.sc.nextLine();
			String dateOfRegistration = new SimpleDateFormat("dd-MM-yy").format(new Date());
			boolean check = controller.addCustomer(me.getID(), carNum,  finishingTime, me.getEmail(), 0, parkingLotNum, dateOfRegistration, arrivalDate, arrivalTime);
			if (check == false){
				System.out.println("Adding reservation failed");
			}
			else
				System.out.println("Reservation added successfully");
			menu(me);
			break;
		case 3:
			CustomerController.cancelReservation(me);
			break;
		case 4:
			
			clientMenu.menu();
		}
	}
	public static void displayReservation(Customer reservation, String type){
		
		switch(type){
		case "trackReservation":
		System.out.println("********************************************");
		System.out.println("This is your reservation:");
		System.out.println("Car number: "+reservation.getCarNum()+
					"\nParking lot number: "+reservation.getParkingLotNum()+"\nArrival date: "
					+reservation.getArrivalDate()+"\nArrival time: "+ reservation.getArrivalTime()+
					"\nFinishing time: "+ reservation.getExitTime());
		System.out.println("********************************************\n");
		menu(reservation);
		break;
		case "LogIn":
			if(reservation.getArrivalTime()==null){
				
				System.out.println("\nThe Id number does not exist\nPlease try agian\n");
				clientMenu.menu();
			}
			else{
			
			System.out.println("Hello "+ reservation.getID());
			menu(reservation);
			break;
			}
		case "cancelReservation" :
			System.out.println("\nReservation cancelled successfuly\n");
			clientMenu.menu();
		}
		 
		return;
	
		
	}
}