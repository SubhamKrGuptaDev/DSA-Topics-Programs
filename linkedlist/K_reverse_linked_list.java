/**
 *
 * Problem Description
 * Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 103
 *
 * B always divides A
 *
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head of the linked list.
 *
 * The second arugment of input contains the integer, B.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the modified linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5, 6]
 *  B = 2
 * Input 2:
 *
 *  A = [1, 2, 3, 4, 5, 6]
 *  B = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 1, 4, 3, 6, 5]
 * Output 2:
 *
 *  [3, 2, 1, 6, 5, 4]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For the first example, the list can be reversed in groups of 2.
 *     [[1, 2], [3, 4], [5, 6]]
 *  After reversing the K-linked list
 *     [[2, 1], [4, 3], [6, 5]]
 * Explanation 2:
 *
 *  For the second example, the list can be reversed in groups of 3.
 *     [[1, 2, 3], [4, 5, 6]]
 *  After reversing the K-linked list
 *     [[3, 2, 1], [6, 5, 4]]
 *
 *
 *
 */



package linkedlist;

public class K_reverse_linked_list {

    public ListNode reverseList(ListNode A, int B) {
        if(B == 1) return A;
        int index = 0;

        // reverse
        ListNode cur = A;
        ListNode prev = null;
        ListNode next = null;

        while(cur != null && index < B) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            index++;
        }
        if(next != null) {
            A.next = reverseList(next, B);
        }
        return prev;
    }


    // Leetcode link - https://leetcode.com/problems/reverse-nodes-in-k-group/

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        int index = 0;

        int size = size(head);
        if(size >= k) {
            while(cur != null && index < k) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                index++;
            }
        }
        else {
            return head;
        }

        if(next != null ) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }

    int size(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

}
