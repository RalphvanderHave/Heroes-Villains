package group5.entity.battle;

import group5.Main;
import group5.entity.fan.Fan;
import group5.entity.gadget.Weapon;
import group5.entity.superperson.Hero;
import group5.entity.superperson.Superperson;
import group5.entity.superperson.Villain;

import java.util.ArrayList;

public class IndividualBattle extends Battle {
    private final Hero hero;
    private final Villain villain;
    private Superperson winner;
    private Superperson loser;

    public int getId() {
        return id;
    }

    public Superperson getWinner() {
        return winner;
    }

    public void setWinner(Superperson winner) {
        this.winner = winner;
    }

    public Superperson getLoser() {
        return loser;
    }

    public void setLoser(Superperson loser) {
        this.loser = loser;
    }

    private void printBattleOpener() {
        System.out.println("----------------------------------");
        System.out.println("The battle starts!");
        System.out.println();
        System.out.println(this.hero.getName() + (" speaks: ") + this.hero.getOneLiner());
        System.out.println(this.villain.getName() + (" speaks: ") + this.villain.getOneLiner());
        System.out.println();
        System.out.println("Pow! Kets! Bam!");
        System.out.println();
    }

    private void calculateFanMutations() {
        System.out.println("Fan mutations:");
        ArrayList<Fan> listOfFansOfLoserAndNotWinner = new ArrayList<>();
        for (int i = 0; i < Main.listOfAllFans.size(); i++) {
            if (Main.listOfAllFans.get(i).getFanOf().contains(this.loser) && !(Main.listOfAllFans.get(i).getFanOf().contains(this.winner))) {
                listOfFansOfLoserAndNotWinner.add(Main.listOfAllFans.get(i));
            }
        }
        if (listOfFansOfLoserAndNotWinner.size() == 0) {
            System.out.println(this.getLoser().getName() + " is an extreme loser. We're not doing anything with the fans.");
        } else {
            for (int k = 0; k < 0.5 * listOfFansOfLoserAndNotWinner.size(); k++) {
                System.out.println(listOfFansOfLoserAndNotWinner.get(k).getName() + " changes allegiance");
                listOfFansOfLoserAndNotWinner.get(k).getFanOf().remove(this.loser);
                listOfFansOfLoserAndNotWinner.get(k).getFanOf().add(this.winner);
            }
        }
    }

    public void calculateBattle() {
        printBattleOpener();

        int cumulativeHeroPowerlvl = this.hero.getPowerLevel();
        int cumulativeVillainPowerlvl = this.villain.getPowerLevel();

        // adding nemesis factor
        if (this.hero.getNemesis().getId() == this.villain.getId()) {
            cumulativeHeroPowerlvl *= 1.1;
        }
        if (this.villain.getNemesis().getId() == this.hero.getId()) {
            cumulativeHeroPowerlvl *= 1.1;
        }

        // 1 fan adds 1 powerlevel
        for (int i = 0; i < Main.listOfAllFans.size(); i++) {
            for (int j = 0; j < Main.listOfAllFans.get(i).getFanOf().size(); j++) {
                if (Main.listOfAllFans.get(i).getFanOf().get(j).getId() == this.hero.getId()) {
                    cumulativeHeroPowerlvl++;
                }
                if (Main.listOfAllFans.get(i).getFanOf().get(j).getId() == this.villain.getId()) {
                    cumulativeVillainPowerlvl++;
                }
            }
        }

        // adding gadget powerlevel to cumulative powerlevel
        for (int i = 0; i < this.hero.getListOfGadgets().size(); i++) {
            if (this.hero.getListOfGadgets().get(i) instanceof Weapon) {
                cumulativeHeroPowerlvl += ((Weapon) this.hero.getListOfGadgets().get(i)).getPowerLevel();
            }
        }
        for (int i = 0; i < this.villain.getListOfGadgets().size(); i++) {
            if (this.villain.getListOfGadgets().get(i) instanceof Weapon) {
                cumulativeVillainPowerlvl += ((Weapon) this.villain.getListOfGadgets().get(i)).getPowerLevel();
            }
        }

        int totalPowerLevel =  cumulativeHeroPowerlvl + cumulativeVillainPowerlvl;

        double heroChanceToWin = (double) cumulativeHeroPowerlvl / (double) totalPowerLevel;

        double decision = Math.random();

        if (decision > heroChanceToWin) {
            System.out.println(this.villain.getName() + " wins because the decision " + decision + " falls outside of the heroChanceToWin: " + heroChanceToWin);
            this.setWinner(this.villain);
            this.setLoser(this.hero);
        } else {
            System.out.println(this.hero.getName() + " wins because the decision " + decision + " falls within the heroChanceToWin " + heroChanceToWin);
            this.setWinner(this.hero);
            this.setLoser(this.villain);
        }

        // Fan switch from loser to winner
        //  50% of loser fans switch
        calculateFanMutations();
        }

    public void calculateWithWinner() {
        if (this.winner instanceof Hero) {
            this.loser = this.villain;
        } else {
            this.loser = this.hero;
        }
        printBattleOpener();
        System.out.println("It was " + this.winner.getName() + "s destiny to win");
        System.out.println();

        calculateFanMutations();
    }

    public IndividualBattle(int id, String name, Hero hero, Villain villain) {
        super(id, name);
        this.hero = hero;
        this.villain = villain;
    }
}
