import java.util.List;

public abstract class Animal {

    private int age;
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's position.
    private Location location;
    // The field occupied.
    private Field field;

    public Animal (int age, boolean alive, Location location, Field field){
        this.age = age;
        this.alive = alive;
        this.location = location;
        this.field = field;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    abstract public void act(List<Animal> newAnimals);


    
}

