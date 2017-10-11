package sort;

/**
 * Created by Yang on 2017/10/8.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m-1, i2 = n -1, kk = m+n-1;//从最后一个元素开始遍历

        while(i1 >= 0 && i2 >= 0) { //Step 1
            if( nums1[i1] > nums2[i2] ) { //如果nums1中当前最大的数比nums2中当前最大的数大，nums1中的那个数应该放在最后
                nums1[kk--] = nums1[i1--];
            }
            else {
                nums1[kk--] = nums2[i2--];
            }
        }

        while( i2 >= 0 ) { //Step1完成之后，nums1的各个数字肯定已经在正确的位置上了
            nums1[kk--] = nums2[i2--];
        }
    }
}
