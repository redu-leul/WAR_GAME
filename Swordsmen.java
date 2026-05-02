public class Swordsmen extends Character implements Combat {
    public Swordsmen(String name){
        super(name, 120,25);
    }
    @Override
    public void attack(Character target){
        IO.println(name + "slashes " + target.getname());
        target.takedamage(damage);
    }
    @Override
    public void displayinfo() {
        IO.println("Swordsmen: " + name + " Health: " + health + " Damage: " + damage);
    }

}
