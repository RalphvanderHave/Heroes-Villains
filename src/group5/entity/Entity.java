package group5.entity;

public abstract class Entity {
    protected final int id;
    protected final String name;

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}