package group5.entity.gadget;

import group5.entity.superperson.Superperson;

public class Weapon extends Gadget {
    private final int powerLevel;

    public int getPowerLevel() {
        return powerLevel;
    }

    public Weapon(int id, String name, String description, Superperson ownedBy, int powerLevel) {
        super(id, name, description, ownedBy);
        this.powerLevel = powerLevel;
    }
}
