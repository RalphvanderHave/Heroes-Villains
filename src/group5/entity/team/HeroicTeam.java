package group5.entity.team;

import group5.entity.superperson.Hero;

import java.util.ArrayList;

public class HeroicTeam extends Team {
    private final ArrayList<Hero> members;

    public ArrayList<Hero> getMembers() {
        return members;
    }

    public HeroicTeam(int id, String name, ArrayList<Hero> members) {
        super(id, name);
        this.members = members;
    }
}
