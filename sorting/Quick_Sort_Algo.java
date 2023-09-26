/**
 *
 * Quick Sort Algorithm
 *
 * QuickSort is a sorting algorithm based on the Divide and Conquer algorithm that picks an element as
 * a pivot and partitions the given array around the picked pivot by placing the pivot in its correct
 * position in the sorted array.
 *
 * link - https://www.geeksforgeeks.org/quick-sort/
 * <>
 * 4,3,2,1 -> check ( arr[j] < arr[end] ) -> swap(arr[i], arr[j]) and start++
 * </>
 *
 */

package sorting;

import java.util.ArrayList;
import java.util.List;

public class Quick_Sort_Algo {

    public void quick_Sort(List<Integer> arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int pivodIndex = partition(arr, start, end);        // pivot means upto partitions left right is smaller and right side is bigger then pivot element

        quick_Sort(arr, start, pivodIndex-1);
        quick_Sort(arr, pivodIndex + 1, end);
    }

    private int partition(List<Integer> arr, int start, int end) {
//        int pivodValue = ;
        for(int j=start; j<=end-1; j++) {           // care full about start variable
            if(arr.get(j) < arr.get(end)) {         // if arr[j] less than arr[end] then swap and slow pointer increase
                swap(arr, start, j);
                start++;                            // slow pointer increase
            }
        }
        swap(arr, start, end);                      // last big element which is in start variable swap with last value
        return start;
    }

    private void swap(List<Integer> arr, int n1, int n2) {
        int temp = arr.get(n1);
        arr.set(n1, arr.get(n2));
        arr.set(n2, temp);
    }

    public static void main(String[] args) {
        Quick_Sort_Algo object = new Quick_Sort_Algo();
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        object.quick_Sort(list, 0, list.size()-1);

        list.forEach(System.out::println);

    }

}
