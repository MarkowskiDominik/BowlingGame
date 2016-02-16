package bowling;

import java.util.LinkedList;

public class BowlingGameResultCalculator implements BowlingGameResultCalculatorInterface {

	private static final int MAX_FRAME = 10;
	private static final int MAX_PINS = 10;
	private LinkedList<Frame> bowlingGameFrames;
	private Integer frameCounter = 0;

	public BowlingGameResultCalculator() {
		bowlingGameFrames = new LinkedList<Frame>();
		bowlingGameFrames.add(FrameFactory.getBowlingGameFrame(++frameCounter));
	}

	public void roll(Integer numberOfPins) throws IllegalArgumentException {
		if (numberOfPins==null || numberOfPins > MAX_PINS || numberOfPins < 0 ) {
			throw new IllegalArgumentException("illegal number of pins " + numberOfPins);
		}

		if (isFinished()) {
			throw new IllegalArgumentException("to many rolls");
		}
		generateCurrentFrame().addScore(numberOfPins);
	}

	private Frame generateCurrentFrame() {
		Frame currentFrame = bowlingGameFrames.getLast();
	
		if (currentFrame.isDone()) {
			bowlingGameFrames.add(FrameFactory.getBowlingGameFrame(++frameCounter));
			currentFrame.setNextFrame(bowlingGameFrames.getLast());
		}
		
		return bowlingGameFrames.getLast();
	}

	public Integer score() {
		Integer gameScore = 0;
		for (Frame bowlingGameFrame : bowlingGameFrames) {
			gameScore += bowlingGameFrame.getScore();
		}
		return gameScore;
	}

	public Boolean isFinished() {
		return (frameCounter.equals(MAX_FRAME) && bowlingGameFrames.getLast().isDone());
	}
}
