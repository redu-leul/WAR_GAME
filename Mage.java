public class Mage extends Character implements Combat{
    public Mage(String name){
        super(name, 80,35);
    }
    @Override
    public void attack(Character target){
        IO.println(name + "casts a spell on " + target.getname());
        target.takedamage(damage);
    }
    @Override
    public void displayinfo(){
        IO.println(("mage: " + name + "health: " + health + "damage: "+ damage ));
    }
}
