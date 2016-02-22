package src.main.java.bowling;

import java.util.LinkedList;

// REVIEW dmarkowski - wrong package structure, there should be 2 folders src and test. Both of them should then have
// the same directory structure. Currently only the bowling package was specified.
// REVIEW dmarkowski - Missing class comment.
public class BowlingGameResultCalculator implements BowlingGameResultCalculatorInterface {

    private static final int MAX_FRAME = 10;
    private static final int MAX_PINS = 10;
    private final LinkedList<Frame> bowlingGameFrames;
    // REVIEW dmarkowski - please change to simple int, then e.g. the equals doesn't have to be performed on this
    private Integer frameCounter = 0;

    public BowlingGameResultCalculator() {
        bowlingGameFrames = new LinkedList<Frame>();
        bowlingGameFrames.add(FrameFactory.getBowlingGameFrame(++frameCounter));
    }

    @Override
    public void roll(Integer numberOfPins) throws IllegalArgumentException {
        if (numberOfPins == null || numberOfPins > MAX_PINS || numberOfPins < 0) {
            throw new IllegalArgumentException("illegal number of pins " + numberOfPins);
        }

        if (isFinished()) {
            throw new IllegalArgumentException("to many rolls");
        }
        generateCurrentFrame().addScore(numberOfPins);
    }

    // REVIEW dmarkowski - incorrect naming, in case when the current frame is not finished no frame get generated,
    // please rename the method
    private Frame generateCurrentFrame() {
        Frame currentFrame = bowlingGameFrames.getLast();

        if (currentFrame.isDone()) {
            // REVIEW dmarkowski - please assign result of the FrameFactory to a local variable and then use when
            // setting next frame, otherwise the code is hard to read
            bowlingGameFrames.add(FrameFactory.getBowlingGameFrame(++frameCounter));
            currentFrame.setNextFrame(bowlingGameFrames.getLast());
        }

        return bowlingGameFrames.getLast();
    }

    @Override
    public Integer score() {
        // REVIEW dmarkowski - please use the Java8 stream and the reduce operation for the calculation
        Integer gameScore = 0;
        for (Frame bowlingGameFrame : bowlingGameFrames) {
            gameScore += bowlingGameFrame.getScore();
        }
        return gameScore;
    }

    @Override
    public Boolean isFinished() {
        // REVIEW dmarkowski - too many '(' and ')', please use only required amount of the round brackets
        return (frameCounter.equals(MAX_FRAME) && bowlingGameFrames.getLast().isDone());
    }
}
