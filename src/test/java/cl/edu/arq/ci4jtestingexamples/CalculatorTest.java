package cl.edu.arq.ci4jtestingexamples;
import org.junit.Assert;
import org.junit.Test;

import cl.edu.arq.ci4jtestingexamples.Calculator;

public class CalculatorTest {
	
	private Calculator calculator = new Calculator();
	
	@Test
	public void testSquarePow() {
		double result = calculator.toSquare(7);
		Assert.assertEquals(49D, result, 0D);
	}
	
	@Test
	public void testInfiniteSquareRoot() {
		double result = calculator.sqrt(Double.POSITIVE_INFINITY);
		Assert.assertEquals(Double.POSITIVE_INFINITY, result, 0D);
	}
	
	@Test
	public void testNegativeSquareRoot() {
		double result = calculator.sqrt(-1);
		Assert.assertEquals(Double.NaN, result, 0D);
	}
	
	@Test
	public void testZeroSquareRoot() {
		double result = calculator.sqrt(0D);
		Assert.assertEquals(-0D, result, 0D);
	}
	
	@Test
	public void testPerfectSquareRoot() {
		double result = calculator.sqrt(64D);
		Assert.assertEquals(8D, result, 0D);
	}

}
