
import acm.graphics.*;
import acm.program.*;


public class GFace extends GCompound{
	
	/* Constants specifying feature size as a fraction of head size */ 
	 private static final double EYE_WIDTH    = 0.15; 
	 private static final double EYE_HEIGHT   = 0.15; 
	 private static final double NOSE_WIDTH   = 0.15; 
	 private static final double NOSE_HEIGHT  = 0.10; 
	 private static final double MOUTH_WIDTH  = 0.50; 
	 private static final double MOUTH_HEIGHT = 0.03; 
	 
	 GFace(double Width,double Height)
	 {
		 head=new GOval(Width,Height);
		 
		 leftEye=new GOval(Width*EYE_WIDTH,Height*EYE_HEIGHT);
		 rightEye=new GOval(Width*EYE_WIDTH,Height*EYE_HEIGHT);
		 
		 nose=createNose(Width*NOSE_WIDTH,Height*NOSE_HEIGHT);
		 mouth=new GRect(MOUTH_WIDTH*Width,MOUTH_HEIGHT*Height);
	
		 ///	
		 add(head,0,0);
		 add(leftEye, 0.25 * Width - EYE_WIDTH * Width / 2, 0.25 * Height- EYE_WIDTH * Height/ 2);
		 add(rightEye, 0.75 * Width - EYE_WIDTH * Width / 2, 0.25 * Height- EYE_WIDTH * Height/ 2);
		 add(nose, 0.50 * Width ,0.50 * Height);
		 add(mouth,0.50 * Width-MOUTH_WIDTH*Width/2 ,0.75*Height-MOUTH_HEIGHT*Height/2);
	 }			 //0.50 * width - MOUTH_WIDTH * width / 2

	 public GPolygon createNose(double x,double y)
	 {
		 GPolygon poly=new GPolygon();
		 poly.addVertex(0, -y/ 2); 
		  poly.addVertex(x / 2, y/ 2); 
		  poly.addVertex(-x/ 2, y/ 2); 
		 
		 return poly;
	 }

	 /* Private instance variables */ 
	 private GOval head; 
	 private GOval leftEye, rightEye; 
	 private GPolygon nose; 
	 private GRect mouth;
}
