package com.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static boolean test;

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

    static int stringSize(String str) {
        if (str == null) {
            return 0;
        }
        int length = 0;

        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
            return length;
        }
    }

    static String convertToUpperCase(String s) {
        String newStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 96 && s.charAt(i) < 123) {
                newStr += (char) (s.charAt(i) - 32);

            } else {
                newStr += s.charAt(i);
            }

        }
        return newStr;
    }

    static String convertToUpperCase2(String s) {

        return s.toUpperCase();

    }

    static boolean startsWith(String prefix, String s) {

        int length = prefix.length();
        String newString = s.substring(0, length);

        if (newString.equals(prefix)) {
            return true;
        } else {
            return false;
        }

    }

    static int numberOfApperence(String str1, String str2) {

        int leng = str2.length();
        int sum = 0;

        for (int i = 0; i < str1.length() && leng <= str1.length(); i++) {

            String newString = str1.substring(i, leng);
            if (newString.equals(str2)) {
                sum++;
            }
            leng++;
        }
        return sum;
    }

    static void reverseWord(String s) {
        // קיים קוד נוסף קצר יותר עם שימוש במערך ומדותה של סטרינג
        StringBuilder reversestr = new StringBuilder();
        int max = s.length();
        int min = -1;
        int n = 0;
        int x = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int ascii = s.charAt(i);
            n++;
            if (ascii == 32) {
                if (x >= 1) {
                    reversestr.append(" ");
                }
                x++;
                min = i + 1;
                String newString = s.substring(min, max);
                reversestr.append(newString);
                max -= n;
                n = 0;
            }
            if (i == 0) {
                String newString = s.substring(i, max);
                reversestr.append(" ");
                reversestr.append(newString);
            }
        }
        System.out.println(reversestr.toString());

    }

    // קוד קצר יותר
    // static void reverseWord2(String s) {
    // String[] words = s.split(" ");
    // StringBuilder reversedStr = new StringBuilder();
    // for (int i = words.length - 1; i >= 0; i--) {
    // reversedStr.append(words[i]);
    // if (i > 0) {
    // reversedStr.append(" ");
    // }
    // }
    // System.out.println(reversedStr.toString());
    // }

    static String isPolindrom(String str) {
        StringBuilder reversedStr = new StringBuilder(str);

        String streverser = reversedStr.reverse().toString();
        if (str.equals(streverser)) {
            return "Is a palindrome";
        } else {
            return "Is a not palindrome";
        }
    }

    static void isAnaram(String x, String y) {

        x = x.toLowerCase().replaceAll("\\s+", "");
        y = y.toLowerCase().replaceAll("\\s+", "");

        if (x.length() != y.length()) {
            System.out.println("Strings are not anagrams");
            return;
        }

        int[] arr_x = new int[x.length()];
        int[] arr_y = new int[y.length()];

        for (int i = 0; i < x.length() && i < y.length(); i++) {
            if (i < x.length()) {
                arr_x[i] = x.charAt(i);

            }
            if (i < y.length()) {
                arr_y[i] = y.charAt(i);
            }
        }
        Arrays.sort(arr_x);
        Arrays.sort(arr_y);

        boolean areEqual = Arrays.equals(arr_x, arr_y);
        System.out.println((areEqual ? "Strings are anagrams" : "Strings are not anagrams"));

    }

    static String substring(String s, int x, int y) {
        if (x > s.length()) {
            return "Error: Ending cut point cannot be greater than the string length.";

        }
        String newstr = "";
        for (int i = x; i < y; i++) {
            newstr += s.charAt(i);

        }
        return newstr;
    }

    static String compress(String s) {
        int sum = 0;
        String newstr = "";
        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j< s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    sum++;
                } else {
                    break;
                }
            }
            newstr += s.charAt(i) + String.valueOf(sum);
            i += sum - 1;
            sum = 0;
        }
        return newstr.length() < s.length() ? newstr : s;
    }

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            String[] options = {
                    " Tergil 6", " Tergil 7a", " Tergil 7b", " Tergil 8", " Tergil 9",
                    " Tergil 10", " Tergil 11", " Tergil 12", " Tergil 13",
                    " Tergil 14a"
            };

            System.out.println("\n Select an option from the menu:\n");

            for (int i = 0; i < options.length; i++) {
                System.out.println("[" + (i + 1) + "] " + options[i]);
            }

            System.out.print("\nEnter your choice (number): ");

            int type = scanner.nextInt();
            scanner.nextLine();
            String str1 = "Enter a string";
            String str2 = "Enter your name";

            switch (type) {
                case 1:
                    System.out.println(stringSize(enterStr(str1)));
                    break;
                case 2:
                    System.out.println(convertToUpperCase(enterStr(str2)));
                    break;
                case 3:
                    System.out.println(convertToUpperCase2(enterStr(str2)));
                    break;
                case 4:
                    System.out.println(
                            "This function takes two strings and checks if the first string starts with the second string.");
                    System.out.println("result: " + startsWith(enterStr(str1), enterStr(str1)));
                    break;
                case 5:
                    System.out.println(
                            "This function takes two strings and checks if the first string starts with the second string.");
                    System.out.println("result: " + numberOfApperence(
                            enterStr("Enter a string in which you would like to search for a sequence of characters."),
                            enterStr("Enter a sequence of characters to search for in a string.")));
                    break;
                case 6:
                    System.out.println("Enter words with a space.");
                    reverseWord(enterStrLine(str1));
                    break;
                case 7:
                    System.out.println(isPolindrom(enterStr(str1)));
                    break;
                case 8:
                    isAnaram(enterStrLine("Enter first string"), enterStrLine("Enter second string"));
                    break;
                case 9:
                    System.out.println(substring(enterStr(str1), enterNumber("Starting cut point"),
                            enterNumber("Ending cut point")));
                    break;
                case 10:
                    System.out.println(compress(enterStr(str1)));
                    break;
                default:
                    break;
            }
        }
    }
}
