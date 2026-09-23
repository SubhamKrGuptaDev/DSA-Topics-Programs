/**
 * Given an array of car numbers car[], an array of penalties fine[], and an integer date,
 * find the total fine collected on that date. The fine is collected based on parity, i.e., on an even date,
 * fines are collected from odd-numbered cars, and on an odd date, fines are collected from even-numbered cars.
 *
 *
 * Link: #{https://www.geeksforgeeks.org/problems/find-the-fine4353/1?sortBy=submissions&category%5B%5D=Arrays&page=3&difficulty%5B%5D=-1}
 *
 */


package GFG.practice.Array;

public class EvenOddPosition {

    private long helper(int date, int car[], int fine[]) {
        boolean isEven = date % 2 == 0;
        int n = car.length;
        long ans = 0L;

        for(int i=0; i<n; i++) {
            if(isEven && car[i] % 2 != 0) {
                ans += fine[i];
            }

            if(!isEven && car[i] % 2 == 0) {
                ans += fine[i];
            }
        }

        return ans;
    }

}
