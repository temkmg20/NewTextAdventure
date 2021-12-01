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
        String [] enemies = {"Ninja", "Warrior", "Guard", "Assassin"};
        int maxEnemyHealth= 100;
        int enemyHitDamage= 20;

        // Player variables
        int health = 100;
        int shieldValue= 15;
        int numShield = 2;
        int numPowerUps = 1;
        int attackDamage = 30;
        int powerUpChance= 22; // percentage
        int shieldChance= 30;
        String powerUp = "Freeze"; // Allows player to deal damage without
        // without taking any in return

        System.out.println("Welcome to Jungle Survivor\nDo you have what it takes to" +
                " fight your way to the hidden treasure?");
        System.out.println("Let the games begin!");
        boolean running = true;
        // main game loop
        GAME:
        while (running){

            int enemyHealth = rand.nextInt(100);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("The " + enemy + " has appeared!\n");
            // loop for when the enemy is alive
            while(enemyHealth > 0) {
                System.out.println("Your Health: " + health);
                System.out.println("Enemy Health: " + enemyHealth);
                System.out.println("\nWhat would you like to do?");
                System.out.println("1 to Attack ");
                System.out.println("2 to Drink shield ");
                System.out.println("3 to Use power up");
                System.out.println("4 to Run");

                int input = scnr.nextInt();
                // user decides to attack
                if (input == 1){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken= rand.nextInt(enemyHitDamage);
                    enemyHealth-= damageDealt;
                    health -= damageTaken;
                    System.out.println("You hit the " + enemy + " for " + damageDealt + " damage");
                    System.out.println("You received " + damageTaken + " in return");
                    // user is out of health
                    if(health < 1 ){
                        System.out.println("You have taken to much damage to go on!");
                        break;
                    }
                }
                // user decides to drink shield
                else if (input == 2){
                    if (numShield > 0){
                        health+= shieldValue;
                        numShield--;
                        System.out.println("You drank shield potion, you now have " + health + " health" +
                                "\nYou now have" + numShield + " shield potion left");
                    }
                    // user is out of shield
                    else {
                        System.out.println("You have no shield potion left! Defeat the enemy for a chance at " +
                                "a power up or shield potion!");
                    }
                }
                // user decides to use power up
                else if (input == 3){
                    if(numPowerUps >= 1){
                        System.out.println("You have frozen the "+ enemy);
                        System.out.println("You can now attack without receiving damage");
                        int damageDealt = rand.nextInt(attackDamage);
                        enemyHealth-= damageDealt;
                        numPowerUps--;
                    }
                    // user is out of power up
                    else {
                        System.out.println("You have no power ups left! Defeat the enemy for a chance at " +
                                "a power up or shield potion!");
                    }
                }
                // user decides to run
                else if (input == 4){
                    System.out.println("You run away from the " + enemy);
                    continue GAME;
                }
                // user's input is invalid
                else {
                    System.out.println("Invalid Command");
                }


            }

            // user is out of health
            if(health < 1){
                System.out.println("The jungle has gotten the better of you");
                break;
            }
            System.out.println("----------------------------------------");
            System.out.println("The " + enemy + " was defeated");
            System.out.println("You have " + health + " health remaining");
            // random chance of shield being dropped when enemy is killed
            if(rand.nextInt(100) < shieldChance){
                numShield++;
                System.out.println("Lucky you! The enemy has dropped a shield potion");
                System.out.println("You have " + numShield + " shield potions");
            }
            // random chance of power up being dropped when enemy is killed
            if(rand.nextInt(100) < powerUpChance){
                numPowerUps++;
                System.out.println("Lucky you! The enemy has dropped a power up");
                System.out.println("You have " + numPowerUps + " power ups");
            }
            System.out.println("----------------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("Enter 1 to keep fighting");
            System.out.println("Enter 2 to leave the jungle");
            int input = scnr.nextInt();
            // user input is invalid
            while(input != 1 && input !=2 ){
                System.out.println("Invalid Command");
                input = scnr.nextInt();
            }
            // user decides to continue game
            if (input == 1){
                System.out.println("You continue your journey...");
            }
            // user decides to end game
            else if (input ==2){
                System.out.println("You exit the jungle with the hidden treasure!");
                break;
            }


            // Fix the Guard issue
            // Fix the "run option"




        }
        System.out.println("#####################");
        System.out.println("Thanks for playing!");
        System.out.println("#####################");
    }
}
