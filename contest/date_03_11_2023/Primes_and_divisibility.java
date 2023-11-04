package contest.date_03_11_2023;

import java.util.ArrayList;

public class Primes_and_divisibility {
    public ArrayList<Integer> solve(int A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=A; i<=B; i++) {
            int factor = factor(i);
            if(factor == 2 && checkValue(i)) {
                result.add(i);
            }
        }

        return result;
    }
    private int factor(int n) {
        int count = 0;
        for(int i=1; i*i<=n; i++) {
            if(i*i == n) count++;
            else if(n % i == 0) count += 2;
        }
        return count;
    }
    private boolean checkValue(int n) {
        int temp = n % 10;
        return temp == 3;
    }

    public static void main(String[] args) {

    }
}
