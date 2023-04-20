package deptStore;

/**
 * A class to create an Employee working at a store
 * 
 * @author OOPDA Instructor
 *
 */
public abstract class Employee {
	/* the name of the Employee */ 				
	protected String name;
	
	/**
	 * The no argument constructor
	 */
	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}