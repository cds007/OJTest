package Que150.DoublePoint2;

public class Solution11 {
    public int maxArea(int[] height) {
        //1.抽象为取两个数，更小数的平方*(长度差)最大的那个。
        //想法：1.暴力法，O(n2)复杂度，用一个二维数组保留结果。
        //题解：很妙！用双指针，每次更小的指针值进行移动，可以进行证明：移动大的那个值得到的值是小于等于原值的。
        int l =0;int r = height.length-1;
        int ans = 0;
        while (l<r){
            ans = Math.max(ans,Math.min(height[l],height[r])*(r-l));
            if (height[l]<=height[r]){
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }
}
