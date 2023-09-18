/**
 *
 *
 *
 *
 *
 *
 *
 */



package recursion;

import java.util.ArrayList;

public class Tower_Of_Hanoi {

    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        toh(A,1,3,2);
        return result;
    }
    public void toh(int disk,int from , int to,int helper){
        if(disk==0){
            return;
        }
        toh(disk-1,from,helper,to);
        ArrayList<Integer> subList=new ArrayList<>();
        subList.add(disk);
        subList.add(from);
        subList.add(to);
        result.add(subList);
        toh(disk-1,helper,to,from);
    }

    public static void main(String[] args) {

    }

}
