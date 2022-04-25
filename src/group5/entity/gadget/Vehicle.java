package group5.entity.gadget;

import group5.entity.superperson.Superperson;

public class Vehicle extends Gadget {
    private final int speed;
    private final int capacity;

    public int getSpeed() {
        return speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public Vehicle(int id, String name, String description, Superperson ownedBy, int speed, int capacity) {
        super(id, name, description, ownedBy);
        this.speed = speed;
        this.capacity = capacity;
    }
}
