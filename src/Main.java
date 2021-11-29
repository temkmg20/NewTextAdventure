import java.util.Random;
import java.util.Scanner;

/** This class implements a text-based adventure game with inspiration from the
 online tutorial
 @author Gardner Temkin

 */
public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();

        // Game variables
        String [] characters = {"Ninja", "Warrior", "Guard", "Assassin"};
        int maxEnemyHealth= 100;
        int enemyHitDamage= 20;

        // Player variables
        int health = 100;
        int shieldValue= 15;
        int lives = 3;
        int powerUpChance= 22; // percentage
        String [] powerUp = {"Shield", "Double Damage", "Freeze", "Gambler"};

        boolean running = true;
        GAME:
        while (running){
            System.out.println("Welcome to Jungle Survivor\nDo you have what it takes to" +
                    " fight your way to the hidden treasure?");
            

        }
    }
}
