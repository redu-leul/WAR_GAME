public class Archer extends Character implements Combat{
    public Archer(String name){
        super(name, 100, 20);
    }
    @Override
    public void attack(Character target){
        IO.println(name + "shoots an arrow at "+ target.getname() );
        target.takedamage(damage);
    }
    @Override
    public void displayinfo(){
        IO.println("Archer: " + name + " health: " + health + "damage: " + damage);
    }
}
