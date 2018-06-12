package easy;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

public class MergeTwoSortedList {

    private ListNode tmp1, tmp2, tmp3;

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        tmp1 = l1;
        tmp2 = l2;
        ListNode res;
        if (tmp1.val <= tmp2.val){
            res = new ListNode(tmp1.val);
            tmp1 = tmp1.next;
        }else {
            res = new ListNode(tmp2.val);
            tmp2 = tmp2.next;
        }
        tmp3 = res;
        while (tmp1 != null && tmp2 != null){
            if (tmp1.val < tmp2.val){
                tmp3.next = new ListNode(tmp1.val);
                tmp1 = tmp1.next;
            }else {
                tmp3.next = new ListNode(tmp2.val);
                tmp2 = tmp2.next;
            }
            tmp3 = tmp3.next;
        }
        tmp3.next = tmp1 == null ? tmp2 : tmp1;
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l4;
        ListNode l11 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l44 = new ListNode(4);
        l11.next = l3;
        l3.next = l44;
        l1.out();
        l11.out();
        ListNode l = new MergeTwoSortedList().mergeTwoLists(l1,l11);
        l.out();
    }



}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public void out(){
        ListNode l = this;
        System.out.print(val);
        while (l.next != null){
            l = l.next;
            System.out.print("->" + l.val);
        }
        System.out.println();
    }

}