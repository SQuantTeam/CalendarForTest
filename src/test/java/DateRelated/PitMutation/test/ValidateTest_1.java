package DateRelated.PitMutation.test;

//import manual.Validate;


import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import DateRelated.Validate;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ValidateTest_1 extends TestCase{
	
	private int input1;
	private int input2;
	private int input3;
	private boolean expected;
	private int expectedInt;
	
	public Validate val;
	//public Judgement judgementMock;
	
	@Parameters
	public static Collection<Object[]> prepareData() {
		return Arrays.asList(new Object[][] {
			
			//setMaxDay's testcase
			{2004, 4, 30},
			{2004, 1, 31},
			{2004, 2, 29},
			{2004, 0, 0},
			{2004, 13, 0},
			{2005, 4, 30},
			{2005, 1, 31},
			{2005, 2, 28},
			{2005, 0, 0},
			{2005, 13, 0},
			

		});
	}
	@Before
	public void setUp() throws Exception {
		super.setUp();
		val = new Validate();
		//judgementMock = EasyMock.createMock(Judgement.class);
	}
	

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public ValidateTest_1(int input1, int input2, int expectedInt) {
		this.input1 = input1;
		this.input2 = input2;
		this.expectedInt = expectedInt;
	}
	@Test
	public void testSetMaxDay() {
		assertEquals(expectedInt, val.setMaxDay(input1, input2));
//		assertEquals(expectedInt, val.setMaxDay1(input1, input2));
//		assertEquals(expectedInt, val.setMaxDay2(input1, input2));
//		assertEquals(expectedInt, val.setMaxDay3(input1, input2));
//		assertEquals(expectedInt, val.setMaxDay4(input1, input2));
//		assertEquals(expectedInt, val.setMaxDay5(input1, input2));
	}
}
