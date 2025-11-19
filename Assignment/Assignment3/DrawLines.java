/**
 * @author fu4yk
 *	Drawing a Line with Mouse in Java
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class DrawLines extends GraphicsProgram {

			/**		Variables	*/
	private GLine drawLine;
	
			/**		Methods...	*/
	
	//	start
	public void mousePressed(MouseEvent e)
	{
		double xLoc=e.getX();
		double yLoc=e.getY();
		
		//	deploying a Line
		drawLine=new GLine(xLoc,yLoc,xLoc,yLoc);
		drawLine.setVisible(true);
		add (drawLine);
	}
	//	move
	public void mouseDragged(MouseEvent e)
	{
		double xdragLoc=e.getX();
		double ydragLoc=e.getY();
		drawLine.setEndPoint(xdragLoc, ydragLoc);
		
	}
	
	
	public void run()
	{
		//	adding actions...
		addMouseListeners();	//	init action
	}
}
