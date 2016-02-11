package bowling;

public interface Frame {

	public void addScore(Integer numberOfPins);
	
	public Integer getScore();

	public Boolean isDone();

	public Boolean isSpare();
	
	public Integer getNextRoll();

	public Boolean isStrike();
	
	public Integer getNextTwoRolls();
	
	public void setNextFrame(Frame frame);
}
