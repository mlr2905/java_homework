package com.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;

public class MainTest {

    public static boolean allTestsPassed = true;

    @Test
    void testNullString() {
        try {
            assertEquals(0, Main.stringSize(null), "Length of null string should be 0");
            System.out.println("v testNullString passed");
        } catch (AssertionError e) {
            System.out.println("x testNullString failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testEmptyString() {
        try {
            assertEquals(0, Main.stringSize(""), "Length of empty string should be 0");
            System.out.println("v testEmptyString passed");
        } catch (AssertionError e) {
            System.out.println("x testEmptyString failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testSingleCharacterString() {
        try {
            assertEquals(1, Main.stringSize("a"), "Length of single character string should be 1");
            System.out.println("v testSingleCharacterString passed");
        } catch (AssertionError e) {
            System.out.println("x testSingleCharacterString failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testRegularString() {
        try {
            assertEquals(5, Main.stringSize("hello"), "Length of 'hello' should be 5");
            System.out.println("v testRegularString passed");
        } catch (AssertionError e) {
            System.out.println("x testRegularString failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testLowerCaseString() {
        try {
            String result = Main.convertToUpperCase("hello");
            assertEquals("HELLO", result, "String should be converted to uppercase");
            System.out.println("v testLowerCaseString passed");
        } catch (AssertionError e) {
            System.out.println("x testLowerCaseString failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testStartsWithRegularStrings() {
        try {
            assertTrue(Main.startsWith("world", "worldwide"), "'worldwide' should start with 'world'");
            System.out.println("v testStartsWithRegularStrings passed");
        } catch (AssertionError e) {
            System.out.println("x testStartsWithRegularStrings failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testStartsWithNegativeStrings() {
        try {
            assertFalse(Main.startsWith("Hi", "Hello"), "'Hello' should not start with 'Hi'");
            System.out.println("v testStartsWithNegativeStrings passed");
        } catch (AssertionError e) {
            System.out.println("x testStartsWithNegativeStrings failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testNumberOfApperenceRegularCase() {
        try {
            int result = Main.numberOfApperence("ababab", "ab");
            assertTrue(result == 3, "Expected 3 appearances of 'ab' in 'ababab'");
            System.out.println("v testNumberOfApperenceRegularCase passed");
        } catch (AssertionError e) {
            System.out.println("x testNumberOfApperenceRegularCase failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void testReverseWord() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        try {
            Main.reverseWord("hello world from java");
            String expectedOutput = "java from world hello";
            assertEquals(expectedOutput, baos.toString().trim(), "The words should be reversed");

            System.out.println("v testReverseWord passed");
        } catch (AssertionError e) {
            System.out.println("x testReverseWord failed");
            throw e;
        }
    }

    @Test
    void testIsPalindrome() {
        try {
            String result = Main.isPolindrom("madam");
            assertEquals("Is a palindrome", result, "Expected 'Is a palindrome'");

            System.out.println("✔ testIsPalindrome passed");
        } catch (AssertionError e) {
            System.out.println("✘ testIsPalindrome failed");
            throw e;
        }
    }

    @Test
    void testIsNotPalindrome() {
        try {
            String result = Main.isPolindrom("hello");
            assertEquals("Is a not palindrome", result, "Expected 'Is a not palindrome'");

            System.out.println("✔ testIsNotPalindrome passed");
        } catch (AssertionError e) {
            System.out.println("✘ testIsNotPalindrome failed");
            throw e;
        }
    }

    @Test
    void testIsAnaram_True() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        try {
            Main.isAnaram("listen", "S ilent");
            String expectedOutput = "Strings are anagrams";
            assertEquals(expectedOutput, baos.toString().trim(), "The strings should be anagrams");

            System.out.println("✔ testIsAnaram (True) passed");
        } catch (AssertionError e) {
            System.out.println("✘ testIsAnaram (True) failed");
            throw e;
        }
    }

    @Test
    void testIsAnaram_False() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        try {
            Main.isAnaram("hello", "world");
            String expectedOutput = "Strings are not anagrams";
            assertEquals(expectedOutput, baos.toString().trim(), "The strings should not be anagrams");

            System.out.println("✔ testIsAnaram (False) passed");
        } catch (AssertionError e) {
            System.out.println("✘ testIsAnaram (False) failed");
            throw e;
        }
    }

    @Test
    void testSubstring_ValidRange() {
        try {
            String result = Main.substring("Hello, World!", 7, 12);
            assertEquals("World", result, "Expected 'World'");

            System.out.println("✔ testSubstring_ValidRange passed");
        } catch (AssertionError e) {
            System.out.println("✘ testSubstring_ValidRange failed");
            throw e;
        }
    }

    @Test
    void testSubstring_OutOfBounds() {
        try {
            String result = Main.substring("Hello", 10, 15);
            assertEquals("Error: Ending cut point cannot be greater than the string length.", result,
                    "Expected error message");

            System.out.println("✔ testSubstring_OutOfBounds passed");
        } catch (AssertionError e) {
            System.out.println("✘ testSubstring_OutOfBounds failed");
            throw e;
        }
    }

    @Test
    void testCompress_RepeatedCharacters() {
        try {
            String result = Main.compress("aaaabbbbccccc");
            assertEquals("a4b4c5", result, "Expected 'a4b4c5'");

            System.out.println("✔ testCompress_RepeatedCharacters passed");
        } catch (AssertionError e) {
            System.out.println("✘ testCompress_RepeatedCharacters failed");
            throw e;
        }
    }

    @Test
    void testCompress_NoCompressionNeeded() {
        try {
            String result = Main.compress("hello");
            assertEquals("hello", result, "Expected 'hello'");

            System.out.println("✔ testCompress_NoCompressionNeeded passed");
        } catch (AssertionError e) {
            System.out.println("✘ testCompress_NoCompressionNeeded failed");
            throw e;
        }
    }

    @AfterAll
    public static void testFinalResult() {
        if (allTestsPassed) {
            System.out.println("V All tests passed successfully!");
        } else {
            System.out.println("X Some tests failed!");
        }
    }

}