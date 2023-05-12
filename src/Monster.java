public class Monster {
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
        }
        //prime
        else if (age<=25) {
            health = (age*2)+40;
        }
        //mature
        else if (age<=45) {
            health = (age/2)+20;
        }
        //old
        else if (age<=70) {
            health = (age/4);
        }
        //elder
        else if (age<=100) {
            health = (age/5)+10;
        }
        damage = (age/emness)+5;
    }

    //Constructor with a preset race
    public Monster(String mType){
        age = (int)(Math.random()*99+2);
        emness = (int)(Math.random()*5+1);
        //young + weak
        if(age<=15){
            health = age;
        }
        //prime
        else if (age<=25) {
            health = (age*2)+40;
        }
        //mature
        else if (age<=45) {
            health = (age/2)+20;
        }
        //old
        else if (age<=70) {
            health = (age/4);
        }
        //elder
        else if (age<=100) {
            health = (age/5)+10;
        }
        damage = (age/emness)+5;
        type = mType;
    }
    //preset race and age
    public Monster(String mType, int aType){
        age = aType;
        emness = (int)(Math.random()*5+1);
        //young + weak
        if(age<=15){
            health = age;
        }
        //prime
        else if (age<=25) {
            health = (age*2)+40;
        }
        //mature
        else if (age<=45) {
            health = (age/2)+20;
        }
        //old
        else if (age<=70) {
            health = (age/4);
        }
        //elder
        else if (age<=100) {
            health = (age/5)+10;
        }
        damage = (age/emness)+5;
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
    public void printMonStats(){
        System.out.println(Colors.Red+"Age"+Colors.Reset+": "+getAge()+Colors.Red+"\nHealth"+Colors.Reset+": "+getHealth()+Colors.Red+"\nDamage"+Colors.Reset+": "+getDamage()+"\n");
    }
}
