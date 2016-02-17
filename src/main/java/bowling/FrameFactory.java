package src.main.java.bowling;

// REVIEW dmarkowski - Missing comments, please add comments for this class and methods
public class FrameFactory {
    // REVIEW dmarkowski - inaccurate naming, the actual function is creating new frame and not retrieving it as the
    // name imposes
    public static Frame getBowlingGameFrame(Integer numberOfFrame) {
        // REVIEW dmarkowski - magic number 10, please extract to a variable
        if (numberOfFrame.equals(Integer.valueOf(10))) {
            return new LastFrame();
        }
        return new StandardFrame();
    }
}
