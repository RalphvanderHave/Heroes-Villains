package group5.entity.fan;

import group5.entity.Entity;
import group5.entity.superperson.Superperson;

import java.util.ArrayList;

public class Fan extends Entity {
    private final ArrayList<Superperson> fanOf = new ArrayList<>();

    public ArrayList<Superperson> getFanOf() {
        return fanOf;
    }

    public Fan(int id, String name) {
        super(id, name);
    }
}