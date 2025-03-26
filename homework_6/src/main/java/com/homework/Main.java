package com.homework;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static boolean test;

    static int addNumbers(int x, int y) {
        try {
            return Math.addExact(x, y);
        } catch (Exception e) {
            System.out.println("Error (Tergil 5): integer overflow when adding " + x + " and " + y);

            return (x > 0 && y > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

    }

    int ds = 5;

    char g = '5';
    int h = (int) g;

    static int addNumbers(String x, String y) {
        int num1 = 0, num2 = 0;

        try {
            num1 = Integer.parseInt(x);
        } catch (NumberFormatException e) {
            System.out.println("Error (Tergil 6): cannot parse " + x + " as a number");
            throw e;
        }

        try {
            num2 = Integer.parseInt(y);
        } catch (NumberFormatException e) {
            System.out.println("Error (Tergil 6): cannot parse " + y + " as a number");
            throw e;
        }

        try {
            return Math.addExact(num1, num2);
        } catch (ArithmeticException e) {
            System.out.println("Error (Tergil 6): integer overflow when adding " + num1 + " and " + num2);
            return (num1 > 0 && num2 > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }

    static int addNumbers(int x, String y) {
        int num1 = x, num2 = 0;

        try {
            num2 = Integer.parseInt(y);
        } catch (NumberFormatException e) {
            System.out.println("Error (Tergil 7 a): cannot parse " + y + " as a number");
            throw e;
        }

        try {
            return Math.addExact(num1, num2);
        } catch (ArithmeticException e) {
            System.out.println("Error (Tergil 7 a): integer overflow when adding " + num1 + " and " + num2);
            return (num1 > 0 && num2 > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }

    static int addNumbers(String x, int y) {
        int num1 = 0, num2 = y;

        try {
            num1 = Integer.parseInt(x);
        } catch (NumberFormatException e) {
            System.out.println("Error (Tergil 7 b): cannot parse " + x + " as a number");
            throw e;
        }

        try {
            return Math.addExact(num1, num2);
        } catch (ArithmeticException e) {
            System.out.println("Error (Tergil 7 b): integer overflow when adding " + num1 + " and " + num2);
            return (num1 > 0 && num2 > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }

    static int[] abs(int x, int y) {
        int num1 = (x == Integer.MIN_VALUE) ? Integer.MAX_VALUE : (x < 0) ? -x : x;
        int num2 = (y == Integer.MIN_VALUE) ? Integer.MAX_VALUE : (y < 0) ? -y : y;
        return new int[] { num1, num2 };
    }

    static int sumNumbersInString(String text) {
        int total = 0, currentNumber = 0;
        boolean foundNumber = false;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
                foundNumber = true;
                if (currentNumber == Integer.MAX_VALUE) {
                    throw new ArithmeticException("Number is exactly Integer.MAX_VALUE!");
                }
            } else if (foundNumber) {
                if (currentNumber > 0 && total > Integer.MAX_VALUE - currentNumber) {
                    throw new ArithmeticException("Addition would exceed Integer.MAX_VALUE!");
                }
                total += currentNumber;
                currentNumber = 0;
                foundNumber = false;
            }
        }

        if (foundNumber) {
            if (currentNumber > 0 && total > Integer.MAX_VALUE - currentNumber) {
                throw new ArithmeticException("Addition would exceed Integer.MAX_VALUE!");
            }
            total += currentNumber;
        }

        return total;
    }

    static boolean testSumNumbersInString() {
        boolean allTestsPassed = true;
        int result;

        String input1 = "abc123def456ghi789";
        result = sumNumbersInString(input1);
        if (result != 1368) {
            System.out.println("Test 1: sumNumbersInString() basic addition test failed: expected 1368, got " + result);
            allTestsPassed = false;
        } else {
            System.out.println("Test 1: sumNumbersInString() basic addition test successful");
        }

        String input2 = "2147483647";
        try {
            sumNumbersInString(input2);
            System.out.println("Test 2: sumNumbersInString() exact MAX_VALUE test failed: expected exception");
            allTestsPassed = false;
        } catch (ArithmeticException e) {
            if ("Number is exactly Integer.MAX_VALUE!".equals(e.getMessage())) {
                System.out.println("Test 2: sumNumbersInString() exact MAX_VALUE test successful");
            } else {
                System.out.println(
                        "Test 2: sumNumbersInString() exact MAX_VALUE test failed: wrong message: " + e.getMessage());
                allTestsPassed = false;
            }
        }

        String input3 = "2147483646 2";
        try {
            sumNumbersInString(input3);
            System.out.println("Test 3: sumNumbersInString() exceeding MAX_VALUE test failed: expected exception");
            allTestsPassed = false;
        } catch (ArithmeticException e) {
            if ("Addition would exceed Integer.MAX_VALUE!".equals(e.getMessage())) {
                System.out.println("Test 3: sumNumbersInString() exceeding MAX_VALUE test successful");
            } else {
                System.out.println("Test 3: sumNumbersInString() exceeding MAX_VALUE test failed: wrong message: "
                        + e.getMessage());
                allTestsPassed = false;
            }

        }

        String input4 = "1000000000 1000000000 147483646";
        result = sumNumbersInString(input4);
        if (result != 2147483646) {
            System.out
                    .println("Test 4: sumNumbersInString() approaching MAX_VALUE test failed: expected 2147483646, got "
                            + result);
            allTestsPassed = false;
        } else {
            System.out.println("Test 4: sumNumbersInString() approaching MAX_VALUE test successful");
        }

        if (allTestsPassed) {
            System.out.println("All tests passed successfully!");
        } else {
            System.out.println("Some tests failed!");
        }
        return allTestsPassed;
    }

    static boolean testAbs() throws InterruptedException {
        boolean allTestsPassed = true;

        int[] result;
        result = abs(5, 8);
        if (result[0] != 5 || result[1] != 8) {
            System.out.println("Test 1: abs(int, int) basic positive numbers test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 1: abs(int, int) basic positive numbers test successful");
        }
        Thread.sleep(1000);

        result = abs(-10, 5);
        if (result[0] != 10 || result[1] != 5) {
            System.out.println("Test 2: abs(int, int) one negative number test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 2: abs(int, int) one negative number test successful");
        }
        Thread.sleep(1000);

        result = abs(Integer.MIN_VALUE, 5);
        if (result[0] != Integer.MAX_VALUE || result[1] != 5) {
            System.out.println("Test 3: abs(int, int) Integer.MIN_VALUE handling test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 3: abs(int, int) Integer.MIN_VALUE handling test successful");
        }
        Thread.sleep(1000);

        result = abs(Integer.MAX_VALUE, -10);
        if (result[0] != Integer.MAX_VALUE || result[1] != 10) {
            System.out.println("Test 4: abs(int, int) Integer.MAX_VALUE handling test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 4: abs(int, int) Integer.MAX_VALUE handling test successful");
        }
        Thread.sleep(1000);

        result = abs(-2147483647, 10);
        if (result[0] != 2147483647 || result[1] != 10) {
            System.out.println("Test 5: abs(int, int) Integer.MIN_VALUE + 1 handling test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 5: abs(int, int) Integer.MIN_VALUE + 1 handling test successful");
        }
        Thread.sleep(1000);

        result = abs(0, 0);
        if (result[0] != 0 || result[1] != 0) {
            System.out.println("Test 6: abs(int, int) both zeros test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 6: abs(int, int) both zeros test successful");

        }
        return allTestsPassed;
    }

    static boolean testAdd() throws InterruptedException {

        boolean allTestsPassed = true;
        int maxInt = Integer.MAX_VALUE;
        int result;

        if (addNumbers(5, 8) != 13) {
            System.out.println("Test 1: addNumbers(int, int) basic addition test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 1: addNumbers(int, int) basic addition test successful");
        }
        Thread.sleep(1000);
        if (addNumbers(-10, 5) != -5) {
            System.out.println("Test 2: addNumbers(int, int) negative number test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 2: addNumbers(int, int) negative number test successful");
        }
        Thread.sleep(1000);
        result = addNumbers(maxInt, 1);
        if (result != Integer.MAX_VALUE && result != -2147483648) {
            System.out.println("Test 3: addNumbers(int, int) overflow test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 3: addNumbers(int, int) overflow test successful");
        }
        Thread.sleep(1000);

        if (addNumbers("5", "8") != 13) {
            System.out.println("Test 4: addNumbers(String, String) basic addition test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 4: addNumbers(String, String) basic addition test successful");
        }
        Thread.sleep(1000);

        result = addNumbers(String.valueOf(maxInt), "1");
        if (result != Integer.MAX_VALUE && result != -2147483648) {
            System.out.println("Test 5: addNumbers(String, String) overflow test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 5: addNumbers(String, String) overflow test successful");
        }
        Thread.sleep(1000);

        try {
            addNumbers("abc", "5");
            System.out
                    .println("Test 6: addNumbers(String, String) invalid string test failed - did not throw exception");
            allTestsPassed = false;
        } catch (Exception e) {
            System.out.println("Test 6: addNumbers(String, String) invalid string test successful");
        }
        Thread.sleep(1000);

        if (addNumbers(5, "8") != 13) {
            System.out.println("Test 7: addNumbers(int, String) basic addition test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 7: addNumbers(int, String) basic addition test successful");
        }
        Thread.sleep(1000);

        result = addNumbers(maxInt, "1");
        if (result != Integer.MAX_VALUE && result != -2147483648) {
            System.out.println("Test 8: addNumbers(int, String) overflow test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 8: addNumbers(int, String) overflow test successful");
        }
        Thread.sleep(1000);

        try {
            addNumbers(5, "abc");
            System.out.println("Test 9: addNumbers(int, String) invalid string test failed - did not throw exception");
            allTestsPassed = false;
        } catch (Exception e) {
            System.out.println("Test 9: addNumbers(int, String) invalid string test successful");
        }
        Thread.sleep(1000);

        if (addNumbers("5", 8) != 13) {
            System.out.println("Test 10: addNumbers(String, int) basic addition test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 10: addNumbers(String, int) basic addition test successful");
        }
        Thread.sleep(1000);

        result = addNumbers(String.valueOf(maxInt), 1);
        if (result != Integer.MAX_VALUE && result != -2147483648) {
            System.out.println("Test 11: addNumbers(String, int) overflow test failed");
            allTestsPassed = false;
        } else {
            System.out.println("Test 11: addNumbers(String, int) overflow test successful");
        }
        Thread.sleep(11000);

        try {
            addNumbers("abc", 5);
            System.out.println("Test 12: addNumbers(String, int) invalid string test failed - did not throw exception");
            allTestsPassed = false;
        } catch (Exception e) {
            System.out.println("Test 12: addNumbers(String, int) invalid string test successful");
        }

        return allTestsPassed;

    }

    static int enterNumber() {

        System.out.println("Enter a number");
        int num = scanner.nextInt();
        return num;
    }

    static String enterNumberStr() {

        System.out.println("Enter a number");
        String num = scanner.next();
        return num;
    }

    static void getTestAdd() {
        try {
            test = testAdd();
            if (test) {
                System.out.println("\nAll functions are working correctly!!");
            } else {
                System.out.println(
                        "There is an error in one of the functions - check the output for more details");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void getAbs() {
        while (true) {
            int num1 = enterNumber();
            int num2 = enterNumber();

            int[] result = abs(num1, num2);
            if (result[0] == Integer.MIN_VALUE || result[1] == Integer.MIN_VALUE) {
                if (result[0] == Integer.MIN_VALUE && result[1] == Integer.MIN_VALUE) {
                    System.out.println(
                            "Error: Both numbers are Integer.MIN_VALUE. Please enter valid numbers.");
                } else if (result[0] == Integer.MIN_VALUE) {
                    System.out.println(
                            "Error: The first number is Integer.MIN_VALUE. Please enter valid numbers.");
                } else if (result[1] == Integer.MIN_VALUE) {
                    System.out.println(
                            "Error: The second number is Integer.MIN_VALUE. Please enter valid numbers.");
                }
            } else {
                System.out.println(
                        "The absolute values are: first = " + result[0] + ", second = " + result[1]);
                break;
            }

        }
    }

    static void getTestAbs() {
        try {
            test = testAbs();
            if (test) {
                System.out.println("\nAll functions are working correctly!!");
            } else {
                System.out.println(
                        "There is an error in one of the functions - check the output for more details");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void getSumNumberInString() {
        System.out.println("Enter characters");
        scanner.nextLine();
        String str1 = scanner.nextLine();
        try {
            int sum = sumNumbersInString(str1);
            System.out.println("Total Sum: " + sum);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void getTestSumNumbersInString() {
        try {
            test = testSumNumbersInString();
            if (test) {
                System.out.println("\nAll tests are working correctly!!");
            } else {
                System.out.println(
                        "There is an error in one of the functions - check the output for more details");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void getAddNumbers(Object first, Object second) {
        int x = 0, y = 0;
        boolean validInput = true;
        try {
            if (first instanceof Integer) {
                x = (Integer) first;
            } else if (first instanceof String) {
                x = Integer.parseInt((String) first);
            } else {
                validInput = false;
            }
        } catch (NumberFormatException e) {
            validInput = false;
            System.out.println("Error: First parameter is not a valid number.");
        }

        try {
            if (second instanceof Integer) {
                y = (Integer) second;
            } else if (second instanceof String) {
                y = Integer.parseInt((String) second);
            } else {
                validInput = false;
            }
        } catch (NumberFormatException e) {
            validInput = false;
            System.out.println("Error: Second parameter is not a valid number.");
        }

        if (validInput) {
            try {
                int sum = addNumbers(x, y);
                System.out.println("Sum: " + sum);
            } catch (Exception e) {
                System.out.println("Calculation error: " + e.getMessage());
            }
        }
    }

    public static boolean validateInput(int m, int n) {
        if (n >= m) {
            System.out.println("Error: n must be less than m");
            return false;
        }
        return true;
    }

    public static long multiply(int m, int n) {
        long product = 1;
        for (int i = n; i <= m; i++) {
            product *= i;
        }
        return product;
    }

    static void getTestAddNumbersAndMultiply() {
        while (true) {
            int num1 = enterNumber();
            int num2 = enterNumber();
            if (validateInput(num1, num2)) {
                System.out.println(num1 + "+" + num2 + "=" + addNumbers(num1, num2));
                System.out.println(num1 + "X" + num2 + "=" + multiply(num1, num2));
                break;
            }
        }
    }

    static void sumDigitsUntilSingle() {
        int n = enterNumber();
        int digitSum = 0;
        int flag = n;
        int m = n;

        while (n == m) {
            digitSum += flag % 10;
            System.out.print(digitSum + "+");

            flag /= 10;
            while (flag > 0) {
                System.out.print(flag % 10 + " + ");
                digitSum += flag % 10;
                flag /= 10;

            }
            System.out.println(" = " + digitSum);
            if (digitSum < 10) {
                System.out.println(n + "-> " + digitSum);
                n++;
                flag = n;

            } else {
                flag = digitSum;
            }
            digitSum = 0;
        }
    }

    static int reverseNumber(int a) {
        int reversed = 0;
        while (a != 0) {
            reversed = reversed * 10 + a % 10;
            a /= 10;
        }
        return reversed;
    }

    static int callCount = 0;

    static void bigStack(int n) {

        if (n == Integer.MAX_VALUE) {
            callCount++;
            bigStack(n);
        } else if (n > 0) {
            n--;
            Thread.dumpStack();
            bigStack(n);
        }
    }

    static int sumBetweenA(int m, int n) {
        return n <= m + 1 ? 0 : n - 1 + sumBetweenA(m, n - 1);
    }

    static int sumBetweenB(int m, int n) {
        return (n - 1 - (m + 1) + 1) * (m + 1 + n - 1) / 2;
    }
int[] a= {};


    static void getsumBetween() {
        while (true) {

            System.out.println(
                    "\n There are two types of solutions:\n\n 1. Recursion\n 2. Mathematical calculation.\n\n Which one do you choose?\n\n");
            int option = enterNumber();

            if (option == 1) {
                System.out.println(sumBetweenA(enterNumber(), enterNumber()));

                break;
            } else if (option == 2) {
                System.out.println(sumBetweenB(enterNumber(), enterNumber()));
                break;
            }
            System.out.println("\nOnly the following numbers can be entered: 1 or 2 only\n");
        }
    }

    static boolean testSumBetweenAAndB() {
        return (sumBetweenA(5, 15) == 90 && sumBetweenB(5, 15) == 90) &&
                (sumBetweenA(20, 30) == 225 && sumBetweenB(20, 30) == 225);
    }

    public static void main(String[] args) throws InterruptedException {
   
        while (true) {
            String[] options = {
                    " Tergil 5", " Tergil 6", " Tergil 7a", " Tergil 7b", " Tergil 8 or mvn test", " Tergil 9",
                    " Tergil 9 test", " Tergil 10", " Tergil 10 test", "Tergil 11", "Tergil 12", "Tergil 13",
                    "Tergil 14a", "Tergil 14b"
            };

            System.out.println("Select an option from the menu:\n");

            for (int i = 0; i < options.length; i++) {
                System.out.println("[" + (i + 1) + "] " + options[i]);
            }

            System.out.print("\nEnter your choice (number): ");

            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    addNumbers(enterNumber(), enterNumber());
                    break;
                case 2:
                    addNumbers(enterNumberStr(), enterNumberStr());
                    break;
                case 3:
                    addNumbers(enterNumber(), enterNumberStr());
                    break;
                case 4:
                    addNumbers(enterNumberStr(), enterNumber());
                    break;
                case 5:
                    getTestAdd();
                    break;
                case 6:
                    getAbs();

                    break;
                case 7:
                    getTestAbs();
                    break;
                case 8:
                    getSumNumberInString();
                    break;
                case 9:
                    getTestSumNumbersInString();
                    break;
                case 10:
                    getTestAddNumbersAndMultiply();
                    break;
                case 11:
                    sumDigitsUntilSingle();
                    break;
                case 12:
                    System.out.println(reverseNumber(enterNumber()));
                    break;
                case 13:
                    System.out.println("A function that prints the program’s call stack a chosen number of times.\n");
                    bigStack(enterNumber());

                    break;
                case 14:
                    System.out.println("\n The function causes the stack to fill up until it crashes.\n");
                    try {
                        bigStack(Integer.MAX_VALUE);

                    } catch (StackOverflowError e) {
                        System.out.println("Stack depth reached: " + callCount + "\n");
                    }
                    break;
                case 15:
                    getsumBetween();
                    break;
                case 16:
                    System.out.println("\nWill the tests succeed?\n" + "\nAnd the answer :" + testSumBetweenAAndB()+"\n");
                    break;
                default:
                    break;
            }
        }
    }
}
