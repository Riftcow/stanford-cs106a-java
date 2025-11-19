/**
 * @author fu4yk
 *
 *	Write a GraphicsProgram that draws a set of ten circles with different sizes, positions, 
	and colors.  Each circle should have a randomly chosen color, a randomly chosen radius 
	between 5 and 50 pixels, and a randomly chosen position on the canvas, subject to the 
	condition that the entire circle must fit inside the canvas without extending past the edge.
 */
		//	Library Needed...
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class RandomCircle extends GraphicsProgram{

		///		Variable Section...
	
		/**	Instance for Random Color Generator...		*/
	private RandomGenerator rGen = RandomGenerator.getInstance();
	

	
	/** creating Object for oval	*/
	private GOval Circle;
	
	///		Method Section...
	
			//	Deploying multiple circle to canvas
	public void createCircle(int x,int y,int width,int height)
	{	
			Circle=new GOval(x,y,width,height);
				
			//	setting up the random color for Circle...
		Circle.setFillColor(rGen.nextColor());
		Circle.setFilled(true);	
		
		//	Add to Canvas...
		add(Circle);
	}
	
	//	Deploying my code in this Section...
	public void run()
	{		
		//	making 10 Circles...
		for(int i=1;i<=10;i++)
		{			//	Random Size for Circle...
			int diameter =2*rGen.nextInt(5,50);
			
					//	Random Postion for Circle...
			int xLoc= rGen.nextInt(0, (getWidth()-diameter));
			int yLoc=rGen.nextInt(0, (getHeight()-diameter));
			
			//	circle call...
			createCircle(xLoc,yLoc,diameter,diameter);
		}
	}
	
		
}
