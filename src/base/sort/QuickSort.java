package base.sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description 双边循环
 * @Author ktx
 * @Date 2022-08-18 17:39
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {5,3,7,2,9,8,1,4};
        System.out.println(Arrays.toString(a));
        quick(a,0,a.length-1);
    }

    private static void quick(int[] a, int l, int h) {
        if(l>=h){
            return;
        }
        int p = partition(a,l,h);
        quick(a,l,p-1);
        quick(a,p+1,h);
    }

    private static int partition(int[] a, int l, int h) {
        int pv = a[l];
        int i = l,j = h;
        while (i<j){
            // j从右找小
            while (i<j&& a[j]>pv){
                j--;
            }
            // i 从左找大
            while (i<j&& a[i]<=pv){
                i++;
            }
            swap(a,i,j);
        }
        swap(a,l,i);
        System.out.println(Arrays.toString(a));
        return j;
    }
    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
