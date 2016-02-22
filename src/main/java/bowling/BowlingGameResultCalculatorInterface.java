package src.main.java.bowling;

// REVIEW dmarkowski - missing comment
// REVIEW dmarkowski - what is the purpose of introducing this interface? For me it is redundant, please follow KISS
// rule
public interface BowlingGameResultCalculatorInterface {

    /**
     * Register a thrown a ball.
     *
     * @param numberOfPins number of knocked down pins
     */
    public void roll(Integer numberOfPins);

    /**
     * @return current game score
     */
    public Integer score();

    /**
     * @return true if a game is over, otherwise false
     */
    public Boolean isFinished();
}
