package com.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private boolean allTestsPassed = true;

    @Test
    void testAddNumbersBasic() {
        try {
            assertEquals(13, Main.addNumbers(5, 8), "Basic addition failed");
            System.out.println("v testAddNumbersBasic passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersBasic failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersNegative() {
        try {
            assertEquals(-5, Main.addNumbers(-10, 5), "Negative number addition failed");
            System.out.println("v testAddNumbersNegative passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersNegative failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersOverflow() {
        try {
            int result = Main.addNumbers(Integer.MAX_VALUE, 1);
            assertTrue(result == Integer.MAX_VALUE || result == -2147483648, "Overflow handling failed");
            System.out.println("v testAddNumbersOverflow passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersOverflow failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersStringBasic() {
        try {
            assertEquals(13, Main.addNumbers("5", "8"), "String addition failed");
            System.out.println("v testAddNumbersStringBasic passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersStringBasic failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersStringOverflow() {
        try {
            int result = Main.addNumbers(String.valueOf(Integer.MAX_VALUE), "1");
            assertTrue(result == Integer.MAX_VALUE || result == -2147483648, "String overflow handling failed");
            System.out.println("v testAddNumbersStringOverflow passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersStringOverflow failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersStringInvalid() {
        try {
            assertThrows(NumberFormatException.class, () -> Main.addNumbers("abc", "5"), "Invalid string test failed");
            System.out.println("v testAddNumbersStringInvalid passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersStringInvalid failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersIntStringBasic() {
        try {
            assertEquals(13, Main.addNumbers(5, "8"), "Int-String addition failed");
            System.out.println("v testAddNumbersIntStringBasic passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersIntStringBasic failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersIntStringOverflow() {
        try {
            int result = Main.addNumbers(Integer.MAX_VALUE, "1");
            assertTrue(result == Integer.MAX_VALUE || result == -2147483648, "Int-String overflow handling failed");
            System.out.println("v testAddNumbersIntStringOverflow passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersIntStringOverflow failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersIntStringInvalid() {
        try {
            assertThrows(NumberFormatException.class, () -> Main.addNumbers(5, "abc"),
                    "Int-String invalid test failed");
            System.out.println("v testAddNumbersIntStringInvalid passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersIntStringInvalid failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersStringIntBasic() {
        try {
            assertEquals(13, Main.addNumbers("5", 8), "String-Int addition failed");
            System.out.println("v testAddNumbersStringIntBasic passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersStringIntBasic failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersStringIntOverflow() {
        try {
            int result = Main.addNumbers(String.valueOf(Integer.MAX_VALUE), 1);
            assertTrue(result == Integer.MAX_VALUE || result == -2147483648, "String-Int overflow handling failed");
            System.out.println("v testAddNumbersStringIntOverflow passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersStringIntOverflow failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testAddNumbersStringIntInvalid() {
        try {
            assertThrows(NumberFormatException.class, () -> Main.addNumbers("abc", 5),
                    "String-Int invalid test failed");
            System.out.println("v testAddNumbersStringIntInvalid passed");
        } catch (AssertionError e) {
            System.out.println("x testAddNumbersStringIntInvalid failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    public void testAbsPositiveValues() {
        try {
            int[] result = Main.abs(5, 10);
            assertEquals(5, result[0], "num1 should be 5");
            assertEquals(10, result[1], "num2 should be 10");
            System.out.println("v testAbsPositiveValues passed");
        } catch (AssertionError e) {
            System.out.println("x testAbsPositiveValues failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    public void testAbsNegativeValues() {
        try {
            int[] result = Main.abs(-5, -10);
            assertEquals(5, result[0], "num1 should be 5");
            assertEquals(10, result[1], "num2 should be 10");
            System.out.println("v testAbsNegativeValues passed");
        } catch (AssertionError e) {
            System.out.println("x testAbsNegativeValues failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    public void testAbsWithIntegerMinValue() {
        try {
            int[] result = Main.abs(Integer.MIN_VALUE, 5);
            assertEquals(Integer.MAX_VALUE, result[0], "num1 should be Integer.MAX_VALUE due to overflow");
            assertEquals(5, result[1], "num2 should be 5");
            System.out.println("v testAbsWithIntegerMinValue passed");
        } catch (AssertionError e) {
            System.out.println("x testAbsWithIntegerMinValue failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    public void testAbsWithIntegerMaxValue() {
        try {
            int[] result = Main.abs(Integer.MAX_VALUE, -100);
            assertEquals(Integer.MAX_VALUE, result[0], "num1 should be Integer.MAX_VALUE");
            assertEquals(100, result[1], "num2 should be 100");
            System.out.println("v testAbsWithIntegerMaxValue passed");
        } catch (AssertionError e) {
            System.out.println("x testAbsWithIntegerMaxValue failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    public void testAbsWithMixedValues() {
        try {
            int[] result = Main.abs(-Integer.MIN_VALUE, -Integer.MAX_VALUE);
            assertEquals(Integer.MAX_VALUE, result[0], "num1 should be Integer.MAX_VALUE");
            assertEquals(Integer.MAX_VALUE, result[1], "num2 should be Integer.MAX_VALUE");
            System.out.println("v testAbsWithMixedValues passed");
        } catch (AssertionError e) {
            System.out.println("x testAbsWithMixedValues failed");
            allTestsPassed = false;
            throw e;
        }
    }
    
    @Test
    public void testSimpleAddition() {
        try {
            String input = "abc123def456ghi789";
            int result = Main.sumNumbersInString(input);
            assertEquals(1368, result, "Sum should be 1368");
            System.out.println("v testSimpleAddition passed");
        } catch (AssertionError e) {
            System.out.println("x testSimpleAddition failed");
            allTestsPassed = false;
            throw e;
        }
    }
    
    @Test
    public void testExactlyIntegerMaxValue() {
        try {
            String input = "2147483647";
            try {
                Main.sumNumbersInString(input);
                fail("Should throw ArithmeticException");
            } catch (ArithmeticException e) {
                assertEquals("Number is exactly Integer.MAX_VALUE!", e.getMessage());
            }
            System.out.println("v testExactlyIntegerMaxValue passed");
        } catch (AssertionError e) {
            System.out.println("x testExactlyIntegerMaxValue failed");
            allTestsPassed = false;
            throw e;
        }
    }
    
    @Test
    public void testAdditionExceedsMaxValue() {
        try {
            String input = "2147483646 2"; 
            try {
                Main.sumNumbersInString(input);
                fail("Should throw ArithmeticException");
            } catch (ArithmeticException e) {
                assertEquals("Addition would exceed Integer.MAX_VALUE!", e.getMessage());
            }
            System.out.println("v testAdditionExceedsMaxValue passed");
        } catch (AssertionError e) {
            System.out.println("x testAdditionExceedsMaxValue failed");
            allTestsPassed = false;
            throw e;
        }
    }
    
    @Test
    public void testMultipleNumbersApproachingMaxValue() {
        try {
            String input = "1000000000 1000000000 147483646";
            int result = Main.sumNumbersInString(input);
            assertEquals(2147483646, result, "Sum should be 2147483646");
            System.out.println("v testMultipleNumbersApproachingMaxValue passed");
        } catch (AssertionError e) {
            System.out.println("x testMultipleNumbersApproachingMaxValue failed");
            allTestsPassed = false;
            throw e;
        }
    }
    
    @Test
    public void testFinalResult() {
        if (allTestsPassed) {
            System.out.println("✔ All tests passed successfully!");
        } else {
            System.out.println("❌ Some tests failed!");
        }
    }

}