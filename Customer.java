package protoType;

public class Customer {

	private int ID;
	private String name;
	private int carNum;
	private String exitTime;
	private String email;
	private int parkingLotNum;
	private double balance;
	private String dateOfRegistration;
	
	private String arrivalDate;
	private String arrivalTime;
	
  //constructors
	public Customer(int inID, String inName, int inCarNum, String inExitTime, String inEmail, int inParkingLotNum, double inBalance, String inDateOfRegistration, String inArrivalDate,String inArrivalTime){
		ID = inID;
		name = inName;
		carNum = inCarNum;
		exitTime = inExitTime;
		email = inEmail;
		parkingLotNum = inParkingLotNum;
		balance = inBalance;
		dateOfRegistration = inDateOfRegistration;
		arrivalDate = inArrivalDate;
		arrivalTime = inArrivalTime;
	}
	public Customer(){
		ID = (Integer) null;
		name = null;
		carNum = (Integer) null;
		exitTime = null;
		email = null;
		parkingLotNum = (Integer) null;
		balance = (Double) null;
		dateOfRegistration = null;
		arrivalDate = null;
		arrivalTime = null;
	}
	
	// gets
	public int getID(){
		return ID;
		
	}
	public String getName(){
		return name;
		
	}
	public int getCarNum(){
		return carNum;
		
	}
	public String getExitTime(){
		return exitTime;
		
	}
	public String getEmail(){
		return email;
	}
	public int getParkingLotNum(){
		return parkingLotNum;
		
	}
	public double getBalance(){
		return balance;
		
	}
	public String getDateOfRegistrtion(){
		return dateOfRegistration;
		
	}
	
	public String getArrivalDate(){
		return arrivalDate;
	}
	public String getArrivalTime(){
		return arrivalTime;
	}
	//sets
	public void setID(int inID){
		ID = inID;
		
	}
	public void  setName( String inName){
		name = inName;
		
	}
	public void   setCarNum(int inCarNum){
		carNum =  inCarNum;
		
	}
	public void setExitTime(String inExitTime){
		exitTime = inExitTime;
		
	}
	public void  setEmail(String inEmail){
		email = inEmail;
	}
	public  void  setParkingLotNum(int inParkingLotNum){
		parkingLotNum = inParkingLotNum;
		
	}
	public  void  setBalance(double inBalance){
		balance = inBalance;
		
	}
	public void setDateOfRegistrtion(String inDateOfRegistrtion){
		dateOfRegistration = inDateOfRegistrtion ;
		
	}
	public void setArrivalDate(String inArrivalDate){
		arrivalDate = inArrivalDate;
	}
	public void setArrivalTime(String inArrivalTime){
		arrivalTime = inArrivalTime;
	}
}