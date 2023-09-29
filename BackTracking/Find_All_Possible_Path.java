
package BackTracking;

public class Find_All_Possible_Path {

    int count = 0;

    void func(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc) return;
        if(sr == dr && sc == dc) {
            count++;
            return;
        }
        func(sr, sc+1,dr,dc);
        func(sr+1, sc,dr,dc);
    }


    public static void main(String[] args) {
        Find_All_Possible_Path object = new Find_All_Possible_Path();
        object.func(0,0,2,2);
        System.out.println("Total count of possible path -> " + object.count);
    }
}
