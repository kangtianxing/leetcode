package nowcoder.sort;

/**
 * @author ktx
 * @data 2022-06-25 14:08
 */
public class bubblesort {
    public static void main(String[] args) {
        int[] a = {10,3,20,4,6};
        bubblesort bubblesort = new bubblesort();
        int[] ints = bubblesort.bubbleSort(a, 5);
        for (int i : ints) {
            System.out.print(i+" ");
        }
    }

    public int[] bubbleSort(int[] A,int n){
        for (boolean sorted = false;sorted!=sorted;n--){   // 逐躺扫描交换，直至完全有序
            for (int i = 1;i<n;i++){   // 自左向右，逐对检查各个相邻的元素
                if(A[i-1]>A[i]){   // 若逆序，则
                    swap(A,i-1,i); // 令其互换，同时
                    sorted = false;  // 清楚全局有序标志
                }
            }
        }
        return A;
    }
    public void swap(int[] A,int left,int right){
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}
