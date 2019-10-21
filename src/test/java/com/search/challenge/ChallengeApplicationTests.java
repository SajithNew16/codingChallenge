package com.search.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.PrintStream;
import org.mockito.Mockito;
import com.search.challenge.constants.Messages;

@SpringBootTest
class ChallengeApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private ChallengeApplication challenge;
	
	@SuppressWarnings("static-access")
	@Test
	public void testPrintInstructionsOnSearch() {
		PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
		PrintStream old = System.out;
		System.setOut(mockedPrintStream);

		challenge.printInstructionsOnSearch();		
		
		String expected = Messages.SELECT_SEARCH_OPTIONS;
		String expected2 = Messages.PRESS_ONE;
		String expected3 = Messages.PRESS_TWO;
		String expected4 = Messages.EXIT;

		Mockito.verify(mockedPrintStream).println(expected);
		Mockito.verify(mockedPrintStream).println(expected2);
		Mockito.verify(mockedPrintStream).println(expected3);
		Mockito.verify(mockedPrintStream).println(expected4);
	}

}
