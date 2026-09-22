package GFG.practice.Array;

public class Rotate_Array_BY_One {

    public void rotate(int[] arr) {
        // code here
        int n = arr.length;
        int temp = arr[n-1];

        for(int i=n-1; i>0; i--) {
            arr[i] = arr[i-1];
        }

        arr[0] = temp;
    }

    public void rotate1(int[] arr) {
        // code here
        int n=arr.length;
        int prev=arr[0];

        for(int i=0; i<n; i++) {
            int temp = arr[i];
            arr[i] = prev;
            prev = temp;
        }

        arr[0] = prev;
    }

}
