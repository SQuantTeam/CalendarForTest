package com.sjtu.daterelated;

import java.util.Arrays;
import java.util.Collection;

import com.sjtu.mock.ValidateMock;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.TestCase;
import com.sjtu.daterelated.ComputeDate;

@RunWith(Parameterized.class)
public class ComputeDateTest_getTheDateAfterAFewDays extends TestCase{

	private int input1, input2, input3, input4;
	private String expected;

	public ComputeDate computeDateMock;
	public ValidateMock valMock;

	@Parameters
	public static Collection<Object[]> prepareData() {
		return Arrays.asList(new Object[][] {
				// pairwise
				{2004, 4, 15, 0, "2004-4-15"},
				{2005, 1, 15, 15, "2005-1-30"},
				{0, 2, 15, -15, "0"},
				{2004, 0, 29, 15, "0"},
				{2005, 13, 29, 0, "0"},
				{0, 1, 30, 0, "0"},
				{2004, 1, 31, -15, "0"},
				{2005, 4, 0, -15, "0"},
				{2004, 2, 32, 0, "0"},
				{0, 0, 31, 0, "0"},
				{2004, 13, 30, 15, "0"},
				{0, 4, 32, 15, "0"},
				{2004, 2, 0, 15, "0"},
				{2005, 0, 30, -15, "0"},
				{2005, 13, 31, 15, "0"},
				{0, 4, 29, -15, "0"},
				{0, 1, 0, 0, "0"},
				{2005, 0, 32, -15, "0"},
				{2005, 2, 29, 0, "0"},
				{0, 13, 15, -15, "0"},
				{2004, 4, 30, 0, "2004-4-30"},
				{2004, 1, 32, 0, "0"},
				{2004, 2, 31, 0, "0"},
				{2004, 0, 0, 0, "0"},
				{2004, 4, 31, 0, "0"},
				{2004, 1, 29, 0, "2004-1-29"},
				{2004, 2, 30, 0, "0"},
				{2004, 0, 15, 0, "0"},
				{2004, 13, 0, 0, "0"},
				{2004, 13, 32, 0, "0"},
		});
	}

	public ComputeDateTest_getTheDateAfterAFewDays(int input1, int input2, int input3, int input4, String expected){
		this.input1 = input1;
		this.input2 = input2;
		this.input3 = input3;
		this.input4 = input4;
        this.expected = expected;
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		valMock = EasyMock.createMock(ValidateMock.class);
		computeDateMock = new ComputeDate(valMock);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void test() {

		EasyMock.expect(valMock.isValidDate(2004,4,15)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005,1,15)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(0,2,15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,0,29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005,13,29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0,1,30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,1,31)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2005,4,0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,2,32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0,0,31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,13,30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0,4,32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,2,0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005,0,30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005,13,31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0,4,29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0,1,0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005,0,32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2005,2,29)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(0,13,15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,4,30)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004,1,32)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,2,31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,0,0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,4,31)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,1,29)).andReturn(true);
		EasyMock.expect(valMock.isValidDate(2004,2,30)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,0,15)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,13,0)).andReturn(false);
		EasyMock.expect(valMock.isValidDate(2004,13,32)).andReturn(false);
		EasyMock.replay(valMock);

		assertEquals(expected, computeDateMock.getTheDateAfterAFewDays(input1, input2, input3, input4));
	}

}
