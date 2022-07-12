package leetcode.hot100;

/**
 * @ClassName reverseList
 * @Description 反转链表
 * @Author ktx
 * @Date 2022-07-10 10:06
 * @Version 1.0
 */
public class reverseList {
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList3(ListNode head){
        if(head==null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = null;
        while (cur.next!=null){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    // 反转部分链表
    public ListNode reverseBetween(ListNode head, int left, int right) {

        return null;
    }















}
