package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArthmeticFileTests extends AbstractTests {

	@Test
	public void testAddition() throws Exception {
		String input = readFileToString("BasicArthmetic.txt");
		String expected = readFileToString("BasicArthmeticResult.txt");
		String result = runInterpreter(input);
		assertEquals(expected, result);
	}

}
