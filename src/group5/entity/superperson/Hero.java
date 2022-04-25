package group5.entity.superperson;

import group5.entity.team.HeroicTeam;

import java.util.ArrayList;

public class Hero extends Superperson {
    private final String secretIdentity;
    private final ArrayList<Villain> bookOfEnemies = new ArrayList<>();
    private Villain nemesis;
    private HeroicTeam memberOf;

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public ArrayList<Villain> getBookOfEnemies() {
        return bookOfEnemies;
    }

    public void setNemesis(Villain nemesis) {
        this.nemesis = nemesis;
    }

    public Villain getNemesis() {
        return nemesis;
    }

    public void setMemberOf(HeroicTeam memberOf) {
        this.memberOf = memberOf;
    }

    public HeroicTeam getMemberOf() {
        return memberOf;
    }

    public Hero(int id, String name, String location, int powerLevel, String secretIdentity) {
        super(id, name, location, powerLevel);
        this.secretIdentity = secretIdentity;
    }

    public Hero(int id, String name, String location, String oneLiner, int powerLevel, String secretIdentity) {
        super(id, name, location, oneLiner, powerLevel);
        this.secretIdentity = secretIdentity;
    }
}
