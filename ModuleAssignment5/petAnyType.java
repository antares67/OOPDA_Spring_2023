// package celebrityKittens;

public class petAnyType extends Pet{
    
    private String type;
    private int ageInMonths;
    private String name;

	public petAnyType(String type, String name, int ageInMonths) {
		super(name, ageInMonths);
        this.type = type;
        this.name = name;
        this.ageInMonths = ageInMonths; 

	}


    /**
     * Returns type
     * @return
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   @Override
    public String toString() {
		return this.type + " " + this.name + " (" + this.ageInMonths + " months)";
	}

}
