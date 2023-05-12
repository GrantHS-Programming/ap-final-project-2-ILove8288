import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Battle{
    ArrayList<Monster> enemies = new ArrayList<>();
    PlayerCharacter player;
    String battleStr;
    int battleInt;
    boolean nextDefend = false;
    Scanner choice = new Scanner(System.in);
    int count = -1;
    int count1 = 0;
    public Battle(PlayerCharacter pc1, Monster... characters) {
        for (Monster arg : characters) {
            count++;
            enemies.add(characters[count]);
        }
        player = pc1;
    }
    public boolean isEnm(){
        return enemies.size() > 0;
    }
    public void pTurn() {
        System.out.println("Do you want to" + Colors.Red + " attack" + Colors.Reset + " or " + Colors.Blue + "defend" + Colors.Reset + "?");
        battleStr = choice.next();
        if (battleStr.equalsIgnoreCase("attack")) {
            System.out.println("There are " + enemies.size() + " " + Colors.Red + "enemies" + Colors.Reset + "," + Colors.Yellow + " what" + Colors.Reset + " enemy do you want to " + Colors.Red + "attack" + Colors.Reset + "? (use number keys. 1, 2, 3, etc...)");
            battleInt = choice.nextInt();
            if(battleInt>enemies.size()){
                battleInt = enemies.size();
            }
            System.out.println("You"+Colors.Red+" strike"+Colors.Reset+" out and "+Colors.Red+"slash"+Colors.Reset+" your enemy!");
            enemies.get(battleInt - 1).damageHealth(player.getDamage());
            enemies.get(battleInt - 1).printMonStats();
            if (enemies.get(battleInt - 1).getHealth() <= 0) {
                enemies.remove(battleInt - 1);
                if (enemies.size() > 0) {
                    System.out.println("You " + Colors.Red + "defeated " + Colors.Reset + "the " + Colors.Red + "enemy" + Colors.Reset + "! Move again.\n");
                    System.out.println("Do you want to" + Colors.Red + " attack" + Colors.Reset + " or " + Colors.Blue + "defend" + Colors.Reset + "?");
                    battleStr = choice.next();
                    if(battleInt>enemies.size()){
                        battleInt = enemies.size();
                    }
                    if (battleStr.equalsIgnoreCase("attack")) {
                        System.out.println("There are " + enemies.size() + " " + Colors.Red + "enemies" + Colors.Reset + "," + Colors.Yellow + " what" + Colors.Reset + " enemy do you want to " + Colors.Red + "attack" + Colors.Reset + "? (use number keys. 1, 2, 3, etc...)");
                        battleInt = choice.nextInt();
                        System.out.println("You use the moment of"+Colors.Cyan+" confusion"+Colors.Reset+" to lunge out and "+Colors.Red+"attack"+Colors.Reset+" another"+Colors.Red+" enemy"+Colors.Reset+"!\n");
                        enemies.get(battleInt - 1).damageHealth(player.getDamage());
                        enemies.get(battleInt - 1).printMonStats();
                    }
                    if (battleStr.equalsIgnoreCase("defend")) {
                        battleInt = (int)(Math.random()*enemies.size());
                        System.out.println(Colors.Red+"Enemy "+Colors.Reset+(battleInt+1)+" attacks you and does "+enemies.get(battleInt).getDamage()/2+" "+Colors.Red+"damage"+Colors.Reset+".\n");
                        player.damageHealth(enemies.get(battleInt).getDamage()/2);
                        player.printStats();
                        System.out.println("\nYou "+Colors.Blue+"reflect"+Colors.Reset+" half of their "+Colors.Red+"attack"+Colors.Reset+" back and do "+enemies.get(battleInt).getDamage()/2+ Colors.Red+" damage"+Colors.Reset+".\n");
                        enemies.get(battleInt).damageHealth(enemies.get(battleInt).getDamage()/2);
                        enemies.get(battleInt).printMonStats();
                        System.out.println("\nYour turn ends.\n");
                        player.printStats();
                        nextDefend = true;
                    }

                }
                }
            System.out.println("Your turn ends.\n");
            player.printStats();
        }
        if (battleStr.equalsIgnoreCase("defend")) {
            battleInt = (int)(Math.random()*enemies.size());
            System.out.println(Colors.Red+"Enemy "+Colors.Reset+(battleInt+1)+" attacks you and does "+enemies.get(battleInt).getDamage()/4+" "+Colors.Red+"damage"+Colors.Reset+".\n");
            player.damageHealth(enemies.get(battleInt).getDamage()/4);
            player.printStats();
            System.out.println("\nYou "+Colors.Blue+"reflect"+Colors.Reset+" half of their "+Colors.Red+"attack"+Colors.Reset+" back and do "+enemies.get(battleInt).getDamage()/2+ Colors.Red+" damage"+Colors.Reset+".\n");
            enemies.get(battleInt).damageHealth(enemies.get(battleInt).getDamage()/2);
            enemies.get(battleInt).printMonStats();
            System.out.println("\nYour turn ends.\n");
            player.printStats();
            nextDefend = true;
        }
        }
        public void eTurn(){
            if(nextDefend){
                battleInt = (int)(Math.random()*enemies.size());
                System.out.println("The "+Colors.Red+enemies.get(battleInt).getType()+Colors.Reset+" rushes towards you without realising you have gotten into your"+Colors.Blue+" defensive"+Colors.Reset+" stance!\n");
                System.out.println("They do no"+Colors.Red+" damage"+Colors.Reset+".");
                player.addDefense(-1);
                player.printStats();
            }
            else {
                battleInt = (int)(Math.random()*enemies.size());
                System.out.println("The "+Colors.Red+enemies.get(battleInt).getType()+Colors.Reset+" rushes towards you and"+Colors.Red+" slashes"+Colors.Reset+", cutting into your flesh!");
                System.out.println("They do "+enemies.get(battleInt).getDamage()+Colors.Red+" damage"+Colors.Reset+".\n");
                player.damageHealth(enemies.get(battleInt).getDamage());
                player.printStats();
            }
        }
    }
