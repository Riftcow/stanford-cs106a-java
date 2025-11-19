/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
														/* 		Methods */
	//	--------------------------------------------------------------------------------------------------------	//
			/* 		Game Menu */
	
	/**		Creating a Window for Application */
	public void init()
	{
		  // Debug...
		//	print(getWidth());
		//	println(getHeight());
		
		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
	}
	
	//	creating a border for my Breakout WINDOW...
	private void windowBorderLayout()
	{
		GRect windowBorder=new GRect(0,0,getWidth(),getHeight());
		windowBorder.setVisible(true);
		
		//	Deugging
		println(getWidth());
		println(getHeight());
		
		add(windowBorder);
	}
	
	private void startLabel()
	{
		
	}
		//	game starting count Dount timer
	public void gameStartingTimer()
	{
		String strTimeNum;
		double x;
		double y;
		

		GLabel gameTimer=new GLabel("Breakout!");
		gameTimer.setFont("Comic Sans MS-BOLD-32");
		gameTimer.setVisible(true);
		
		x=(getWidth()-gameTimer.getWidth())/2;
		y=(getHeight()-gameTimer.getHeight())/2;
		
		gameTimer.setColor(Color.DARK_GRAY);
		add(gameTimer,x,y);
		pause(1000);	//	1 sec
		
		for(int i=1;i<=3;i++)
		{
			
			remove(gameTimer);
			
			if(i==1)
			{
				
				strTimeNum= Integer.toString(i);
				gameTimer.setLabel(strTimeNum);
				add(gameTimer,x,y);
				pause(1000);	//	1 sec
				remove(gameTimer);
			}
			if(i==2)
			{
				strTimeNum=  Integer.toString(i);
				gameTimer.setLabel(strTimeNum);
				add(gameTimer,x,y);
				pause(1000);	//	1 sec
				remove(gameTimer);
				
			}
			if(i==3)
			{
				strTimeNum=  Integer.toString(i);
				gameTimer.setLabel(strTimeNum);
				add(gameTimer,x,y);
				pause(1000);	//	1 sec
				remove(gameTimer);
				
			}
			
				//	Game Starts from here...
			
		}	
		
	
		
		
	}
	
	//	--------------------------------------------------------------------------------------------------------	//
				/* 		BRICKS */
	
		//	arranging bricks in row and columns...
	private void setupBrick()
	{
		//	Column counts
		for (int i=0; i<NBRICK_ROWS;i++)
		{	
			//	arranging the Brick in Y-axis Oder by center alignment
			int yLoc=BRICK_Y_OFFSET+(i*(BRICK_HEIGHT+BRICK_SEP));
			
			createBrick(yLoc,i);

			//	println(i);		//debuging
		}
	}
	
		//		create a Bricks sets...
	private void createBrick( int yloc,int colorKey)
	{
		
		int x;
		
		//	Width for brick placement location
		int totalWidth=BRICK_WIDTH*NBRICKS_PER_ROW+(NBRICKS_PER_ROW-1)*BRICK_SEP;
			
		//		Row counts
		for (int j=0;j<NBRICKS_PER_ROW;j++)
		{
				//		arranging the Brick in X-axis Oder by center alignment
			x=((WIDTH-totalWidth)/2)+(j*(BRICK_WIDTH+BRICK_SEP));//+(j*BRICK_SEP);
			
			/**	create a Brick GRect	*/
			GRect Brick= new GRect(x,yloc,BRICK_WIDTH,BRICK_HEIGHT);
			
			Brick.setFillColor(colorBrick(colorKey));
			Brick.setColor(colorBrick(colorKey));
			Brick.setFilled(true);
			
			add(Brick);
			
			//	print(j);	//	debugging
		}
	}
	
	//	setting up color varient for Bricks...
	private Color colorBrick(int colorCounter )
	{
		//	println("hello Color");		//	Debugg
		
		//	create a color for each row
		switch(colorCounter/2)
		{
		case 0: 
			return Color.RED ;
		case 1:
			return Color.ORANGE;
		case 2:
			return Color.YELLOW;
		case 3:
			return Color.GREEN;
		default: 
			return Color.CYAN;
			
		}
	}
	

	
	//	--------------------------------------------------------------------------------------------------------	//
					/* 		PADDLE	*/
	//	Create a Paddle for a Ball to Bounce...
	private GRect createPaddle()
	{
		//	1. setup a Rect Paddle Shape.
		GRect Paddle=new GRect((getWidth()-PADDLE_WIDTH)/2,(getHeight()-BRICK_HEIGHT)-PADDLE_Y_OFFSET,PADDLE_WIDTH,PADDLE_HEIGHT);
		
		Paddle.setFillColor(Color.BLACK);
		Paddle.setFilled(true);
		return Paddle;	
	}
	
		// set paddle to GRect ivar Instance
		public void setPaddle()
		{
			Ipaddle=createPaddle();
			Ipaddle.setVisible(true);
			add(Ipaddle);
		}
	
		//	Paddle movement working
	public void mouseMoved(MouseEvent e)
	{
		int mouseX=e.getX();
		int newX=mouseX-PADDLE_WIDTH/2;
		
		  // Clamp to window bounds
        if (newX < 0)
        	{
        	newX = 0+5;
        	}
        if (newX + PADDLE_WIDTH > WIDTH) 
        {
            newX = WIDTH - PADDLE_WIDTH-5;
        }
		
		
		Ipaddle.setLocation(newX,Ipaddle.getY());
		
	}
	
		//	-----------------------------------------------------------------------------------------------------	//
				//	Creating a Ball
	public void createBall()
	{
		double x=(getWidth()-(2*BALL_RADIUS))/2;
		double y=(getHeight()-(2*BALL_RADIUS))/2;
		
		Ball=new GOval(x,y,2*BALL_RADIUS,2*BALL_RADIUS);
		Ball.setFillColor(Color.black);
		Ball.setColor(Color.black);
		Ball.setFilled(true);
		
		 add(Ball);
	}
	private void velocityConfig()
	{
		vx=rgen.nextDouble(1.0,3.0);
		vy=7.5;
		if(rgen.nextBoolean(0.5))
		{
			vx=-vx;
		}
	}
		//	move the Ball
	public void moveBall()
	{
		Ball.move(vx, vy);
	}
	
	//		checking if the ball bounce from the surrounding walls...
	public void checkBallBounce()
	{
			//	double vIncrease=0.5;
		if(Ball.getY()>=(getHeight()-2*BALL_RADIUS))
		{
			vy=-vy;
				//	vy--;
			Ball.move(vx,2*vy);
		}
		if(Ball.getX()>(WIDTH-2*BALL_RADIUS))
		{
			vx=-vx;
			Ball.move(vx,vy);
		}
		if(Ball.getX()<0)
		{
			vx=-vx;
			Ball.move(vx,vy);
		}
		if(Ball.getY()<0)
		{
			vy=-vy;
			Ball.move(vx, vy);
		}
	}
	
	
	//	---------------------------------------------------------------------------------------------------------------	//
					/**		Collision Detection	*/
	
	//	
	private GObject getCollisionObject()
	{
		double x=Ball.getX();
		double y=Ball.getY();
		GObject Element;
		
		if(null!=getElementAt(x,y))
		{
			Element=getElementAt(x,y);
		}
		else if(null!=getElementAt(x+(2*BALL_RADIUS),y))
		{
			Element=getElementAt(x+(2*BALL_RADIUS),y);
		}
		else if(null!=getElementAt(x,y+(2*BALL_RADIUS)))
		{
			Element=getElementAt(x,y+(2*BALL_RADIUS));
		}
		else if(null!=getElementAt(x+(2*BALL_RADIUS),y+(2*BALL_RADIUS)))
		{
			Element=getElementAt(x+(2*BALL_RADIUS),y+(2*BALL_RADIUS));
		}
		else
		{
			Element=null;
		}
		
		return Element; 
	}
		
	//	Collision Detection for Paddle...
	public void CollisionDetection()
	{
		
		GObject Collider=getCollisionObject();
	
			// collision with Paddle
		if(Collider==Ipaddle )
		{
			vy=-vy-0.1;
			
			Ball.move(vx, vy);
		}
			//	Collision with Bricks
		else if(Collider != Ipaddle && Collider!=null)
		{
			brickCounter--;
			remove(Collider);
			
			//	
			vy=-vy-0.1;
			
			Ball.move(vx, vy);
		}
	}
	
	//	game movements...
	public void motionSimulate()
	{
		while(Ball.getY()<=(getHeight()))
		{
			moveBall();
			checkBallBounce();
			CollisionDetection();
			
			if(Ball.getY()>=(getHeight()-(PADDLE_Y_OFFSET)))
			{
				return ;
			}
			pause(FPS);
		}
	}
	
	
	//	---------------------------------------------------------------------------------------------------------------	//
		//	mouseListener for mouse activation
	public void motionListener()
	{
		addMouseListeners(this);
	}
	
			/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		windowBorderLayout();
		gameStartingTimer();
		motionListener();
		
		
			//	Game...			
		Play();				
		
	}
	
	/**	Making a Setup Method 	*/
	private void Setup()
	{
		setupBrick();
		setPaddle();
		pause(2000);
		
		velocityConfig();
		createBall();
	}
	
	/**		Making a Play method 	*/
	public void Play()
	{
		int gameTurn=1;
		while(gameTurn<=NTURNS)
		{
			Setup();
			motionSimulate();
			if(brickCounter==0)
			{
				println("You Have Won!");
				gameTurn++;
				
				removeAll();
				
			}
			else if (brickCounter !=0 && Ball.getY()>=(getHeight()-(PADDLE_Y_OFFSET)))
			{
				println("you Lose Try Again!");
				gameTurn++;
			
				removeAll();
				
			}
			
		}
	}
	
	/**	-------------------------------------------------------------------------------------------------------	*/
		//	Ivar
	private static GRect Ipaddle;
	private GOval Ball;
	
		// random generator numbers
	private  RandomGenerator rgen= RandomGenerator.getInstance();
	
	//	Velocity calculator
	private double vx;
	private double vy;
	
	//	FPS capping for motion capture
	private static final int FPS=30;
	
	//	Brick Counter...
	private int brickCounter=100;
}
