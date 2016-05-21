import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void testSquarePow() {
		double result = Calculator.toSquare(3);
		Assert.assertEquals(9d, result, 0d);
	}

}
