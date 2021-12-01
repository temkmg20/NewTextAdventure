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
        int attackDamage = 30;
        int powerUpChance= 22; // percentage
        int shieldChance= 30;
        String [] powerUp = {"Shield", "Double Damage", "Freeze"};


        boolean running = true;
        GAME:
        while (running){
            System.out.println("Welcome to Jungle Survivor\nDo you have what it takes to" +
                    " fight your way to the hidden treasure?");
            System.out.println("Let the games begin");
            int enemyHealth = rand.nextInt(100);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println(enemy + " has appeared!\n");

            while(enemyHealth > 0) {
                System.out.println("Your Health: " + health);
                System.out.println("Enemy Health: " + enemyHealth);
                System.out.println("\nWhat would you like to do?");
                System.out.println("1 to Attack ");
                System.out.println("2 to Drink shield ");
                System.out.println("3 to Use power up");
                System.out.println("4 to Run");

                int input = scnr.nextInt();
                if (input == 1){
                int damageDealt = rand.nextInt(attackDamage);
                int damageTaken= rand.nextInt(enemyHitDamage);
                enemyHealth-= damageDealt;
                health -= damageTaken;
                    System.out.println("You strike " + enemy + "for" + damageDealt + "damage");
                    System.out.println("You receive " + damageTaken + " in return");
                    if(health < 1 ){
                        System.out.println("You have taken to much damage to go on!");
                        break;
                    }
                }
                else if (input == 2){
                if (numShield > 0){
                    health+= shieldValue;
                    numShield--;
                    System.out.println("You drank shield potion, you now have " + health + " health" +
                            "\nYou now have" + numShield + "shield potion left");
                }
                else {
                    System.out.println("You have no shield potion left! Defeat the enemy for a chance at " +
                            "a power up or shield potion!");
                }
                }
                else if (input == 3){

                }
                else if (input == 4){

                }
                else {
                }


            }

            

        }
    }
}
