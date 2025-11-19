import acm.program.*; 
import acm.graphics.*; 
import java.awt.event.*; 
 
public class ClickForFace extends GraphicsProgram { 
 
 /* Private constants */ 
 private static final double FACE_DIAM = 30;  
 
  
  public void init() { 
   addMouseListeners(); 
 }
 
  public void mousePressed(MouseEvent e)
  {
	double mX=e.getX();  
	double mY=e.getY();  
	GFace face=new GFace(FACE_DIAM,FACE_DIAM);
	add(face,mX-(FACE_DIAM/2),mY-(FACE_DIAM/2));		//	mouse clicked centered!
  }
}