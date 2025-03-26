package com.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;

public class MainTest {

    public static boolean allTestsPassed = true;
    @Test
    void testAddToArr_Success() {
        try {
            String result = Main.addToArr(2, 202);
            assertEquals("The value '202' was successfully added", result, "Failed to add value correctly");
            System.out.println("V testAddToArr_Success passed");
        } catch (AssertionError e) {
            System.out.println("✘ testAddToArr_Success failed");
            allTestsPassed = false;
            throw e;
        }
    }
    @Test
    void testAddToArr_IndexOutOfBounds() {
        try {
            String result = Main.addToArr(10, 101); 
            assertEquals("You attempted to update an index that does not exist.", result, "Out of bounds message mismatch");
            System.out.println("V testAddToArr_IndexOutOfBounds passed");
        } catch (AssertionError e) {
            System.out.println("✘ testAddToArr_IndexOutOfBounds failed");
            allTestsPassed = false;
            throw e;
        }
    }
    @Test
    void at_Success() {
        try {
            String result = Main.at(2);
            assertEquals("33", result, "Failed to add value correctly");
            System.out.println("V at_Success passed");
        } catch (AssertionError e) {
            System.out.println("✘ at_Success failed");
            allTestsPassed = false;
            throw e;
        }
    }
    @Test
    void at_IndexOutOfBounds() {
        try {
            String result = Main.at(10); 
            assertEquals("Index 10 out of bound.", result, "Out of bounds message mismatch");
            System.out.println("V at_IndexOutOfBounds passed");
        } catch (AssertionError e) {
            System.out.println("✘ at`_IndexOutOfBounds failed");
            allTestsPassed = false;
            throw e;
        }
    }
    @Test
    void charAt_Success() {
        try {
            char result = Main.charAt(1);
            assertEquals('e', result, "Character mismatch at index 1");
            System.out.println("V charAt_Success passed");
        } catch (AssertionError e) {
            System.out.println("✘ charAt_Success failed");
            allTestsPassed = false;
            throw e;
        }
    }

    @Test
    void charAt_IndexOutOfBounds() {
        try {
            char result = Main.charAt(10);
            assertEquals('\0', result, "Out of bounds character mismatch");
            System.out.println("V charAt_IndexOutOfBounds passed");
        } catch (AssertionError e) {
            System.out.println("✘ charAt_IndexOutOfBounds failed");
            allTestsPassed = false;
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