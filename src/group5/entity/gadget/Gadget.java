package group5.entity.gadget;

import group5.entity.Entity;
import group5.entity.superperson.Superperson;

public abstract class Gadget extends Entity {
    protected final String description;
    protected final Superperson ownedBy;

    public String getDescription() {
        return description;
    }

    public Superperson getOwnedBy() {
        return ownedBy;
    }

    public Gadget(int id, String name, String description, Superperson ownedBy) {
        super(id, name);
        this.description = description;
        this.ownedBy = ownedBy;
    }
}