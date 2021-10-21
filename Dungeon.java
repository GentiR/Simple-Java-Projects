import java.util.*;

public class Dungeon{
   public static void main(String [] args){
   
      Scanner sc = new Scanner(System.in);
      Random rand = new Random();
   
   //Game variables
      String[] enemies = {"Skeletion", "Zombie", "Warriors", "Assassin"};
      int maxEnemyHealth = 75;
      int enemyAttackDamage = 25;
   
   //Player variables
      int health = 100;
      int attackDamage = 50;
      int numHealthPotions = 3;
      int healthPotionHealAmount = 30;
      int healPotionDropChance = 50;
   
      boolean running = true;
   
      System.out.println("Welcome to the Dungeon:");
   
      GAME:
      while(running){
         System.out.println("--------------------------------");
      
         int enemyHealth = rand.nextInt(maxEnemyHealth);
         String enemy = enemies[rand.nextInt(enemies.length)];
         System.out.println("\t# "+enemy+ " appeared: #\n");
      
         while(enemyHealth > 0){
            System.out.println("\tYour HealthPoint: "+health);
            System.out.println("\t" + enemy + "'s HealthPoints: " + enemyHealth);
            System.out.println("\n\tWhat would you like to do?");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Drink health potion");
            System.out.println("\t3. Run!");
         
            String input = sc.nextLine();
            
            if(input.equals("1")){
               int damageDealt = rand.nextInt(attackDamage);
               int damageTaken = rand.nextInt(enemyAttackDamage);
               enemyHealth -= damageDealt;
               health -= damageTaken;
            
               System.out.println("\t> You strike the " + enemy + " for " +damageDealt + "damage.");
               System.out.println("\t> You recieve " + damageTaken + " in retaliation!");
            
               if(health < 1){
                  System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                  break;
               }
            }
            else if(input.equals("2")){
               if(numHealthPotions > 0){
                  health += healthPotionHealAmount;
                  numHealthPotions--;
                  System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount +" ."
                              + "\n\t> You now have " + health + "Healthpoints."
                              + "\n\t? You have " + numHealthPotions + "Health potions left.\n");
               }
               else{
                  System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
               }
            }
            else if(input.equals("3")){
               System.out.print("\tYou run away from the " +enemy+ "!");
               continue GAME;
            }
            else{
               System.out.println("\tInvalid comand!");
            }
         }
         if(health < 1){
            System.out.println("You limp out of the dungeon, weak from battle.");
            break;
         }
         
         System.out.println("---------------------------");
         System.out.println(" # "+enemy+ "was defeted! #");
         System.out.println("# You have "+health+ "HealthPoint left. #");
         
         if(rand.nextInt(100) < healPotionDropChance){
            numHealthPotions++;
            System.out.println("# The " + enemy + "dropped a health potion #");
            System.out.println(" # You now have" +numHealthPotions+ " health potion(s).");         
         }
         System.out.println("-----------------------------------------------");
         System.out.println("what would you like to do now?");
         System.out.println("1. Contionue fighting");
         System.out.println("2. Exit dungeon");
         
         String input = sc.nextLine();
         
         while(!input.equals("1") && !input.equals("2")){
            System.out.println("Invalid comand");
            input = sc.nextLine();
         }
         if(input.equals("1")){
            System.out.println("You contionue on your adventure!");
         }
         else if(input.equals("2")){
            System.out.println("You exit successful from your adventure!");
            break;
         }
      }
      System.out.println("###################");
      System.out.println("THANKS FOR PLAYING");
      System.out.println("###################");
   }
}