package deptStore;

import javax.sql.RowSetEvent;

/**
 * A class to create a SalesAssociate working at a store
 * 
 * @author OOPDA Instructor
 *
 */
public class SalesAssociate extends Employee {

	private String name;
	private int employeeID;
	private double hourlyWage;
	private String department;
	private int saleCount;
	private double revenueAmount;
	private double productivity;
	

	public SalesAssociate(String name, int employeeID, double hourlyWage, String department) {
		// TODO Auto-generated constructor stub
		super(name);
		this.name = name;
		this.employeeID = employeeID;
		this.hourlyWage = hourlyWage;
		this.department = department;
	}


/*	Sales Associate productivity is calculated based on two metrics -- 
 number of sales and amount of revenue.  
 A sales associate has a daily target of 3 sales, and a target daily revenue of $1000. 
  In the example above, Will Martin did make 3 sales, making the sales number metric 100%.  
  However, he only brought in revenue of $202.40, making the revenue generated metric about 20%. 
   When you average these two metrics, you can see that Will's final productivity is 60%.
 */
	public void makeSale(int randomSales, double randomAmount) {
		saleCount = randomSales;
		revenueAmount = randomAmount;
		double revenueQuota = randomAmount / 1000.0;
		if(saleCount < 3){
		productivity = (((double)saleCount)/3.0 + revenueQuota) / 2;
		} else {
		productivity = (1 + revenueQuota) / 2;
		}
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "SalesAssociate\nName: " + name + "\nID: " + employeeID + "\nHourly Wage: " + hourlyWage + "\nProductivity: " + productivity +"\nDepartment: " + department + "\nNumber of Sales: " + saleCount + "\nAmount of Revenue: " + revenueAmount + "\n";
	}

	

}

/*
 * SalesAssociate
Name: Will Martin
ID: 166
Hourly Wage: 11.5
Productivity: 0.601205
Department: Shoes
Number of Sales: 3
Amount of Revenue: 202.41
 * 
 */