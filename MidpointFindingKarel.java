/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		moveToMidpoint();
		moveToInitial();
		moveToMidpoint_2();
	}	
	
	/*
	 * place a beeper if a beeper is not present.
	 */
	private void placeBeeper() {
		if (!beepersPresent()) {
			putBeeper();
		}
	}
	
	/*
	 * move backwards.
	 */
	private void moveBackwards() {
		turnAround();
		move();
		turnAround();
	}
	
	/*
	 * first, move forward; if a beeper is present, move back to initial position
	 * and turn left.
	 */
	private void checkFrontBeeper() {
		move();
		if (beepersPresent()) {
			moveBackwards();
			turnLeft();
			move();
		}
		
		if (!frontIsClear()) {
			placeBeeper();
			turnLeft();
			move();
		}
	}
	
	/*
	 * 
	 */
	private void checkAround() {
		for (int i=0; i<4; i++) {
			if (beepersPresent()) {
				move();
				moveBackwards();
				turnLeft();
			}
		}
	}
	
	/*
	 * setting North orientation
	 */
	private void setNorth() {
		
	}
	
	/*
	 * algorithm for locating the midpoint on 1st street.
	 */
	private void moveToMidpoint() {
		while (frontIsClear()) {
			placeBeeper();
			checkFrontBeeper();
			checkAround();
			if (beepersPresent()) {
				move();
				if (beepersPresent()) {
					moveBackwards();
					turnLeft();
					move();
					if (beepersPresent()) {
						moveBackwards();
						turnLeft();
						move();
						if (beepersPresent()) {
							moveBackwards();
							turnLeft();
							move();
							if (beepersPresent()) {
								moveBackwards();
								turnLeft();
								turnAround();
								while (frontIsClear()) {
									move();
								}
								turnLeft();
								break;
							}
						}
					}
				}
			}
		}
	}
/***********************************************************************************************************/
	
	/*
	 * setup initial position.
	 */
	private void moveToInitial() {
		while (!facingWest()) {
			turnLeft();
		}
		
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
/***********************************************************************************************************/
	
	/*
	 * place a beeper if a beeper is not present.
	 */
	private void pickupBeeper() {
		if (beepersPresent()) {
			pickBeeper();
		}
	}
	
	/*
	 * first, move forward; if a beeper is present, move back to initial position
	 * and turn left.
	 */
	private void checkFrontBeeper_2() {
		move();
		if (!beepersPresent()) {
			moveBackwards();
			turnLeft();
			move();
		}
		
		if (!frontIsClear()) {
			pickupBeeper();
			turnLeft();
			move();
		}
	}
	
	/*
	 * 
	 */
	private void checkAround_2() {
		for (int i=0; i<4; i++) {
			if (!beepersPresent()) {
				move();
				moveBackwards();
				turnLeft();
			}
		}
	}
	
	/*
	 * 
	 */
	private void moveToMidpoint_2() {
		while (frontIsClear()) {
			pickBeeper();
			checkFrontBeeper_2();
			checkAround_2();
			if (!beepersPresent()) {
				move();
				if (!beepersPresent()) {
					moveBackwards();
					turnLeft();
					move();
					if (!beepersPresent()) {
						moveBackwards();
						turnLeft();
						move();
						if (!beepersPresent()) {
							moveBackwards();
							turnLeft();
							move();
							if (!beepersPresent()) {
								moveBackwards();
								turnLeft();
								turnAround();
								while (frontIsClear()) {
									move();
								}
								turnLeft();
								break;
							}
						}
					}
				}
			}
		}
		putBeeper();
	}
	
	
	
	
}

