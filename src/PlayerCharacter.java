import java.util.Scanner;

public class PlayerCharacter extends Monster {
    //child class of monster specific to some

    private int defenseCount = 10;
    private int damage;

    private Scanner scanned = new Scanner(System.in);
    private String name;
    private String lName;
    public PlayerCharacter(){
        super.setType("human");
        name =  scanned.next();
        super.setDamage(super.getDamage()+20);
        super.setAge((int) (Math.random()*55+10));
    }
    public void setLastName(){
        lName = scanned.next();
    }
    public String getLastName(){
        return lName;
    }
    public String getName() {
        return name;
    }
    public void addDefense(){
        defenseCount+=3;
    }
    public void addDefense(int defenseInt){
        defenseCount+=defenseInt;
    }
    public void printStats(){
        if(getHealth() <= 0){
            System.out.println(Colors.Red+"! YOU HAVE DIED !"+Colors.Reset);
        }
        else{
            System.out.println("↓ Your stats are shown here. ↓\n");
            System.out.println(Colors.Cyan+"Age"+Colors.Reset+": "+getAge()+Colors.Cyan+"\nHealth"+Colors.Reset+": "+getHealth()+Colors.Cyan+"\nDamage"+Colors.Reset+": "+getDamage()+"\n");
        }
    }

    public int getDefense(){
        return defenseCount;
    }
}
