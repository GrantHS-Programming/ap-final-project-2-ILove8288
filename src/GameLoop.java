import java.util.Scanner;

public class GameLoop{
    private static Scanner checker = new Scanner(System.in);
    private static String[] startPOS = {"tavern","forest","back ally","back ally","back ally"};
    //private static String[] startPOS = {"tavern","forest","back ally","cabin","musty dungeon"};
    static int rNum = (int)(Math.random()*5);
    public static void tutorial(){
        System.out.println("If a word is written in"+Colors.Green+ " green text"+Colors.Reset+" you answer with the same word or the opposite. For example,"+Colors.Green+" true"+Colors.Reset+" or"+Colors.Green+" false"+Colors.Reset+"...");
        System.out.println("If a word is written in"+Colors.Yellow+ " gold text"+Colors.Reset+" you should enter your answer. For example,"+ Colors.Yellow+" name"+ Colors.Reset+"...");
        System.out.println("If a word is written in"+ Colors.Cyan+ " cyan text"+ Colors.Reset+" it represents "+ Colors.Cyan+"important information"+ Colors.Reset+"...");
        System.out.println("If a word is written in"+ Colors.Red+ " red text"+ Colors.Reset+" it represents "+ Colors.Red+"combat"+ Colors.Reset+"...");
        System.out.println("If a word is written in"+ Colors.Blue+ " blue text"+ Colors.Reset+" it represents "+ Colors.Blue+"defense"+ Colors.Reset+"...");
        System.out.println("If a sentence is written with a "+ Colors.White_Background+ Colors.Black+ "white background and black text"+ Colors.Reset+" it represents "+ Colors.White_Background+ Colors.Black+"inner thoughts"+ Colors.Reset+"...");
        System.out.println("");
    }

    public static void main(String[] args) throws InterruptedException {
        String tutCheck = "";
        boolean choiceOne = false;
        System.out.println("Is it true that you want to see a tutorial?");
        tutCheck = checker.next();
        if(tutCheck.equalsIgnoreCase("yes") || tutCheck.equalsIgnoreCase("true")){
            tutorial();
        }
        System.out.println("As you drowsily awaken you try to understand what is happening, the first step is to remember your"+Colors.Yellow+" name"+ Colors.Reset +"... ");
        PlayerCharacter pc1 = new PlayerCharacter();
        System.out.println("AHA! "+ Colors.Cyan+pc1.getName()+ Colors.Reset+", that's it!");
        System.out.println("Now for your"+ Colors.Yellow+" last name"+ Colors.Reset +", what could it be?");
        pc1.setLastName();
        System.out.println("Oh that's it, "+ Colors.Cyan+pc1.getLastName()+ Colors.Reset+ "!");
        System.out.println("Your arm tingles and you look down, a strange"+ Colors.Cyan+" set of markings"+ Colors.Reset+" starts to appear on your lower forearm... As it comes into focus you can make out what it says...\n");
        pc1.printStats();
        System.out.println("As the world spins around you realize you have awoken in a "+ Colors.Cyan+startPOS[rNum]+Colors.Reset+".");


        if(startPOS[rNum].equalsIgnoreCase(startPOS[0])){
            System.out.println("As you look around you see many drunken patrons talking, laughing, and drinking.\nA large man walks up to you, \"Why are you trying to"+ Colors.Red+" leave"+Colors.Reset+" my fine establishment? is it not up to YOUR standards!?\"");
                Monster human1 = new Monster("human");
                Monster human2 = new Monster("human");
                System.out.println(Colors.White_Background+ Colors.Black+"How did he know what I was thinking!?"+ Colors.Reset+"\nYou hastily say \"Yes, I was just about to leave.\" You scan the room for a door, but you cant make one out, there is too much of commotion to be able to focus.");
                System.out.println("\"BOYS!!\" You hear the"+ Colors.Red+" man"+ Colors.Reset+" yell.\nAs you spin around you see 2"+ Colors.Red+" people"+ Colors.Reset+" running at you!\n");
                System.out.println("The first "+human1.getType()+" you see.");
                human1.printMonStats();
                System.out.println("The second "+human1.getType()+" you see.");
                human2.printMonStats();
                pc1.addDefense();
                Battle fightTavern = new Battle(pc1,human1,human2);
                while (true){
                    if(pc1.getHealth() > 0 && fightTavern.isEnm()){
                        fightTavern.pTurn();
                    }
                    if(pc1.getHealth() > 0 && fightTavern.isEnm()){
                        fightTavern.eTurn();
                    }
                    else{
                        break;
                    }
                }
            System.out.println("You find the door and rush out. A "+Colors.Cyan+"road"+Colors.Reset+" comes into your sights. Day and night you walk, you walk until you "+Colors.Red+"collapse"+Colors.Reset+".");
            }
        if(startPOS[rNum].equalsIgnoreCase(startPOS[1])){
            Monster bandit1 = new Monster("bandit");
            Monster bandit2 = new Monster("bandit");
            Monster dog1 = new Monster("dog",(int)(Math.random()*3)+1);
            System.out.println("As your eyes start to adjust to the light you can make out a"+Colors.Cyan+" road"+Colors.Reset+" in the distance.");
            System.out.println(Colors.White_Background+ Colors.Black+"If only I can make it to the road! I'll be able to get out of this god forsaken forest."+ Colors.Reset+"\nAs you start to make your way over to the"+Colors.Cyan+" road"+Colors.Reset+", you can help but think you are being"+Colors.Red+" watched"+Colors.Reset+".");
            System.out.println("As you are about to reach the"+Colors.Cyan+" road"+Colors.Reset+" you hear a large "+Colors.Red+"CRACK"+Colors.Reset+"! 2 "+Colors.Red+"bandits"+Colors.Reset+" drop from the tree and a"+Colors.Red+" dog"+Colors.Reset+" runs up snarling!\n");
            System.out.println("The first "+bandit1.getType()+" you see.");
            bandit1.printMonStats();
            System.out.println("The second "+bandit2.getType()+" you see.");
            bandit2.printMonStats();
            System.out.println("The dog "+dog1.getType()+" you see.");
            dog1.printMonStats();
            pc1.addDefense();
            Battle fightForrest = new Battle(pc1,bandit1,bandit2,dog1);
            while (true){
                if(pc1.getHealth() > 0 && fightForrest.isEnm()) {
                    fightForrest.pTurn();
                }
                if(pc1.getHealth() > 0 && fightForrest.isEnm()){
                    fightForrest.eTurn();
                }
                else{
                    break;
                }
            }
            System.out.println("As you escape the "+Colors.Red+"scuffle"+Colors.Reset+" and make your way to the "+Colors.Cyan+"road"+Colors.Reset+" you decide to walk. Day and night, shuffling along...");
        }
        if(startPOS[rNum].equalsIgnoreCase(startPOS[2])){
            System.out.println("When you fully come to your senses you see soot floating about. The ally way as a particular stench you cant quite make out. As you begin to stand a huge"+ Colors.Red+" man"+ Colors.Reset+" walks into the ally.");
            System.out.println("\"Hey there, you better empty your pockets if you know whats good for you.\" You hear the"+ Colors.Red+" man"+ Colors.Reset+" say in a strange and cheery tone.\nAs you try to get a better view on him, the"+ Colors.Red+" man"+ Colors.Reset+" starts running at you!\n");
            Monster thug1 = new Monster("thug",25);
            Battle fightCity = new Battle(pc1, thug1);
            System.out.println("The Man you see.");
            thug1.printMonStats();
            while (true){
                if(pc1.getHealth() > 0 && fightCity.isEnm()) {
                    fightCity.pTurn();
                }
                if(pc1.getHealth() > 0 && fightCity.isEnm()){
                    fightCity.eTurn();
                }
                else{
                    break;
                }
            }
        }
        if(startPOS[rNum].equalsIgnoreCase(startPOS[3])){

        }
        if(startPOS[rNum].equalsIgnoreCase(startPOS[4])){

        }
    }
}
