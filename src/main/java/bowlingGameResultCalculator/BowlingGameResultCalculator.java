package bowlingGameResultCalculator;

import java.util.LinkedList;

import frame.Frame;
import frameFactory.FrameFactory;

// REVIEW dmarkowski - Missing class comment.
/**
 * @author Dominik Markowski
 * 
 */
public class BowlingGameResultCalculator {

	private static final int MAX_FRAME = 10;
	private static final int MAX_PINS = 10;
	private final LinkedList<Frame> bowlingGameFrames;
	private int frameCounter = 0;

	public BowlingGameResultCalculator() {
		bowlingGameFrames = new LinkedList<Frame>();
		bowlingGameFrames.add(FrameFactory.createBowlingGameFrame(++frameCounter));
	}
	
	public void roll(int numberOfPins) throws IllegalArgumentException {
		if (numberOfPins > MAX_PINS || numberOfPins < 0) {
			throw new IllegalArgumentException("illegal number of pins " + numberOfPins);
		}

		if (isFinished()) {
			throw new IllegalArgumentException("to many rolls");
		}
		currentFrame().addScore(numberOfPins);
	}

	private Frame currentFrame() {
		Frame currentFrame = bowlingGameFrames.getLast();

		if (currentFrame.isDone()) {
			Frame newFrame = FrameFactory.createBowlingGameFrame(++frameCounter);
			bowlingGameFrames.add(newFrame);
			currentFrame.setNextFrame(newFrame);
		}

		return bowlingGameFrames.getLast();
	}

	public int score() {
		return bowlingGameFrames.stream().mapToInt(frame -> frame.getScore()).sum();
	}

	public Boolean isFinished() {
		return frameCounter == MAX_FRAME && bowlingGameFrames.getLast().isDone();
	}
}
