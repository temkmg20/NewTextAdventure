import java.util.Random;
import java.util.Scanner;

/** This class implements a text-based adventure game with inspiration from the
 online tutorial
 @author Gardner Temkin, Jack Bradley, Isa Granizo

 */
public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();

        // Game variables
        int maxEnemyHealth= 100;
        int minEnemyHealth= 65;
        int enemyHitDamage= 25;
        Enemy [] enemies = new Enemy[4];
        enemies[0] = new Warrior("Warrior");
        enemies[1] = new Ninja("Ninja");
        enemies[2] = new Assassin("Assassin");
        enemies[3] = new Guard("Guard");

        // Player variables
        int health = 100;
        int shieldValue= 15;
        int numShield = 2;
        int numPowerUps = 1;
        int attackDamage = 45;
        int powerUpChance= 22; // percentage
        int shieldChance= 30;
        String powerUp = "Extra Damage"; // Allows player to deal damage with none in return

        System.out.println("Welcome to Jungle Survivor\nDo you have what it takes to" +
                " fight your way to the hidden treasure?");
        System.out.println("Defeat three enemies to grab the treasure!");
        System.out.println("Begin!");
        boolean running = true;
        // Initiate game sequence
        GAME:
        while (running){

            int enemyHealth = rand.nextInt(35) + 65;
            Enemy enemy = enemies[rand.nextInt(3)];
            System.out.println("The " + enemy + " has appeared!\n");
            // loop for while enemy is alive, presenting choice to user
            while(enemyHealth > 0) {
                System.out.println("Your Health: " + health);
                System.out.println("Enemy Health: " + enemyHealth);
                System.out.println("\nWhat would you like to do?");
                System.out.println("1 to Attack ");
                System.out.println("2 to Drink shield ");
                System.out.println("3 to Use power up");
                System.out.println("4 to Run, and have enemy respawn with new health");

                int input = scnr.nextInt();
                // user attacks
                if (input == 1){
                int damageDealt = rand.nextInt(attackDamage);
                int damageTaken= rand.nextInt(enemyHitDamage);
                enemyHealth-= damageDealt;
                health -= damageTaken;
                    System.out.println("You hit the " + enemy + " for " + damageDealt + " damage");
                    System.out.println("You received " + damageTaken + " in return");
                    if(health < 1 ){
                        System.out.println("---------------------------------------");
                        System.out.println("You have taken to much damage to go on!");
                        break;
                    }
                }
                // user drinks shield
                else if (input == 2){
                if (numShield > 0){
                    health+= shieldValue;

                    numShield--;
                    System.out.println("You drank shield potion, you now have " + health + " health" +
                            "\nYou now have " + numShield + " shield potion left");
                }
                // user tries to use shield but is out
                else {
                    System.out.println("You have no shield potion left! Defeat the enemy for a chance at " +
                            "a power up or shield potion!");
                }
                }
                // user uses power up
                else if (input == 3){
                    if(numPowerUps >= 1){
                        System.out.println("POWER UP! Enemy will lose health without dealing any return damage");
                        int damageDealt = (int) (rand.nextInt(attackDamage) * 2);
                        enemyHealth-= damageDealt;
                        numPowerUps--;
                    }
                    // user tries to use power up but is out
                    else {
                        System.out.println("You have no power ups left! Defeat the enemy for a chance at " +
                                "a power up or shield potion!");
                    }
                }
                // user runs away
                else if (input == 4){
                    System.out.println("You run away from the " + enemy);
                    continue GAME;
                }
                // user inputs something other than 1-4
                else {
                    System.out.println("Invalid Command");
                }


            }

            // user runs out of health
            if(health < 1){
                System.out.println("The jungle has gotten the better of you!");
                break;
            }
            System.out.println("----------------------------------------");
            System.out.println("The " + enemy + " was defeated");
            int counter =0;
            System.out.println("You have " + health + " health remaining");
            // random chance of shield dropping
            if(rand.nextInt(100) < shieldChance){
                numShield++;
                System.out.println("Lucky you! The enemy has dropped a shield potion");
                System.out.println("You have " + numShield + " shield potions");
            }
            // random chance of power up dropping
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
            // user inputs something other than 1-2
            while(input != 1 && input !=2 ){
                System.out.println("Invalid Command");
                input = scnr.nextInt();
            }
            // user continues game
            if (input == 1){
                counter++;
                System.out.println("You continue your journey...");
                if(counter == 3){
                    System.out.println("Well done! You navigated your way to the hidden treasure!");
                }
            }
            // user ends game
            else if (input ==2){
                System.out.println("You exit the jungle with your life, but no treasure.");
                break;
            }

        }
        System.out.println("#####################");
        System.out.println("Thanks for playing!");
        System.out.println("#####################");

    }
}
