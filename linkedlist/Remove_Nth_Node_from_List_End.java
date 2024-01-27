/**
 *
 * Problem Description
 * Given a linked list A, remove the B-th node from the end of the list and return its head.
 * For example, given linked list: 1->2->3->4->5, and B = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * NOTE: If B is greater than the size of the list, remove the first node of the list.
 *
 * Try doing it using constant additional space.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 106
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.
 *
 *
 * Output Format
 * Return the head of the linked list after deleting the B-th element from the end.
 *
 *
 * Example Input
 * Input 1:
 * A = 1->2->3->4->5
 * B = 2
 * Input 2:
 * A = 1
 * B = 1
 *
 *
 * Example Output
 * Output 1:
 * 1->2->3->5
 * Output 2:
 *
 *
 *
 * Example Explanation
 * Explanation 1:
 * In the first example, 4 is the second last element.
 * Explanation 2:
 * In the second example, 1 is the first and the last element.
 *
 *
 *
 */

package linkedlist;

public class Remove_Nth_Node_from_List_End {

    // Brute Force Approach
    public ListNode removeNthFromEnd(ListNode A, int B) {
        int n = size(A);
        if( B > n) return A.next;
        if(A == null) return null;
        if(A.next == null && B == 1) return null;

        ListNode cur = reverseList(A);

        if(B == 1) {
            cur = reverseList(cur.next);
            return cur;
        }

        return remove(cur, B);
    }

    private ListNode remove(ListNode head, int n) {
        int index = 1;

        ListNode cur = head;
        ListNode prev = null;

        while(cur != null) {
            if(n == index) {
                prev.next = cur.next;
                cur.next = null;
                break;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
            index++;
        }

        head = reverseList(head);

        return head;
    }

    private int size(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while(cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }


    // Optimized Approach
    public ListNode removeNthFromEndOptimized(ListNode A, int B) {
        if (A == null)
            return null;
        int n = 0;
        ListNode node = A;
        // calculates the size of the linked list
        while (node != null) {
            n++;
            node = node.next;
        }
        if (B >= n) {
            return A.next;
        }
        node = A;
        for (int i = 0; i < n - B - 1; i++)
            node = node.next;
        node.next = node.next.next;
        return A;
    }

}
