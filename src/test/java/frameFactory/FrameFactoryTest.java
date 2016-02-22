package frameFactory;

import static org.junit.Assert.*;

import org.junit.Test;

import frame.Frame;
import frame.LastFrame;
import frame.StandardFrame;

/**
 * @author Dominik Markowski
 *
 * {@link FrameFactory}
 */
public class FrameFactoryTest {

	@Test
	public void shouldReturnStandardFrameForNumberOfFrameEqualsThree() {
		//given
		Frame expected = new StandardFrame();
		int numberOfFrame = 3;
		//when
		Frame actual = FrameFactory.createBowlingGameFrame(numberOfFrame);
		//then
		assertEquals(expected.getClass(), actual.getClass());
	}
	
	@Test
	public void shouldReturnLastFrameForNumberOfFrameEqualsTeen() {
		//given
		Frame expected = new LastFrame();
		int numberOfFrame = 10;
		//when
		Frame actual = FrameFactory.createBowlingGameFrame(numberOfFrame);
		//then
		assertEquals(expected.getClass(), actual.getClass());
	}

}
