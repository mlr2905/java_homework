package com.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean isRunning = true;

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

    public static void backToMenu() {
        String reply = enterStr("\nDo you want to go back to the main menu? [y/n]");
        if (reply.equals("y") || reply.equals("Y")) {
            return;
        } else {
            isRunning = false;
        }
    }

    public static int[] reverse_1(int[] arr) {
        System.out.println("The resulting array: " + Arrays.toString(arr));// O(n)
        int Leng = arr.length;// O(1)

        int[] newarr = new int[Leng];// O(1)
        int i = 0;// O(1)

        for (int index = Leng - 1; index != -1; index--) {// O(n)
            newarr[index] = arr[i];// O(1)
            i++;// O(1)
        }
        return newarr;// O(1)
    }

    public static int[] reverse_2(int[] arr) {
        System.out.println("The resulting array: " + Arrays.toString(arr));// O(n)

        for (int i = 0; i < arr.length / 2; i++) { // O(n)
            int j = arr.length - 1 - i;// O(1)

            int temp = arr[i];// O(1)
            arr[i] = arr[j];// O(1)
            arr[j] = temp;// O(1)
        }
        return arr;// O(1)
    }

    static void timeComplexityReverse_1() {
        String output = String.format("Reverse_1%n" +
                "int Leng = arr.length;                      | O(1)%n" +
                "int[] newarr = new int[Leng];               | O(1)%n" +
                "int i = 0;                                  | O(1)%n" +
                "for (int index = Leng - 1; index != 0; index--)  | O(n-1)%n" +
                "    newarr[index] = arr[i];                 | O(1)%n" +
                "    i++;                                    | O(1)%n" +
                "return newarr;                              | O(1)%n" +
                "-------------------------------------------------%n" +
                "Total time complexity:                      | O(n)%n");
        System.out.println(output);
    }

    static void timeComplexityReverse_2() {
        String output = String.format("%nReverse_2 %n" +
                "for (int i = 0; i < arr.length / 2; i++)    | O(n/2)%n" +
                "    int j = arr.length - 1 - i;             | O(1)%n" +
                "    int temp = arr[i]                       | O(1)%n" +
                "    arr[i] = arr[j];                        | O(1)%n" +
                "    arr[j] = temp;                          | O(1)%n" +
                "return arr;                                 | O(1)%n" +
                "-------------------------------------------------%n" +
                "Total time complexity:                      | O(n)%n");

        System.out.println(output);
    }

    static void time_complexity() {

        String output1 = String.format("Reverse_1%n" + "Total time complexity:| O(n)%n");
        String output2 = String.format("Reverse_2%n" + "Total time complexity:| O(n)%n");
        System.out.println(output1 + output2);
        String response = enterStr(
                "Would you like an explanation of how time complexity is calculated?(y/n)");
        if (response.equals("y") || response.equals("Y")) {
            timeComplexityReverse_1();
            timeComplexityReverse_2();
        }
    }

    static int[] minAndMaxNum(int[] arr) {
        System.out.println("The resulting array: " + Arrays.toString(arr));// O(n)

        return new int[] { arr[0], arr[arr.length - 1] };
    }

    public static boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static int[] bubbleSort(int[] arr) {
        int conter = 0;
        System.out.println("The resulting array: " + Arrays.toString(arr));// O(n)

        if (arr.length == 1) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;

                }
                conter++;

            }
            if (!swapped) {
                break;
            }
        }
        System.out.println("conter: " + conter);
        return arr;
    }

    static int[] avrage(int[][] matrix) {
        int length = matrix.length;
        int ave = 0;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ave += matrix[i][j];
            }
            arr[i] = ave / matrix[i].length;
            ave = 0;
        }
        return arr;

    }

    static int findKth(int[] arr, int k) {
        System.out.println("The resulting array: " + Arrays.toString(arr));// O(n)
        int conter = 0;
        int n = arr.length;
        int i = 0;
        int j = 0;
        while (j != n) {
            if (i >= n - 1) {
                i = 0;

            }
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                j = 0;
            }
            conter++;
            i++;
            j++;
        }
        System.out.println("conter: " + conter);
        System.out.println("This is the array after sorting.: " + Arrays.toString(arr));// O(n)

        return arr[k];

    }

    public static String[] sortByLength(String[] arr) {
        String temp = "";
        boolean bool = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].length() > arr[i + 1].length()) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                bool = true;
            }
        }

        if (bool) {
            sortByLength(arr);
        }
        String[] newArr = new String[arr.length];
        newArr = arr;
        return newArr;

    }

    public static int[] merge(int[] nums1, int[] nums2) {

        int x = nums1.length - nums2.length;

        for (int i = 0; i < nums2.length; i++) {
            nums1[x] = nums2[i];
            x++;
        }
        
        return bubbleSort(nums1);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.toString(reverse_1(new int[] { 1, 2, 3, 4, 5, 6 })));
        while (isRunning) {
            String[] options = {
                    " Tergil 5 A", " Tergil 5 B", " Tergil 5 C", " Tergil 6", " Tergil 7 A.B.C",
                    " Tergil 8", " Tergil 9", " Tergil 10", " Tergil 11", "Tergil 12", "Tergil 13",
                    "Tergil 14", "Tergil 15", "Tergil 16", "Tergil 16"

            };

            System.out.println("\n Select an option from the menu:\n");

            for (int i = 0; i < options.length; i++) {
                System.out.printf("[%d] %s%n", (i + 1), options[i]);
            }

            System.out.print("\nEnter your choice (number): ");

            int type = scanner.nextInt();
            scanner.nextLine();

            switch (type) {
                case 1:
                    System.out.println(
                            "this is the returned array: " + Arrays.toString(reverse_1(new int[] { 1, 3, 5, 7, 9 })));
                    break;
                case 2:
                    System.out.println(
                            "this is the returned array: " + Arrays.toString(reverse_2(new int[] { 2, 4, 6, 8, 10 })));
                    break;
                case 3:
                    time_complexity();
                    break;
                case 4:
                    System.out.println("this is the returned array: "
                            + Arrays.toString(minAndMaxNum(new int[] { 22, 24, 26, 28, 30 })));

                    break;
                case 5:
                    System.out.println(
                            "The function stops when the array is of size 1 or when no operation is performed or when it is already sorted.");
                    System.out.println("this is the returned array: "
                            + Arrays.toString(bubbleSort(new int[] { 1, 33, 69, 4, -665, 7423, 55 })));

                    break;
                case 6:

                    System.out.println("this is the returned array: "
                            + Arrays.toString(avrage(new int[][] {
                                    { 1, 2, 3 },
                                    { 4, 5, 6 },
                                    { 7, 8, 9 }
                            })));

                    break;
                case 7:
                    int[] numArr = { 1, 33, 69, 4, -665, 7423, 55 };
                    System.out.println("This is the number : "
                            + (findKth(numArr, enterNumber(" This is the number "))));
                    break;
                case 8:

                    String[] strArr = { "hello", "world", "java" };
                    System.out.println(Arrays.toString((sortByLength(strArr))));
                    break;
                case 9:
                System.out.println(Arrays.toString(merge(new int[] {1,2,4,0,0,0},new int[] {1,3,6})));
                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:

                    break;
                case 15:

                    break;
                case 16:

                    break;
            }
            backToMenu();

        }

    }
}
