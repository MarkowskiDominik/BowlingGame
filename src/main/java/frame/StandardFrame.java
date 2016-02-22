package frame;

// REVIEW dmarkowski - missing class comment
/**
 * @author Dominik Markowski
 *
 * Class contains information on rolls in the standard frame and how to calculate the result
 */
public class StandardFrame implements Frame {
	private static final int ZERO_ATTEMPS = 0;
    private static final int ONE_ATTEMP = 1;
    private static final int TWO_ATTEMPS = 2;
	private static final int MAX_PINS_OF_FRAME = 10;
    private int firstRoll = 0;
    private int secondRoll = 0;
    private int attemps = 0;
    public Frame nextFrame = null;

    public StandardFrame() {
    }

    @Override
    public void addScore(int numberOfPins) throws IllegalArgumentException {
        if (attemps == ZERO_ATTEMPS) {
            firstRoll = numberOfPins;
        }
        else {
            if (firstRoll + numberOfPins > MAX_PINS_OF_FRAME) {
                throw new IllegalArgumentException("sum of two rolls in frame over 10 ");
            }
            secondRoll = numberOfPins;
        }
        attemps++;
    }

    @Override
    public Boolean isDone() {
        return (attemps == TWO_ATTEMPS || attemps == ONE_ATTEMP && isStrike());
    }

    @Override
    public int getScore() {
        return firstRoll + secondRoll + getBonus();
    }

    private int getBonus() {
        int bonusPoint = 0;
        if (nextFrame != null) {
            if (isSpare()) {
                bonusPoint = nextFrame.getNextRoll();
            }
            if (isStrike()) {
                bonusPoint = nextFrame.getNextTwoRolls();
            }
        }
        return bonusPoint;
    }

    @Override
    public Boolean isSpare() {
        return !isStrike() && firstRoll + secondRoll == MAX_PINS_OF_FRAME;
    }

    @Override
    public int getNextRoll() {
        return firstRoll;
    }

    @Override
    public Boolean isStrike() {
        return firstRoll == MAX_PINS_OF_FRAME;
    }

    @Override
    public int getNextTwoRolls() {
        int sumOfNextTwoRolls = firstRoll + secondRoll;
        if (isStrike() && nextFrame != null) {
            sumOfNextTwoRolls += nextFrame.getNextRoll();
        }
        return sumOfNextTwoRolls;
    }

    @Override
    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }
}