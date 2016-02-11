package bowling;

public class LastFrame implements Frame {

	private Integer firstRoll = 0;
	private Integer secondRoll = 0;
	private Integer thirdRoll = 0;
	private Integer attemps = 0;

	public LastFrame() {
	}

	public void addScore(Integer numberOfPins) throws IllegalArgumentException {
		if (attemps.equals(Integer.valueOf(0))) {
			firstRoll = numberOfPins;
		}
		else {
			if (attemps.equals(Integer.valueOf(1))) {
				if (firstRoll + numberOfPins > Integer.valueOf(11) && !isStrike()) {
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

	public Boolean isDone() {
		return (attemps.equals(Integer.valueOf(3)) || attemps.equals(Integer.valueOf(2)) && !isBonusRoll());
	}

	private Boolean isBonusRoll() {
		return (isSpare() || isStrike());
	}

	public Integer getScore() {
		return firstRoll + secondRoll + thirdRoll;
	}

	public Boolean isSpare() {
		return (!isStrike() && Integer.valueOf(10).equals(firstRoll + secondRoll));
	}

	public Integer getNextRoll() {
		return firstRoll;
	}

	public Boolean isStrike() {
		return (firstRoll.equals(Integer.valueOf(10)));
	}

	public Integer getNextTwoRolls() {
		return firstRoll + secondRoll;
	}

	public void setNextFrame(Frame frame) {
		throw new IllegalStateException();
	}
}
