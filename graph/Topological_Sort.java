/**
 *
 * Problem Description
 * Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 *
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 *
 * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
 *
 * If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
 *
 * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
 *
 * NOTE:
 *
 * There are no self-loops in the graph.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 *
 *
 * Problem Constraints
 * 2 <= A <= 104
 *
 * 1 <= M <= min(100000,A*(A-1))
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 *
 *
 * Input Format
 * The first argument given is an integer A representing the number of nodes in the graph.
 *
 * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 *
 *
 *
 * Output Format
 * Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 6
 *  B = [  [6, 3]
 *         [6, 1]
 *         [5, 1]
 *         [5, 2]
 *         [3, 4]
 *         [4, 2] ]
 * Input 2:
 *
 *  A = 3
 *  B = [  [1, 2]
 *         [2, 3]
 *         [3, 1] ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [5, 6, 1, 3, 4, 2]
 * Output 2:
 *
 *  []
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
 * Explanation 2:
 *
 *  The given graph contain cycle so topological ordering not possible we will return empty array.
 *
 *
 *
 */

package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Topological_Sort {

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[A+1];

        // adjacency List
        for(int i=0; i<=A; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<B.size(); i++) {
            adj.get(B.get(i).get(0)).add(B.get(i).get(1));
        }

        // indegree values added
        for(int i=0; i<adj.size(); i++) {
            for(int x : adj.get(i)) {
                inDegree[x]++;
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        // find zeros inDegree
        for(int i=1; i<=A; i++) {
            if(inDegree[i] == 0)
                q.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {

            int temp = q.remove();
            // Add Result values
            result.add(temp);

            for(int x : adj.get(temp)) {
                inDegree[x] -= 1;
                if(inDegree[x] == 0) {
                    q.add(x);
                }
            }
        }

        return result;
    }

}
