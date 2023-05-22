import java.util.ArrayList;

public class Monster {
    //static ArrayList<String> mTypes = new ArrayList<String>();
    //public static void typeList(){
    //    mTypes.add("Vampire");
    //    mTypes.add("Werewolf");
    //    mTypes.add("Zombie");
    //    mTypes.add("Ghoul");
    //    mTypes.add("Ghost");
    //   mTypes.add("Warlock");
    //    mTypes.add("Demon");
    //    mTypes.add("Banshee");
    //    mTypes.add("Djinn");
    //    mTypes.add("Yeti");
    //    mTypes.add("Goblin");
    //    mTypes.add("Troll");
    //    mTypes.add("Orc");
    //    mTypes.add("Minotaur");
    //   mTypes.add("theif");
    //   mTypes.add("human");
    //    mTypes.add("bandit");
    //    mTypes.add("thug");
    //}

    //holding variables for entities health
    private String[] types;
    private int health;
    private int age;
    private int damage;
    private int emness;
    private String type;

    //constructor
    public Monster(){
        age = (int)(Math.random()*99+2);
        emness = (int)(Math.random()*5+1);
        //young + weak
        if(age<=15){
            health = age;
            emness -= 3;
        }
        //prime
        else if (age<=25) {
            health = (age*2)+40;
            emness += 5;
        }
        //mature
        else if (age<=45) {
            health = (age/2)+20;
            emness += 3;
        }
        //old
        else if (age<=70) {
            health = (age/4);
            emness -= 4;
        }
        //elder
        else if (age<=100) {
            health = (age/5)+10;
            emness -= 5;
        }
        damage = emness*2;
        if (damage<5){
            damage = 4;
        }
        //type = mTypes.get((int)(Math.random()*mTypes.size()));
    }

    //Constructor with a preset race
    public Monster(String mType){
        age = (int)(Math.random()*99+5);
        emness = (int)(Math.random()*5+5);
        //young + weak
        if(age<=15){
            health = age;
            emness -= 3;
        }
        //prime
        else if (age<=25) {
            health = (age*2)+40;
            emness += 5;
        }
        //mature
        else if (age<=45) {
            health = (age/2)+20;
            emness += 3;
        }
        //old
        else if (age<=70) {
            health = (age/4);
            emness -= 4;
        }
        //elder
        else if (age<=100) {
            health = (age/5)+10;
            emness -= 5;
        }
        damage = emness*2;
        if (damage<5){
            damage = 4;
        }
        type = mType;
    }
    //preset race and age
    public Monster(String mType, int aType){
        age = aType;
        emness = (int)(Math.random()*5+1);
        //young + weak
        if(age<=15){
            health = age;
            emness -= 3;
        }
        //prime
        else if (age<=25) {
            health = (age*2)+40;
            emness += 5;
        }
        //mature
        else if (age<=45) {
            health = (age/2)+20;
            emness += 3;
        }
        //old
        else if (age<=70) {
            health = (age/4);
            emness -= 4;
        }
        //elder
        else if (age<=100) {
            health = (age/5)+10;
            emness -= 5;
        }
        damage = emness*2;
        if (damage<5){
            damage = 4;
        }
        type = mType;
    }

    //getters
    public int getAge() {
        return age;
    }
    public int getDamage() {
        return damage;
    }
    public int getEmness() {
        return emness;
    }
    public int getHealth() {
        return health;
    }
    public void setType(String nType) {
        type = nType;
    }
    public String getType(){
        return type;
    }

    //sets health equal to damage passed (can be negative to add)
    public void damageHealth(int dmg){
        health-=dmg;
    }
    public void setHealth(int nHealth){
        health = nHealth;
    }
    public void setDamage(int nDamage){
        damage=nDamage;
    }
    public void setAge(int nAge){
        age = nAge;
    }
    public void printMonStats(){
        System.out.println(Colors.Red+"Age"+Colors.Reset+": "+getAge()+Colors.Red+"\nHealth"+Colors.Reset+": "+getHealth()+Colors.Red+"\nDamage"+Colors.Reset+": "+getDamage()+"\n");
    }

}
