package deptStore;

/**
 * A class to create a Cashier working at a store
 * 
 * @author OOPDA Instructor
 *
 */

 public class Cashier extends Employee {

	private String name;
	private int employeeID;
	private double hourlyWage;
	private double drawerAmount;
	private double transactions;
	private double productivity;
	final private double quota = 20; 

	public Cashier(String name, int employeeID, double hourlyWage, double drawerAmount) {
		super(name);
		this.name = name;
		this.employeeID = employeeID;
		this.hourlyWage = hourlyWage;
		this.drawerAmount = drawerAmount;
	}	

/*
 * Cashiers will ringup sales at the register and complete returns.  
 * Each of these will count as a transaction.  
 * You need to keep track of the cashier transactions.  
 * The daily transaction target for all cashiers is 20.  
 * In the example above, Franny Wilkins only made 6 transactions, so her productivity is 30%.
 * 
 */


	public void ringup(int e, double d) { //quota of 20 transactions
		this.transactions = e;
		this.productivity = transactions / quota;	
		this.drawerAmount += d;
	}

	public void completeReturn(double d) {
		// TODO Auto-generated method stub		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getDrawerAmount() {
		return drawerAmount;
	}

	public void setDrawerAmount(double drawerAmount) {
		this.drawerAmount = drawerAmount;
	}

	@Override
	public String toString() {
		return "Cashier\nName: " + name + "\nID: " + employeeID + "\nHourly Wage: " + hourlyWage + "\nProductivity: " + productivity + "\nDrawer Amount: "+ drawerAmount  + "\n";
	}
	

	

}

/*
 * 
 * Here are the employees:


Cashier
Name: Franny Wilkins
ID: 100
Hourly Wage: 10.75
Productivity: 0.3
Drawer Amount: 1196.52

Cashier
Name: Barbara Smith
ID: 76
Hourly Wage: 11.0
Productivity: 1.2
Drawer Amount: 3026.73
 * 
 */