//	Testing given random generator class...
//	with different techniques...
import acm.util.*;
import acm.program.*;

public class randomGen extends ConsoleProgram {				//		version 0.10
	
	//instances variables section... ivar
	private static final int DICE_SIDE=6;
	private static final int givenDice=2;
	private RandomGenerator RGEN_DICENO = RandomGenerator.getInstance();
	
	//		Method section...
	public void run()
	{									
		println("Welcome to Roll a Dice Game!\n\t pick a Winning Number, \n\t\t Roll a Dice!\n\t\t and Win!!");
			// identify rolling numbers... (i) Picka winning Num
		println("Choose a Number to Roll a Dice ");
		int winNo_1=readInt("Pick a Number!\n");
							///		int winNo_2;
							///		int maxRoll=DICE_SIDE* givenDice;
		int drawDice=rollDice();
		if(winNo_1==drawDice)
		{
			println("Congrats Your Win!\n\t Dice is : "+drawDice);
		}
		else
		{
			println("your Guess : "+winNo_1+"\n Dice is : "+ drawDice);
		}
	}
	
	//	------Mini Games
	
	
	private int rollDice()
	{
		int resultRoll=0;
		
		for(int i=0; i<givenDice;i++)
		{
		
			resultRoll=resultRoll+RGEN_DICENO.nextInt(1, DICE_SIDE);
			
		}
		return resultRoll;
	}
	
}
