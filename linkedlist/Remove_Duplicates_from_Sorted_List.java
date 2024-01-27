/**
 *
 * Problem Description
 * Given a sorted linked list, delete all duplicates such that each element appears only once.
 *
 *
 *
 * Problem Constraints
 * 0 <= length of linked list <= 106
 *
 *
 *
 * Input Format
 * First argument is the head pointer of the linked list.
 *
 *
 *
 * Output Format
 * Return the head pointer of the linked list after removing all duplicates.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  1->1->2
 * Input 2:
 *
 *  1->1->2->3->3
 *
 *
 * Example Output
 * Output 1:
 *
 *  1->2
 * Output 2:
 *
 *  1->2->3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Each element appear only once in 1->2.
 *
 *
 *
 */



package linkedlist;

public class Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode A) {
        if(A == null) return A;
        if(A.next == null) return A;

        ListNode cur = A;
        ListNode prev = null;
        while(cur != null && cur.next != null) {
            prev = cur;
            if(cur.val == cur.next.val) {
                while(cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
            }
            else {
                cur = cur.next;
            }
        }
        return A;
    }

    public ListNode deleteDuplicatesSimple(ListNode A) {
        ListNode cur = A;

        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }

        return A;
    }

}
