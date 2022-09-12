package leetcode.hot100;

import java.util.ArrayList;

/**
 * @ClassName addTwoNumbers
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-07 10:18
 * @Version 1.0
 */
public class addTwoNumbers {

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        int i = 0;
//        while (true){
//            list.add(i);
//        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;
        int carry = 0;
        while (l1!=null||l2!=null){
            int val1 = l1!=null?l1.val:0;
            int val2 = l2!=null?l2.val:0;
            int sum = val1+val2+carry;
            if(head==null){
                head = tail = new ListNode(sum%10);
            }else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        if(carry>0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
