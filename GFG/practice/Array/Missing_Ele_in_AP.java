package GFG.practice.Array;

public class Missing_Ele_in_AP {

    public int findMissing(int[] arr) {
        // code here
        return helper(arr);
    }

    private int helper(int[] arr) {
        int n = arr.length;
        int minDiv = findMinDiv(arr, n);
        System.out.println(minDiv);
        if(arr[0] < arr[1]) {
            for(int i=0; i<n-1; i++) {
                if(arr[i] + minDiv != arr[i+1]) {
                    return arr[i] + minDiv;
                }
            }
            return arr[n-1] + minDiv;
        } else {
            for(int i=0; i<n-1; i++) {
                System.out.println(arr[i]);
                System.out.println(arr[i] - minDiv + " || " + arr[i+1]);
                if(arr[i] - minDiv != arr[i+1]) {
                    return arr[i] - minDiv;
                }
            }
            return arr[n-1] - minDiv;
        }
    }

    private int findMinDiv(int[] arr, int n) {
        int minDiv = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++) {
            minDiv = Math.min(minDiv, Math.abs(arr[i] - arr[i+1]));
        }

        return minDiv;
    }

    /**
     * Test Cases - [41 21 11]
     * @param args
     */
    public static void main(String[] args) {
        Missing_Ele_in_AP obj = new Missing_Ele_in_AP();
        int[] arr = {41, 21, 11};
        System.out.println(obj.findMissing(arr));
    }

}
