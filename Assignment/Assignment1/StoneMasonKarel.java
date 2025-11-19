/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// You fill in this part

	//	run method for character starting point...
	public void run()
	{
		while(facingEast())
		{
		climbTop();
		goDownFromCliff();
		if(frontIsClear())
		{
			skipToFourthAvenue();
		}
		else
		{
			break;
		}
		}
		
	}
		//	cleaning the quake mess in the path...
	private void repairQuad()
	{
		if(beepersPresent())
		{}
		else
		{
			putBeeper();
		}
	}
	
	// climb the Cliff...
	private void climbTop()
	{
		turnLeft();
		while(frontIsClear())
		{
			repairQuad();
			move();
		}
		repairQuad();
		turnRight();
	}
	
	
	//	go down from cliff top...
	private void goDownFromCliff()
	{
		turnRight();
		while(frontIsClear())
		{
			move();
		}
		turnLeft();
	}
	
		//		it is use to jump to the broken avenue location...
	private void skipToFourthAvenue()
	{
		
		move();
		move();
		move();
		move();
	}
	
}
