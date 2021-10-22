package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArthmeticTests extends AbstractTests {

	@Test
	public void testAddition() throws Exception {
		String inputString = "PRINT -5 + 6;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1" + System.lineSeparator(), result);
	}

	@Test
	public void testAdditionVariable() throws Exception {
		String inputString = "a = 5 + 6; PRINT a;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("11" + System.lineSeparator(), result);
	}
    @Test
	public void testSubtractionVariable() throws Exception {
		String inputString = "a = 5 - 6; PRINT a;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("-1" + System.lineSeparator(), result);
	}

}
