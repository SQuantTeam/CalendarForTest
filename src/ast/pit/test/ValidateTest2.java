package ast.pit.test;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ast.pit.raw.Validate;

import java.util.Arrays;
import java.util.Collection;

//import ast.manual.Validate;

@RunWith(Parameterized.class)
public class ValidateTest2 extends TestCase {

    private int input1;
    private int input2;
    private int input3;
    private boolean expected;
    private int expectedInt;

    public Validate val;
    //public Judgement judgementMock;

    @Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{


			/*
            //isValidDate testcase
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
                //  isValidDate pairwise

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


    public ValidateTest2(int input1, int input2, int input3, boolean expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
        this.expected = expected;
    }

    @Test
    public void testIsValidDate() {
        assertEquals(expected, val.isValidDate(input1, input2, input3));
//		assertEquals(expected, val.isValidDate1(input1, input2, input3));
//		assertEquals(expected, val.isValidDate2(input1, input2, input3));
//		assertEquals(expected, val.isValidDate3(input1, input2, input3));
//		assertEquals(expected, val.isValidDate4(input1, input2, input3));
//		assertEquals(expected, val.isValidDate5(input1, input2, input3));
    }

}
