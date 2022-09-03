package leetcode.hot100;

import javax.lang.model.type.IntersectionType;
import javax.management.relation.InvalidRelationTypeException;
import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName finalPrices
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-01 22:13
 * @Version 1.0
 */
public class finalPrices {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int discount  =0;
            for (int j = i+1;j<n;j++){
                if(prices[i]<=prices[j]){
                    discount = prices[i];
                    break;
                }
            }
            ans[i] = prices[i]-discount;
        }
        return ans;
    }

    public int[] finalPrices1(int[] prices) {
        int n = prices.length;
        int[] ans =new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()&&stack.peek()>prices[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty()?prices[i]:prices[i]-stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> greaterMap = new HashMap<>();
        Stack<Integer> stack= new Stack<>();
        for (int i = nums2.length-1; i > 0; i--) {
            while (!stack.isEmpty()&&stack.peek()<=nums2[i]){
                stack.pop();
            }
            greaterMap.put(nums2[i],stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }


}
