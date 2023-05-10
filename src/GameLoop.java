import java.util.Scanner;

public class GameLoop{
    private static Scanner checker = new Scanner(System.in);
    private static String[] startPOS = {"tavern","tavern","tavern","tavern","tavern"};
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
        System.out.println("AHA! "+ Colors.Cyan+pc1.getName()+ Colors.Reset+", thats it!");
        System.out.println("Now for your"+ Colors.Yellow+" last name"+ Colors.Reset +", what could it be?");
        pc1.setLastName();
        System.out.println("Oh thats it, "+ Colors.Cyan+pc1.getLastName()+ Colors.Reset+ "!");
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
                Battle fight1 = new Battle(pc1,human1,human2);
                while (true){
                    if(human1.getHealth()>0 || human2.getHealth()>0){
                        fight1.pTurn();
                    }
                    if(human1.getHealth()>0 || human2.getHealth()>0){
                        fight1.eTurn();
                    }
                    else{
                        break;
                    }
                }
            }
        if(startPOS[rNum].equalsIgnoreCase(startPOS[1])){

        }
        if(startPOS[rNum].equalsIgnoreCase(startPOS[2])){

        }
        if(startPOS[rNum].equalsIgnoreCase(startPOS[3])){

        }
        if(startPOS[rNum].equalsIgnoreCase(startPOS[4])){

        }
    }
}
