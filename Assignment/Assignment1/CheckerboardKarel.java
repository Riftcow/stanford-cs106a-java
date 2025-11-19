/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import acm.graphics.*;
import acm.program.*;

public class CheckerboardKarel extends GraphicsProgram {

	// You fill in this part
	
	//	Variable for Board CHecker Size
	private static final int rowCalcSize=8;
	private static final int columnCalcSize=8;
	private int counter=0;
	
	
	//	now Methods for working the program as checkerBoard...
			//		Run method 
	public void run()
	{
		for (int i=0 ; i<rowCalcSize;i++)
		{
			for (int j=0 ; j<columnCalcSize; j++)
			{
				GRect box = new GRect(columnCalcSize, rowCalcSize);
				
			}
			
		}
	}
}
