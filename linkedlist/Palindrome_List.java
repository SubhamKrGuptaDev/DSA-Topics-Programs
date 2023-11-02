/**
 *
 * Problem Description
 * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 10^5
 *
 *
 *
 * Input Format
 * The first and the only argument of input contains a pointer to the head of the given linked list.
 *
 *
 *
 * Output Format
 * Return 0, if the linked list is not a palindrome.
 *
 * Return 1, if the linked list is a palindrome.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 * A = [1, 2, 2, 1]
 * Input 2:
 *
 * A = [1, 3, 2]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
 * Explanation 2:
 *
 *  The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
 *
 *
 *
 */


package linkedlist;

public class Palindrome_List {

    public int lPalin(ListNode A) {
        ListNode cur = A;
        int size = sizeOfLinkedList(A);

        int i = 0;
        while(cur != null && i < size/2) {
            i++;
            cur = cur.next;
        }

        ListNode middle = reverse(cur);
        ListNode reverseMiddle = middle;
        cur = A;
        while(reverseMiddle != null) {
            if(reverseMiddle.val != cur.val) {
                return 0;
            }
            reverseMiddle = reverseMiddle.next;
            cur = cur.next;
        }

        return 1;
    }

    private int sizeOfLinkedList(ListNode node) {
        int size = 0;
        ListNode cur = node;
        while(cur != null) {
            size++;
            cur = cur.next;
        }

        return size;
    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node;
        ListNode next = null;
        ListNode prev = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
