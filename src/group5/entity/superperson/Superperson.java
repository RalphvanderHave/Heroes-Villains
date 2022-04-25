package group5.entity.superperson;

import group5.entity.Entity;
import group5.entity.gadget.Gadget;

import java.util.ArrayList;

public abstract class Superperson extends Entity {
    protected final ArrayList<Gadget> listOfGadgets = new ArrayList<>();
    protected final String location;
    protected String oneLiner = "Hello!";
    protected final int powerLevel;

    public ArrayList<Gadget> getListOfGadgets() {
        return listOfGadgets;
    }

    public String getLocation() {
        return location;
    }

    public String getOneLiner() {
        return oneLiner;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public Superperson(int id, String name, String location, int powerLevel) {
        super(id, name);
        this.location = location;
        this.powerLevel = powerLevel;
    }

    public Superperson(int id, String name, String location, String oneLiner, int powerLevel) {
        super(id, name);
        this.location = location;
        this.oneLiner = oneLiner;
        this.powerLevel = powerLevel;
    }
}
