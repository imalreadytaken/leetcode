package hard;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.(它骗我)
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count;
        ListNode cur = head, tail = null, begin = head, tmp, pre, res = null;
        while (cur != null){
            count = k;
            while (count > 0 && cur != null) {
                cur = cur.next;
                count--;
            }
            if (count == 0){
                pre = cur;
                while (begin != cur){
                    tmp = begin.next;
                    begin.next = pre;
                    pre = begin;
                    begin = tmp;
                }
                if (tail != null) tail.next = pre;
                if (res == null) res = pre;
                tail = head;
                head = cur;
            }else break;
        }
        return res == null ? head : res;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5};
        ListNode l = new ListNode(test[0]), a = l;
        for (int i = 1; i < test.length; i++) {
            ListNode tmp = new ListNode(test[i]);
            l.next = tmp;
            l = tmp;
        }
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(a, 2));
    }

}
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}