import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Character> players = new ArrayList<>();

        IO.println("=== STICK WAR MINI GAME ===");

        for (int i = 1; i <= 3; i++) {
            IO.println("\nEnter name for player " + i + ": ");
            //read a full line of text from the user and store it in the variable name
            String name = input.nextLine();

            IO.println("Choose character (1=Swordsman 2=Archer 3=Mage): ");
            int c = input.nextInt();
            input.nextLine();

            players.add(c == 1 ? new Swordsmen(name) // if c is 1 create swordman, if c is 2 create archer, otherwise create maga
            : c == 2 ? new Archer(name)  // or could use if, else if, else
            : new Mage(name));
        }

        IO.println("\nGame ready!");
        for (Character p : players) ((Combat) p).displayinfo();// to store various character types in a character list

        IO.println("\n=== BATTLE START === (type 5 to quit)");

        while (true) {

            long alive = players.stream().filter(Character::isalive).count();// determine the current state of the game by calculating how many players are still alive
            if (alive <= 1) break;

            IO.println("\nAttacker (1-3 or 5 to quit): ");
            int a = input.nextInt();
            if (a == 5) break;

            IO.println("Target (1-3 or 5 to quit): ");
            int t = input.nextInt();
            if (t == 5) break;

            Character attacker = players.get(a - 1);//connect user input with the actual game data
            Character target = players.get(t - 1);

            if (!attacker.isalive()) {
                IO.println(attacker.getname() + " is already dead and cannot attack!");
                continue;
            }

            if (!target.isalive()) {
                IO.println(target.getname() + " is already dead!");
                continue;
            }

            ((Combat) attacker).attack(target); // casts the object that implements a combat interface to call the cobat class

            for (Character p : players)
                IO.println(p.getname() + " HP: " + p.gethealth());
        }

        IO.println("\n=== GAME OVER ===");

        for (Character p : players)
            if (p.isalive())
                IO.println(p.getname() + " wins!");

        input.close();
    }
}