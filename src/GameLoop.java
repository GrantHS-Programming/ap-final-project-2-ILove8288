import java.util.Scanner;

public class GameLoop {
    private static Scanner checker = new Scanner(System.in);
    private static String[] startPOS = {"tavern", "forest", "back ally", "cabin"};
    static int rNum = (int) (Math.random() * 4);

    public static void tutorial() {
        System.out.println("If a word is written in" + Colors.Green + " green text" + Colors.Reset + " you answer with the same word or the opposite. For example," + Colors.Green + " true" + Colors.Reset + " or" + Colors.Green + " false" + Colors.Reset + "...");
        System.out.println("If a word is written in" + Colors.Yellow + " gold text" + Colors.Reset + " you should enter your answer. For example," + Colors.Yellow + " name" + Colors.Reset + "...");
        System.out.println("If a word is written in" + Colors.Cyan + " cyan text" + Colors.Reset + " it represents " + Colors.Cyan + "important information" + Colors.Reset + "...");
        System.out.println("If a word is written in" + Colors.Red + " red text" + Colors.Reset + " it represents " + Colors.Red + "combat" + Colors.Reset + "...");
        System.out.println("If a word is written in" + Colors.Blue + " blue text" + Colors.Reset + " it represents " + Colors.Blue + "defense" + Colors.Reset + "...");
        System.out.println("If a sentence is written with a " + Colors.White_Background + Colors.Black + "white background and black text" + Colors.Reset + " it represents " + Colors.White_Background + Colors.Black + "inner thoughts" + Colors.Reset + "...");
        System.out.println("");
    }

    public static boolean pass = false;

    public static void main(String[] args) throws InterruptedException {
        String check = "";
        int randInt;
        System.out.println("Is it true that you want to see a tutorial?");
        check = checker.next();
        if (check.equalsIgnoreCase("yes") || check.equalsIgnoreCase("true")) {
            tutorial();
        }
        System.out.println("As you drowsily awaken you try to understand what is happening, the first step is to remember your" + Colors.Yellow + " name" + Colors.Reset + "... ");
        PlayerCharacter pc1 = new PlayerCharacter();
        pc1.setDamage(pc1.getDamage()-10);
        System.out.println("AHA! " + Colors.Cyan + pc1.getName() + Colors.Reset + ", that's it!");
        System.out.println("Now for your" + Colors.Yellow + " last name" + Colors.Reset + ", what could it be?");
        pc1.setLastName();
        System.out.println("Oh that's it, " + Colors.Cyan + pc1.getLastName() + Colors.Reset + "!");
        System.out.println("Your arm tingles and you look down, a strange" + Colors.Cyan + " set of markings" + Colors.Reset + " starts to appear on your lower forearm... As it comes into focus you can make out what it says...\n");
        pc1.printStats();
        System.out.println("As the world spins around you realize you have awoken in a " + Colors.Cyan + startPOS[rNum] + Colors.Reset + ".");


        if (startPOS[rNum].equalsIgnoreCase(startPOS[0])) {
            System.out.println("As you look around you see many drunken patrons talking, laughing, and drinking.\nA large man walks up to you, \"Why are you trying to" + Colors.Red + " leave" + Colors.Reset + " my fine establishment? is it not up to YOUR standards!?\"");
            Monster human1 = new Monster("human");
            Monster human2 = new Monster("human");
            System.out.println(Colors.White_Background + Colors.Black + "How did he know what I was thinking!?" + Colors.Reset + "\nYou hastily say \"Yes, I was just about to leave.\" You scan the room for a door, but you cant make one out, there is too much of commotion to be able to focus.");
            System.out.println("\"BOYS!!\" You hear the" + Colors.Red + " man" + Colors.Reset + " yell.\nAs you spin around you see 2" + Colors.Red + " people" + Colors.Reset + " running at you!\n");
            System.out.println("The first " + human1.getType() + " you see.\n");
            human1.printMonStats();
            System.out.println("The second " + human1.getType() + " you see.\n");
            human2.printMonStats();
            pc1.addDefense();
            Battle fightTavern = new Battle(pc1, human1, human2);
            while (true) {
                if (pc1.getHealth() > 0 && fightTavern.isEnm()) {
                    fightTavern.pTurn();
                }
                if (pc1.getHealth() > 0 && fightTavern.isEnm()) {
                    fightTavern.eTurn();
                } else {
                    break;
                }
            }
            if (pc1.getHealth()<1){
                System.exit(0);
            }
            if (!fightTavern.isEnm() && pc1.getHealth() > 0) {
                System.out.println("You find the door and rush out. A " + Colors.Cyan + "road" + Colors.Reset + " comes into your sights. Day and night you walk, you walk until you collapse...");
                pass = true;
            }
        }
        if (startPOS[rNum].equalsIgnoreCase(startPOS[1])) {
            Monster bandit1 = new Monster("bandit");
            Monster bandit2 = new Monster("bandit");
            Monster dog1 = new Monster("dog", (int) (Math.random() * 3) + 1);
            System.out.println("As your eyes start to adjust to the light you can make out a" + Colors.Cyan + " road" + Colors.Reset + " in the distance.");
            System.out.println(Colors.White_Background + Colors.Black + "If only I can make it to the road! I'll be able to get out of this god forsaken forest." + Colors.Reset + "\nAs you start to make your way over to the" + Colors.Cyan + " road" + Colors.Reset + ", you can help but think you are being" + Colors.Red + " watched" + Colors.Reset + ".");
            System.out.println("As you are about to reach the" + Colors.Cyan + " road" + Colors.Reset + " you hear a large " + Colors.Red + "CRACK" + Colors.Reset + "! 2 " + Colors.Red + "bandits" + Colors.Reset + " drop from the tree and a" + Colors.Red + " dog" + Colors.Reset + " runs up snarling!\n");
            System.out.println("The first " + bandit1.getType() + " you see.\n");
            bandit1.printMonStats();
            System.out.println("The second " + bandit2.getType() + " you see.\n");
            bandit2.printMonStats();
            System.out.println("The snarling " + dog1.getType() + " you see.\n");
            dog1.printMonStats();
            pc1.addDefense();
            Battle fightForrest = new Battle(pc1, bandit1, bandit2, dog1);
            while (true) {
                if (pc1.getHealth() > 0 && fightForrest.isEnm()) {
                    fightForrest.pTurn();
                }
                if (pc1.getHealth() > 0 && fightForrest.isEnm()) {
                    fightForrest.eTurn();
                } else {
                    break;
                }
            }
            if (pc1.getHealth()<1){
                System.exit(0);
            }
            if (!fightForrest.isEnm() && pc1.getHealth() > 0) {
                System.out.println("As you escape the " + Colors.Red + "scuffle" + Colors.Reset + " and make your way to the " + Colors.Cyan + "road" + Colors.Reset + " you decide to walk. Day and night, shuffling along...");
                pass = true;
            }
        }
        if (startPOS[rNum].equalsIgnoreCase(startPOS[2])) {
            System.out.println("When you fully come to your senses you see soot floating about. The ally way as a particular stench you cant quite make out. As you begin to stand a huge" + Colors.Red + " man" + Colors.Reset + " walks into the ally.");
            System.out.println("\"Hey there, you better empty your pockets if you know whats good for you.\" You hear the" + Colors.Red + " man" + Colors.Reset + " say in a strange and cheery tone.\nAs you try to get a better view on him, the" + Colors.Red + " man" + Colors.Reset + " starts running at you!\n");
            Monster thug1 = new Monster("thug", 20);
            Battle fightCity = new Battle(pc1, thug1);
            System.out.println("The Man lumbering towards you.\n");
            thug1.printMonStats();
            while (true) {
                if (pc1.getHealth() > 0 && fightCity.isEnm()) {
                    fightCity.pTurn();
                }
                if (pc1.getHealth() > 0 && fightCity.isEnm()) {
                    fightCity.eTurn();
                } else {
                    break;
                }
                if (pc1.getHealth()<1){
                    System.exit(0);
                }
            }
            if (!fightCity.isEnm() && pc1.getHealth() > 0) {
                System.out.println(Colors.White_Background + Colors.Black + "I cant believe I made it out of that alive! At least I can see the road from here.");
                System.out.println("As you make your way down the " + Colors.Cyan + "road" + Colors.Reset + " you realise you might be walking for a while...");
                pass = true;
            }
        }
        if (startPOS[rNum].equalsIgnoreCase(startPOS[3])) {
            Monster grany1 = new Monster("Old lady", 90);
            grany1.damageHealth(40);
            if (grany1.getHealth() < 10) {
                grany1.setHealth(25 - (int) (Math.random() * 8));
            }
            System.out.println(Colors.White_Background + Colors.Black + "What is that squeaking noise?" + Colors.Reset);
            System.out.println("You slowly turn around to see an old lady in a rocking chair. You sneaks as silently as you can to the door but as you open it, you realize the " + Colors.Red + "old woman" + Colors.Reset + " is already up, and she looks angry.");
            System.out.println("\"YOU THINK YOU CAN JUST LEAVE? AFTER ALL IVE DONE FOR YOU?? I SAVED YOU FROM THAT " + Colors.Cyan + "ROAD" + Colors.Reset + " AND THIS IS HOW YOU TREAT ME?!\" As she continues to scream she starts approaching you.");
            System.out.println("You don't want to have to " + Colors.Red + "fight" + Colors.Reset + " this lady, but you know you have to.\n");
            System.out.println("The Old Lady you see.\n");
            Battle fightCabin = new Battle(pc1, grany1);
            grany1.printMonStats();
            while (true) {
                if (pc1.getHealth() > 0 && fightCabin.isEnm()) {
                    fightCabin.pTurn();
                }
                if (pc1.getHealth() > 0 && fightCabin.isEnm()) {
                    fightCabin.eTurn();
                } else {
                    break;
                }
            }
            if (pc1.getHealth()<1){
                System.exit(0);
            }
            if (!fightCabin.isEnm() && pc1.getHealth() > 0) {
                System.out.println("Confused and rattled by that crazy old lady you leave the house and find the " + Colors.Cyan + "road" + Colors.Reset + ". You walk, and walk...");
                pass = true;
            }
        }
        if (pass) {
            System.out.println("After a long walk, and a longer rest you find yourself in a forsaken land you have never seen the likes of in a long time. As you start your travels for the day the road starts to wind its way through desolate landscapes, with gnarled trees and overgrown foliage casting long shadows upon its path. Few travelers dared to venture upon this treacherous route, for the " + Colors.Cyan + "road" + Colors.Reset + " was rumored to be haunted by" + Colors.Red + " malevolent spirits" + Colors.Reset + " and plagued by roaming\n" + Colors.Red + "bandits" + Colors.Reset + ". It was said that those who braved the journey often met a" + Colors.Red + " gruesome fate" + Colors.Reset + ", never to be seen again.");
            System.out.println("However, there was one intrepid traveler who, driven by a burning curiosity, or a need for escape, set upon this path. This time the adventurer is you, " + Colors.Cyan + pc1.getName() + " " + pc1.getLastName() + Colors.Reset + ".");
            System.out.println("Clutching a" + Colors.Cyan + " map" + Colors.Reset + " gathered from your fallen " + Colors.Red + "foes" + Colors.Reset + ", you continue on your perilous expedition, prepared for whatever lay ahead. The first leg of your journey has been quiet, you have seen a few other travelers and a " + Colors.Cyan + "village" + Colors.Reset + " up ahead.\n" + Colors.Black + Colors.White_Background + "I could stop at this town and gather some supplies, there may be enemies though..." + Colors.Reset + "\nIs it really " + Colors.Green + "true" + Colors.Reset + " you want to stop?");
            check = checker.next();
            randInt = (int) (Math.random() * 10);
            if (randInt > 8 && check.equalsIgnoreCase("true")) {
                Monster vil1 = new Monster("villager");
                Monster vil2 = new Monster("villager");
                Monster vil3 = new Monster("villager");
                Monster vil4 = new Monster("villager");
                Monster vil5 = new Monster("villager");
                Battle fightVillage = new Battle(pc1, vil1, vil2, vil3, vil4, vil5);
                System.out.println("As you approach the village, a crowd gathers. By the time you get close enough to have a better view on the crowd, 5 of the " + Colors.Red + "villagers" + Colors.Reset + " rush at you.\n");
                System.out.println("The first " + vil1.getType() + " approaching.\n");
                vil1.printMonStats();
                System.out.println("The second " + vil2.getType() + " advancing.\n");
                vil2.printMonStats();
                System.out.println("The third " + vil3.getType() + " advancing.\n");
                vil3.printMonStats();
                System.out.println("The fourth " + vil4.getType() + " coming towards you.\n");
                vil4.printMonStats();
                System.out.println("The fifth " + vil5.getType() + " preparing for a fight.\n");
                vil5.printMonStats();
                pc1.addDefense();
                while (true) {
                    if (pc1.getHealth() > 0 && fightVillage.isEnm()) {
                        fightVillage.pTurn();
                    }
                    if (pc1.getHealth() > 0 && fightVillage.isEnm()) {
                        fightVillage.eTurn();
                    } else {
                        break;
                    }
                }
                if (pc1.getHealth()<1){
                    System.exit(0);
                }
            } else if (check.equalsIgnoreCase("yes") || check.equalsIgnoreCase("true")) {
                System.out.println("As you approach the village, a crowd gathers. They don't seem " + Colors.Red + "hostile" + Colors.Reset + ", although they are acting strange they offer you food and water.");
                System.out.println("You drink and eat this gifts, as you eat this food you feel yourself gaining " + Colors.Blue + "energy" + Colors.Reset + ". The aches, pains, and dreariness from your travels reseed as your arm tingles, you look down to see your" + Colors.Cyan + " markings" + Colors.Reset + " shift.\n");
                pc1.setHealth(pc1.getHealth() + 5);
                pc1.printStats();
                System.out.println("Your " + Colors.Cyan + "health" + Colors.Reset + " increased by " + Colors.Cyan + "5" + Colors.Reset + ".");
            } else {
                System.out.println("You pass by the " + Colors.Cyan + "village" + Colors.Reset + " not wanting to risk the chance of battle.");
            }
        }
        System.out.println("You continue down the " + Colors.Cyan + "road" + Colors.Reset + " with the wind whispering through the trees, creating a haunting melody that sent shivers down your spine. Your footsteps echo through the desolation, the sound of solitary presence breaking the silence. As you walked, you couldn't help but notice how the " + Colors.Cyan + "road" + Colors.Reset + " seemed to grow narrower and more " + Colors.Red + "treacherous" + Colors.Reset + " with each passing mile. It was as if the very land itself conspired against his your.");
        System.out.println("Days turned into nights, and nights into days, as you pushed forward, resolute in your quest for discovery. Along the way, you encountered remnants of long-forgotten villages, you see " + Colors.Red + "shadows" + Colors.Reset + " slinking around in the crumbling walls and dilapidated homes. As you get closer to this collapsed village someone springs out at you!");
        System.out.println("\"ⱧɆɎ... ₩ⱧɎ ĐØ₦'₮ ɎØɄ ₮ɆⱠⱠ ₥Ɇ ɎØɄⱤ " + Colors.Yellow + "₦₳₥Ɇ" + Colors.Reset + "... ł₮ ₩ØɄⱠĐ ₥₳₭Ɇ ₮Ⱨł₴ ₳ ⱠØ₮ ₴ł₥₱ⱠɆⱤ...\"");
        check = checker.next();
        if (check.equalsIgnoreCase(pc1.getName())) {
            System.out.println("\"₮Ⱨ₳₦₭₴ ₣ØⱤ ₮ɆⱠⱠł₦₲ ₥Ɇ... ₮ⱧɆ " + Colors.Red + "Ⱡ₳₴₮ Ø₦Ɇ" + Colors.Reset + " ₩₳₴₦'₮ ₳₴ ₴Ⱨ₳Ɽ₱ ₳₴ ɎØɄ...\" You could barely make out what this creature was saying. But the way it was talking was making you increasingly uncomfortable.\n\"₩ⱧɎ ĐØ₦'₮ ɎØɄ Ⱨ₳₦Đ ØVɆⱤ ₴Ø₥Ɇ Ø₣ ɎØɄⱤ ₥Ø₦ɆɎ, ⱧɆⱠ₱ ₳ ØɄ₮ ₳ ₣-₣-₣₣ɆⱠⱠØ₩-₩... ₮Ɽ₳VɆⱠɆⱤ...\"");
            System.out.println("\"Im sorry I don't have any money to give you I have been surviving off of only what I can find.\"");
            randInt = (int) (Math.random() * 2 + 1);
            if (randInt == 1) {
                System.out.println("\"ł ₴Ʉ₱₱Ø₴Ɇ ₮Ⱨ₳₮'₴ ₣-₣-₣ł₦Ɇ... ł ₴ⱧØɄⱠĐ₦'₮ ɆӾ₱Ɇ₵₮ ₳ ⱧɄ₥฿Ⱡ-Ⱡ-ⱠɆ " + Colors.Cyan + "₮Ɽ₳VɆⱠɆⱤ" + Colors.Reset + " ₮Ø Ⱨ₳VɆ ₥Ʉ₵Ⱨ ₵-₵-₵Øł₦...\"");

            }
            if (randInt == 2) {
                System.out.println("\"ł ₲-₲Ɇ₮ ₩Ⱨ₳₮ ł ₩-₩-₩₳₦₮... ł₣ ɎØɄ ₴Ⱨ₳ⱠⱠ₦'₮ ₲łVɆ ₥Ɇ ₵Øł₦... ł ₴Ⱨ₳ⱠⱠ " + Colors.Red + "₮₳₭Ɇ₮Ⱨ" + Colors.Reset + ".\"");
                Monster roadShine = new Monster("shine-goblin");
                roadShine.setDamage(roadShine.getDamage() + 15);
                Battle fightCoin = new Battle(pc1, roadShine);
                pc1.addDefense(1);
                System.out.println("The " + roadShine.getType() + " approaching you.\n");
                roadShine.printMonStats();
                while (true) {
                    if (pc1.getHealth() > 0 && fightCoin.isEnm()) {
                        fightCoin.pTurn();
                    }
                    if (pc1.getHealth() > 0 && fightCoin.isEnm()) {
                        fightCoin.eTurn();
                    } else {
                        break;
                    }
                }
                if (pc1.getHealth()<1){
                    System.exit(0);
                }
            }
        }
        if (!check.equalsIgnoreCase(pc1.getName())) {
            System.out.println("\"ɎØɄ ₮Ⱨł₦₭ ɎØɄ ₵₳₦ JɄ₴₮ " + Colors.Red + "Ⱡ-Ⱡ-Ⱡ-ⱠłɆ" + Colors.Reset + " ₮-₮Ø ₥Ɇ? ₮ⱧɆ Ⱡ₳₴₮ " + Colors.Red + "₮Ɽ₳VɆⱠɆⱤ" + Colors.Red + " ₩ⱧØ ĐłĐ ₮Ⱨ₳₮ ₩₳₴₦'₮ ₳₴ ⱠɄ₵₭Ɏ...\"");
            System.out.println("As you continue to look at the creature you can't figure out what it is, then the creature " + Colors.Red + "lunges" + Colors.Reset + " at you!");
            Monster roadShine = new Monster("creature");
            roadShine.setDamage(roadShine.getDamage() + 15);
            Battle fightCoin = new Battle(pc1, roadShine);
            pc1.addDefense(1);
            System.out.println("The " + roadShine.getType() + " feverishly approaching.\n");
            roadShine.printMonStats();
            while (true) {
                if (pc1.getHealth() > 0 && fightCoin.isEnm()) {
                    fightCoin.pTurn();
                }
                if (pc1.getHealth() > 0 && fightCoin.isEnm()) {
                    fightCoin.eTurn();
                } else {
                    break;
                }
            }
            if (pc1.getHealth()<1){
                System.exit(0);
            }
        }
        System.out.println(Colors.Black+Colors.White_Background+"What a strange encounter."+Colors.Reset+"\nYou think to yourself as you walk away into the night...");
        System.out.println("The air hung heavy with a sense of abandonment, as if the spirits of the past still clung to this forsaken place. As the forsaken road grew ever more treacherous, you encountered "+Colors.Red+"dangerous"+Colors.Reset+" beasts and faced natural obstacles that threatened to halt your progress. Yet, you "+Colors.Cyan+"persevered"+Colors.Cyan+", your unwavering spirit undeterred. With each trial you faced, you grew more adept, learning to navigate the perils that await you.\nAs you settle down by a tree and feel that all too familiar tingle, you look down to see your "+Colors.Cyan+"markings"+Colors.Reset+" shift once again. You start feeling a bit more "+Colors.Cyan+"healthy"+Colors.Reset+" and feel your "+Colors.Cyan+"strength"+Colors.Reset+" revitalised.\n\n");
        pc1.setDamage(pc1.getDamage()+4);
        pc1.setHealth(pc1.getHealth()+10);
        pc1.printStats();
        System.out.println("Your " + Colors.Cyan + "health" + Colors.Reset + " increased by " + Colors.Cyan + "10" + Colors.Reset + ".");
        System.out.println("Your " + Colors.Cyan + "damage" + Colors.Reset + " increased by " + Colors.Cyan + "4" + Colors.Reset + ".");
        System.out.println("After your rest you resume your journey with a new vigor.");
        System.out.println("As you arrive deep into the heart of the forsaken road, you stumble upon a forgotten "+Colors.Cyan+"temple"+Colors.Reset+", its stone structure crumbling but still standing defiantly against the test of time. Intrigued, you cautiously ventured inside, his footsteps reverberating in the empty halls. The air was thick with a sense of ancient power, and as you delved deeper, you discovered a long-lost "+Colors.Cyan+"artifact"+Colors.Cyan+", a mystical amulet believed to hold great "+Colors.Cyan+"secrets"+Colors.Reset+".");
        System.out.println("As your reach out to grab it, you notice statues on the wall start to move, shift, come to life...");
        Monster statue1 = new Monster("Statue",20);
        Monster statue2 = new Monster("Statue",20);
        System.out.println("The "+statue1.getType()+" to your left.\n");
        statue1.printMonStats();
        System.out.println("The "+statue1.getType()+" to your right.\n");
        statue2.printMonStats();
        Battle fightTemple = new Battle(pc1,statue1,statue2);
        while (true) {
            if (pc1.getHealth() > 0 && fightTemple.isEnm()) {
                fightTemple.pTurn();
            }
            if (pc1.getHealth() > 0 && fightTemple.isEnm()) {
                fightTemple.eTurn();
            } else {
                break;
            }
        }
        if (pc1.getHealth()<1){
            System.exit(0);
        }
        System.out.println("As you watch the "+Colors.Red+"statues"+Colors.Reset+" crumble on the floor, you attention returns to the amulet...");

    }
}
