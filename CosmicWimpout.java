/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
public class CosmicWimpout extends howto
{
     
        public  static void main(String args[])
    {
        	 try
             {
                System.out.println(" PLEASE NOTE THAT 99 IS A WILD VALUE");
        	Scanner meow=new Scanner(System.in);
        	String wow;
        	CosmicWimpout player=new CosmicWimpout();
        	CosmicWimpout cpu=new CosmicWimpout();
        	int d1=player.rollDice();   // for the first chance
        	int d2=cpu.rollDice();
        	System.out.println("Enter the Winning Total:");
        	int num=meow.nextInt();
        
        	System.out.println("Enter the Player's name:");
        	wow=meow.next();
        	System.out.println(wow+" ROLLED  "+d1);    
        	System.out.println("CPU ROLLED   "+d2);
        while(d1>d2 || d2>d1)
        {       
            if(d1>d2)
            {
                System.out.println(wow+" WILL START");
                player_turn=true;
                break;
            }
            else if(d2>d1)
            {
                System.out.println("CPU WILL START");
                cpu_turn=true;
                break;
            }
            else if(d1==d2)
            {
                while(d1>d2 || d2>d1)
                {
                    d1=player.rollDice();
                    d2=cpu.rollDice();
                    break;
                }
            }
        }

       
        while(player.show()<num && cpu.show()<num)   // the main loop for the chances
        {
            if(player_turn==true)
            {
                System.out.println(wow+"'s CHANCE");
                
                player.play();
                if(player.show()>=num)
                {
                	System.out.print(wow+" WON");
                }
                cpu_turn=true;
                player_turn=false;
            }
            else
            {
                System.out.println("CPU's CHANCE");
                cpu.play();
                if(cpu.show()>=num)
                {
                	System.out.print("CPU WON");
                }
                player_turn=true;
                cpu_turn=false;
            }
        }
        }
        catch(Exception io)
        {
        	System.out.println("Game unexpectedly stopped");
        	
        }
        
        
            
    }

}
