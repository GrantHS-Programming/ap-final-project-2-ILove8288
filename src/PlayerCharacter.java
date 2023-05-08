import java.util.Scanner;

public class PlayerCharacter extends Monster {
    //child class of monster specific to some
    private Scanner scanned = new Scanner(System.in);
    private String name;
    private String lName;
    public PlayerCharacter(){
        name =  scanned.next();
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
    public void printStats(){
        System.out.println(Colors.Cyan+"Age"+Colors.Reset+": "+getAge()+Colors.Cyan+"\nHealth"+Colors.Reset+": "+getHealth()+Colors.Cyan+"\nDamage"+Colors.Reset+": "+getDamage());
    }
}
