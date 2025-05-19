package com.homework;

public class Test_main {

    public static void testAddToArr() {
        
        int index1 = 2, value1 = 101;
        String result1 = Main.addToArr(index1, value1);
        assert result1.equals("The value '101' was successfully added") : "Test failed for index " + index1;
        System.out.println(
                "Test passed for index " + index1 + ". Inserted value: " + value1 + ". Received message: " + result1);

        int index2 = 10, value2 = 202;
        String result2 = Main.addToArr(index2, value2);
        assert result2.equals("You attempted to update an index that does not exist.")
                : "Test failed for index " + index2;
        System.out.println(
                "Test passed for index " + index2 + ". Inserted value: " + value2 + ". Received message: " + result2);

        System.out.println("All tests passed!");
    }

    public static void testAt() {
        int index1 = 2;
        String result1 = Main.at(index1);
        assert result1.equals("33") : "Test failed for index " + index1;
        System.out.println("Test passed for index " + index1 + ". Received message: " + result1);

        int index2 = 10;
        String result2 = Main.at(index2);
        assert result2.equals("Index 10 out of bound.") : "Test failed for index " + index2;
        System.out.println("Test passed for index " + index2 + ". Received message: " + result2);

        System.out.println("All tests passed!");

    }

    public static void testCharAt() {
        int index1 = 1;
        char result1 = Main.charAt(index1);
        assert result1 == 'e' : "Test failed for index " + index1;
        System.out.println("Test passed for index " + index1 + ". Received char: " + result1);

        int index2 = 10;
        char result2 = Main.charAt(index2);
        assert result2 == '\0' : "Test failed for index " + index2;
        System.out.println("Test passed for index " + index2 + ". Received char: " + result2);

        System.out.println("All tests passed!");
    }
}
