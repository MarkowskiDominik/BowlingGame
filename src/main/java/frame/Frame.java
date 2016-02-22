package frame;

public interface Frame {

    public void addScore(int numberOfPins);

    public int getScore();

    public Boolean isDone();

    public Boolean isSpare();

    public int getNextRoll();

    public Boolean isStrike();

    public int getNextTwoRolls();

    public void setNextFrame(Frame frame);
}
