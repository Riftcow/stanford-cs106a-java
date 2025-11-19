/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		HangmanScaffoldGraphics=new GCompound();
		HangmanScaffoldGraphics.setLocation(WIDTH/2,0);
		add(HangmanScaffoldGraphics);
		drawScaffold();
		
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
	}
	
	
	/**		Drawing section	*/
	public void drawScaffold()
	{
		//	location sets...
		double x0=0.0;
		double y0=HEIGHT;
		
		double x1=0.0;
		double y1=HEIGHT-SCAFFOLD_HEIGHT;
		
		GLine scaffoldVPipe=new GLine(x0,y0,x1,y1);
		GLine scaffoldHPipe=new GLine(x0,y0,x1,y1);
		GLine scaffoldRope=new GLine(x0,y0,x1,y1);
		
		scaffoldVPipe.setVisible(true);
		scaffoldHPipe.setVisible(true);
		scaffoldRope.setVisible(true);
		
		
		//	stick graphic in Compound...
		HangmanScaffoldGraphics.add(scaffoldVPipe);
		HangmanScaffoldGraphics.add(scaffoldHPipe);
		HangmanScaffoldGraphics.add(scaffoldRope);
	}

	
	
/* Constants for the simple version of the picture (in pixels) */
	
		private int WIDTH=200;
		private int HEIGHT=400;
	
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
		//	Body Part!
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	private GCompound HangmanScaffoldGraphics;
}
