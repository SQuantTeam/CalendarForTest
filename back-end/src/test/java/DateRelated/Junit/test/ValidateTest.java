package DateRelated.Junit.test;

import static org.junit.Assert.*;

import java.util.Arrays;  
import java.util.Collection;  

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;  
import org.junit.runners.Parameterized.Parameters;

import DateRelated.Validate;

import org.easymock.EasyMock;

import junit.framework.TestCase;

@RunWith(Parameterized.class)
public class ValidateTest extends TestCase{

	private int input1;
	private int input2;
	private int input3;
	private int expected;
	
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
			
			/*
			//isValideDate's testcase
			{2004, 4, 15, true},
			{2004, 4, 29, true},
			{2004, 4, 30, true},
			{2004, 4, 31, false},
			{2004, 4, 0, false},
			{2004, 4, 32, false},
			{2004, 1, 15, true},
			{2004, 1, 29, true},
			{2004, 1, 30, true},
			{2004, 1, 31, true},
			{2004, 1, 0, false},
			{2004, 1, 32, false},
			{2004, 2, 15, true},
			{2004, 2, 29, true},
			{2004, 2, 30, false},
			{2004, 2, 31, false},
			{2004, 2, 0, false},
			{2004, 2, 32, false},
			{2004, 0, 15, false},
			{2004, 0, 29, false},
			{2004, 0, 30, false},
			{2004, 0, 31, false},
			{2004, 0, 0, false},
			{2004, 0, 32, false},
			{2004, 13, 15, false},
			{2004, 13, 29, false},
			{2004, 13, 30, false},
			{2004, 13, 31, false},
			{2004, 13, 0, false},
			{2004, 13, 32, false},
			
			{2005, 4, 15, true},
			{2005, 4, 29, true},
			{2005, 4, 30, true},
			{2005, 4, 31, false},
			{2005, 4, 0, false},
			{2005, 4, 32, false},
			{2005, 1, 15, true},
			{2005, 1, 29, true},
			{2005, 1, 30, true},
			{2005, 1, 31, true},
			{2005, 1, 0, false},
			{2005, 1, 32, false},
			{2005, 2, 15, true},
			{2005, 2, 29, false},
			{2005, 2, 30, false},
			{2005, 2, 31, false},
			{2005, 2, 0, false},
			{2005, 2, 32, false},
			{2005, 0, 15, false},
			{2005, 0, 29, false},
			{2005, 0, 30, false},
			{2005, 0, 31, false},
			{2005, 0, 0, false},
			{2005, 0, 32, false},
			{2005, 13, 15, false},
			{2005, 13, 29, false},
			{2005, 13, 30, false},
			{2005, 13, 31, false},
			{2005, 13, 0, false},
			{2005, 13, 32, false},
			
			{0, 4, 15, false},
			{0, 4, 29, false},
			{0, 4, 30, false},
			{0, 4, 31, false},
			{0, 4, 0, false},
			{0, 4, 32, false},
			{0, 1, 15, false},
			{0, 1, 29, false},
			{0, 1, 30, false},
			{0, 1, 31, false},
			{0, 1, 0, false},
			{0, 1, 32, false},
			{0, 2, 15, false},
			{0, 2, 29, false},
			{0, 2, 30, false},
			{0, 2, 31, false},
			{0, 2, 0, false},
			{0, 2, 32, false},
			{0, 0, 15, false},
			{0, 0, 29, false},
			{0, 0, 30, false},
			{0, 0, 31, false},
			{0, 0, 0, false},
			{0, 0, 32, false},
			{0, 13, 15, false},
			{0, 13, 29, false},
			{0, 13, 30, false},
			{0, 13, 31, false},
			{0, 13, 0, false},
			{0, 13, 32, false}
			*/
			/*
			//pairwise
			{2004, 4, 15, true},
			{2005, 1, 15, true},
			{0, 2, 15, false},
			{2004, 0, 29, false},
			{2005, 13, 0, false},
			{0, 4, 30, false},
			{2004, 1, 31, true},
			{2005, 4, 0, false},
			{0, 1, 32, false},
			{2004, 2, 30, false},
			{2005, 0, 31, false},
			{2004, 13, 0, false},
			{2005, 2, 32, false},
			{0, 0, 0, false},
			{2005, 13, 30, false},
			{0, 4, 29, false},
			{0, 2, 31, false},
			{2004, 0, 32, false},
			{2004, 1, 29, true},
			{0, 13, 15, false},
			{2004, 4, 31, false},
			{2004, 1, 30, true},
			{2004, 2, 0, false},
			{2004, 13, 32, false},
			{2004, 0, 15, false},
			{2004, 4, 32, false},
			{2004, 1, 0, false},
			{2004, 2, 29, true},
			{2004, 0, 31, false},
			{2004, 4, 31, false}
			*/
		});
	}
	
	
    public ValidateTest(int input1, int input2, int expected){  
        this.input1 = input1;  
        this.input2 = input2;
        this.input3 = input3;
        this.expected = expected;
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

	@Test
	public void testSetMaxDay() {
		/*
		EasyMock.expect(judgementMock.isLunarMonth(4)).andReturn(true);
		EasyMock.expect(judgementMock.isLunarMonth(6)).andReturn(true);
		EasyMock.expect(judgementMock.isLunarMonth(9)).andReturn(true);
		EasyMock.expect(judgementMock.isLunarMonth(11)).andReturn(true);
		EasyMock.expect(judgementMock.isLeapYear(2004)).andReturn(true);
		EasyMock.expect(judgementMock.isLeapYear(2005)).andReturn(false);
		EasyMock.replay(judgementMock);
		*/
		assertEquals(expected, val.setMaxDay(input1, input2));
	}


}
