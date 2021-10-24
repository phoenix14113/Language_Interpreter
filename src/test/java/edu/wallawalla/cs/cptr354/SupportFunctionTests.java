package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SupportFunctionTests extends AbstractTests{
	@Test
	public void testDebug() throws Exception {
		String inputString = "var a = 1.0; debugger;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("{a=1.0}" + System.lineSeparator(), result);
	}

	@Test
	public void testDebugMultipleVariables() throws Exception {
		String inputString = "var a = 1.0; var b = 2.0; debugger;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("{a=1.0, b=2.0}" + System.lineSeparator(), result);
	}

	@Test
	public void testPrint() throws Exception {
		String inputString = "console.log(1.0);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1.0" + System.lineSeparator(), result);
	}

	@Test
	public void testPrintMultiple() throws Exception {
		String inputString = "console.log(1.0); console.log(2.0);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1.0" + System.lineSeparator() + "2.0" + System.lineSeparator(), result);
	}
}
