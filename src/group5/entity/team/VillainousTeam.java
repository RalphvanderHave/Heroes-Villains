package group5.entity.team;

import group5.entity.superperson.Villain;

import java.util.ArrayList;

public class VillainousTeam extends Team {
    private final ArrayList<Villain> members;

    public ArrayList<Villain> getMembers() {
        return members;
    }

    public VillainousTeam(int id, String name, ArrayList<Villain> members) {
        super(id, name);
        this.members = members;
    }
}
