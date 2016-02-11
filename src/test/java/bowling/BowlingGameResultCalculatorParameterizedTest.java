package bowling;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import bowling.BowlingGameResultCalculator;

@RunWith(Parameterized.class)
public class BowlingGameResultCalculatorParameterizedTest {
	enum Type {NO_EXCEPTION, EXCEPTION};

	private BowlingGameResultCalculator bowlingGameresultCalculator;
	private Type type;
	private Integer numberOfZeroRolls;
	private List<Integer> listOfRolls;
	private Integer expectedResult;

	@Before
	public void initializeBowlingGameResultCalculator() {
		bowlingGameresultCalculator = new BowlingGameResultCalculator();
	}

	@After
	public void finalizeBowlingGameResultCalculator() {
		bowlingGameresultCalculator = null;
	}

	public BowlingGameResultCalculatorParameterizedTest(Type type, Integer numberOfZeroRolls,
			List<Integer> listOfRolls, Integer expectedResult) {
		this.type = type;
		this.numberOfZeroRolls = numberOfZeroRolls;
		this.listOfRolls = listOfRolls;
		this.expectedResult = expectedResult;
	}

	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection testedRolls() {
		return Arrays.asList(new Object[][] {
			{ Type.NO_EXCEPTION, 0, Arrays.asList(), 0 },
			{ Type.NO_EXCEPTION, 0, Arrays.asList(0), 0 },
			{ Type.NO_EXCEPTION, 0, Arrays.asList(9), 9 },
			{ Type.NO_EXCEPTION, 0, Arrays.asList(1, 1), 2 },
			{ Type.NO_EXCEPTION, 0, Arrays.asList(9, 1, 9), 28 },
			{ Type.NO_EXCEPTION, 0, Arrays.asList(10, 8, 1), 28 },
			{ Type.NO_EXCEPTION, 0, Arrays.asList(10, 10, 5), 45 },
			{ Type.NO_EXCEPTION, 0, Arrays.asList(10, 10, 10), 60 },
			{ Type.NO_EXCEPTION, 18, Arrays.asList(10, 5, 4), 19 },
			{ Type.NO_EXCEPTION, 18, Arrays.asList(9, 1, 2), 12 },
			{ Type.NO_EXCEPTION, 18, Arrays.asList(7, 2), 9 },
			{ Type.NO_EXCEPTION, 16, Arrays.asList(10, 5, 4), 28 },
			{ Type.NO_EXCEPTION, 16, Arrays.asList(9, 1, 5, 1), 21 },
			{ Type.NO_EXCEPTION, 16, Arrays.asList(7, 2, 5, 4), 18 },
			{ Type.EXCEPTION, 0, Arrays.asList(), 0 },
			{ Type.EXCEPTION, 0, Arrays.asList(-1), 0 },
			{ Type.EXCEPTION, 0, Arrays.asList(11), 0 },
			{ Type.EXCEPTION, 0, Arrays.asList(6, 6), 0 },
			{ Type.EXCEPTION, 20, Arrays.asList(0), 0 }
		});
	}

	@Test
	public void testBowlingGameResultCalculator_NoException() {
		Assume.assumeTrue(type == Type.NO_EXCEPTION);
		// given
		
		// when
		for (int i = 0; i < numberOfZeroRolls; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		for (Integer roll : listOfRolls) {
			bowlingGameresultCalculator.roll(roll);
		}
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(expectedResult, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBowlingGameResultCalculator_Exception() {
		Assume.assumeTrue(type == Type.EXCEPTION);
		// given
		// when
		for (int i = 0; i < numberOfZeroRolls; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		if (listOfRolls.isEmpty()) {
			bowlingGameresultCalculator.roll(null);
		}
		else {
			for (Integer roll : listOfRolls) {
				bowlingGameresultCalculator.roll(roll);
			}
		}
		
		// then
	}
}
