package com.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Class for analyzing runtime complexity of algorithms
 */
public class RuntimeComplexityAnalyzer {

    /**
     * Analyzes the runtime complexity of an algorithm by measuring execution times
     * for inputs of different sizes, and tries to infer the time complexity.
     * 
     * @param algorithm The function to be analyzed
     * @param inputSizeGenerator Function that generates input of a specified size
     * @param sizes Array of input sizes for which measurements will be performed
     * @param repetitions Number of repetitions for each input size (for more accurate average)
     */
    public static <T> void analyzeTimeComplexity(
            Function<T, ?> algorithm,
            Function<Integer, T> inputSizeGenerator,
            int[] sizes,
            int repetitions) {
        
        System.out.println("=== Runtime Complexity Analysis ===");
        System.out.println("Input Size | Runtime (milliseconds) | Ratio");
        System.out.println("------------------------------------------");
        
        List<Long> times = new ArrayList<>();
        
        for (int size : sizes) {
            T input = inputSizeGenerator.apply(size);
            
            // Warm up JVM before measurement
            for (int i = 0; i < 3; i++) {
                algorithm.apply(input);
            }
            
            // Measure execution time
            long startTime = System.nanoTime();
            for (int i = 0; i < repetitions; i++) {
                algorithm.apply(input);
            }
            long endTime = System.nanoTime();
            
            long avgTime = (endTime - startTime) / repetitions / 1_000_000; // Convert to milliseconds
            times.add(avgTime);
            
            // Display current measurement
            String ratio = times.size() > 1 
                ? String.format("%.2f", (double) avgTime / times.get(times.size() - 2))
                : "-";
            
            System.out.printf("%-10d | %-22d | %s%n", size, avgTime, ratio);
        }
        
        // Try to infer time complexity
        estimateComplexity(sizes, times);
    }
    
    /**
     * Tries to infer the time complexity based on measurements
     */
    private static void estimateComplexity(int[] sizes, List<Long> times) {
        if (sizes.length < 3 || times.size() < 3) {
            System.out.println("\nNot enough measurements to infer complexity");
            return;
        }
        
        // Calculate growth ratios of time relative to input size growth
        double[] ratios = new double[times.size() - 1];
        for (int i = 1; i < times.size(); i++) {
            double sizeRatio = (double) sizes[i] / sizes[i - 1];
            double timeRatio = (double) times.get(i) / times.get(i - 1);
            ratios[i - 1] = timeRatio / sizeRatio;
        }
        
        // Calculate average ratio
        double avgRatio = 0;
        for (double ratio : ratios) {
            avgRatio += ratio;
        }
        avgRatio /= ratios.length;
        
        System.out.println("\n--- Summary ---");
        System.out.println("Average growth ratio: " + String.format("%.2f", avgRatio));
        
        // Infer complexity based on the ratio
        if (avgRatio < 1.1) {
            System.out.println("Estimated complexity: O(1) - Constant time");
        } else if (avgRatio < 1.3) {
            System.out.println("Estimated complexity: O(log n) - Logarithmic");
        } else if (avgRatio < 2.0) {
            System.out.println("Estimated complexity: O(n) - Linear");
        } else if (avgRatio < 3.0) {
            System.out.println("Estimated complexity: O(n log n)");
        } else if (avgRatio < 5.0) {
            System.out.println("Estimated complexity: O(n²) - Quadratic");
        } else if (avgRatio < 9.0) {
            System.out.println("Estimated complexity: O(n³) - Cubic");
        } else {
            System.out.println("Estimated complexity: O(2^n) - Exponential or worse");
        }
    }
    
    /**
     * Example usage - analyzing array reversal algorithm
     */
    public static void main(String[] args) {
        // Example for analyzing array reversal algorithm
        Function<int[], int[]> reverseArray = arr -> {
            int[] result = arr.clone(); // Create a copy to avoid modifying the original array
            for (int i = 0; i < result.length / 2; i++) {
                int j = result.length - 1 - i;
                int temp = result[i];
                result[i] = result[j];
                result[j] = temp;
            }
            return result;
        };
        
        // Function to generate an array of specified size
        Function<Integer, int[]> arrayGenerator = size -> {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = i;
            }
            return arr;
        };
        
        // Test complexity with arrays of different sizes
        int[] sizes = {1000, 10000, 100000, 500000, 1000000, 5000000};
        int repetitions = 100;
        
        analyzeTimeComplexity(reverseArray, arrayGenerator, sizes, repetitions);
        
        // Example of an algorithm with quadratic complexity - finding pairs
        Function<int[], Integer> findPairs = arr -> {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] + arr[j] == 0) {
                        count++;
                    }
                }
            }
            return count;
        };
        
        System.out.println("\n\nAnalyzing pair finding algorithm (expected O(n²)):");
        int[] smallerSizes = {100, 200, 400, 800, 1600};
        analyzeTimeComplexity(findPairs, arrayGenerator, smallerSizes, 10);
    }
    
    /**
     * Displays theoretical time complexity for lines of code
     * @param functionName Name of the function
     * @param codeLines Array of code lines
     * @param complexities Array of corresponding complexities
     */
    public static void printTheoreticalComplexity(String functionName, String[] codeLines, String[] complexities) {
        System.out.println("\n=== Theoretical Complexity Analysis: " + functionName + " ===");
        
        for (int i = 0; i < codeLines.length; i++) {
            System.out.println(codeLines[i] + " - " + complexities[i]);
        }
        
        // Find the highest complexity
        String highestComplexity = findHighestComplexity(complexities);
        System.out.println("\nOverall complexity: " + highestComplexity);
    }
    
    /**
     * Finds the highest complexity from a list
     */
    private static String findHighestComplexity(String[] complexities) {
        // Order of complexities (from lowest to highest)
        String[] order = {"O(1)", "O(log n)", "O(n)", "O(n log n)", "O(n²)", "O(n³)", "O(2^n)", "O(n!)"};
        
        int highestIndex = 0;
        for (String complexity : complexities) {
            for (int i = 0; i < order.length; i++) {
                if (complexity.contains(order[i]) && i > highestIndex) {
                    highestIndex = i;
                }
            }
        }
        
        return order[highestIndex];
    }
}
