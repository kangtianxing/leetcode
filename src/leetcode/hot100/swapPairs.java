package leetcode.hot100;

import java.util.List;

/**
 * @ClassName swapPairs
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-25 12:33
 * @Version 1.0
 */
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummpyNode = new ListNode(0);
        dummpyNode.next = head;
        ListNode prev = dummpyNode;
        while (prev.next!=null&&prev.next.next !=null){
            ListNode temp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;
        }
        return dummpyNode.next;
    }
}
