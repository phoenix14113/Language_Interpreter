package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SupportFunctionTests extends AbstractTests{
	@Test
	public void testDebug() throws Exception {
		String inputString = "a = 1; DEBUG;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("{a=1}" + System.lineSeparator(), result);
	}

	@Test
	public void testDebugMultipleVariables() throws Exception {
		String inputString = "a = 1; b = 2; DEBUG;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("{a=1, b=2}" + System.lineSeparator(), result);
	}

	@Test
	public void testPrint() throws Exception {
		String inputString = "PRINT 1;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1" + System.lineSeparator(), result);
	}

	@Test
	public void testPrintMultiple() throws Exception {
		String inputString = "PRINT 1; PRINT 2;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1" + System.lineSeparator() + "2" + System.lineSeparator(), result);
	}
}
