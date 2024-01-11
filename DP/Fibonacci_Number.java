package DP;

import java.util.Scanner;

public class Fibonacci_Number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // iterative Solution
        int result = iterativeFibonacci(n);
        System.out.println(result);

        // Simple Recursive Solution
        // int result = recursiveFibonacci(n);
        // System.out.println(result);

        // Recursive DP Solution
        // int[] storage = new int[n+1];
        // int result = fibonacciNumber(n, storage);
        // System.out.println(result);
    }

    // Iterative Solution TC: O(N) | SC: O(1)
    private static int iterativeFibonacci(int n) {
        int prev = 0;
        int cur = 1;
        for(int i=0; i<n; i++) {
            int next = prev + cur;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /// Simple Recursive Solution TC: O(2^N)
    private static int recursiveFibonacci(int n) {
        if(n <= 1) return n;
        return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }

    // DP Solution TC: O(N * 2) | SC: O(N)
    private static int fibonacciNumberDP(int n, int[] storage) {
        if(n <= 1) return n;
        if(storage[n] != 0) return storage[n];
        storage[n] = fibonacciNumberDP(n-1, storage) + fibonacciNumberDP(n-2, storage);
        return storage[n];
    }

}
