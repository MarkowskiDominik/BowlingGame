package frameFactory;

import frame.Frame;
import frame.LastFrame;
import frame.StandardFrame;

/**
 * Create 2 types of bowling frame
 */
public class FrameFactory {
    private static final int NUMBER_OF_LAST_FRAME = 10;

	/**
	 * Based on number of frame create and return the frame of right type
	 *
	 * @param numberOfFrame number of current frame
	 */
    public static Frame createBowlingGameFrame(int numberOfFrame) {
        if (numberOfFrame == NUMBER_OF_LAST_FRAME) {
            return new LastFrame();
        }
        return new StandardFrame();
    }
}
