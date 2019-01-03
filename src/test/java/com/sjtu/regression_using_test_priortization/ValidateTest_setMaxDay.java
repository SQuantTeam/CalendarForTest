package com.sjtu.regression_using_test_priortization;

import java.util.Arrays;
import java.util.Collection;  

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;  
import org.junit.runners.Parameterized.Parameters;

import com.sjtu.daterelated.Validate;

import junit.framework.TestCase;

@RunWith(Parameterized.class)
public class ValidateTest_setMaxDay extends TestCase{

	private int input1;
	private int input2;
	private int input3;
	private int expected;
	
	public Validate val;
	//public Judgement judgementMock;
	
	@Parameters
	public static Collection<Object[]> prepareData() {
		return Arrays.asList(new Object[][] {
			{2004, 2, 29},
			{2005, 2, 28},
			
			{2004, 1, 31},
			{2005, 1, 31},
			
			{2004, 4, 30},
			{2005, 4, 30},

			{2005, 13, 0},
			{2004, 13, 0},
			
			{2005, 0, 0},
			{2004, 0, 0},
		});
	}
	
	
    public ValidateTest_setMaxDay(int input1, int input2, int expected){  
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
