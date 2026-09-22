package GFG.practice.Array;

import java.util.ArrayList;

public class Min_Max_Array {

    public ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(min);
        result.add(max);

        return result;
    }

}
