package group5;

import group5.entity.battle.Battle;
import group5.entity.battle.IndividualBattle;
import group5.entity.battle.TeamBattle;
import group5.entity.Entity;
import group5.entity.fan.Fan;
import group5.entity.gadget.Base;
import group5.entity.gadget.Gadget;
import group5.entity.gadget.Vehicle;
import group5.entity.gadget.Weapon;
import group5.entity.superperson.Hero;
import group5.entity.superperson.Villain;
import group5.entity.team.HeroicTeam;
import group5.entity.team.Team;
import group5.entity.team.VillainousTeam;

import java.util.*;

public class Main {
    private static final ArrayList<Entity> listOfAllEntities = new ArrayList<>();
    private static final ArrayList<Hero> listOfAllHeroes = new ArrayList<>();
    private static final ArrayList<Villain> listOfAllVillains = new ArrayList<>();
    private static final ArrayList<Team> listOfAllTeams = new ArrayList<>();
    private static final ArrayList<HeroicTeam> listOfAllHeroicTeams = new ArrayList<>();
    private static final ArrayList<VillainousTeam> listOfAllVillainousTeams = new ArrayList<>();
    private static final ArrayList<Gadget> listOfAllGadgets = new ArrayList<>();
    private static final ArrayList<Battle> listOfAllBattles = new ArrayList<>();
    private static final ArrayList<IndividualBattle> listOfAllIndividualBattles = new ArrayList<>();
    private static final ArrayList<TeamBattle> listOfAllTeamBattles = new ArrayList<>();
    public static final ArrayList<Fan> listOfAllFans = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int menuChoice;

    private static void generateEntities() {
        // hero objects
        Hero batman = new Hero(101, "Batman", "Gotham", "I'm Batman", 85, "Bruce Wayne");
        Hero robin = new Hero(102, "Robin", "Gotham", "Holy Smokes", 65, "Dick Grayson");
        Hero superman = new Hero(103, "Superman", "Metropolis", "Up, up, and away!", 88, "Clark Kent");
        Hero flash = new Hero(104, "Flash", "Central City", 70, "Barry Allen");

        Hero ironman = new Hero(105, "Ironman", "Los Angeles", "If there's one thing I've proven it's that you can count on me to pleasure myself", 84, "Anthony Edward Stark");
        Hero hulk = new Hero(106, "Hulk", "Ohio", "Hulk smash", 87, "Robert Bruce Banner");
        Hero antman = new Hero(107, "Ant-man", "Nebraska", "We're The Good Guys Right?", 65, "Henry Jonathan Pym");
        Hero captainAmerica = new Hero(108, "Captain America", "America", "I Can Do This All Day", 84, "Steven Rogers");
        Hero thor = new Hero(109, "Thor", "Asgard", "Do I look to be in a gaming mood?", 87, "Thor Odinson");

        Hero leo = new Hero(110, "Leo", "New York", "I'm Leonardo", 70, "Leonardo");
        Hero raph = new Hero(111, "Raph", "New York", "I'm Raphael", 66, "Raphael");
        Hero don = new Hero(112, "Don", "New York", "I'm Donatello", 65, "Donatello");
        Hero mikey = new Hero(113, "Mikey", "New York", "Cowabunga!", 65, "Michelangelo");

        listOfAllHeroes.addAll(Arrays.asList(batman, robin, superman, flash, ironman, hulk, antman, captainAmerica, thor, leo, raph, don, mikey));
        listOfAllEntities.addAll(listOfAllHeroes);

        // villain objects
        Villain joker = new Villain(201, "Joker", "Gotham", "HAHAHAHAHA", 70, "Create chaos.");
        Villain penguin = new Villain(202, "Penguin", "Sewers of Gotham", "Miserable. You're all miserable ain't ya?", 60, "Poison citizen.");
        Villain deathstroke = new Villain(203, "Deathstroke", "Gotham", 72, "Assasinate.");
        Villain bane = new Villain(215, "Bane", "Gotham", 85, "Fight batman");
        Villain lexLuthor = new Villain(204, "Lex Luthor", "Metropolis", "Lex giveth -- and Lex taketh away.", 84, "Make a god bleed.");
        Villain doomsday = new Villain(205, "Doomsday", "Krypton", "There comes a time when even gods must die.", 87, "Kill superman.");
        Villain reverseFlash = new Villain(206, "Reverse Flash", "Central City", "My fate was to become your greatest enemy.", 70, "Kill Barry as a child.");
        Villain godspeed = new Villain(207, "Godspeed", "Central City", "I thought of calling myself the new and improved Flash", 78, "Commit robberies.");

        Villain thanos = new Villain(208, "Thanos", "Titan", "You're strong, but I could snap my fingers and you'd all cease to exist.", 95, "Kill half the universe");
        Villain ultron = new Villain(209, "Ultron", "Los Angeles", "Don't compare me with Stark. He's a sickness.", 80, "Kill Ironman");
        Villain kang = new Villain(210, "Kang the Conqueror", "Other Earth", "The Twentieth Century belongs to Kang! To Kang!!", 76, "Kill all Avengers");
        Villain galactus = new Villain(211, "Galactus", "Taa-an", "I Hunger!", 70, "Devour planets");
        Villain loki = new Villain(212, "Loki", "Asgard", "You will never be a god", 90, "Becoming the ruler of Asgard");

        Villain shredder = new Villain(213, "The Shredder", "New York", "I'm a ninja, oof!", 85, "Take over New York city.");
        Villain karai = new Villain(214, "Karai", "New York", "I'm a commander ninja!", 75, "Take over New York city.");

        listOfAllVillains.addAll(Arrays.asList(joker, penguin, deathstroke, bane, lexLuthor, doomsday, reverseFlash, godspeed, thanos, ultron, kang, galactus, loki, shredder, karai));
        listOfAllEntities.addAll(listOfAllVillains);

        // set hero nemesis
        batman.setNemesis(joker);
        robin.setNemesis(deathstroke);
        superman.setNemesis(lexLuthor);
        flash.setNemesis(reverseFlash);

        ironman.setNemesis(ultron);
        hulk.setNemesis(kang);
        antman.setNemesis(galactus);
        captainAmerica.setNemesis(thanos);
        thor.setNemesis(loki);

        leo.setNemesis(shredder);
        raph.setNemesis(karai);
        don.setNemesis(shredder);
        mikey.setNemesis(karai);

        // set villain nemesis
        joker.setNemesis(batman);
        penguin.setNemesis(batman);
        deathstroke.setNemesis(robin);
        bane.setNemesis(batman);
        lexLuthor.setNemesis(superman);
        doomsday.setNemesis(superman);
        reverseFlash.setNemesis(flash);
        godspeed.setNemesis(flash);

        ultron.setNemesis(ironman);
        thanos.setNemesis(captainAmerica);
        kang.setNemesis(hulk);
        galactus.setNemesis(antman);

        shredder.setNemesis(leo);
        karai.setNemesis(raph);
        loki.setNemesis(thor);

        // set hero BookOfEnemies
        batman.getBookOfEnemies().addAll(Arrays.asList(joker, penguin, deathstroke));
        robin.getBookOfEnemies().addAll(Arrays.asList(joker, penguin, deathstroke));
        superman.getBookOfEnemies().addAll(Arrays.asList(lexLuthor, doomsday));
        flash.getBookOfEnemies().addAll(Arrays.asList(reverseFlash, godspeed));

        leo.getBookOfEnemies().addAll(Arrays.asList(shredder, karai));
        raph.getBookOfEnemies().addAll(Arrays.asList(shredder, karai));
        don.getBookOfEnemies().addAll(Arrays.asList(shredder, karai));
        mikey.getBookOfEnemies().addAll(Arrays.asList(shredder, karai));

        thor.getBookOfEnemies().add(loki);
        ironman.getBookOfEnemies().add(ultron);
        hulk.getBookOfEnemies().add(kang);
        antman.getBookOfEnemies().add(galactus);
        captainAmerica.getBookOfEnemies().add(thanos);

        // set villain BookOfEnemies
        joker.getBookOfEnemies().add(batman);
        penguin.getBookOfEnemies().add(batman);
        deathstroke.getBookOfEnemies().addAll(Arrays.asList(batman, robin));
        bane.getBookOfEnemies().add(batman);
        lexLuthor.getBookOfEnemies().add(superman);
        doomsday.getBookOfEnemies().add(superman);
        reverseFlash.getBookOfEnemies().add(flash);
        godspeed.getBookOfEnemies().add(flash);

        shredder.getBookOfEnemies().addAll(Arrays.asList(leo, raph, don, mikey));
        karai.getBookOfEnemies().addAll(Arrays.asList(leo, raph, don, mikey));

        loki.getBookOfEnemies().add(thor);
        ultron.getBookOfEnemies().add(ironman);
        kang.getBookOfEnemies().add(hulk);
        galactus.getBookOfEnemies().add(antman);
        thanos.getBookOfEnemies().add(captainAmerica);

        // Base objects
        batman.getListOfGadgets().add(new Base(401, "Batcave", "Underground cave", batman, "Underneath Wayne Manor"));
        robin.getListOfGadgets().add(new Base(402,"Wayne Manor Garage", "Houses a motorcycle", robin, "Part of Wayne Manor"));
        superman.getListOfGadgets().add(new Base(403, "The Fortress of Solitude", " A place of solace and occasional headquarters for Superman", superman, "The Arctic"));
        joker.getListOfGadgets().add(new Base(404, "Ha-Hacienda", "A dark place", joker, "Unclear"));
        lexLuthor.getListOfGadgets().add(new Base(405, "LexCorp", "One of the world's largest, most diversified multinational corporations", lexLuthor, "Metropolis"));

        ironman.getListOfGadgets().add(new Base(406, "Stark Industries", "Stark company", ironman, "Los Angeles"));
        hulk.getListOfGadgets().add(new Base(407, "Project Greenskin Base", "Base to hold gamma-powered superhumans", hulk, "New Mexico"));
        captainAmerica.getListOfGadgets().add(new Base(408, "Camp Lehigh", "Abandoned military base", captainAmerica, "Virginia"));

        leo.getListOfGadgets().add(new Base(409, "Sewers", "Underground sewers", leo, "Underneath New York city"));
        shredder.getListOfGadgets().add(new Base(410, "Ninja hideout", "Base of operation of the Foot Clan", shredder, "New York city"));
        thor.getListOfGadgets().add(new Base(411, "Asgard", "Home of the Asgardians", thor, "Nine Realms"));

        // Weapon objects
        batman.getListOfGadgets().add(new Weapon(412, "Batarang", "A roughly bat-shaped throwing weapon", batman, 5));
        robin.getListOfGadgets().add(new Weapon(413, "Bo Staff", "A retractable metallic staff", robin, 3));
        superman.getListOfGadgets().add(new Weapon(414, "Heat Vision", "The ability to release massive amounts of solar energy stored within the body through the eyes", superman, 9));
        flash.getListOfGadgets().add(new Weapon(415, "Hand", "Can create an Infinite mass punch", flash, 6));
        joker.getListOfGadgets().add(new Weapon(416, "Acid Flower", "Sprays acid, poisonous laughing gas, water, knock out gas, or nothing at all", joker, 4));
        penguin.getListOfGadgets().add(new Weapon(417, "Bulgarian umbrella", "Contains weapons such as machine guns, sword tips, missiles, lasers, flamethrowers, and acid", penguin, 6));
        deathstroke.getListOfGadgets().add(new Weapon(418, "The Deathstroke", "An ancient Scottish war blade", deathstroke, 4));
        lexLuthor.getListOfGadgets().add(new Weapon(419, "Warsuit", "A sophisticated alien battlesuit", lexLuthor, 6));

        captainAmerica.getListOfGadgets().add(new Weapon(420, "Shield", "Throwable shield", captainAmerica, 5));
        ironman.getListOfGadgets().add(new Weapon(421, "Powered Armor Suit", "Flight, Superhuman strength, Regenerative life support", ironman, 10));
        hulk.getListOfGadgets().add(new Weapon(422, "Lamppost", "Convenient object to smash", hulk, 2));
        antman.getListOfGadgets().add(new Weapon(423, "Pym Patricles Disks", "Small shootable disks", antman, 5));

        thanos.getListOfGadgets().add(new Weapon(424, "Infinity Gauntlet", "All powerfull weapon when infity stones are collected", thanos, 10));
        galactus.getListOfGadgets().add(new Weapon(425, "Punisher", "Robot with superhuman strength, speed and durability", galactus, 4));
        kang.getListOfGadgets().add(new Weapon(426, "Battle Armor", "Gives wearer superhuman strength and reflexes", kang, 3));
        kang.getListOfGadgets().add(new Weapon(427, "Neutrino-ray", "Size of a handgun but devastating", kang, 7));
        ultron.getListOfGadgets().add(new Weapon(428, "Exothermic Manipulation", "Raises temperature of his hands making them able to slice through anything", ultron, 6));
        ultron.getListOfGadgets().add(new Weapon(429, "Mind Transfer", "Allows Ultron to transfer consciousness to any computer system", ultron, 2));

        leo.getListOfGadgets().add(new Weapon(430, "Katana", "Leo's favorite weapon", leo, 7));
        raph.getListOfGadgets().add(new Weapon(431, "Sai", "Raph's favorite weapon", raph, 7));
        don.getListOfGadgets().add(new Weapon(432, "Bō", "Don's favorite weapon", don, 6));
        mikey.getListOfGadgets().add(new Weapon(433, "Nunchaku", "Mikey's favorite weapon", mikey, 7));
        shredder.getListOfGadgets().add(new Weapon(434, "Claws", "Shredder's favorite weapon", shredder, 9));
        karai.getListOfGadgets().add(new Weapon(435,"Manipulation",  "Karai's favorite weapon", karai, 5));
        thor.getListOfGadgets().add(new Weapon(436,"Mjolnir",  "Weapon of the Gods", thor, 10));
        loki.getListOfGadgets().add(new Weapon(437, "Chitauri Scepter", "Weapon of mischief", loki, 10));

        // Vehicle objects
        batman.getListOfGadgets().add(new Vehicle(438, "Batmobile", "A heavily armored tactical assault vehicle", batman, 50, 2));
        robin.getListOfGadgets().add(new Vehicle(439, "Redbird", "A tricked-out car", robin, 50, 4));

        for (int i = 0; i < listOfAllHeroes.size(); i++) {
            listOfAllGadgets.addAll(listOfAllHeroes.get(i).getListOfGadgets());
        }
        for (int i = 0; i < listOfAllVillains.size(); i++) {
            listOfAllGadgets.addAll(listOfAllVillains.get(i).getListOfGadgets());
        }

        // heroicteam objects
        HeroicTeam theDynamicDuo = new HeroicTeam(501, "The Dynamic Duo", new ArrayList<>(Arrays.asList(batman, robin)));
        batman.setMemberOf(theDynamicDuo);
        robin.setMemberOf(theDynamicDuo);

        HeroicTeam justiceLeague = new HeroicTeam(502, "Justice League", new ArrayList<>(Arrays.asList(batman, superman, flash)));
        batman.setMemberOf(justiceLeague);
        superman.setMemberOf(justiceLeague);
        flash.setMemberOf(justiceLeague);

        HeroicTeam ninjaTurtles = new HeroicTeam(505, "Ninja Turtles", new ArrayList<>(Arrays.asList(leo, raph, don, mikey)));
        leo.setMemberOf(ninjaTurtles);
        raph.setMemberOf(ninjaTurtles);
        don.setMemberOf(ninjaTurtles);
        mikey.setMemberOf(ninjaTurtles);

        HeroicTeam avengers = new HeroicTeam(530, "Avengers", new ArrayList<>(Arrays.asList(ironman, hulk, antman, captainAmerica)));
        ironman.setMemberOf(avengers);
        hulk.setMemberOf(avengers);
        antman.setMemberOf(avengers);
        captainAmerica.setMemberOf(avengers);

        listOfAllHeroicTeams.addAll(Arrays.asList(theDynamicDuo, justiceLeague, ninjaTurtles, avengers));
        listOfAllTeams.addAll(listOfAllHeroicTeams);
        listOfAllEntities.addAll(listOfAllHeroicTeams);

        // villainousteam objects
        VillainousTeam arkhamAsylumInmates = new VillainousTeam(601, "The Arkham Asylum Inmates", new ArrayList<>(Arrays.asList(joker, penguin, deathstroke)));
        joker.setMemberOf(arkhamAsylumInmates);
        penguin.setMemberOf(arkhamAsylumInmates);
        deathstroke.setMemberOf(arkhamAsylumInmates);

        VillainousTeam spvSquad = new VillainousTeam(640, "SPV squad", new ArrayList<>(Arrays.asList(thanos, galactus, ultron, kang)));
        thanos.setMemberOf(spvSquad);
        galactus.setMemberOf(spvSquad);
        ultron.setMemberOf(spvSquad);
        kang.setMemberOf(spvSquad);

        VillainousTeam footClan = new VillainousTeam(506, "Foot Clan", new ArrayList<>(Arrays.asList(shredder, karai)));
        shredder.setMemberOf(footClan);
        karai.setMemberOf(footClan);

        listOfAllVillainousTeams.addAll(Arrays.asList(arkhamAsylumInmates, spvSquad, footClan));
        listOfAllTeams.addAll(listOfAllVillainousTeams);
        listOfAllEntities.addAll(listOfAllVillainousTeams);

        // Fan objects
        Fan harry = new Fan(301, "Harry");
        harry.getFanOf().addAll(Arrays.asList(batman, robin));

        Fan benedict = new Fan(302, "Benedict");
        benedict.getFanOf().addAll(Arrays.asList(batman, robin));

        Fan hubert = new Fan(303, "Hubert");
        hubert.getFanOf().addAll(Arrays.asList(batman, robin));

        Fan george = new Fan(304, "George");
        george.getFanOf().addAll(Arrays.asList(batman, robin));

        Fan kimberly = new Fan(305, "Kimberly");
        kimberly.getFanOf().add(superman);

        Fan frederick = new Fan(306, "Frederick");
        frederick.getFanOf().add(superman);

        Fan joelle = new Fan(307, "Joelle");
        joelle.getFanOf().add(superman);

        Fan daisy = new Fan(308, "Daisy");
        daisy.getFanOf().addAll(Arrays.asList(superman, flash));

        Fan vicky = new Fan(309, "Vicky");
        vicky.getFanOf().add(flash);

        Fan tim = new Fan(310, "Tim");
        tim.getFanOf().add(flash);

        Fan jason = new Fan(311, "Jason");
        jason.getFanOf().add(flash);

        Fan vera = new Fan(312, "Vera");
        vera.getFanOf().add(ironman);

        Fan lisa = new Fan(313, "Lisa");
        lisa.getFanOf().add(ironman);

        Fan rick = new Fan(314, "Rick");
        rick.getFanOf().addAll(Arrays.asList(ironman, hulk));

        Fan peter = new Fan(315, "Peter");
        peter.getFanOf().add(hulk);

        Fan ulric = new Fan(316, "Ulric");
        ulric.getFanOf().addAll(Arrays.asList(hulk, captainAmerica));

        Fan tina = new Fan(317, "Tina");
        tina.getFanOf().add(captainAmerica);

        Fan rita = new Fan(318, "Rita");
        rita.getFanOf().add(captainAmerica);

        Fan heinrich = new Fan(319, "Heinrich");
        heinrich.getFanOf().add(antman);

        Fan justin = new Fan(320, "Justin");
        justin.getFanOf().add(antman);

        Fan zen = new Fan(321, "Zen");
        zen.getFanOf().addAll(Arrays.asList(antman, thor));

        Fan aafje = new Fan(322, "Aafje");
        aafje.getFanOf().add(thor);

        Fan marcia = new Fan(323, "Marcia");
        marcia.getFanOf().addAll(Arrays.asList(thor, bane));

        Fan maxime = new Fan(324, "Maxime");
        maxime.getFanOf().addAll(Arrays.asList(leo, raph, don, mikey));

        Fan navid = new Fan(325, "Navid");
        navid.getFanOf().addAll(Arrays.asList(leo, raph, don, mikey));

        Fan rigmor = new Fan(326, "Rigmor");
        rigmor.getFanOf().addAll(Arrays.asList(leo, raph, don, mikey));

        Fan eliza = new Fan(327, "Eliza");
        eliza.getFanOf().addAll(Arrays.asList(batman, superman, hulk));

        Fan ziva = new Fan(328, "Ziva");
        ziva.getFanOf().addAll(Arrays.asList(ironman, captainAmerica, thor));

        Fan samir = new Fan(329, "Samir");
        samir.getFanOf().addAll(Arrays.asList(hulk, robin, superman));

        Fan andries = new Fan(330, "Andries");
        andries.getFanOf().addAll(Arrays.asList(batman, ironman, leo, don));

        Fan nayla = new Fan(331, "Nayla");
        nayla.getFanOf().addAll(Arrays.asList(ironman, thor, raph, mikey));

        Fan diesel = new Fan(332, "Diesel");
        diesel.getFanOf().add(joker);

        Fan lindsey = new Fan(333, "Lindsey");
        lindsey.getFanOf().add(joker);

        Fan julien = new Fan(334, "Julien");
        julien.getFanOf().add(joker);

        Fan dimitri = new Fan(335, "Dimitri");
        dimitri.getFanOf().add(penguin);

        Fan derek = new Fan(336, "Derek");
        derek.getFanOf().add(penguin);

        Fan clinton = new Fan(337, "Clinton");
        clinton.getFanOf().add(penguin);

        Fan petra = new Fan(338, "Petra");
        petra.getFanOf().add(penguin);

        Fan bea = new Fan(339, "Bea");
        bea.getFanOf().addAll(Arrays.asList(penguin, deathstroke));

        Fan sam = new Fan(340, "Sam");
        sam.getFanOf().add(deathstroke);

        Fan brody = new Fan(341, "Brody");
        brody.getFanOf().add(deathstroke);

        Fan lucca = new Fan(342, "Lucca");
        lucca.getFanOf().addAll(Arrays.asList(deathstroke, lexLuthor));

        Fan kathy = new Fan(343, "Kathy");
        kathy.getFanOf().add(lexLuthor);

        Fan angela = new Fan(344, "Angela");
        angela.getFanOf().add(lexLuthor);

        Fan rylee = new Fan(345, "Rylee");
        rylee.getFanOf().addAll(Arrays.asList(lexLuthor, doomsday));

        Fan rihanna = new Fan(346, "Rihanna");
        rihanna.getFanOf().addAll(Arrays.asList(doomsday, reverseFlash));

        Fan rosanna = new Fan(347, "Rosanna");
        rosanna.getFanOf().addAll(Arrays.asList(doomsday, reverseFlash));

        Fan francesca = new Fan(348, "Francesca");
        francesca.getFanOf().add(godspeed);

        Fan michelle = new Fan(349, "Michelle");
        michelle.getFanOf().addAll(Arrays.asList(godspeed, thanos));

        Fan willard = new Fan(350, "Willard");
        willard.getFanOf().add(joker);

        Fan savannah = new Fan(351, "Savannah");
        savannah.getFanOf().add(reverseFlash);

        Fan aman = new Fan(352, "Aman");
        aman.getFanOf().add(thanos);

        Fan sander = new Fan(353, "Sander");
        sander.getFanOf().add(thanos);

        Fan mark = new Fan(354, "Mark");
        mark.getFanOf().addAll(Arrays.asList(thanos, ultron));

        Fan homer = new Fan(355, "Homer");
        homer.getFanOf().addAll(Arrays.asList(thanos, ultron));

        Fan abbey = new Fan(356, "Abbey");
        abbey.getFanOf().add(ultron);

        Fan opal = new Fan(357, "Opal");
        opal.getFanOf().add(ultron);

        Fan isaaq = new Fan(358, "Isaaq");
        isaaq.getFanOf().addAll(Arrays.asList(kang, galactus));

        Fan phoebe = new Fan(359, "Phoebe");
        phoebe.getFanOf().addAll(Arrays.asList(kang, galactus));

        Fan simon = new Fan(360, "Simon");
        simon.getFanOf().addAll(Arrays.asList(kang, galactus, loki));

        Fan penny = new Fan(361, "Penny");
        penny.getFanOf().addAll(Arrays.asList(loki, shredder));

        Fan aiden = new Fan(362, "Aiden");
        aiden.getFanOf().add(loki);

        Fan kieran = new Fan(363, "Kieran");
        kieran.getFanOf().addAll(Arrays.asList(shredder, karai));

        Fan jasper = new Fan(364, "Jasper");
        jasper.getFanOf().addAll(Arrays.asList(loki, thanos));

        Fan mustafa = new Fan(365, "Mustafa");
        mustafa.getFanOf().addAll(Arrays.asList(shredder, karai));

        Fan erin = new Fan(366, "Erin");
        erin.getFanOf().addAll(Arrays.asList(shredder, karai));

        Fan aurelia = new Fan(367, "Aurelia");
        aurelia.getFanOf().addAll(Arrays.asList(shredder, karai));

        Fan olivier = new Fan(368, "Olivier");
        olivier.getFanOf().add(galactus);

        Fan gregory = new Fan(369, "Gregory");
        gregory.getFanOf().add(kang);

        Fan cameron = new Fan(370, "Cameron");
        cameron.getFanOf().add(lexLuthor);

        listOfAllFans.addAll(Arrays.asList(harry, benedict, hubert, george, kimberly, frederick, joelle, daisy, vicky,
                tim, jason, vera, lisa, rick, peter, ulric, tina, rita, heinrich, justin, zen, aafje, marcia, maxime,
                navid, rigmor, eliza, ziva, samir, andries, nayla, diesel, lindsey, julien, dimitri, derek, clinton,
                petra, bea, sam, brody, lucca, kathy, angela, rylee, rihanna, rosanna, francesca, michelle, willard,
                savannah, aman, sander, mark, homer, abbey, opal, isaaq, phoebe, simon, penny, aiden, kieran, jasper,
                mustafa, erin, aurelia, olivier, gregory, cameron));
        listOfAllEntities.addAll(listOfAllFans);
    }

    private static void runMainMenu() {
        while (true) {
            System.out.print("""
                    ----------------------------
                    Main Menu
                    ----------------------------
                    (1) Menu People & Teams
                    (2) Menu Gadgets
                    (3) Menu Fights
                    (0) Exit
                    Make a choice (0-3):\s""");
            menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    runMenuPeopleAndTeams();
                    break;
                case 2:
                    runMenuGadgets();
                    break;
                case 3:
                    runMenuFights();
                    break;
                case 0:
                    System.exit(1);
                default:
                    System.out.println("That number is not in the list of options.");
                    System.out.print("Press enter to continue.");
                    scanner.nextLine();
                    scanner.nextLine();
            }
        }
    }

    private static void runMenuPeopleAndTeams() {
        System.out.print("""
            ----------------------------
            Menu People & Teams
            ----------------------------
            (1) List of Heros
            (2) List of Villains
            (3) List of Fans
            (4) List of Teams
            (5) Search...
            (0) Exit
            Make a choice (0-5):\s""");
        menuChoice = scanner.nextInt();
        int idChoice;

        switch (menuChoice) {
            case 1:
                for (int i = 0; i < listOfAllHeroes.size(); i++) {
                    System.out.print("(" + listOfAllHeroes.get(i).getId() + ")  ");
                    System.out.println(listOfAllHeroes.get(i).getName());
                }
                System.out.println("(0) Exit");
                System.out.print("Choose an id to view details: ");
                menuChoice = scanner.nextInt();
                for (int i = 0; i < listOfAllHeroes.size(); i++) {
                    if (listOfAllHeroes.get(i).getId() == menuChoice) {
                        Hero chosenHero = listOfAllHeroes.get(i);
                        System.out.println("----------------------------------");
                        System.out.println("ID: " + chosenHero.getId());
                        System.out.println("Hero: " + chosenHero.getName());
                        System.out.println("Name: " + chosenHero.getSecretIdentity());
                        System.out.println("Location: " + chosenHero.getLocation());
                        System.out.println();
                        System.out.println("One-Liner: " + chosenHero.getOneLiner());
                        System.out.println();
                        System.out.println("Enemies: ");
                        for (int j = 0; j < chosenHero.getBookOfEnemies().size(); j++) {
                            System.out.println("    " + chosenHero.getBookOfEnemies().get(j).getName());
                        }
                        System.out.println();
                        System.out.println("Nemesis: ");
                        System.out.println("    " + chosenHero.getNemesis().getName());
                        System.out.println();
                        System.out.println("Fans: ");
                        for (int j = 0; j < listOfAllFans.size(); j++) {
                            for (int k = 0; k < listOfAllFans.get(j).getFanOf().size(); k++) {
                                if (listOfAllFans.get(j).getFanOf().get(k).getId() == chosenHero.getId()) {
                                    System.out.println("    " + listOfAllFans.get(j).getName());
                                }
                            }
                        }
                        System.out.println();
                        System.out.println("Gadgets: ");
                        for (int j = 0; j < chosenHero.getListOfGadgets().size(); j++) {
                            System.out.println("    " + chosenHero.getListOfGadgets().get(j).getName());
                        }
                        System.out.println();
                        if (chosenHero.getMemberOf() != null) {
                            System.out.println("Member of: " + chosenHero.getMemberOf().getName());
                        }
                    }
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 2:
                for (int i = 0; i < listOfAllVillains.size(); i++) {
                    System.out.print("(" + listOfAllVillains.get(i).getId() + ")  ");
                    System.out.println(listOfAllVillains.get(i).getName());
                }
                System.out.println("(0) Exit");
                System.out.print("Choose an id to view details: ");
                idChoice = scanner.nextInt();
                for (int i = 0; i < listOfAllVillains.size(); i++) {
                    if (listOfAllVillains.get(i).getId() == idChoice) {
                        Villain chosenVillain = listOfAllVillains.get(i);
                        System.out.println("----------------------------------");
                        System.out.println("ID: " + chosenVillain.getId());
                        System.out.println("Villain: " + chosenVillain.getName());
                        System.out.println("Evil Plan: " + chosenVillain.getEvilPLan());
                        System.out.println("Location: " + chosenVillain.getLocation());
                        System.out.println();
                        System.out.println("One-Liner: " + chosenVillain.getOneLiner());
                        System.out.println();
                        System.out.println("Enemies: ");
                        for (int j = 0; j < chosenVillain.getBookOfEnemies().size(); j++) {
                            System.out.println("    " + chosenVillain.getBookOfEnemies().get(j).getName());
                        }
                        System.out.println();
                        System.out.println("Nemesis: ");
                        System.out.println("    " + chosenVillain.getNemesis().getName());
                        System.out.println();
                        System.out.println("Fans: ");
                        for (int j = 0; j < listOfAllFans.size(); j++) {
                            for (int k = 0; k < listOfAllFans.get(j).getFanOf().size(); k++) {
                                if (listOfAllFans.get(j).getFanOf().get(k).getId() == chosenVillain.getId()) {
                                    System.out.println("    " + listOfAllFans.get(j).getName());
                                }
                            }
                        }
                        System.out.println();
                        System.out.println("Gadgets: ");
                        for (int j = 0; j < chosenVillain.getListOfGadgets().size(); j++) {
                            System.out.println("    " + chosenVillain.getListOfGadgets().get(j).getName());
                        }
                        System.out.println();
                        if (chosenVillain.getMemberOf() != null) {
                            System.out.println("Member of: " + chosenVillain.getMemberOf().getName());
                        }
                    }
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 3:
                for (int i = 0; i < listOfAllFans.size(); i++) {
                    System.out.print("(" + listOfAllFans.get(i).getId() + ")  ");
                    System.out.println(listOfAllFans.get(i).getName());
                }
                System.out.println("(0) Exit");
                System.out.print("Choose an id to view details: ");
                idChoice = scanner.nextInt();
                for (int i = 0; i < listOfAllFans.size(); i++) {
                    if (listOfAllFans.get(i).getId() == idChoice) {
                        Fan chosenFan = listOfAllFans.get(i);
                        System.out.println("----------------------------------");
                        System.out.println("ID: " + chosenFan.getId());
                        System.out.println("Name: " + chosenFan.getName());
                        System.out.println("Fan of:");
                        for (int j = 0; j < chosenFan.getFanOf().size(); j++) {
                            System.out.println("    " + chosenFan.getFanOf().get(j).getId() + " - " + chosenFan.getFanOf().get(j).getName());
                        }
                    }
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 4:
                for (int i = 0; i < listOfAllTeams.size(); i++) {
                    System.out.print("(" + listOfAllTeams.get(i).getId() + ")  ");
                    System.out.println(listOfAllTeams.get(i).getName());
                }
                System.out.println("(0) Exit");
                System.out.print("Choose an id to view details: ");
                idChoice = scanner.nextInt();
                for (int i = 0; i < listOfAllTeams.size(); i++) {
                    if (listOfAllTeams.get(i).getId() == idChoice) {
                        System.out.println("----------------------------------");
                        System.out.println("ID: " + listOfAllTeams.get(i).getId());
                        System.out.println("Name: " + listOfAllTeams.get(i).getName());
                        System.out.println("Members: ");

                        if (listOfAllTeams.get(i) instanceof HeroicTeam) {
                            HeroicTeam chosenTeam = (HeroicTeam) listOfAllTeams.get(i);
                            for (int j = 0; j < chosenTeam.getMembers().size(); j++) {
                                System.out.print("    (" + chosenTeam.getMembers().get(j).getId() + ")  ");
                                System.out.println(chosenTeam.getMembers().get(j).getName());
                            }
                        } else {
                            VillainousTeam chosenTeam = (VillainousTeam) listOfAllTeams.get(i);
                            for (int j = 0; j < chosenTeam.getMembers().size(); j++) {
                                System.out.print("    (" + chosenTeam.getMembers().get(j).getId() + ")  ");
                                System.out.println(chosenTeam.getMembers().get(j).getName());
                            }
                        }
                    }
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 5:
                System.out.println("Fill in a name: ");
                scanner.nextLine();
                String searchTerm = scanner.nextLine();
                searchTerm = searchTerm.toLowerCase();
                int numberOfResults = 0;
                System.out.println("You searched for: " + searchTerm);
                for (int i = 0; i < listOfAllEntities.size(); i++) {
                    if (listOfAllEntities.get(i).getName().toLowerCase().contains(searchTerm)) {
                        String[] objectClass = listOfAllEntities.get(i).getClass().toString().split("[.]");
                        System.out.println("We found " + listOfAllEntities.get(i).getName() + " Type: " + objectClass[objectClass.length - 1] + ". ID: " + listOfAllEntities.get(i).getId());
                        numberOfResults++;
                    }
                }
                if (numberOfResults == 0) {
                    System.out.println("We found nothing. :(");
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                break;
            case 0:
                break;
            default:
                System.out.println("That number is not in the list of options.");
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
        }
    }


    private static void runMenuGadgets() {

        System.out.print("""
            ----------------------------
            Gadget Menu
            ----------------------------
            (1) List of Gadgets
            (2) Search...
            (0) Exit
            Make a choice (0-2):\s""");
        int menuChoice = scanner.nextInt();

        switch (menuChoice) {
            case 1:
                System.out.println("----------------------------------");
                for (int i = 0; i < listOfAllGadgets.size(); i++) {
                    Gadget gadget = listOfAllGadgets.get(i);
                    System.out.println("(" + gadget.getId() + ") " + gadget.getName());
                }
                System.out.println("(0) Exit");
                System.out.print("Choose an id to view details: ");
                int gadgetId = scanner.nextInt();
                for (int i = 0; i < listOfAllGadgets.size(); i++) {
                    if (listOfAllGadgets.get(i).getId() == gadgetId) {
                        Gadget gadget = listOfAllGadgets.get(i);
                        System.out.println("----------------------------");
                        System.out.println("This gadget is named " + gadget.getName());
                        String[] category = gadget.getClass().toString().split("[.]");
                        System.out.println("Category: " + category[category.length - 1]);
                        System.out.println(gadget.getDescription());
                        if (gadget instanceof Weapon) {
                            System.out.println("Its powerlevel is " + ((Weapon) gadget).getPowerLevel());
                        } else if (gadget instanceof Base) {
                            System.out.println("Its located at " + ((Base) gadget).getLocation());
                        } else {
                            System.out.println("It can go " + ((Vehicle) gadget).getSpeed() + " speedunits!");
                            System.out.println("Its can carry " + ((Vehicle) gadget).getCapacity() + " person(s).");
                        }
                    }
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 2:
                System.out.println("Fill in a search term: ");
                scanner.nextLine();
                String searchTerm = scanner.nextLine().toLowerCase();
                int numberOfResults = 0;
                System.out.println("You searched for: " + searchTerm);
                for (int i = 0; i < listOfAllGadgets.size(); i++) {
                    if (listOfAllGadgets.get(i).getName().toLowerCase().contains(searchTerm)) {
                        System.out.println("We found " + listOfAllGadgets.get(i).getName() + "\nID: " + listOfAllGadgets.get(i).getId() + " - owned by: " + listOfAllGadgets.get(i).getOwnedBy().getName());
                        numberOfResults++;
                    }
                }
                if (numberOfResults == 0) {
                    System.out.println("We found nothing. :(");
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                break;
            case 0:
                break;
            default:
                System.out.println("That number is not in the list of options.");
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
        }
    }

    private static void runMenuFights() {
        System.out.print("""
                    ----------------------------
                    Menu Fights
                    ----------------------------
                    (1) List of Individual Fights
                    (2) New Individual Fight...
                    (3) Simulate x amount of  random fights
                    (4) Fight stats
                    (5) Fight randomly until someone has x fans
                    (6) New Team Fight
                    (7) Search...
                    (0) Exit
                    Make a choice (0-7):\s""");
        Random random = new Random();
        menuChoice = scanner.nextInt();
        switch (menuChoice) {
            case 1:
                System.out.println("----------------------------------");
                if (listOfAllIndividualBattles.size() > 0) {
                    for (int i = 0; i < listOfAllIndividualBattles.size(); i++) {
                        IndividualBattle individualBattle = listOfAllIndividualBattles.get(i);
                        System.out.println(individualBattle.getId() + " " + individualBattle.getName() + "\tWinner: " + individualBattle.getWinner().getName());
                    }
                } else {
                    System.out.println("No fights have happened yet.");
                }
                break;
            case 2:
                System.out.println("Who battles?");
                for (int i = 0; i < listOfAllHeroes.size(); i++) {
                    System.out.print("(" + listOfAllHeroes.get(i).getId() + ")  ");
                    System.out.println(listOfAllHeroes.get(i).getName());
                }
                Hero chosenHero = null;
                while (chosenHero == null) {
                    System.out.print("Choose a Hero Id: ");
                    int chosenHeroId = scanner.nextInt();
                    for (int i = 0; i < listOfAllHeroes.size(); i++) {
                        if (listOfAllHeroes.get(i).getId() == chosenHeroId) {
                            chosenHero = listOfAllHeroes.get(i);
                        }
                    }
                }

                for (int i = 0; i < listOfAllVillains.size(); i++) {
                    System.out.print("(" + listOfAllVillains.get(i).getId() + ")  ");
                    System.out.println(listOfAllVillains.get(i).getName());
                }
                Villain chosenVillain = null;
                while (chosenVillain == null) {
                    System.out.print("Choose a Villain Id: ");
                    int chosenVillainId = scanner.nextInt();
                    for (int i = 0; i < listOfAllVillains.size(); i++) {
                        if (listOfAllVillains.get(i).getId() == chosenVillainId) {
                            chosenVillain = listOfAllVillains.get(i);
                        }
                    }
                }
                IndividualBattle individualBattle = new IndividualBattle((listOfAllBattles.size() + 1),chosenHero.getName() + " vs " + chosenVillain.getName(), chosenHero, chosenVillain);
                listOfAllIndividualBattles.add(individualBattle);
                listOfAllBattles.add(individualBattle);
                System.out.print("""
                        ----------------------------
                        Who wins?
                        (0) Hero wins
                        (1) Villain wins
                        (2) Let the program calculate the winner!
                        Choose (0-2)\s""");
                menuChoice = scanner.nextInt();

                if (menuChoice == 0) {
                    individualBattle.setWinner(chosenHero);
                    individualBattle.calculateWithWinner();
                } else if (menuChoice == 1) {
                    individualBattle.setWinner(chosenVillain);
                    individualBattle.calculateWithWinner();
                } else {
                    individualBattle.calculateBattle();
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 3:
                System.out.print("Amount of fights to simulate: ");
                int amount = scanner.nextInt();
                for (int i = 0; i < amount; i++) {
                    Hero randomHero = listOfAllHeroes.get(random.nextInt(listOfAllHeroes.size()));
                    Villain randomVillain = listOfAllVillains.get(random.nextInt(listOfAllVillains.size()));
                    IndividualBattle randomIndividualBattle = new IndividualBattle(listOfAllBattles.size() + 1, randomHero.getName() + " vs " + randomVillain.getName(), randomHero, randomVillain);
                    listOfAllIndividualBattles.add(randomIndividualBattle);
                    listOfAllBattles.add(randomIndividualBattle);
                    randomIndividualBattle.calculateBattle();
                }
                System.out.println("----------------------------------");
                System.out.println(amount + " fights simulated.");
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 4:
                System.out.println();
                System.out.println("# Fans   -  Superperson");
                ArrayList<String> stats = new ArrayList<>();
                for (int i = 0; i < listOfAllHeroes.size(); i++) {
                    int fanCounter = 0;
                    for (int j = 0; j < listOfAllFans.size(); j++) {
                        for (int k = 0; k < listOfAllFans.get(j).getFanOf().size(); k++) {
                            if (listOfAllFans.get(j).getFanOf().get(k).getId() == listOfAllHeroes.get(i).getId()) {
                                fanCounter++;
                            }
                        }
                    }
                    String statLine = fanCounter + "\t\t\t\t" + listOfAllHeroes.get(i).getName();
                    stats.add(statLine);
                }
                for (int i = 0; i < listOfAllVillains.size(); i++) {
                    int fanCounter = 0;
                    for (int j = 0; j < listOfAllFans.size(); j++) {
                        for (int k = 0; k < listOfAllFans.get(j).getFanOf().size(); k++) {
                            if (listOfAllFans.get(j).getFanOf().get(k).getId() == listOfAllVillains.get(i).getId()) {
                                fanCounter++;
                            }
                        }
                    }
                    String statLine = fanCounter + "\t\t\t\t" + listOfAllVillains.get(i).getName();
                    stats.add(statLine);
                }

                for (int i = 0; i < stats.size(); i++) {
                    System.out.println(stats.get(i));
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 5:
                System.out.println("Keep the input low! Ex: To accumulate 50 fans takes millions of fights and a lot of memory.");
                System.out.print("Amount of fans for a superperson to accumulate: ");
                int amountOfFans = scanner.nextInt();
                int fanCounter = 0;
                int amountOfBattles = 0;
                while (fanCounter < amountOfFans) {
                    fanCounter = 0;
                    Hero randomHero = listOfAllHeroes.get(random.nextInt(listOfAllHeroes.size()));
                    Villain randomVillain = listOfAllVillains.get(random.nextInt(listOfAllVillains.size()));
                    IndividualBattle randomIndividualBattle = new IndividualBattle(listOfAllBattles.size() + 1, randomHero.getName() + " vs " + randomVillain.getName(), randomHero, randomVillain);
                    listOfAllIndividualBattles.add(randomIndividualBattle);
                    listOfAllBattles.add(randomIndividualBattle);
                    randomIndividualBattle.calculateBattle();
                    amountOfBattles++;
                    for (int i = 0; i < listOfAllFans.size(); i++) {
                        for (int j = 0; j < listOfAllFans.get(i).getFanOf().size(); j++) {
                            if (listOfAllFans.get(i).getFanOf().get(j).getId() == randomIndividualBattle.getWinner().getId()) {
                                fanCounter++;
                            }
                        }
                    }
                }
                System.out.println();
                System.out.println(listOfAllIndividualBattles.get(listOfAllIndividualBattles.size() - 1).getWinner().getName() + " has " + amountOfFans + " fans and it took " + amountOfBattles + " battles.");
                break;
            case 6:
                System.out.println("Who battles?");
                for (int i = 0; i < listOfAllHeroicTeams.size(); i++) {
                    System.out.print("(" + listOfAllHeroicTeams.get(i).getId() + ")  ");
                    System.out.println(listOfAllHeroicTeams.get(i).getName());
                }
                HeroicTeam chosenHeroicTeam = null;
                while (chosenHeroicTeam == null) {
                    System.out.print("Choose a Hero Id: ");
                    int chosenHeroicTeamId = scanner.nextInt();
                    for (int i = 0; i < listOfAllHeroicTeams.size(); i++) {
                        if (listOfAllHeroicTeams.get(i).getId() == chosenHeroicTeamId) {
                            chosenHeroicTeam = listOfAllHeroicTeams.get(i);
                        }
                    }
                }

                for (int i = 0; i < listOfAllVillainousTeams.size(); i++) {
                    System.out.print("(" + listOfAllVillainousTeams.get(i).getId() + ")  ");
                    System.out.println(listOfAllVillainousTeams.get(i).getName());
                }
                VillainousTeam chosenVillainousTeam = null;
                while (chosenVillainousTeam == null) {
                    System.out.print("Choose a Villain Id: ");
                    int chosenVillainousTeamId = scanner.nextInt();
                    for (int i = 0; i < listOfAllVillainousTeams.size(); i++) {
                        if (listOfAllVillainousTeams.get(i).getId() == chosenVillainousTeamId) {
                            chosenVillainousTeam = listOfAllVillainousTeams.get(i);
                        }
                    }
                }

                TeamBattle teamBattle = new TeamBattle(listOfAllBattles.size() + 1,chosenHeroicTeam.getName() + " vs " + chosenVillainousTeam.getName(), chosenHeroicTeam, chosenVillainousTeam);
                listOfAllTeamBattles.add(teamBattle);
                listOfAllBattles.add(teamBattle);
                System.out.print("""
                        ----------------------------
                        Who wins?
                        (0) Heroic Team wins
                        (1) Villainous Team wins
                        (2) Let the program calculate the winner!
                        Choose (0-2)\s""");
                menuChoice = scanner.nextInt();

                if (menuChoice == 0) {
                    teamBattle.setWinner(chosenHeroicTeam);
                    teamBattle.calculateWithWinner();
                } else if (menuChoice == 1) {
                    teamBattle.setWinner(chosenVillainousTeam);
                    teamBattle.calculateWithWinner();
                } else {
                    teamBattle.calculateBattle();
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 7:
                System.out.println("Fill in a search term: ");
                scanner.nextLine();
                String searchTerm = scanner.nextLine();
                searchTerm = searchTerm.toLowerCase();
                int numberOfResults = 0;
                System.out.println("You searched for: " + searchTerm);
                for (int i = 0; i < listOfAllIndividualBattles.size(); i++) {
                    if (listOfAllIndividualBattles.get(i).getWinner().getName().toLowerCase().contains(searchTerm)) {
                        String[] objectClass = listOfAllIndividualBattles.get(i).getClass().toString().split("[.]");
                        System.out.println("We found battle number: " + listOfAllIndividualBattles.get(i).getId() + "\tType: " + objectClass[objectClass.length - 1] + "\tWinner: " + listOfAllIndividualBattles.get(i).getWinner().getName());
                        numberOfResults++;
                    }
                }
                for (int i = 0; i < listOfAllTeamBattles.size(); i++) {
                    if (listOfAllTeamBattles.get(i).getWinner().getName().toLowerCase().contains(searchTerm)) {
                        String[] objectClass = listOfAllTeamBattles.get(i).getClass().toString().split("[.]");
                        System.out.println("We found battle number: " + listOfAllTeamBattles.get(i).getId() + "\tType: " + objectClass[objectClass.length - 1] + "\tWinner: " + listOfAllTeamBattles.get(i).getWinner().getName());
                        numberOfResults++;
                    }
                }
                if (numberOfResults == 0) {
                    System.out.println("We found nothing. :(");
                }
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                break;
            case 0:
                break;
            default:
                System.out.println("That number is not in the list of options.");
                System.out.print("Press enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
                break;
        }
    }


    public static void main(String[] args) {
        generateEntities();
        try {
            runMainMenu();
        } catch (InputMismatchException e) {
            System.out.print("The program only handles numbers. Exiting.");
        }
    }
}