package com.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int arrLength = 10;
    static int[] arr = new int[arrLength];
    static int[] numArr = { 54, 85, 33, 98, 77, 45, 68, 88, 101 };
    static char[] chArr = { 'h', 'e', 'l', 'l', 'o', ' ', 'a', 'r', 'r', 'a', 'y' };
    static int[] numArrCh = { 5, 8, 3, 9, 7 };
    static boolean isRunning = true;

    static String enterStrLine(String t) {

        System.out.println(t);
        String s = scanner.nextLine();

        return s;
    }

    static String enterStr(String t) {

        System.out.println(t);

        String s = scanner.next();

        return s;
    }

    static int enterNumber(String t) {

        System.out.println(t);
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    static void backToMenu() {
        String reply = enterStr("\nDo you want to go back to the main menu? [y/n]");
        if (reply.equals("y") || reply.equals("Y")) {
            return;
        } else {
            isRunning = false;
        }
    }

    public static String addToArr(int i, int val) {
        try {
            arr[i] = val;
            return String.format("The value '%-2s' was successfully added", val);

        } catch (Exception e) {

            return "You attempted to update an index that does not exist.";
        }

    }

    public static String at(int i) {
        try {
            return String.valueOf(numArr[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return String.format("Index %d out of bound.", i);
        }
    }

    public static char charAt(int i) {
        try {
            return chArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Index %d out of bound.%n", i);
            return '\0';
        }
    }

    public static void printArray() {

        for (int i = 0; i < chArr.length; i++) {
            System.out.print(chArr[i]);
        }
    }

    public static void intArrPrintArray() {
        for (int i = 0; i < numArr.length; i++) {
            char ch = (char) numArr[i];
            System.out.print(ch);
        }
    }

    public static void duplicate(int x) {
        for (int index = 0; index < numArr.length; index++) {
            if (index == 0) {
                System.out.print("{");
            }
            if (index > 1 && index < numArr.length - 1) {
                System.out.print(numArr[index] * x + ", ");

            }
            if (index == numArr.length - 1) {
                System.out.print(numArr[index] * x);

                System.out.print("}\n");
            }
        }

    }

    public static int findIndex(int i) {
        for (int index = 0; index < numArrCh.length; index++) {
            if (numArrCh[index] == i) {
                return index;
            }
        }
        return -1;
    }

    public static boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int findSmallest(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        if (arr.length == 1 || isSorted(arr)) {
            return arr[0];
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        if (arr.length == 1 || isSorted(arr)) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] findMaxSumPair(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int[] maxPair = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i] + arr[i + 1];

            if (sum > maxSum) {
                maxSum = sum;
                maxPair[0] = arr[i];
                maxPair[1] = arr[i + 1];
            }
        }

        return maxPair;
    }

    // public static int findDuplicate(int[] arr) {
    // for (int i = 0; i < arr.length; i++) {
    // for (int j = 0; j < i; j++) {
    // if (arr[i] == arr[j] && i != j) {
    // return arr[i];
    // }
    // }
    // }
    // return 0;
    // }

    public static int findDuplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return arr[i];
            }
        }
        return 0;
    }

    public static int findMissing(int[] arr) {
        int n = arr.length + 1;
        int sum = (n * (1 + n)) / 2;
        int sumArr = 0;

        for (int i = 0; i < arr.length; i++) {
            sumArr += arr[i];
        }
        return sum - sumArr;
    }

    public static int[] findNoDuplicate(int[] arr, int n, int x, int[] result) {
        if (n >= arr.length) {
            return result;
        }

        boolean exist = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[n] == arr[i] && n != i) {
                exist = true;
                break;
            }
        }

        if (!exist) {
            result[x] = arr[n];
            x++;
        }

        return findNoDuplicate(arr, n + 1, x, result);
    }

    public static void main(String[] args) throws InterruptedException {
      

        while (isRunning) {
            String[] options = {
                    " Tergil 3", " Tergil 3 test", " Tergil 4", " Tergil 4 test", " Tergil 5",
                    " Tergil 5 test", " Tergil 6", " Tergil 7", " Tergil 8", " Tergil 9", " Tergil 10",
                    " Tergil 11", " Tergil 12", " Tergil 15", " Tergil 16"

            };

            System.out.println("\n Select an option from the menu:\n");

            for (int i = 0; i < options.length; i++) {
                System.out.printf("[%d] %s%n", (i + 1), options[i]);
            }

            System.out.print("\nEnter your choice (number): ");

            int type = scanner.nextInt();
            scanner.nextLine();
            String str1 = "Enter a string";
            String str2 = "Enter your name";

            switch (type) {
                case 1:
                    System.out.println("You chose exercise number 3, which assigns numbers until an overflow occurs.");
                    for (int i = 0; i <= arr.length; i++) {
                        System.out.println(addToArr(i, (i + 1) * 3));

                    }
                    break;
                case 2:
                    Test_main.testAddToArr();
                    break;
                case 3:
                    System.out.println(at(enterNumber("Enter an index to print.")));
                    break;
                case 4:
                    System.out.printf(
                            "The test checks this array: %s \n The indexes that exist in it are from 0 to %d\n",
                            Arrays.toString(numArr), numArr.length - 1);
                    Test_main.testAt();
                    break;
                case 5:
                    System.out.println(charAt(enterNumber("Enter an index to print.")));

                    break;
                case 6:
                    System.out.printf(
                            "The test checks this array: %s \n The indexes that exist in it are from 0 to %d\n",
                            Arrays.toString(chArr), chArr.length - 1);
                    Test_main.testCharAt();
                    break;
                case 7:
                    printArray();
                    break;
                case 8:
                    intArrPrintArray();
                    break;
                case 9:
                    System.out.println("This is an array:\n" + Arrays.toString(numArr));
                    duplicate(enterNumber("Enter a product"));
                    break;
                case 10:
                    System.out.println("The function returns the index of a number in an array or '-1' if not found.");
                    System.out.println(
                            "The number is located at: " + findIndex(enterNumber("Enter a number to search for.")));
                    break;
                case 11:
                    System.out.println(findSmallest(new int[] { 22, 5, 88, 74, 999, -988, -4 }));
                    break;
                case 12:
                    System.out.println(Arrays.toString(sort(new int[] { 22, 554, 989, 5, -88 })));
                    break;
                case 13:
                    System.out.println(Arrays.toString(findMaxSumPair(new int[] { 2, 45, 7, 77, -8, 55, 74 })));
                    break;
                case 14:
                    System.out.println(findDuplicate(new int[] { 1, 4, 9, 7, 55, 74, 2, 4 }));
                    break;
                case 15:
                    System.out.println(findMissing(new int[] { 1, 2, 3, 4, 5, 6, 7, 9 }));
                    break;
                case 16:
                    int[] arr = { 5, 2, 3, 3, 5, 7, 1, 7 };
                    int[] result = new int[arr.length];

                    System.out.println(Arrays.toString(findNoDuplicate(arr, 0, 0, result)));
                    break;
            }
            backToMenu();

        }

    }
}
