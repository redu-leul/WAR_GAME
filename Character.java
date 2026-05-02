public class Character {
    protected String name;
    protected int health;
    protected int damage;
    public Character(String name, int health, int damage){
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    public boolean isalive(){
        return health >0;
    }
    public void takedamage(int damage){
        health -= damage;
        if (health < 0)  health = 0;   
    }
    public String getname(){
        return name;
    }
    public int gethealth(){
        return health;
    }
    public int getdamage(){
        return damage;
    }

    }
