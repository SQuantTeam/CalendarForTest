package regression_using_test_priortization;

import java.util.Arrays;
import java.util.Collection;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import daterelated.ComputeDate;
import junit.framework.TestCase;
import mock.ValidateMock;

@RunWith(Parameterized.class)
public class ComputeDateTest_getYearOfNextDay extends TestCase{

	private int input1;
	private int input2;
	private int input3;
	private int expected;
	
	public ValidateMock valMock;
	public ComputeDate computeDate;

	@Parameters
	public static Collection<Object[]> prepareData() {
		return Arrays.asList(new Object[][] {
			{2004, 12, 31, 2005},
			
			{2004, 2, 29, 2004},
			{2004, 1, 31, 2004},
			{2005, 4, 30, 2005},
			
			{2004, 4, 15, 2004},
			{2005, 1, 15, 2005},
			{2004, 12, 28, 2004},
			{2004, 1, 29, 2004},
			{2004, 12, 15, 2004},
			{2004, 4, 28, 2004},
//			{2004, 12, 29, 2004},
//			{2004, 1, 28, 2004},
//			{2004, 4, 29, 2004},
//			{2004, 2, 28, 2004},
//			{2004, 12, 30, 2004},	
			
//			{2004, 0, 15, 0},
//			{2004, 13, 31, 0},
//			{2004, 13, 32, 0},
//			{0, 2, 15, 0},
//			{2005, 0, 28, 0},
//			{0, 13, 28, 0},
//			{0, 4, 31, 0},
//			{2004, 2, 0, 0},
//			{2005, 12, 32, 0},
//			{0, 0, 29, 0},
//			{2004, 13, 30, 0},
//			{2004, 2, 32, 0},
//			{0, 12, 0, 0},
//			{2005, 13, 29, 0},
//			{2004, 0, 30, 0},
//			{2005, 4, 0, 0},
//			{0, 1, 32, 0},
//			{2005, 2, 31, 0},
//			{2004, 0, 31, 0},
//			{2004, 13, 0, 0},
//			{0, 1, 30, 0},
//			{2004, 0, 32, 0},
//			{2004, 13, 15, 0},
//			{2004, 4, 32, 0},
//			{2004, 2, 30, 0},
//			{2004, 0, 0, 0},
//			{2004, 1, 0, 0},
		});
	}
	
	public ComputeDateTest_getYearOfNextDay(int input1, int input2, int input3, int expected){  
        this.input1 = input1;  
        this.input2 = input2;
        this.input3 = input3;
        this.expected = expected;
    } 
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		valMock = EasyMock.createMock(ValidateMock.class);
		computeDate = new ComputeDate(valMock);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testGetYearOfNextDay() {
		EasyMock.expect(valMock.isValidDate(2004, 4, 15)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 4, 29)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 4, 30)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 4, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 4, 28)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 4, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 4, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 1, 15)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 1, 29)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 1, 30)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 1, 31)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 1, 28)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 1, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 1, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 2, 15)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 2, 29)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 2, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 2, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 2, 28)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 2, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 2, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 12, 15)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 12, 29)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 12, 30)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 12, 31)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 12, 28)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004, 12, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 12, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 0, 15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 0, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 0, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 0, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 0, 28)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 0, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 0, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 13, 15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 13, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 13, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 13, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 13, 28)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 13, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004, 13, 32)).andReturn(false);
		
		EasyMock.expect(valMock.isValidDate(2005, 4, 15)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 4, 29)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 4, 30)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 4, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 4, 28)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 4, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 4, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 1, 15)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 1, 29)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 1, 30)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 1, 31)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 1, 28)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 1, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 1, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 2, 15)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 2, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 2, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 2, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 2, 28)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 2, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 2, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 12, 15)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 12, 29)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 12, 30)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 12, 31)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 12, 28)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005, 12, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 12, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 0, 15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 0, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 0, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 0, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 0, 28)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 0, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 0, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 13, 15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 13, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 13, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 13, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 13, 28)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 13, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005, 13, 32)).andReturn(false);
		
		EasyMock.expect(valMock.isValidDate(0, 4, 15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 4, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 4, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 4, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 4, 28)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 4, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 4, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 1, 15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 1, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 1, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 1, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 1, 28)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 1, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 1, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 2, 15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 2, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 2, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 2, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 2, 28)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 2, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 2, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 12, 15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 12, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 12, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 12, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 12, 28)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 12, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 12, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 0, 15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 0, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 0, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 0, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 0, 28)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 0, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 0, 32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 13, 15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 13, 29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 13, 30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 13, 31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 13, 28)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 13, 0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0, 13, 32)).andReturn(false);
		
		EasyMock.expect(valMock.setMaxDay(2004, 4)).andReturn(30);
		EasyMock.expect(valMock.setMaxDay(2004, 1)).andReturn(31);
		EasyMock.expect(valMock.setMaxDay(2004, 2)).andReturn(29);
		EasyMock.expect(valMock.setMaxDay(2004, 12)).andReturn(31);
		EasyMock.expect(valMock.setMaxDay(2004, 0)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(2004, 13)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(2005, 4)).andReturn(30);
		EasyMock.expect(valMock.setMaxDay(2005, 1)).andReturn(31);
		EasyMock.expect(valMock.setMaxDay(2005, 2)).andReturn(28);
		EasyMock.expect(valMock.setMaxDay(2005, 12)).andReturn(31);
		EasyMock.expect(valMock.setMaxDay(2005, 0)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(2005, 13)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 4)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 1)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 2)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 12)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 0)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 13)).andReturn(0);
		EasyMock.replay(valMock);
		
		assertEquals(expected, computeDate.getYearOfNextDay(input1, input2, input3));
	}

}