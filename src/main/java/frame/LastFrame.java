package frame;

// REVIEW dmarkowski - Missing class comment
/**
 * @author Dominik Markowski
 *
 * Class contains information on rolls in the last frame and how to calculate the result
 */
public class LastFrame implements Frame {
	private static final int ZERO_ATTEMPS = 0;
    private static final int ONE_ATTEMP = 1;
    private static final int TWO_ATTEMPS = 2;
    private static final int THREE_ATTEMPS = 3;
	private static final int MAX_PINS_OF_FRAME = 10;
	private int firstRoll = 0;
    private int secondRoll = 0;
    private int thirdRoll = 0;
    private int attemps = 0;

    public LastFrame() {
    }

    @Override
    public void addScore(int numberOfPins) throws IllegalArgumentException {
        if (attemps == ZERO_ATTEMPS) {
            firstRoll = numberOfPins;
        }
        else {
            if (attemps == ONE_ATTEMP) {
                if (firstRoll + numberOfPins > MAX_PINS_OF_FRAME && !isStrike()) {
                    throw new IllegalArgumentException("two rolls over 10 in last frame");
                }
                secondRoll = numberOfPins;
            }
            else {
                thirdRoll = numberOfPins;
            }
        }
        attemps++;
    }

    @Override
    public Boolean isDone() {
        return attemps == THREE_ATTEMPS || attemps == TWO_ATTEMPS && !isBonusRoll();
    }

    private Boolean isBonusRoll() {
        return isSpare() || isStrike();
    }

    @Override
    public int getScore() {
        return firstRoll + secondRoll + thirdRoll;
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
        return firstRoll + secondRoll;
    }

    @Override
    public void setNextFrame(Frame frame) {
        throw new IllegalStateException();
    }
}
