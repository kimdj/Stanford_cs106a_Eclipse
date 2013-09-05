/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends Karel {
	public void run() {
		/*
		 * essentially a case statement..if there exists more than one avenue, moveStreet() method works fine.
		 * else, turn left THEN moveStreet()
		 */
		if (frontIsClear()) {
			while (true) {
				moveStreet();
				
				if (facingEast() && !leftIsClear()) {
					break;
				}
				if (facingWest() && !rightIsClear()) {
					break;
				}
				
				nextStreet();
			}
		} else {
			turnLeft();
			moveStreet();
		}
	}
	
	private void moveStreet() {
		do {
			if (!beepersPresent()) {
				putBeeper();
			}
			
			if (frontIsClear()) {
				move();
				if (frontIsClear()) {
					move();
					putBeeper();
				}
			}
		} while (frontIsClear());
	}
	
	private void nextStreet() {
		/*
		 * if beeper is present, the number of avenues is odd.
		 * Therefore, the run() method must be offset by one space since it begins with the placement of a beeper.
		 * else, the number of avenues is even, and an offset is unnecessary
		 */
		if (facingEast() && beepersPresent()) {
			turnLeft();
			move();
			turnLeft();
			move();
		} else if (facingEast() && !beepersPresent()) {
			turnLeft();
			move();
			turnLeft();
		} else if (facingWest() && beepersPresent()) {
			turnLeft();
			turnLeft();
			turnLeft();
			move();
			turnLeft();
			turnLeft();
			turnLeft();
			move();
		} else if (facingWest() && !beepersPresent()) {
			turnLeft();
			turnLeft();
			turnLeft();
			move();
			turnLeft();
			turnLeft();
			turnLeft();
		}
	}
}
