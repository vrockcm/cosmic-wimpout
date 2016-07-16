/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

import java.util.*;
public class howto 
{
    int  dice[]=new int[]{10,2,3,4,5,6};
    int Sundice[]=new int[]{10,2,99,4,5,6};
    int total=-35;
    static boolean player_turn=false;
    static boolean cpu_turn=false;
    int d1;
    int d2;
    int face;
    int cntflash;
    int flag1=1,cnttotal=0;
    boolean sunout;
	public int rollDice()    // method to roll a dice
    {
        int rnd = new Random().nextInt(dice.length);
        return dice[rnd];
        
    }
    public int rollSun()     // method to roll a sun dice
    {
        
            int rnd = new Random().nextInt(Sundice.length);
            return Sundice[rnd];
        
    }
    public int addpoint(int amount)  // method for the storing and adding the points in the account 
    {
        if(total>=0)
        {
                if(cnttotal==0)
                {
                    System.out.println("STARTED ACCULMULATING");
                    cnttotal++;
                }
        }
        total=total+amount;
        System.out.println("BALANCE: "+total+ " Amount added "+amount);
        return total=total+amount;
    }
    public int show()  // getter for addpoints
    {
        return total;
    }
    public int flash(int arr[],boolean s)    // to check if there is a flash or no
    {
        face=0;
        boolean sun=s;
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    cntflash++;
                    face=arr[i];
                }
                
            }
            if(sun==true)
            {
                
                if(cntflash==2)
                {
                    return face;
                }
                if(cntflash==3)
                {
                	return face;
                }
            }
            else if(cntflash>=3)
                
                return face;
            
            cntflash=0;
        }
        return -1;
        
        
    }
    public int Frieght(int arr[],boolean sun)   // for checking if there is a freight
    {
        face=0;
        int cnt1=1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[0]==arr[i])
            {
                cnt1++;
                face=arr[0];
            }
        }
        if(cnt1==5)
            return face;
        else if(cnt1==4 && sun==true)
            return face;
        return -1;
    }
    public int check10(int arr[])   // to count how many 10s the player has
    { 
        int cnt1=0;
    
        for(int i=0;i<arr.length;i++)
        {
                if(arr[i]==10)
                {
                    cnt1++;
                    if(i>1)
                    {
                    	if(i==arr.length-1)
                    	{ 
                    		sunout=true;
                    	}
                    }
                }
            
            
        }


        return cnt1;
        
    }
    public int check5(int arr[])  // to count how many 5s the player has
    { 
        int cnt1=0;
        for(int i=0;i<arr.length;i++)
        {
                if(arr[i]==5)
                {
                    cnt1++;
                    if(i>1)
                    {
                    	if(i==arr.length-1)
                    	{ 
                    		sunout=true;
                    	}
                    }
                }
        }
       
        return cnt1;
        
    }
    public int[] eliminator(int arr[],int num)  // to remove the dices which were used
    {
        for(int i=0;i<arr.length;i++)
        {
                if(arr[i]==num)
                {
                    arr[i]=0;
                }
            
        }
        return arr;
    }
    public boolean suncheck(int arr[])  // to check if there is a sun in the Array of dices
    {
        int cnt1=0;
        for(int i=0;i<arr.length;i++)
        {
                if(arr[i]==99)
                {
                    cnt1++;
                }
            
        }
        if(cnt1==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int[] ree(int flashface,int num)   // to check if the newly rolled dices has a prev flash value
    {
        int arr[]=new int [num];
        boolean mr=false;
        int flag=0;
        System.out.println("   DICES ROLLED HAD PREV FLASHFACE");
        while(mr!=true)
        {
        	System.out.print("  RE-ROLLED  ");
            for(int i=0;i<num;i++)
            {
                arr[i]=rollDice();
                System.out.print(arr[i]+"  ");
                
            }
            for(int i=0;i<num;i++)
            {
                if(arr[i]==flashface)
                {
                    flag=1;
                }
            }
            if(flag==0)
            {
                mr=true;
            }
            else
            {
                mr=false;
                flag=0;  }
        }
            return arr;
    
    }
    public int counter(int arr[]) // to count how many dices are left
    {
        int cnt=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                ++cnt;
            }
        }
        return cnt;
    }
    public void play()          // the main evaluation method for everything
    {
        boolean wimpout=false;
        boolean re=false;
        sunout=false;
        int num=5;
        int n;
        int prevflashface=0;
        int flashface=0;
        boolean EXTRA=false;
        Scanner in=new Scanner(System.in); 
        while(wimpout==false || re==true)
        {
           if(EXTRA!=true)
           {
        	if(num==0)
        	{
                    num=5;
        	}
           }
            prevflashface=flashface;
            int alldices[]=new int[num];
            
            	for(int i=0;i<num;i++)
                {
                    alldices[i]=rollDice();
       
                }
           
            if(sunout==false)
            {
                alldices[num-1]=rollSun();
            }
            for(int i=0;i<num;i++)
            {
            	System.out.print(alldices[i]+"  ");    
            }
            
            if(re==true)
            {
                for(int i=0;i<num;i++)
                {
                    if(alldices[i]==prevflashface)
                    {
                        alldices=ree(flashface,num);
                    }
                }
            }
            System.out.println("DICES ROLLED:");    
            boolean sun=suncheck(alldices);
            flashface=flash(alldices,sun);
            int frieghtface=Frieght(alldices,sun);
            
            if(sun==true)
            {
                if(flashface!=-1)
                {
                    System.out.println("A FLASH! with "+flashface);
                    addpoint(flashface*10);
                    alldices=eliminator(alldices,flashface);
                    if(cntflash==3)
                    {
                        System.out.println("ENTER WHAT DO YOU WANT FOR SUN DICE '5' or '10'");
                        int sunnum=in.nextInt();
                        if(sunnum==5)
                        {
                            addpoint(5);
                        }
                        else
                        {
                            addpoint(10);
                        }
                         alldices=eliminator(alldices,99);
                         cntflash=0;
                    }
                    int tens=check10(alldices);
                    int fives=check5(alldices);
                    alldices=eliminator(alldices,99);
                    cntflash=0;
                    
                    
                    if(tens>0)
                    {
                    	addpoint(10*tens);
                        alldices=eliminator(alldices,10);
                    }
                    if(fives>0)
                    {
                    	addpoint(5*fives);
                        alldices=eliminator(alldices,5);
                    }
                    
                    sunout=true;
                    num=counter(alldices);
                    System.out.println(num);
                    if(num==1)
                    {
                    	System.out.println("1 DICE LEFT");
                    
                    	if(cpu_turn==true)
                        {
                        	   	String stay12=Math.random() < 0.5 ? "STAY" : "EXIT";
                        	   	if(stay12.equals("STAY"))
                                {
                        	   		System.out.println("imma STAY");
                                	 wimpout=false;
                                	  re=true;
                                          EXTRA=true;
                                }
                                else
                                {
                                	System.out.println("Imma LEAVE");
                                	wimpout=true;
                                	re=false;
                                }
		
                        }
                        if(player_turn==true)
                        {
                        	
                        
                        System.out.println("Enter 'STAY' or 'END'");
                        String stay=in.next();
                        if(stay.equals("STAY"))
                        {
                        	 wimpout=false;
                        	  re=true;
                                  EXTRA=true;
                        }
                        else
                        {
                        	wimpout=true;
                        	re=false;
                        }
                        
                      }
                    }
                    else
                        re=true;
                    if(num==0)
                    {
                    	System.out.println("SCORED WITH ALL FIVE DICES");
                    	System.out.println("EXTRA CHANCE..... \n");
                    }
            
                  }
                
                else if(frieghtface!=-1)
                {
                    if(frieghtface==6 || frieghtface==10)
                    {
                        System.out.println("YOU WON with frieght of "+frieghtface);
                        if(frieghtface==6)
                        {
                        	addpoint(6*100);
                        }
                        else
                        {
                        	addpoint(10*100);
                        }
                        
                        re=false;
                        wimpout=true;
                    }
                    else
                    {
                    	System.out.println("YOU have a frieght of "+frieghtface);
                        addpoint(frieghtface*100);
                        alldices=eliminator(alldices,99);
						sunout=true;
						System.out.println("SCORED WITH ALL FIVE DICES");
                    	System.out.println("EXTRA CHANCE..... \n");
						re=true;
						wimpout=false;
                    }
                    
                }
                else if(flashface==-1 && frieghtface==-1 && check10(alldices)==0 
                        && check5(alldices)==0)
                {
                    System.out.println("YOU HAVE WORTH NOTHING BUT JUST A SUN FACE" );
                    if(cpu_turn==true)
                    {
                    	   	addpoint(Math.random() < 0.5 ? 5 : 10);
                    }
                    if(player_turn==true){
                    	System.out.println("SUN DICE: Choose 5 or 10");
                    	 n=in.nextInt();
                    if(n==5)
                        addpoint(5);
                    else
                        addpoint(10);   }
                    sunout=true;
                    wimpout=true;
                    re=false;   
                }
                else if(flashface==-1 && frieghtface==-1)
                        {
                			int tens=check10(alldices);
                			int fives=check5(alldices);
                			if(tens>0)
                			{
                				addpoint(10*tens);
                				alldices=eliminator(alldices,10);
                			}
                			if(fives>0)
                			{
                				addpoint(5*fives);
                				alldices=eliminator(alldices,5);
                			}
                                        
                    
               
                    if(cpu_turn==true)
                    {
                    	addpoint(Math.random() < 0.5 ? 5 : 10);
                    }
                    if(player_turn==true)
                    {
                    	System.out.println("SUN DICE: Choose 5 or 10");
                    	n=in.nextInt();
                    if(n==5)
                        addpoint(5);
                    else
                        addpoint(10);   
                    }
                    
                    sunout=true;
                    eliminator(alldices,99);
                    num=counter(alldices);
                    System.out.println(num);
                    
                    if(num<=1)
                    {
                        wimpout=true;
                        re=false;  
                    }
                    else
                    {
                        wimpout=false;
                        re=true; 
                        EXTRA=true;
                    }
                    
                    
                 }
                
                
            }
            
            
            // CHange
            // CHange
            // CHange
            // CHange
            // Change
            
            
            
            
            else if(sun==false)
                
                if(flashface!=-1)
                {
                	System.out.println("A FLASH! with "+flashface);
                    addpoint(flashface*10);
                    alldices=eliminator(alldices,flashface);
                    int tens=check10(alldices);
        			int fives=check5(alldices);
        			if(tens>0)
        			{
        				addpoint(10*tens);
        				alldices=eliminator(alldices,10);
        			}
        			else if(fives>0)
        			{
        				addpoint(5*fives);
        				alldices=eliminator(alldices,5);
        			}
            			
                    num=counter(alldices);
                    System.out.println(num);
                    cntflash=0;
                    if(num==1)
                    {
                    	System.out.println("1 DICE LEFT");
                    
                    	if(cpu_turn==true)
                        {
                        	   	String stay12=Math.random() < 0.5 ? "STAY" : "EXIT";
                        	   	if(stay12.equals("STAY"))
                                {
                        	   		System.out.println("imma STAY");
                                	 wimpout=false;
                                	  re=true;
                                           EXTRA=true;
                                }
                                else
                                {
                                	System.out.println("imma LEAVE");
                                	wimpout=true;
                                	re=false;
                                }
		
                        }
                        if(player_turn==true)
                        {
                            
                        	
                        
                        System.out.println("Enter 'STAY' or 'END'");
                        String stay=in.next();
                        if(stay.equals("STAY"))
                        {
                        	 wimpout=false;
                        	  re=true;
                                   EXTRA=true;
                        }
                        else
                        {
                        	wimpout=true;
                        	re=false;
                        }
                        
                      }
                    }
                    else
                        re=true;
                    if(num==0)
                    {
                    	System.out.println("SCORED WITH ALL FIVE DICES");
                    	System.out.println("EXTRA CHANCE..... \n");
                    	
                    }
            
                    
                }
                
                else if(frieghtface!=-1)
                {
                    if(frieghtface==6 || frieghtface==10)
                    {
                        System.out.println("YOU WON with frieght of "+frieghtface);
                        re=false;
                        wimpout=true;
                    }
                    else
                    {
                    	System.out.println("YOU have a frieght of "+frieghtface);
                        addpoint(frieghtface*100);
                        System.out.println("SCORED WITH ALL FIVE DICES");
                    	System.out.println("EXTRA CHANCE..... \n");
						re=true;
						wimpout=false;
                    }
                    
                }
                else if(flashface==-1 && frieghtface==-1 && check10(alldices)==0 
                        && check5(alldices)==0)
                {
                    System.out.println("HAA YOU WIMPED OUT");
                    wimpout=true;
                    re=false;   
                }
                else if(flashface==-1 && frieghtface==-1)
                {
                	int tens=check10(alldices);
        			int fives=check5(alldices);
        			
        			if(tens>0)
        			{
        				addpoint(10*tens);
        				alldices=eliminator(alldices,10);
        			}
        			if(fives>0)
        			{
        				addpoint(5*fives);
        				alldices=eliminator(alldices,5);
        			}
                    num=counter(alldices);
                    System.out.println(num);
                    if(num==1)
                    {
                        System.out.println("1 DICE LEFT");

                    	if(cpu_turn==true)
                        {
                        	   	String stay12=Math.random() < 0.5 ? "STAY" : "EXIT";
                        	   	if(stay12.equals("STAY"))
                                {
                        	   		System.out.println("imma STAY");
                                	 wimpout=false;
                                	  re=true;
                                           EXTRA=true;
                                }
                                else
                                {
                                	System.out.println("imma LEAVE");
                                	wimpout=true;
                                	re=false;
                                }
		
                        }
                        if(player_turn==true)
                        {
                        	
                        
                        System.out.println("Enter 'STAY' or 'END'");
                        String stay=in.next();
                        if(stay.equals("STAY"))
                        {
                        	 wimpout=false;
                        	  re=true;
                                   EXTRA=true;
                        }
                        else
                        {
                        	wimpout=true;
                        	re=false;
                        }
                        }
                    }        
                    else
                    {
                        wimpout=false;
                        re=true;    
                    }
                    if(num==0)
                    {
                        if(EXTRA==true)
                        {
                           wimpout=true;
                           re=false;  
                        }
                    }
                     
                    
                    
                 }
                
                
            }
    
    }
     
}
