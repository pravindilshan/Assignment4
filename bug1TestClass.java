import java.util.List;
import java.io.*;

// Test class for Test Case 1 – Game does not pay out at correct level 
// This test class will reproduce the bug mentioned in the above test case. 
public class Maintest {
	
	public static void main(String[] args) throws Exception {
		
	   BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();

        Player player = new Player("Fred", 50);
        Game game = new Game(d1, d2, d3);
        List<DiceValue> cdv = game.getDiceValues(); 

        while (true)
        {
      
            for (int i = 0; i < 50; i++)
            {
            	String name = "Roger";
            	int balance = 50;// The balance used was reduced to 50
            	int limit = 0;
                player = new Player(name, balance);
                player.setLimit(limit);
                int bet = 5;

                System.out.println(String.format("Start Game %d: ", i));
                System.out.println(String.format("%s starts with balance %d, limit %d", 
                		player.getName(), player.getBalance(), player.getLimit()));

                int turn = 0;
                
                while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 100)
                {
                    turn++;                    
                	DiceValue pick = DiceValue.getRandom();
                   
                	System.out.printf("Turn %d: %s bet %d on %s\n",
                			turn, player.getName(), bet, pick); 
                	
                	int winnings = game.playRound(player, pick, bet);
                    cdv = game.getDiceValues();
                    
                    System.out.printf("Rolled %s, %s, %s\n",
                    		cdv.get(0), cdv.get(1), cdv.get(2));
                    
                  // if statement for winnings will not be used instead it will directly print the winnings
                  // this is done to make the program shorter.
                    
	                    System.out.printf("%s won %d, balance now %d\n\n",
	                    		player.getName(), winnings, player.getBalance());
	                	
                    }
                    
                    
                } //while

                //System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
                System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));
                
            } //for
            
         
         //while true
        }
       
	}


