package src.main.java.bowling;

// REVIEW dmarkowski - missing class comment
public class StandardFrame implements Frame {
    // REVIEW dmarkowski - please use simple types
    private Integer firstRoll = 0;
    private Integer secondRoll = 0;
    private Integer attemps = 0;
    public Frame nextFrame = null;

    public StandardFrame() {
    }

    @Override
    public void addScore(Integer numberOfPins) throws IllegalArgumentException {
        // REVIEW dmarkowski - magic number 0, please extract to a constant and name accordingly
        if (attemps.equals(Integer.valueOf(0))) {
            firstRoll = numberOfPins;
        }
        else {
            // REVIEW dmarkowski - magic number 10, please extract to a constant and name accordingly
            if (firstRoll + numberOfPins > Integer.valueOf(10)) {
                throw new IllegalArgumentException("sum of two rolls in frame over 10 ");
            }
            secondRoll = numberOfPins;
        }
        attemps++;
    }

    @Override
    public Boolean isDone() {
        // REVIEW dmarkowski - magic numbers 1 and 2, please extract to a constant and name accordingly
        return (attemps.equals(Integer.valueOf(2)) || attemps.equals(Integer.valueOf(1)) && isStrike());
    }

    @Override
    public Integer getScore() {
        return firstRoll + secondRoll + getBonus();
    }

    private Integer getBonus() {
        Integer bonusPoint = 0;
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
        // REVIEW dmarkowski - magic number 10
        return (!isStrike() && Integer.valueOf(10).equals(firstRoll + secondRoll));
    }

    @Override
    public Integer getNextRoll() {
        return firstRoll;
    }

    @Override
    public Boolean isStrike() {
        // REVIEW dmarkowski - magic number 10
        return (firstRoll.equals(Integer.valueOf(10)));
    }

    @Override
    public Integer getNextTwoRolls() {
        Integer sumOfNextTwoRolls = firstRoll + secondRoll;
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