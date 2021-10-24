package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArthmeticTests extends AbstractTests {

	@Test
	public void testAddition() throws Exception {
		String inputString = "console.log(-5 + 6);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1" + System.lineSeparator(), result);
	}

	@Test
	public void testAdditionVariable() throws Exception {
		String inputString = "var a = 5 + 6; console.log(a);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("11" + System.lineSeparator(), result);
	}
    @Test
	public void testSubtractionVariable() throws Exception {
		String inputString = "var a = 5 - 6; console.log(a);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("-1" + System.lineSeparator(), result);
	}
        @Test
	public void testMultiplicationVariable() throws Exception {
		String inputString = "var a = 3 * 2; console.log(a);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("6" + System.lineSeparator(), result);
	}
    @Test
	public void testDivisionVariable() throws Exception {
		String inputString = "var a = 12 / 6; console.log(a);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("2" + System.lineSeparator(), result);
	}


}
