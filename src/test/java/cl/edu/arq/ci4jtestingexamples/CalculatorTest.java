package cl.edu.arq.ci4jtestingexamples;
import org.junit.Assert;
import org.junit.Test;

import cl.edu.arq.ci4jtestingexamples.Calculator;

public class CalculatorTest {
	
	@Test
	public void testSquarePow() {
		double result = Calculator.toSquare(3);
		Assert.assertEquals(9d, result, 0d);
	}

}
