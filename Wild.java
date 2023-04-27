import java.io.*;
import java.util.*;
class Wild
{
    static int player_health = 100;
    static int dialogueSpeed = 40;
    static long sleepTime = 250;
    static int wildAnimal_Health = 100;
    static int[] damage ={0, 10, 15, 24, 52, 69, 22, 31, 41, 39, 37, 1, 9, 3, 25};
    static Scanner sc = new Scanner(System.in);
    static Random rn = new Random();
    public static void slowPrint(String text, int speed) throws InterruptedException, IOException{
        // import java.io.* for method to work
        Writer w = new PrintWriter(System.out);
        for(int t = 0; t < text.length(); t++){
          System.out.print(text.charAt(t));
          w.flush();
          Thread.sleep(speed);
        }
        System.out.println();
    }
    static void displayIntro()throws InterruptedException, IOException{
        slowPrint("####################", 10);
        slowPrint("    MAN VS WILD", 10);
        slowPrint("####################", 10);
        System.out.println("\n\n\n\n");
        slowPrint("[Wild Animal] GRAHhhhhhhhh!!!!", dialogueSpeed);
        Thread.sleep(sleepTime);
        slowPrint("[Player] What? What are you?", dialogueSpeed);
        Thread.sleep(sleepTime);
        slowPrint("[Wild Animal] HUHAHUHAHUHAHUHAHUHAHUHA", dialogueSpeed);
        Thread.sleep(sleepTime); 
        slowPrint("[Player] TF is going on...", dialogueSpeed);
        Thread.sleep(sleepTime);      
        slowPrint("\nCan you,the man beat this wild beast to survive ??!\n", 60);
    }
    static void attackDisplay(String playerName)throws InterruptedException, IOException{
        slowPrint(playerName+"'s attack options:- ", 26);
        System.out.println("1. Four-knuckles Uppercut");
        System.out.println("2. Close Combat");
        System.out.println("3. Eat Food");
        System.out.println("4. Low Kick");
        System.out.print(">> ");
        

    }
    static void damageEntity(int dmg, boolean isPlayer, boolean regen){
        if(!regen){
          if(!isPlayer) player_health -= dmg;
          else wildAnimal_Health -= dmg;
        }
        else{
          if(isPlayer) player_health += dmg;
          else wildAnimal_Health += dmg;
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException, IOException{
        displayIntro();
        int turn = 1, dmg, choice;
        String[] enemy_moves = {"Butt Slam", "Claw Punch", "Ball Twister", "Eat Food"};
        while(player_health > 0 && wildAnimal_Health > 0)
        {
            if(turn == 1)
            {
                attackDisplay("Man");
                choice = sc.nextInt();
                if(choice > 4 || choice < 0){
                    slowPrint("Invalid attack provided. Try again.\n", dialogueSpeed);
                    continue;
                
                }
                System.out.println("");
                dmg = damage[rn.nextInt(15)];
                damageEntity(dmg, true, (choice == 3));
                if(choice != 3)
                slowPrint("Your move dealt " + dmg + " damage.\nWild Beast\'s health is at " + wildAnimal_Health + " hp", dialogueSpeed);
                else
                slowPrint("Your move healed " + dmg + " damage.\nYour health is at " + player_health + " hp", dialogueSpeed);
                turn++;
                
            }
            else{
              dmg = damage[rn.nextInt(11)];
              choice = rn.nextInt(4);           
              String move = enemy_moves[choice];
              damageEntity(dmg, false, (choice == 3));
              if(choice != 3)
              slowPrint("\n\nWild Beast used " + move + " which dealt " + dmg + " damage.\nYour health is at " + player_health + " hp.\n", dialogueSpeed);
              else
              slowPrint("\n\nWild Beast used " + move + " which healed " + dmg + " damage.\nWild Beast\'s health is at " + wildAnimal_Health + " hp.\n", dialogueSpeed);            
              turn--;
            }
            
            if(player_health > 100) player_health = 100;
            if(wildAnimal_Health > 100) wildAnimal_Health = 100;
        }
        
        if(player_health > wildAnimal_Health){
          slowPrint("[Man] Nigerundao Smokeyyyyyyyy!!.", dialogueSpeed);
        Thread.sleep(sleepTime);
        }
        else if(wildAnimal_Health > player_health){
          slowPrint("[Wild Beast] HAMBA HAMBA RAMBA RAMBA.", dialogueSpeed);
        Thread.sleep(sleepTime);
        }
    }
}