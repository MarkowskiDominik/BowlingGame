package bowling;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bowling.BowlingGameResultCalculator;

public class BowlingGameResultCalculatorTest {

	private BowlingGameResultCalculator bowlingGameresultCalculator;

	@Before
	public void initializeBowlingGameResultCalculator() {
		bowlingGameresultCalculator = new BowlingGameResultCalculator();
	}

	@After
	public void finalizeBowlingGameResultCalculator() {
		bowlingGameresultCalculator = null;
	}

	@Test
	public void shouldReturn_0_ForNoRoll() {
		// given
		// when
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(0), result);
	}

	@Test
	public void shouldReturn_0_ForRoll_0() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(0));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(0), result);
	}

	@Test
	public void shouldReturn_9_ForRoll_9() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(9));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(9), result);
	}

	@Test
	public void shouldReturn_2_ForRolls_1_1() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(2), result);
	}

	@Test
	public void shouldReturn_28_ForRolls_9_1_9() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(9));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		bowlingGameresultCalculator.roll(Integer.valueOf(9));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(28), result);
	}

	@Test
	public void shouldReturn_28_ForRolls_10_8_1() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(8));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(28), result);
	}

	@Test
	public void shouldReturn_45_ForRolls_10_10_5() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(5));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(45), result);
	}

	@Test
	public void shouldReturn_60_ForRolls_10_10_10() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(60), result);
	}
	
	@Test
	public void shouldReturn_19_ForEightenRollsZeroAndLastFrameRolls_10_5_4() {
		// given
		// when
		for (int i = 0; i < 18; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(5));
		bowlingGameresultCalculator.roll(Integer.valueOf(4));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(19), result);
	}

	@Test
	public void shouldReturn_12_ForEightenRollsZeroAndLastFrameRolls_9_1_2() {
		// given
		// when
		for (int i = 0; i < 18; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		bowlingGameresultCalculator.roll(Integer.valueOf(9));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		bowlingGameresultCalculator.roll(Integer.valueOf(2));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(12), result);
	}

	@Test
	public void shouldReturn_9_ForEightenRollsZeroAndLastFrameRolls_7_2() {
		// given
		// when
		for (int i = 0; i < 18; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		bowlingGameresultCalculator.roll(Integer.valueOf(7));
		bowlingGameresultCalculator.roll(Integer.valueOf(2));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(9), result);
	}

	@Test
	public void shouldReturn_28_ForSixtenRollsZeroAndTwoLastFrameRolls_10_5_4() {
		// given
		// when
		for (int i = 0; i < 16; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(5));
		bowlingGameresultCalculator.roll(Integer.valueOf(4));
		Integer result = bowlingGameresultCalculator.score();
		
		// then
		assertEquals(Integer.valueOf(28), result);
	}
	
	@Test
	public void shouldReturn_21_ForEightenRollsZeroAndTwoLastFrameRolls_9_1_5_1() {
		// given
		// when
		for (int i = 0; i < 16; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		bowlingGameresultCalculator.roll(Integer.valueOf(9));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		bowlingGameresultCalculator.roll(Integer.valueOf(5));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		Integer result = bowlingGameresultCalculator.score();
		
		// then
		assertEquals(Integer.valueOf(21), result);
	}
	
	@Test
	public void shouldReturn_18_ForEightenRollsZeroAndTwoLastFrameRolls_7_2_5_4() {
		// given
		// when
		for (int i = 0; i < 16; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		bowlingGameresultCalculator.roll(Integer.valueOf(7));
		bowlingGameresultCalculator.roll(Integer.valueOf(2));
		bowlingGameresultCalculator.roll(Integer.valueOf(5));
		bowlingGameresultCalculator.roll(Integer.valueOf(4));
		Integer result = bowlingGameresultCalculator.score();
		
		// then
		assertEquals(Integer.valueOf(18), result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldReturn_Exception_ForNullRoll() {
		// given
		// when
		bowlingGameresultCalculator.roll(null);

		// then
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldReturn_Exception_ForRoll_Minus1() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(-1));

		// then
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldReturn_Exception_ForRoll_11() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(11));

		// then
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldReturn_Exception_ForRoll_6_6() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(6));
		bowlingGameresultCalculator.roll(Integer.valueOf(6));

		// then
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldReturn_Exception_ForToManyRolls() {
		// given
		// when
		for (int i = 0; i < 20; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		bowlingGameresultCalculator.roll(Integer.valueOf(0));

		// then
	}
}