package group5.entity.superperson;

import group5.entity.team.VillainousTeam;

import java.util.ArrayList;

public class Villain extends Superperson {
    private final String evilPLan;
    private final ArrayList<Hero> bookOfEnemies = new ArrayList<>();
    private Hero nemesis;
    private VillainousTeam memberOf;

    public String getEvilPLan() {
        return evilPLan;
    }

    public ArrayList<Hero> getBookOfEnemies() {
        return bookOfEnemies;
    }

    public void setMemberOf(VillainousTeam memberOf) {
        this.memberOf = memberOf;
    }

    public VillainousTeam getMemberOf() {
        return memberOf;
    }

    public void setNemesis(Hero nemesis) {
        this.nemesis = nemesis;
    }

    public Hero getNemesis() {
        return nemesis;
    }

    public Villain(int id, String name, String location, int powerLevel, String evilPLan) {
        super(id, name, location, powerLevel);
        this.evilPLan = evilPLan;
    }

    public Villain(int id, String name, String location, String oneLiner, int powerLevel, String evilPLan) {
        super(id, name, location, oneLiner, powerLevel);
        this.evilPLan = evilPLan;
    }
}
