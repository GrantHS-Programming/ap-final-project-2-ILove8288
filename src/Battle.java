import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Battle{
    ArrayList<Monster> enemies = new ArrayList<>();
    PlayerCharacter player;
    String battleStr;
    int battleInt;
    Scanner choice = new Scanner(System.in);
    int count = -1;
    public Battle(PlayerCharacter pc1, Monster... characters) {
        for (Monster arg : characters) {
            count++;
            enemies.add(characters[count]);
        }
        player = pc1;
    }
    public void pTurn() {
        System.out.println("Do you want to" + Colors.Red + " attack" + Colors.Reset + " or " + Colors.Blue + "defend" + Colors.Reset + "?");
        battleStr = choice.next();
        if (battleStr.equalsIgnoreCase("attack")) {
            System.out.println("There are " + enemies.size() + " " + Colors.Red + "enemies" + Colors.Reset + "," + Colors.Yellow + " what" + Colors.Reset + " enemy do you want to " + Colors.Red + "attack" + Colors.Reset + "? (use number keys. 1, 2, 3, etc...)");
            battleInt = choice.nextInt();
            enemies.get(battleInt - 1).damageHealth(player.getDamage());
            enemies.get(battleInt - 1).printMonStats();
            if (enemies.get(battleInt - 1).getHealth() <= 0) {
                enemies.remove(battleInt - 1);
                System.out.println("You " + Colors.Red + "defeated " + Colors.Reset + "the " + Colors.Red + "enemy" + Colors.Reset + "! Attack again.");
                System.out.println("Do you want to" + Colors.Red + " attack" + Colors.Reset + " or " + Colors.Blue + "defend" + Colors.Reset + "?");
                battleStr = choice.next();
                if (battleStr.equalsIgnoreCase("attack")) {
                    System.out.println("There are " + enemies.size() + " " + Colors.Red + "enemies" + Colors.Reset + "," + Colors.Yellow + " what" + Colors.Reset + " enemy do you want to " + Colors.Red + "attack" + Colors.Reset + "? (use number keys. 1, 2, 3, etc...)");
                    battleInt = choice.nextInt();
                    enemies.get(battleInt - 1).damageHealth(player.getDamage());
                    enemies.get(battleInt - 1).printMonStats();
                    }

                }
            System.out.println("\n↓ Your turn ends. Your stats are shown here. ↓\n");
            player.printStats();
        }
        if (battleStr.equalsIgnoreCase("defend")) {
            battleInt = (int)(Math.random()*enemies.size());
            System.out.println(Colors.Red+"Enemy "+Colors.Reset+(battleInt+1)+" attacks you and does "+enemies.get(battleInt).getDamage()/2+" "+Colors.Red+"damage"+Colors.Reset+".\n");
            player.damageHealth(enemies.get(battleInt).getDamage()/2);
            player.printStats();
            System.out.println("\nYou "+Colors.Blue+"reflect"+Colors.Reset+" half of their "+Colors.Red+"attack"+Colors.Reset+" back and do "+enemies.get(battleInt).getDamage()/2+ Colors.Red+" damage"+Colors.Reset+".\n");
            enemies.get(battleInt).damageHealth(enemies.get(battleInt).getDamage()/2);
            enemies.get(battleInt).printMonStats();
            System.out.println("\n↓ Your turn ends. Your stats are shown here. ↓\n");
            player.printStats();
        }
        }
    }
