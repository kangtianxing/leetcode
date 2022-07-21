package leetcode.hot100;

/**
 * @ClassName singleNumber
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-21 18:54
 * @Version 1.0
 */
public class singleNumber {
    // 按数字异或即可
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    /*
    * 如果可以将原数组拆分为两个子数组，让这两个出现一次的数字分别分到两个数组中，那么是不是就能在两个子数组中分别求异或和、分别得到num1和num2了呢？
    * 为了寻求这个特征，我们回到最初的尝试结果，即所有元素的异或和sum。所有元素的异或和其实等价于num1 ^ num2，思考一下，如果在某一位上这个异或值为1
    * 说明什么？说明num1和num2在该位上不相等，即一定是一个为0一个为1；而对于相等的其他数字，在该位上自然也是相等的——这不正是我们所寻求的数组拆分特征吗？
    * */
    public int[] singleNumber1(int[] nums){
        // 求所有数字异或和
        int sum = 0;
        for (int num : nums) {
            sum^=num;
        }
        // 找异或和第一个为1的位
        int mask = 1;
        while ((sum&mask)==0){
           mask<<=1;
        }
        // 以该位为依据分组异或
        int x = 0;
        int y = 0;
        for (int num : nums) {
            if((num&mask)==0){
                x^=num;
            }else {
                y^=num;
            }
        }
        return new int[]{x,y};
    }

    public int singleNumber3(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 对于int每一位
            int bit = 0;
            for (int num : nums) {
                bit+=((num>>i)&1);
            }
            // 对3取余即为res在该位置的值
            res+=((bit%3)<<i);
        }
        return res;
    }

}
