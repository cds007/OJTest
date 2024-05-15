package Que150.Binary18;

class Solution162 {
    public int findPeakElement(int[] nums) {
        // 这个方法相对于题解来说，规避了两边是负无穷的边界处理，很牛逼。
        // 可以用样例 1,2 或者 2,1 或者 1,2,1来测试一下
        int l = 0, r = nums.length - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
