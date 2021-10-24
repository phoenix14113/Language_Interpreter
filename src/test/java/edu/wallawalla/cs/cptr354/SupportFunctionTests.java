package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SupportFunctionTests extends AbstractTests{
	@Test
	public void testDebug() throws Exception {
		String inputString = "var a = 1; debugger;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("{a=1}" + System.lineSeparator(), result);
	}

	@Test
	public void testDebugMultipleVariables() throws Exception {
		String inputString = "var a = 1; var b = 2; debugger;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("{a=1, b=2}" + System.lineSeparator(), result);
	}

	@Test
	public void testPrint() throws Exception {
		String inputString = "console.log(1);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1" + System.lineSeparator(), result);
	}

	@Test
	public void testPrintMultiple() throws Exception {
		String inputString = "console.log(1); console.log(2);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1" + System.lineSeparator() + "2" + System.lineSeparator(), result);
	}
}
