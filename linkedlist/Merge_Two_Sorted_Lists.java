/**
 *
 * Problem Description
 * Merge two sorted linked lists, A and B, and return it as a new list.
 *
 * The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
 *
 *
 *
 * Problem Constraints
 * 0 <= |A|, |B| <= 105
 *
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head of linked list A.
 *
 * The second argument of input contains a pointer to the head of linked list B.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the merged linked list.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = 5 -> 8 -> 20
 *  B = 4 -> 11 -> 15
 * Input 2:
 *
 *  A = 1 -> 2 -> 3
 *  B = Null
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Output 2:
 *
 *  1 -> 2 -> 3
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Explanation 2:
 *
 *  We don't need to merge as B is empty.
 *
 *
 */

package linkedlist;

public class Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null) return B;
        if(B == null) return A;

        ListNode head = null;

        if(A.val <= B.val) {
            head = A;
            A = A.next;
        }
        else {
            head = B;
            B = B.next;
        }

        ListNode cur = head;

        while(A != null && B != null) {
            if(A.val <= B.val) {
                cur.next = A;
                A = A.next;
            }
            else {
                cur.next = B;
                B = B.next;
            }
            cur = cur.next;
        }

        if(A != null) cur.next = A;
        if(B != null) cur.next = B;

        return head;
    }

    public static void main(String[] args) {

    }

}
