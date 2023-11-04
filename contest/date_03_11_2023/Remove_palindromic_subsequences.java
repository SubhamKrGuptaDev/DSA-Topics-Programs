package contest.date_03_11_2023;

public class Remove_palindromic_subsequences {

    public int solve(String A) {
        int left = 0;
        int right = A.length() - 1;

        while(left < right) {
            if(A.charAt(left) != A.charAt(right)) return 1;
        }
        return 2;
    }

    public static void main(String[] args) {

    }

}
