package com.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;

public class MainTest {

    public static boolean allTestsPassed = true;
    

    @AfterAll
    public static void testFinalResult() {
        if (allTestsPassed) {
            System.out.println("V All tests passed successfully!");
        } else {
            System.out.println("X Some tests failed!");
        }
    }

}