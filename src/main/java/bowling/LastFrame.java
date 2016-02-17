package src.main.java.bowling;

// REVIEW dmarkowski - Missing class comment
public class LastFrame implements Frame {
    // REVIEW dmarkowski - please change all to simple types, then simple checks can be done and no Integer creation is
    // necessary
    private Integer firstRoll = 0;
    private Integer secondRoll = 0;
    private Integer thirdRoll = 0;
    private Integer attemps = 0;

    public LastFrame() {
    }

    @Override
    public void addScore(Integer numberOfPins) throws IllegalArgumentException {
        // REVIEW dmarkowski - magic number 0, please extract to a constant and name accordingly
        if (attemps.equals(Integer.valueOf(0))) {
            firstRoll = numberOfPins;
        }
        else {
            // REVIEW dmarkowski - magic number 1, please extract to a constant and name accordingly
            if (attemps.equals(Integer.valueOf(1))) {
                if (firstRoll + numberOfPins > Integer.valueOf(11) && !isStrike()) {
                    // REVIEW dmarkowski - not tested, missing test case for this branch
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
        // REVIEW dmarkowski - magic numbers 3 and 2, please extract to a constant and name accordingly
        // REVIEW dmarkowski - to many ( brackets
        return (attemps.equals(Integer.valueOf(3)) || attemps.equals(Integer.valueOf(2)) && !isBonusRoll());
    }

    private Boolean isBonusRoll() {
        // REVIEW dmarkowski - too many ( brackets
        return (isSpare() || isStrike());
    }

    @Override
    public Integer getScore() {
        return firstRoll + secondRoll + thirdRoll;
    }

    @Override
    public Boolean isSpare() {
        // REVIEW dmarkowski - to many round brackets, please use only required
        // REVIEW dmarkowski - magic number 10, please extract to a constant and name accordingly
        return (!isStrike() && Integer.valueOf(10).equals(firstRoll + secondRoll));
    }

    @Override
    public Integer getNextRoll() {
        return firstRoll;
    }

    @Override
    public Boolean isStrike() {
        return (firstRoll.equals(Integer.valueOf(10)));
    }

    @Override
    public Integer getNextTwoRolls() {
        return firstRoll + secondRoll;
    }

    @Override
    public void setNextFrame(Frame frame) {
        throw new IllegalStateException();
    }
}
