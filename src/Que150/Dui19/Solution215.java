package Que150.Dui19;

public class Solution215 {
    int quickselect(int[] nums, int l, int r, int k) {
        if (l == r)
            return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do
                i++;
            while (nums[i] < x);
            do
                j--;
            while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j)
            return quickselect(nums, l, j, k);
        else
            return quickselect(nums, j + 1, r, k);
    }

    public int findKthLargest(int[] _nums, int k) {
        //这个是美团面试的题，基于快排的方法
        int n = _nums.length;
        return quickselect(_nums, 0, n - 1, n - k);
    }

    public int findKthLargest2(int[] nums, int k) {
        //用桶排序也是O(n)复杂度，厉害了。
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }


}
