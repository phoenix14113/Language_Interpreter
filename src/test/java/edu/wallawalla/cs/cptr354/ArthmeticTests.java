package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArthmeticTests extends AbstractTests {

	@Test
	public void testAddition() throws Exception {
		String inputString = "console.log(-5.0 + 6.0);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1.0" + System.lineSeparator(), result);
	}

	@Test
	public void testAdditionVariable() throws Exception {
		String inputString = "var a = 5.0 + 6.0; console.log(a);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("11.0" + System.lineSeparator(), result);
	}
    @Test
	public void testSubtractionVariable() throws Exception {
		String inputString = "var a = 5.0 - 6.0; console.log(a);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("-1.0" + System.lineSeparator(), result);
	}
    @Test
	public void testMultiplicationVariable() throws Exception {
		String inputString = "var a = 3.0 * 2.0; console.log(a);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("6.0" + System.lineSeparator(), result);
	}
    @Test
	public void testDivisionVariable() throws Exception {
		String inputString = "var a = 12.0 / 6.0; console.log(a);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("2.0" + System.lineSeparator(), result);
	}
    @Test
	public void testSqrtVariable() throws Exception {
		String inputString = "var a = sqrt(81.0); console.log(a);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("9.0" + System.lineSeparator(), result);
	}
    @Test
	public void orderOfOpTest() throws Exception {
		String inputString = "var a = 1.0 + 3.0 * 2.0 / 6.0 + 2.0; console.log(a);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("4.0" + System.lineSeparator(), result);
	}
    @Test
    public void QuadraticTest() throws Exception {
		String inputString = "var a = 1.0; var b = 2.0; var c = 1.0; var solution = (-b + sqrt(b * b - 4.0 * a * c))/(2.0 * a); console.log(solution);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("-1.0" + System.lineSeparator(), result);
	}

}
