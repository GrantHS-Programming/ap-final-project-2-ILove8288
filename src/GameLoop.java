import java.sql.SQLOutput;
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
        pc1.setDamage(pc1.getDamage() - 6);
        System.out.println("AHA! " + Colors.Cyan + pc1.getName() + Colors.Reset + ", that's it!");
        System.out.println("Now for your" + Colors.Yellow + " last name" + Colors.Reset + ", what could it be?");
        pc1.setLastName();
        System.out.println("Oh that's it, " + Colors.Cyan + pc1.getLastName() + Colors.Reset + "!");
        Thread.sleep(500);
        System.out.println("Your arm tingles and you look down, a strange" + Colors.Cyan + " set of markings" + Colors.Reset + " starts to appear on your lower forearm... As it comes into focus you can make out what it says...\n");
        Thread.sleep(500);
        pc1.printStats();
        Thread.sleep(500);

        System.out.println("As the world spins around you realize you have awoken in a " + Colors.Cyan + startPOS[rNum] + Colors.Reset + ".");
        Thread.sleep(500);
        if (startPOS[rNum].equalsIgnoreCase(startPOS[0])) {
            System.out.println("As you look around you see many drunken patrons talking, laughing, and drinking.\nA large man walks up to you, \"Why are you trying to" + Colors.Red + " leave" + Colors.Reset + " my fine establishment? is it not up to YOUR standards!?\"");
            Thread.sleep(500);
            Monster human1 = new Monster("human");
            Monster human2 = new Monster("human");
            System.out.println(Colors.White_Background + Colors.Black + "How did he know what I was thinking!?" + Colors.Reset + "\nYou hastily say \"Yes, I was just about to leave.\" You scan the room for a door, but you cant make one out, there is too much of commotion to be able to focus.");
            Thread.sleep(500);
            System.out.println("\"BOYS!!\" You hear the" + Colors.Red + " man" + Colors.Reset + " yell.\nAs you spin around you see 2" + Colors.Red + " people" + Colors.Reset + " running at you!\n");
            Thread.sleep(500);
            System.out.println("The first " + human1.getType() + " you see.\n");
            Thread.sleep(200);
            human1.printMonStats();
            Thread.sleep(500);
            System.out.println("The second " + human1.getType() + " you see.\n");
            Thread.sleep(200);
            human2.printMonStats();
            Thread.sleep(500);
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
            if (pc1.getHealth() < 1) {
                System.exit(0);
            }
            if (!fightTavern.isEnm() && pc1.getHealth() > 0) {
                System.out.println("You find the door and rush out. A " + Colors.Cyan + "road" + Colors.Reset + " comes into your sights. Day and night you walk, you walk until you collapse...");
                Thread.sleep(1000);
            }
        }
        if (startPOS[rNum].equalsIgnoreCase(startPOS[1])) {
            Monster bandit1 = new Monster("bandit");
            Monster bandit2 = new Monster("bandit");
            Monster dog1 = new Monster("dog", (int) (Math.random() * 3) + 1);
            System.out.println("As your eyes start to adjust to the light you can make out a" + Colors.Cyan + " road" + Colors.Reset + " in the distance.");
            Thread.sleep(500);
            System.out.println(Colors.White_Background + Colors.Black + "If only I can make it to the road! I'll be able to get out of this god forsaken forest." + Colors.Reset + "\nAs you start to make your way over to the" + Colors.Cyan + " road" + Colors.Reset + ", you can help but think you are being" + Colors.Red + " watched" + Colors.Reset + ".");
            Thread.sleep(500);
            System.out.println("As you are about to reach the" + Colors.Cyan + " road" + Colors.Reset + " you hear a large " + Colors.Red + "CRACK" + Colors.Reset + "! 2 " + Colors.Red + "bandits" + Colors.Reset + " drop from the tree and a" + Colors.Red + " dog" + Colors.Reset + " runs up snarling!\n");
            Thread.sleep(500);
            System.out.println("The first " + bandit1.getType() + " you see.\n");
            Thread.sleep(200);
            bandit1.printMonStats();
            Thread.sleep(500);
            System.out.println("The second " + bandit2.getType() + " you see.\n");
            Thread.sleep(200);
            bandit2.printMonStats();
            Thread.sleep(500);
            System.out.println("The snarling " + dog1.getType() + " you see.\n");
            Thread.sleep(200);
            dog1.printMonStats();
            Thread.sleep(500);
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
            if (pc1.getHealth() < 1) {
                System.exit(0);
            }
            if (!fightForrest.isEnm() && pc1.getHealth() > 0) {
                System.out.println("As you escape the " + Colors.Red + "scuffle" + Colors.Reset + " and make your way to the " + Colors.Cyan + "road" + Colors.Reset + " you decide to walk. Day and night, shuffling along...");
                Thread.sleep(1000);
            }
        }
        if (startPOS[rNum].equalsIgnoreCase(startPOS[2])) {
            System.out.println("When you fully come to your senses you see soot floating about. The ally way as a particular stench you cant quite make out. As you begin to stand a huge" + Colors.Red + " man" + Colors.Reset + " walks into the ally.");
            Thread.sleep(500);
            System.out.println("\"Hey there, you better empty your pockets if you know whats good for you.\" You hear the" + Colors.Red + " man" + Colors.Reset + " say in a strange and cheery tone.\nAs you try to get a better view on him, the" + Colors.Red + " man" + Colors.Reset + " starts running at you!\n");
            Thread.sleep(500);
            Monster thug1 = new Monster("thug", 20);
            Battle fightCity = new Battle(pc1, thug1);
            System.out.println("The Man lumbering towards you.\n");
            Thread.sleep(200);
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
                if (pc1.getHealth() < 1) {
                    System.exit(0);
                }
            }
            if (!fightCity.isEnm() && pc1.getHealth() > 0) {
                System.out.println(Colors.White_Background + Colors.Black + "I cant believe I made it out of that alive! At least I can see the road from here." + Colors.Reset);
                System.out.println("As you make your way down the " + Colors.Cyan + "road" + Colors.Reset + " you realise you might be walking for a while...");
                Thread.sleep(1000);
            }
        }
        if (startPOS[rNum].equalsIgnoreCase(startPOS[3])) {
            Monster grany1 = new Monster("Old lady", 90);
            grany1.damageHealth(40);
            if (grany1.getHealth() < 10) {
                grany1.setHealth(25 - (int) (Math.random() * 8));
            }
            System.out.println(Colors.White_Background + Colors.Black + "What is that squeaking noise?" + Colors.Reset);
            Thread.sleep(500);
            System.out.println("You slowly turn around to see an old lady in a rocking chair. You sneaks as silently as you can to the door but as you open it, you realize the " + Colors.Red + "old woman" + Colors.Reset + " is already up, and she looks angry.");
            Thread.sleep(500);
            System.out.println("\"YOU THINK YOU CAN JUST LEAVE? AFTER ALL IVE DONE FOR YOU?? I SAVED YOU FROM THAT " + Colors.Cyan + "ROAD" + Colors.Reset + " AND THIS IS HOW YOU TREAT ME?!\" As she continues to scream she starts approaching you.");
            Thread.sleep(500);
            System.out.println("You don't want to have to " + Colors.Red + "fight" + Colors.Reset + " this lady, but you know you have to.\n");
            Thread.sleep(500);
            System.out.println("The Old Lady you see.\n");
            Thread.sleep(200);
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
            if (pc1.getHealth() < 1) {
                System.exit(0);
            }
            if (!fightCabin.isEnm() && pc1.getHealth() > 0) {
                System.out.println("Confused and rattled by that crazy old lady you leave the house and find the " + Colors.Cyan + "road" + Colors.Reset + ". You walk, and walk...");
                Thread.sleep(1000);
            }
        }
            System.out.println("After a long walk, and a longer rest you find yourself in a forsaken land you have never seen the likes of in a long time. As you start your travels for the day the " + Colors.Cyan + "road" + Colors.Reset + " starts to wind its way through desolate landscapes, with gnarled trees and overgrown foliage casting long shadows upon its path. Few travelers dared to venture upon this treacherous route, for the " + Colors.Cyan + "road" + Colors.Reset + " was rumored to be haunted by" + Colors.Red + " malevolent spirits" + Colors.Reset + " and plagued by roaming\n" + Colors.Red + "bandits" + Colors.Reset + ". It was said that those who braved the journey often met a" + Colors.Red + " gruesome fate" + Colors.Reset + ", never to be seen again.");
        Thread.sleep(1000);
            System.out.println("However, there was one intrepid traveler who, driven by a burning curiosity, or a need for escape, set upon this path. This time the adventurer is you, " + Colors.Cyan + pc1.getName() + " " + pc1.getLastName() + Colors.Reset + ".");
            System.out.println("Clutching a" + Colors.Cyan + " map" + Colors.Reset + " gathered from your fallen " + Colors.Red + "foes" + Colors.Reset + ", you continue on your perilous expedition, prepared for whatever lay ahead. The first leg of your journey has been quiet, you have seen a few other travelers and a " + Colors.Cyan + "village" + Colors.Reset + " up ahead.\n");
        Thread.sleep(500);
        System.out.println(Colors.Black + Colors.White_Background + "I could stop at this town and gather some supplies, there may be enemies though..." + Colors.Reset + "\nIs it really " + Colors.Green + "true" + Colors.Reset + " you want to stop?");
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
                Thread.sleep(500);
                System.out.println("The first " + vil1.getType() + " approaching.\n");
                Thread.sleep(200);
                vil1.printMonStats();
                Thread.sleep(500);
                System.out.println("The second " + vil2.getType() + " advancing.\n");
                Thread.sleep(200);
                vil2.printMonStats();
                Thread.sleep(500);
                System.out.println("The third " + vil3.getType() + " advancing.\n");
                Thread.sleep(200);
                vil3.printMonStats();
                Thread.sleep(500);
                System.out.println("The fourth " + vil4.getType() + " coming towards you.\n");
                Thread.sleep(200);
                vil4.printMonStats();
                Thread.sleep(500);
                System.out.println("The fifth " + vil5.getType() + " preparing for a fight.\n");
                Thread.sleep(200);
                vil5.printMonStats();
                Thread.sleep(500);
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
                if (pc1.getHealth() < 1) {
                    System.exit(0);
                }
            } else if (check.equalsIgnoreCase("yes") || check.equalsIgnoreCase("true")) {
                Thread.sleep(200);
                System.out.println("As you approach the village, a crowd gathers. They don't seem " + Colors.Red + "hostile" + Colors.Reset + ", although they are acting strange they offer you food and water.");
                Thread.sleep(500);
                System.out.println("You drink and eat this gifts, as you eat this food you feel yourself gaining " + Colors.Blue + "energy" + Colors.Reset + ". The aches, pains, and dreariness from your travels reseed as your arm tingles, you look down to see your" + Colors.Cyan + " markings" + Colors.Reset + " shift.\n");
                Thread.sleep(500);
                pc1.setHealth(pc1.getHealth() + 10);
                pc1.printStats();
                System.out.println("Your " + Colors.Cyan + "health" + Colors.Reset + " increased by " + Colors.Cyan + "10" + Colors.Reset + ".");
                Thread.sleep(200);
            } else {
                System.out.println("You pass by the " + Colors.Cyan + "village" + Colors.Reset + " not wanting to risk the chance of battle.");
                Thread.sleep(500);
            }
        System.out.println("You continue down the " + Colors.Cyan + "road" + Colors.Reset + " with the wind whispering through the trees, creating a haunting melody that sent shivers down your spine. Your footsteps echo through the desolation, the sound of solitary presence breaking the silence. As you walked, you couldn't help but notice how the " + Colors.Cyan + "road" + Colors.Reset + " seemed to grow narrower and more " + Colors.Red + "treacherous" + Colors.Reset + " with each passing mile. It was as if the very land itself conspired against his your.");
        Thread.sleep(500);
        System.out.println("Days turned into nights, and nights into days, as you pushed forward, resolute in your quest for discovery. Along the way, you encountered remnants of long-forgotten villages, you see " + Colors.Red + "shadows" + Colors.Reset + " slinking around in the crumbling walls and dilapidated homes. As you get closer to this collapsed village someone springs out at you!");
        Thread.sleep(500);
        System.out.println("\"ⱧɆɎ... ₩ⱧɎ ĐØ₦'₮ ɎØɄ ₮ɆⱠⱠ ₥Ɇ ɎØɄⱤ " + Colors.Yellow + "₦₳₥Ɇ" + Colors.Reset + "... ł₮ ₩ØɄⱠĐ ₥₳₭Ɇ ₮Ⱨł₴ ₳ ⱠØ₮ ₴ł₥₱ⱠɆⱤ...\"");
        check = checker.next();
        if (check.equalsIgnoreCase(pc1.getName())) {
            System.out.println("\"₮Ⱨ₳₦₭₴ ₣ØⱤ ₮ɆⱠⱠł₦₲ ₥Ɇ... ₮ⱧɆ " + Colors.Red + "Ⱡ₳₴₮ Ø₦Ɇ" + Colors.Reset + " ₩₳₴₦'₮ ₳₴ ₴Ⱨ₳Ɽ₱ ₳₴ ɎØɄ...\" You could barely make out what this creature was saying. But the way it was talking was making you increasingly uncomfortable.");
            System.out.println("₩ⱧɎ ĐØ₦'₮ ɎØɄ Ⱨ₳₦Đ ØVɆⱤ ₴Ø₥Ɇ Ø₣ ɎØɄⱤ ₥Ø₦ɆɎ, ⱧɆⱠ₱ ₳ ØɄ₮ ₳ ₣-₣-₣₣ɆⱠⱠØ₩-₩... ₮Ɽ₳VɆⱠɆⱤ...\"");
            Thread.sleep(500);
            System.out.println("\"Im sorry I don't have any money to give you I have been surviving off of only what I can find.\"");
            Thread.sleep(500);
            randInt = (int) (Math.random() * 2 + 1);
            if (randInt == 1) {
                System.out.println("\"ł ₴Ʉ₱₱Ø₴Ɇ ₮Ⱨ₳₮'₴ ₣-₣-₣ł₦Ɇ... ł ₴ⱧØɄⱠĐ₦'₮ ɆӾ₱Ɇ₵₮ ₳ ⱧɄ₥฿Ⱡ-Ⱡ-ⱠɆ " + Colors.Cyan + "₮Ɽ₳VɆⱠɆⱤ" + Colors.Reset + " ₮Ø Ⱨ₳VɆ ₥Ʉ₵Ⱨ ₵-₵-₵Øł₦...\"");
                Thread.sleep(500);

            }
            if (randInt == 2) {
                System.out.println("\"ł ₲-₲Ɇ₮ ₩Ⱨ₳₮ ł ₩-₩-₩₳₦₮... ł₣ ɎØɄ ₴Ⱨ₳ⱠⱠ₦'₮ ₲łVɆ ₥Ɇ ₵Øł₦... ł ₴Ⱨ₳ⱠⱠ " + Colors.Red + "₮₳₭Ɇ₮Ⱨ" + Colors.Reset + ".\"");
                Thread.sleep(500);
                Monster roadShine = new Monster("shine-goblin");
                roadShine.setDamage(roadShine.getDamage() + 15);
                Battle fightCoin = new Battle(pc1, roadShine);
                pc1.addDefense(1);
                System.out.println("\nThe " + roadShine.getType() + " approaching you.\n");
                Thread.sleep(200);
                roadShine.printMonStats();
                Thread.sleep(500);
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
                if (pc1.getHealth() < 1) {
                    System.exit(0);
                }
            }
        }
        if (!check.equalsIgnoreCase(pc1.getName())) {
            System.out.println("\"ɎØɄ ₮Ⱨł₦₭ ɎØɄ ₵₳₦ JɄ₴₮ " + Colors.Red + "Ⱡ-Ⱡ-Ⱡ-ⱠłɆ" + Colors.Reset + " ₮-₮Ø ₥Ɇ? ₮ⱧɆ Ⱡ₳₴₮ " + Colors.Red + "₮Ɽ₳VɆⱠɆⱤ" + Colors.Red + " ₩ⱧØ ĐłĐ ₮Ⱨ₳₮ ₩₳₴₦'₮ ₳₴ ⱠɄ₵₭Ɏ...\"");
            Thread.sleep(500);
            System.out.println("As you continue to look at the creature you can't figure out what it is, then the creature " + Colors.Red + "lunges" + Colors.Reset + " at you!");
            Thread.sleep(500);
            Monster roadShine = new Monster("creature");
            roadShine.setDamage(roadShine.getDamage() + 15);
            Battle fightCoin = new Battle(pc1, roadShine);
            pc1.addDefense(1);
            Thread.sleep(500);
            System.out.println("\nThe " + roadShine.getType() + " feverishly approaching.\n");
            Thread.sleep(200);
            roadShine.printMonStats();
            Thread.sleep(500);
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
            if (pc1.getHealth() < 1) {
                System.exit(0);
            }
        }
        System.out.println(Colors.Black + Colors.White_Background + "What a strange encounter." + Colors.Reset + "\nYou think to yourself as you walk away into the night...");
        Thread.sleep(500);
        System.out.println("The air hung heavy with a sense of abandonment, as if the spirits of the past still clung to this forsaken place. As the forsaken " + Colors.Cyan + "road" + Colors.Reset + " grew ever more treacherous, you encountered " + Colors.Red + "dangerous" + Colors.Reset + " beasts and faced natural obstacles that threatened to halt your progress. Yet, you " + Colors.Cyan + "persevered" + Colors.Reset + ", your unwavering spirit undeterred. With each trial you faced, you grew more adept, learning to navigate the perils that await you.\nAs you settle down by a tree and feel that all too familiar tingle, you look down to see your " + Colors.Cyan + "markings" + Colors.Reset + " shift once again. You start feeling a bit more " + Colors.Cyan + "healthy" + Colors.Reset + " and feel your " + Colors.Cyan + "strength" + Colors.Reset + " revitalised.\n");
        Thread.sleep(500);
        pc1.setDamage(pc1.getDamage() + 4);
        pc1.setHealth(pc1.getHealth() + 10);
        pc1.printStats();
        System.out.println("Your " + Colors.Cyan + "health" + Colors.Reset + " increased by " + Colors.Cyan + "10" + Colors.Reset + ".");
        System.out.println("Your " + Colors.Cyan + "damage" + Colors.Reset + " increased by " + Colors.Cyan + "4" + Colors.Reset + ".");
        System.out.println("After your rest you resume your journey with a new vigor.");
        Thread.sleep(500);
        System.out.println("As you arrive deep into the heart of the forsaken " + Colors.Cyan + "road" + Colors.Reset + ", you stumble upon a forgotten " + Colors.Cyan + "temple" + Colors.Reset + ", its stone structure crumbling but still standing defiantly against the test of time. Intrigued, you cautiously ventured inside, his footsteps reverberating in the empty halls. The air was thick with a sense of ancient power, and as you delved deeper, you discovered a long-lost " + Colors.Cyan + "artifact" + Colors.Cyan + ", a mystical amulet believed to hold great " + Colors.Cyan + "secrets" + Colors.Reset + ".");
        Thread.sleep(500);
        System.out.println("As your reach out to grab it, you notice statues on the wall start to move, shift, come to life...");
        Thread.sleep(500);
        Monster statue1 = new Monster("Statue", 50);
        Monster statue2 = new Monster("Statue", 50);
        System.out.println("\nThe " + statue1.getType() + " to your left.\n");
        Thread.sleep(200);
        statue1.printMonStats();
        Thread.sleep(500);
        System.out.println("The " + statue1.getType() + " to your right.\n");
        Thread.sleep(200);
        statue2.printMonStats();
        Thread.sleep(500);
        Battle fightTemple = new Battle(pc1, statue1, statue2);
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
        if (pc1.getHealth() < 1) {
            System.exit(0);
        }
        System.out.println("As you watch the " + Colors.Red + "statues" + Colors.Reset + " crumble on the floor, you attention returns to the amulet...");
        Thread.sleep(500);
        System.out.println("You reach out and clasp the amulet,  feeling a surge of " + Colors.Cyan + "energy" + Colors.Reset + " coursing through his veins. The amulet whispered secrets of forgotten civilizations, guiding him with a newfound wisdom. Empowered by its magic, he continued his journey with renewed vigor and a clearer sense of purpose.");
        Thread.sleep(500);
        System.out.println("Do you decide to " + Colors.Green + "stow" + Colors.Reset + " or " + Colors.Green + "wear" + Colors.Reset + " the amulet?");
        check = checker.next();
        if (check.equalsIgnoreCase("stow")) {
            System.out.println("Resisting the urge to put on the amulet, you slide it into your pocket. ");
            Thread.sleep(500);
            System.out.println("Exiting the temple, something about the " + Colors.Cyan + "road" + Colors.Reset + " doesn't seem right. Something seems off.");
            Thread.sleep(500);
            System.out.println(Colors.White_Background + Colors.Black + "I feel like the road is brighter than it was before... The grass seems greener..." + Colors.Reset);
            Thread.sleep(500);
        }
        if (check.equalsIgnoreCase("wear")) {
            System.out.println("You put on the amulet and start to vigorously shake and contort, as your vision fades to black the last thing you see is the floor rushing towards you face...");
            Thread.sleep(500);
            System.out.println("You awaken to the sound of marching and clanging armor. As your eyes flutter open you feel something around your neck. You reach up to feel it and get hit in the back of the head. Scanning your surroundings you see a crowd of people, but they don't look quite right. You hear a foreign language shouted from behind you, with a deafening response from the crowd... You hear the man behind you walk to the other side of the platform... Feeling the platform drop from under you... All you can think is about how you are going to " + Colors.Red + "die" + Colors.Reset + ".");
            Thread.sleep(200);
            randInt = (int) (Math.random() * 4 + 1);
            if (randInt == 1) {
                pc1.damageHealth(1000000000);
                System.out.println();
                pc1.printStats();
                System.exit(0);
            } else {
                System.out.println("The amulet bursts with power and fires out beams, striking down many of the people in the crowd, the rope breaks and you fall to the ground. You rush over to a fallen solider and take up his weapon. Feeling that " + Colors.Cyan + "tingle" + Colors.Reset + " you look down at your markings and see damage and health increase. The door is in sight and as you make you way over to it... " + Colors.Red + "AMBUSH!" + Colors.Reset);
                Thread.sleep(500);
                pc1.addDefense(2);
                pc1.setHealth(pc1.getHealth() + (int) (Math.random() * 9 + 1));
                pc1.setDamage(pc1.getDamage() + (int) (Math.random() * 3 + 1));
                Monster fSolider1 = new Monster("forsaken solider");
                Monster fSolider2 = new Monster("forsaken solider");
                Monster fSolider3 = new Monster("forsaken solider");
                Thread.sleep(500);
                System.out.println("\nThe first " + fSolider1.getType() + " who rushed up on you!\n");
                Thread.sleep(200);
                fSolider1.printMonStats();
                Thread.sleep(500);
                System.out.println("The second " + fSolider1.getType() + " who rushed up on you!\n");
                Thread.sleep(200);
                fSolider2.printMonStats();
                Thread.sleep(500);
                System.out.println("The third " + fSolider1.getType() + " who rushed up on you!\n");
                Thread.sleep(200);
                fSolider3.printMonStats();
                Thread.sleep(500);
                Battle fightEscape = new Battle(pc1, fSolider1, fSolider2, fSolider3);
                while (true) {
                    if (pc1.getHealth() > 0 && fightEscape.isEnm()) {
                        fightEscape.pTurn();
                    }
                    if (pc1.getHealth() > 0 && fightEscape.isEnm()) {
                        fightEscape.eTurn();
                    } else {
                        break;
                    }
                }
                if (pc1.getHealth() < 1) {
                    System.exit(0);
                }
                System.out.println("You crash your way through the door and realise that you have made it to the entrance to the temple... It just doesn't seem the same as the first time you came here. ");
                Thread.sleep(500);
            }
        }
        System.out.println("As you travel down the " + Colors.Cyan + "road" + Colors.Reset + " your encounters took on a different tone. Instead of " + Colors.Red + "enemies" + Colors.Reset + " and " + Colors.Red + "threats" + Colors.Reset + ", you crossed paths with individuals in need, seeking solace and guidance. you became a beacon of hope in this desolate realm, extending a helping hand to those who had lost their way. His knowledge and wisdom, bolstered by the amulet's magic, became a source of comfort and inspiration for the lost souls you encountered.");
        Thread.sleep(500);
        System.out.println("The first of these encounters was with a young man. Perhaps 19 years of age on this " + Colors.Cyan + "road" + Colors.Reset + " all alone. The traveler's clothes were tattered, and their eyes held a glimmer of desperation mixed with a hint of hope.");
        Thread.sleep(500);
        System.out.println("You greet the traveler asking what brings him onto this " + Colors.Cyan + "road" + Colors.Reset + ".");
        Thread.sleep(500);
        System.out.println("The traveler greets you in return stating that \"I've been lost for days, searching for a path that leads to something more than desolation and darkness. This forsaken road seemed my only option. There is no possibilities left for me... I have been searching for my whole life with this " + Colors.Cyan + "road" + Colors.Reset + " being my final option. Please will you " + Colors.Red + "end" + Colors.Reset + " my journey here. Please...\"");
        Thread.sleep(500);
        System.out.println("Do you decide to " + Colors.Yellow + "kill" + Colors.Reset + " him and take up his offer, or " + Colors.Yellow + "persuade" + Colors.Reset + " him to keep living?");
        check = checker.next();
        if (check.equalsIgnoreCase("persuade")) {
            System.out.println("\"I understand the feeling all too well. This " + Colors.Cyan + "road" + Colors.Reset + ", once cloaked in shadows and despair, has undergone a transformation. It now carries a glimmer of hope, fueled by tales of redemption and discovery.\" You say.");
            Thread.sleep(500);
            System.out.println("The traveler perks up, a glimmer in his eyes... \"Redemption and discovery? I never thought such possibilities existed along this treacherous path. Tell me, traveler, what experiences have you had that bring such hope?\"");
            Thread.sleep(500);
            System.out.println("You settle down next to him and say \"Ah, my friend, the " + Colors.Cyan + "road" + Colors.Reset + " has been filled with both " + Colors.Red + "peril" + Colors.Reset + " and " + Colors.Cyan + "wonder" + Colors.Reset + ". I've encountered ancient ruins and mystical artifacts, each holding secrets and untold stories. Along the way, I've faced " + Colors.Red + "adversaries" + Colors.Reset + " and " + Colors.Red + "challenges" + Colors.Reset + " that tested my strength, but with each victory, the " + Colors.Cyan + "road" + Colors.Reset + " seemed to shift, as if responding to my determination.\"");
            Thread.sleep(500);
            System.out.println("\"My point is that there is more on the desolate " + Colors.Cyan + "road" + Colors.Reset + " than may seem... Keep searching and you will find your way...\"");
            Thread.sleep(500);
            randInt = (int) (Math.random() * 3);
            if (randInt != 1) {
                System.out.println("\"Thank you, thank you, thank you... You have given me hope to keep on my way. I shall perceive this journey under a new light!\"");
                Thread.sleep(500);
            }
            if (randInt == 1) {
                System.out.println("\"I see your way... I have thought and tried for too many years. As just a 19 year old I should not be suffering so... Please if you will not give me "+Colors.Red+"death"+Colors.Reset+" I shall giveth to myself...\"");
                Thread.sleep(500);
                System.out.println("You walk away with an awful feeling, his screams haunting every thought... ");
                Thread.sleep(500);
                System.out.println(Colors.White_Background+Colors.Black+"How will I be able to live... I couldn't... I should have helped, been better...");
                Thread.sleep(500);
            }
        }
        else {
            System.out.println("As the traveler has decided his fate, you raise your sword pause for a second, see this traveler lost in his own despair, and bring down your sword in a sweeping arc...");
            Thread.sleep(500);
            System.out.println("The traveler "+Colors.Red+"died"+Colors.Reset+" a silent "+Colors.Red+"death"+Colors.Reset);
            Thread.sleep(500);
        }
        System.out.println("\nAfter a while more of traveling the road you arrive at a inn.");
        Thread.sleep(500);
        if(rNum == 0){
            System.out.println("After walking in you realise that this is te fateful tavern you woke in... It looks like there has been a shift in ownership since your departure, as you see no familiar faces. This is for the best.");
            Thread.sleep(500);
            System.out.println("You settle down into a chair and order some food... You wake up the next morning.");
            Thread.sleep(500);
            System.out.println("\"Why are you trying to" + Colors.Red +" leave" + Colors.Reset + " my fine establishment? is it not up to YOUR standards!? ");
            Thread.sleep(500);
            System.out.println("NAW im just joking with you!\" Freaked out you look up to see who said this to you... Feeling awfully familiar ");
            Thread.sleep(500);
            System.out.println("\"YA know I heard that the old owner said that to someone and then they "+Colors.Reset+"killed"+Colors.Reset+" him?!??! CAN YOU BELIEVE THAT! You were passed out cold last night... You should get going.\"");
            Thread.sleep(500);
        }
        else{
            System.out.println("After walking in you realise that this is te fateful tavern you woke in... It looks like there has been a shift in ownership since your departure, as you see no familiar faces. This is for the best.");
            Thread.sleep(500);
            System.out.println("You settle down into a chair and order some food... You wake up the next morning.");
            Thread.sleep(500);
            System.out.println("You make your way out of the tavern feeling "+Colors.Cyan+"rejuvenated"+Colors.Reset+".");
            Thread.sleep(500);
            pc1.setHealth(pc1.getHealth()+5);
        }
        System.out.println("As you get outside of the tavern you see a mugging! You rush over to interfere...");
        Thread.sleep(500);
        Monster bandit3 = new Monster("bandit");
        System.out.println("\nThe " + bandit3.getType() + " mugging a civilian!\n");
        Thread.sleep(200);
        bandit3.printMonStats();
        Thread.sleep(500);
        Battle fightMugging = new Battle(pc1,bandit3);
        while (true) {
            if (pc1.getHealth() > 0 && fightMugging.isEnm()) {
                fightMugging.pTurn();
            }
            if (pc1.getHealth() > 0 && fightMugging.isEnm()) {
                fightMugging.eTurn();
            } else {
                break;
            }
        }
        if (pc1.getHealth() < 1) {
            System.exit(0);
        }
        System.out.println("After giving the stolen goods back to the civilian you get beckoned over by someone in a official uniform...");
        Thread.sleep(500);
        System.out.println("\"OI! I saw what you did over there. That was mighty impressive bruv... You wan' a job as a top level enforcer? You could set'le down 'ere for a while... No need to always travel right? "+Colors.Yellow+"Yes"+Colors.Reset+" or "+Colors.Yellow+"no"+Colors.Reset+".");
        check = checker.next();
        if (check.equalsIgnoreCase("yes")||check.equalsIgnoreCase("sure")|check.equalsIgnoreCase("true")){
            System.out.println("You settle down in a city going my the name of Eldoria. The Captain was correct, you don't always need to be traveling... Sometimes its better to settle down in one place and rest, get to know people, and raise a family. You live in Eldoria until you "+Colors.Red+"die"+Colors.Reset+" of old age...");
            Thread.sleep(200);
            System.out.println(Colors.Green+"THE END"+Colors.Reset);
            pass = checker.nextBoolean();
            if (pass){
                System.exit(0);
            }
            else{
                System.out.println("Years of living in Eldoria has been eventful, but with enforcers patrolling it has been relatively peaceful... With crime at an all time low, the enforcers were on a skeleton crew... This was also the night planned by the "+Colors.Red+"\'brigade\'"+Colors.Reset+", the organized crime group that was thought to have left the city...");
                Thread.sleep(500);
                System.out.println("In the middle of the night you hear the "+Colors.Red+"raid"+Colors.Reset+" sirens... "+Colors.Red+"Screams"+Colors.Reset+"... and the crackle of one thousand "+Colors.Red+"fires"+Colors.Reset+"...");
                System.out.println("By the time you make it out of your house... "+Colors.Red+"Death..."+Colors.Reset+" ");
            }
        }
        else {
            System.out.println("You tell the man that you cannot take up his offer even though it sounds intriguing, you have business and adventure yet to be attended...");
            Thread.sleep(500);
            System.out.println("As you travel out of the town, returning to the "+Colors.Cyan+"road"+Colors.Reset+" you can't help but smile...");
            Thread.sleep(500);
        }

    }
}
