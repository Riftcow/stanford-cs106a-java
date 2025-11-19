/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 *
 * This file implements the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.awt.event.*;

public class Breakout_V2 extends GraphicsProgram {

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

    /** Game messages */
    private static final String START_TITLE = "Breakout!";
    private static final String WIN_MESSAGE = "You Have Won!";
    private static final String LOSE_MESSAGE = "You Lose! Try Again!";

    /** FPS */
    private static final int FPS = 30;

    /** Ivars */
    private static GRect paddle;
    private GOval ball;
    private double vx, vy;
    private int brickCounter = NBRICKS_PER_ROW * NBRICK_ROWS;
    private RandomGenerator rgen = RandomGenerator.getInstance();

    /* ---------------- Methods ---------------- */

    public void init() {
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
    }

    /** Draws the game window border */
    private void windowBorderLayout() {
        GRect windowBorder = new GRect(0, 0, getWidth(), getHeight());
        add(windowBorder);
    }

    /** Countdown timer before starting the game */
    public void gameStartingTimer() {
        GLabel label = new GLabel(START_TITLE);
        label.setFont("Comic Sans MS-BOLD-32");
        double x = (getWidth() - label.getWidth()) / 2;
        double y = (getHeight() - label.getHeight()) / 2;
        label.setColor(Color.DARK_GRAY);

        add(label, x, y);
        pause(1000);

        for (int i = 1; i <= 3; i++) {
            label.setLabel(Integer.toString(i));
            add(label, x, y);
            pause(1000);
            remove(label);
        }
    }

    /** Arrange bricks in rows and columns */
    private void setupBrick() {
        for (int i = 0; i < NBRICK_ROWS; i++) {
            int yLoc = BRICK_Y_OFFSET + (i * (BRICK_HEIGHT + BRICK_SEP));
            createBrickRow(yLoc, i);
        }
    }

    private void createBrickRow(int yLoc, int row) {
        int totalWidth = BRICK_WIDTH * NBRICKS_PER_ROW + (NBRICKS_PER_ROW - 1) * BRICK_SEP;

        for (int j = 0; j < NBRICKS_PER_ROW; j++) {
            int x = ((WIDTH - totalWidth) / 2) + (j * (BRICK_WIDTH + BRICK_SEP));
            GRect brick = new GRect(x, yLoc, BRICK_WIDTH, BRICK_HEIGHT);
            Color color = getBrickColor(row);
            brick.setFilled(true);
            brick.setFillColor(color);
            brick.setColor(color);
            add(brick);
        }
    }

    private Color getBrickColor(int row) {
        switch (row / 2) {
            case 0: return Color.RED;
            case 1: return Color.ORANGE;
            case 2: return Color.YELLOW;
            case 3: return Color.GREEN;
            default: return Color.CYAN;
        }
    }

    /** Paddle setup */
    private GRect createPaddle() {
        return new GRect((getWidth() - PADDLE_WIDTH) / 2,
                (getHeight() - BRICK_HEIGHT) - PADDLE_Y_OFFSET,
                PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public void setPaddle() {
        paddle = createPaddle();
        paddle.setFilled(true);
        paddle.setFillColor(Color.BLACK);
        add(paddle);
    }

    public void mouseMoved(MouseEvent e) {
        int newX = e.getX() - PADDLE_WIDTH / 2;
        newX = Math.max(5, Math.min(newX, WIDTH - PADDLE_WIDTH - 5));
        paddle.setLocation(newX, paddle.getY());
    }

    /** Ball setup */
    public void createBall() {
        double x = (getWidth() - (2 * BALL_RADIUS)) / 2;
        double y = (getHeight() - (2 * BALL_RADIUS)) / 2;
        ball = new GOval(x, y, 2 * BALL_RADIUS, 2 * BALL_RADIUS);
        ball.setFilled(true);
        ball.setFillColor(Color.BLACK);
        add(ball);
    }

    	/**		Velocity of Ball is Define here		*/
    private void velocityConfig() {
        vx = rgen.nextDouble(1.0, 3.0);
        vy = 7.5;
        if (rgen.nextBoolean(0.5)) vx = -vx;
    }

    public void moveBall() {
        ball.move(vx, vy);
    }

    public void checkBallBounce() {
        if (ball.getY() >= (getHeight() - 2 * BALL_RADIUS)) vy = -vy;
        if (ball.getX() > (WIDTH - 2 * BALL_RADIUS) || ball.getX() < 0) vx = -vx;
        if (ball.getY() < 0) vy = -vy;
    }

    /** Collision detection */
    private GObject getCollisionObject() {
        double x = ball.getX();
        double y = ball.getY();

        if (getElementAt(x, y) != null) return getElementAt(x, y);
        if (getElementAt(x + 2 * BALL_RADIUS, y) != null) return getElementAt(x + 2 * BALL_RADIUS, y);
        if (getElementAt(x, y + 2 * BALL_RADIUS) != null) return getElementAt(x, y + 2 * BALL_RADIUS);
        if (getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS) != null)
            return getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS);

        return null;
    }

    public void collisionDetection() {
        GObject collider = getCollisionObject();

        if (collider == paddle) {
            vy = -(vy + 0.1);
        } else if (collider != null) {
            brickCounter--;
            remove(collider);
            vy = -(vy + 0.1);
        }
    }

    /** Main motion loop */
    public void motionSimulate() {
        while (ball.getY() <= getHeight()) {
            moveBall();
            checkBallBounce();
            collisionDetection();
            if (ball.getY() >= (getHeight() - PADDLE_Y_OFFSET)) return;
            pause(FPS);
        }
    }

    public void motionListener() {
        addMouseListeners(this);
    }
    
    //*		Win or Lose Message Display	*/
public void setMatchState(String str)
	{
		GLabel matchStateLabel= new GLabel(str);
		
		matchStateLabel.setFont("Comic Sans MS-BOLD-32");
	        double x = (getWidth() - matchStateLabel.getWidth()) / 2;
	        double y = (getHeight() - matchStateLabel.getHeight()) / 2;
	        matchStateLabel.setColor(Color.RED);

	        add(matchStateLabel, x, y);
	        pause(1000);
	}

    private void setup() {
        setupBrick();
        setPaddle();
        pause(2000);
        velocityConfig();
        createBall();
    }

    public void play() {
        
    	int gameTurn = 1;
        
        while (gameTurn <= NTURNS) {
            
        	setup();
            motionSimulate();
            
            if (brickCounter == 0) {
                setMatchState(WIN_MESSAGE);
                gameTurn++;
                removeAll();
            } else if (ball.getY() >= (getHeight() - PADDLE_Y_OFFSET)) {
                setMatchState(LOSE_MESSAGE);
                gameTurn++;
               
                pause(3000);
                removeAll();
                
            }
        }
    }
    	/**		Main Run method for collectively ruuning the Functions...	*/
    public void run() {
        windowBorderLayout();
        gameStartingTimer();
        motionListener();
        play();
    }
}
