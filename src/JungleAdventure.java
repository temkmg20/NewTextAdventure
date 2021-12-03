import java.util.Random;
import java.util.Scanner;

public class JungleAdventure {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        Enemy[] enemies;

        enemies = createEnemies();

    }

    public static Enemy[] createEnemies(){
            Enemy[] enemies = new Enemy[4];
            enemies[0] = new Warrior("Warrior");
            enemies[1] = new Ninja("Ninja");
            enemies[2] = new Assassin("Assassin");
            enemies[3] = new Guard("Guard");

            return enemies;
        }
    }

