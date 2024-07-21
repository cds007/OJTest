package Que150;

class SolutionQ2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1.双指针直接赋值给nums1，这起码是O(n*m)的复杂度了，其实不太好
        //2.直接赋值，然后排序，这是O(n+(m+n)log(m+n))的复杂度，相对来讲好一点
        //3.空间换时间，用一个新数组保存，时间复杂度O(m+n)
        int[] nums3 = new int[m + n];
        int l1 = 0;
        int l2 = 0;
        int cnt = 0;
        while (l1 < m && l2 < n) {
            int n1 = nums1[l1];
            int n2 = nums2[l2];
            if (n1 <= n2) {
                //谁小放谁
                nums3[cnt++] = n1;
                l1++;
            } else {
                nums3[cnt++] = n2;
                l2++;
            }
        }
        while (l1 < m) nums3[cnt++] = nums1[l1++];
        while (l2 < n) nums3[cnt++] = nums2[l2++];
        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums3[i];
        }
    }
}
