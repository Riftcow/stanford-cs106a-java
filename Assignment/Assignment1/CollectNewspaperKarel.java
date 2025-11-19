/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 *		Practiceing
 */
		
import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	// You fill in this part
		
	//	to start the player
	public void run()
	{
		lookForNewsPaper();
		pickBeeper();
		goBackToBed();
	}
	
//	move character to NEWS paper
	private void lookForNewsPaper()
	{
		turnRight();
		move();
		turnLeft();
		move();
		move();
		move();
	}
	
	//	return to initial state in room (take Newspaper to Bed)
	private void goBackToBed()
	{
		turnLeft();
		turnLeft();
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();
	//
	}
}

