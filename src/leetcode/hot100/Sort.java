package leetcode.hot100;

/**
 * @ClassName Sort
 * @Description TODO
 * @Author ktx
 * @Date 2022-07-28 23:10
 * @Version 1.0
 */
public class Sort {
    void bubbleSort(int a[], int n)
    {
        for(int i =0 ; i< n-1; ++i)
        {
            for(int j = 0; j < n-i-1; ++j)
            {
                if(a[j] > a[j+1])
                {
                    int tmp = a[j] ;  //交换
                    a[j] = a[j+1] ;
                    a[j+1] = tmp;
                }
            }
        }
    }
}
