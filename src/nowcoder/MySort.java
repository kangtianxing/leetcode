package nowcoder;

/**
 * @ClassName MySort
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-31 23:42
 * @Version 1.0
 */
public class MySort {
    public int[] MySort (int[] arr) {
        // write code here
        sort(arr,0,arr.length-1);
        return arr;
    }

    private void sort(int[] arr, int lo, int hi) {
        if(lo>=hi){
            return;
        }
        int mid = lo+(hi-lo)/2;
        sort(arr,lo,mid);
        sort(arr,mid+1,hi);
        merge(arr,lo,mid,hi);
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[hi-lo+1];
        int index = 0;
        int l1 = lo,l2 = mid+1;
        while (l1<=mid&&l2<=hi){
            if(arr[l1]<arr[l2]){
                temp[index++] = arr[l1++];
            }else {
                temp[index++] = arr[l2++];
            }
        }
        while(l1<=mid){
            temp[index++] = arr[l1++];
        }
        while(l2<=hi){
            temp[index++] =arr[l2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[lo+i] = temp[i];
        }
    }

    public int[] MySort1 (int[] arr) {
        quickSort(arr , 0 , arr.length-1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int point = partition(arr, left, right);
            // 递归调用，对左子数组进行快速排序
            quickSort(arr, left, point - 1);
            // 递归调用，对右子数组进行快速排序
            quickSort(arr, point + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int first = arr[left];
        while (left<right){
            while (left<right &&arr[right]>=first){
                right--;
            }
            // 交换
            swap(arr, left, right);
            while (left<right &&arr[left]<=first){
                left++;
            }
            swap(arr,left,right);
        }
        return left;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
