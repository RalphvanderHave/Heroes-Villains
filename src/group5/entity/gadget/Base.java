package group5.entity.gadget;

import group5.entity.superperson.Superperson;

public class Base extends Gadget {
    private final String location;

    public String getLocation() {
        return location;
    }

    public Base(int id, String name, String description, Superperson ownedBy, String location) {
        super(id, name, description, ownedBy);
        this.location = location;
    }
}
