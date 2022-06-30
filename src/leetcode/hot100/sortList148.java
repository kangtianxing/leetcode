package leetcode.hot100;

import java.awt.*;

/**
 * 链表的排序
 * 核心: 链表的截断
 *      链表的二路归断
 *      虚拟头节点，滞后指针等
 * @author ktx
 * @data 2022-06-30 10:16
 */
public class sortList148 {
    // 核心思路：对左右链分别排好序后，在进行归并--递归
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode L = head;
        ListNode R = cut(L);
        ListNode sortedL = sortList(L);
        ListNode sortedR = sortList(R);
        return merge(sortedL,sortedR);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummpHead = new ListNode(-1);
        ListNode p = dummpHead;
        while (node1!=null&&node2!=null){
            if(node1.val<node2.val){
                p.next = node1;
                node1 = node1.next;
            }else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        if(node1!=null){
            p.next= node1;
        }
        if(node2!=null){
            p.next = node2;
        }
        return dummpHead.next;
    }

    /**
     *【cut断链】
     * 两个动作：切开链表 + 返回右链的头节点
     */
    private ListNode cut(ListNode left) {
        if(left==null||left.next==null){
            return left;
        }
        ListNode slow = left;
        ListNode fast = left;
        ListNode pre = null;
        // slow/fast快慢指针用于找中点(其实偏右)，返回的正是中点slow
        // pre指针滞后slow，用于断链(!!!小技巧)
        while (fast!=null&&fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }
}
