/**
 *
 * * Problem Description *
 * Implement the next permutation, which rearranges numbers into the numerically
 * next greater permutation of numbers for a given array A of size N.
 *
 * If such arrangement is not possible, it must be rearranged as the lowest possible order,
 * i.e., sorted in ascending order.
 *
 * * NOTE: *
 *
 * The replacement must be in-place, do not allocate extra memory.
 * DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions
 * will disqualify your submission retroactively and will give you penalty points.
 *
 *
 * * Problem Constraints *
 * 1 <= N <= 5 * 105
 *
 * 1 <= A[i] <= 109
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [1, 2, 3]
 * Input 2:
 *
 *  A = [3, 2, 1]
 *
 * * Example Output *
 * Output 1:
 *
 *  [1, 3, 2]
 * Output 2:
 *
 *  [1, 2, 3]
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  Next permutaion of [1, 2, 3] will be [1, 3, 2].
 * Explanation 2:
 *
 *  No arrangement is possible such that the number are arranged into
 *  the numerically next greater permutation of numbers.
 *  So will rearrange it in the lowest possible order.
 *
 *
 * * Let’s try some examples to see if we can recognize some patterns. *
 *
 * [3, 1, 3] = next greater number is 331
 * [5, 1, 3] = next greater number is 531
 * [1, 2, 3] = next greater number is 132
 * [1, 3, 5, 4] = next greater number is 1435
 * [3, 2, 1] = we can’t form a number greater than the current number from all
 * the possible permutations
 *
 * So, it is clear that to get the next permutation we will have to change
 * the number in a position which is as right as possible.
 * Each permutation (except the very first) has an increasing suffix.
 * Now if we change the pattern from the pivot point (where the increasing suffix breaks)
 * to its next possible lexicographic representation we will get the next greater permutation.
 *
 *
 *
 */


package Array;

public class Next_Permutation {

    // Function to find the next permutation
    static void nextPermutation(int[] arr)
    {
        int n = arr.length, i, j;

        // Find for the pivot element.
        // A pivot is the first element from
        // end of sequencewhich doesn't follow
        // property of non-increasing suffix
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }

        // Check if pivot is not found
        if (i < 0) {
            reverse(arr, 0, arr.length - 1);
        }

        // if pivot is found
        else {

            // Find for the successor of pivot in suffix
            for (j = n - 1; j > i; j--) {
                if (arr[j] > arr[i]) {
                    break;
                }
            }

            // Swap the pivot and successor
            swap(arr, i, j);

            // Minimise the suffix part
            reverse(arr, i + 1, arr.length - 1);
        }
    }

    static void reverse(int[] arr, int start, int end)
    {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {

        // Given input array
        int[] arr = new int[] { 1, 2, 3, 6, 5, 4 };

        // Function call
        nextPermutation(arr);

        // Printing the answer
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
