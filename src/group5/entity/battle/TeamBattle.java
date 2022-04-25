package group5.entity.battle;

import group5.Main;
import group5.entity.gadget.Weapon;
import group5.entity.team.HeroicTeam;
import group5.entity.team.Team;
import group5.entity.team.VillainousTeam;

public class TeamBattle extends Battle {
    private final HeroicTeam heroicTeam;
    private final VillainousTeam villainousTeam;
    private Team winner;

    public int getId() {
        return id;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public Team getWinner() {
        return winner;
    }

    private int getNumberOfHeroicTeamFans() {
        int numberOfHeroicTeamFans = 0;
        for (int i = 0; i < heroicTeam.getMembers().size(); i++) {
            for (int j = 0; j < Main.listOfAllFans.size(); j++) {
                if (Main.listOfAllFans.get(j).getFanOf().contains(heroicTeam.getMembers().get(i))) {
                    numberOfHeroicTeamFans++;
                }
            }
        }
        return numberOfHeroicTeamFans;
    }

    private int getNumberOfVillainousTeamFans() {
        int numberOfVillainousTeamFans = 0;
        for (int i = 0; i < villainousTeam.getMembers().size(); i++) {
            for (int j = 0; j < Main.listOfAllFans.size(); j++) {
                if (Main.listOfAllFans.get(j).getFanOf().contains(villainousTeam.getMembers().get(i))) {
                    numberOfVillainousTeamFans++;
                }
            }
        }
        return numberOfVillainousTeamFans;
    }

    private void printTeamBattleOpener() {
        System.out.println("----------------------------------");
        System.out.println("The battle starts!");
        System.out.println();
        System.out.println(this.heroicTeam.getName() + (": "));
        for (int i = 0; i < heroicTeam.getMembers().size(); i++) {
            System.out.println("\t " + heroicTeam.getMembers().get(i).getOneLiner());
        }
        System.out.println(this.villainousTeam.getName() + (": "));
        for (int i = 0; i < villainousTeam.getMembers().size(); i++) {
            System.out.println("\t " + villainousTeam.getMembers().get(i).getOneLiner());
        }
    }

    public void calculateBattle() {
        printTeamBattleOpener();

        int cumulativeHeroicTeamPowerlvl = 0;
        int cumulativeVillainousTeamPowerlvl = 0;

        // add individual member powerlevels to cumulative powerlevel
        for (int i = 0; i < heroicTeam.getMembers().size(); i++) {
            cumulativeHeroicTeamPowerlvl += heroicTeam.getMembers().get(i).getPowerLevel();
        }
        for (int i = 0; i < villainousTeam.getMembers().size(); i++) {
            cumulativeVillainousTeamPowerlvl += villainousTeam.getMembers().get(i).getPowerLevel();
        }

        // adding nemesis factor
        int nemesesOfHeros = 0;
        int nemesesOfVillains = 0;
        for (int i = 0; i < heroicTeam.getMembers().size(); i++) {
            if (villainousTeam.getMembers().contains(heroicTeam.getMembers().get(i).getNemesis())) {
                nemesesOfHeros++;
            }
        }
        for (int i = 0; i < villainousTeam.getMembers().size(); i++) {
            if (heroicTeam.getMembers().contains(villainousTeam.getMembers().get(i).getNemesis())) {
                nemesesOfVillains++;
            }
        }

        cumulativeHeroicTeamPowerlvl *= Math.pow(1.1, nemesesOfHeros);
        cumulativeVillainousTeamPowerlvl *= Math.pow(1.1, nemesesOfVillains);

        // adding fans // 1 fan adds 1 powerlevel
        int amountOfHeroicTeamFans = getNumberOfHeroicTeamFans();
        int amountOfVillainousTeamFans = getNumberOfVillainousTeamFans();

        System.out.println();
        System.out.println((amountOfHeroicTeamFans + amountOfVillainousTeamFans) + " fans showed up to see this epic team battle!");
        System.out.println("Fans of " + this.heroicTeam.getName() + " members add " + amountOfHeroicTeamFans + " to their strength!");
        System.out.println("Fans of " + this.villainousTeam.getName() + " members add " + amountOfVillainousTeamFans + " to their strength!");
        System.out.println();
        System.out.println("Pow! Kets! Bam!");
        System.out.println();

        cumulativeHeroicTeamPowerlvl += amountOfHeroicTeamFans;
        cumulativeVillainousTeamPowerlvl += amountOfVillainousTeamFans;

        for (int i = 0; i < heroicTeam.getMembers().size(); i++) {
            for (int j = 0; j < this.heroicTeam.getMembers().get(i).getListOfGadgets().size(); j++) {
                if (this.heroicTeam.getMembers().get(i).getListOfGadgets().get(j) instanceof Weapon) {
                    cumulativeHeroicTeamPowerlvl += ((Weapon) this.heroicTeam.getMembers().get(i).getListOfGadgets().get(j)).getPowerLevel();
                }
            }
        }
        for (int i = 0; i < villainousTeam.getMembers().size(); i++) {
            for (int j = 0; j < this.villainousTeam.getMembers().get(i).getListOfGadgets().size(); j++) {
                if (this.villainousTeam.getMembers().get(i).getListOfGadgets().get(j) instanceof Weapon) {
                    cumulativeVillainousTeamPowerlvl += ((Weapon) this.villainousTeam.getMembers().get(i).getListOfGadgets().get(j)).getPowerLevel();
                }
            }
        }

        int totalPowerLevel = cumulativeHeroicTeamPowerlvl + cumulativeVillainousTeamPowerlvl;
        double heroicTeamChanceToWin = (double) cumulativeHeroicTeamPowerlvl / (double) totalPowerLevel;

        double decision = Math.random();

        if (decision > heroicTeamChanceToWin) {
            System.out.println(this.villainousTeam.getName() + " wins because the decision " + decision + " falls outside of the heroChanceToWin: " + heroicTeamChanceToWin);
            this.setWinner(this.villainousTeam);
        } else {
            System.out.println(this.heroicTeam.getName() + " wins because the decision " + decision + " falls within the heroChanceToWin " + heroicTeamChanceToWin);
            this.setWinner(this.heroicTeam);
        }
    }

    public void calculateWithWinner() {
        if (winner instanceof HeroicTeam) {
            this.winner = this.heroicTeam;
        } else {
            this.winner = this.villainousTeam;
        }
        printTeamBattleOpener();

        System.out.println();
        System.out.println("Pow! Kets! Bam!");
        System.out.println();
        System.out.println("It was " + this.winner.getName() + "'s destiny to win");
        System.out.println();
    }

    public TeamBattle(int id, String name, HeroicTeam heroicTeam, VillainousTeam villainousTeam) {
        super(id, name);
        this.heroicTeam = heroicTeam;
        this.villainousTeam = villainousTeam;
    }
}
