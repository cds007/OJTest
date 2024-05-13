package Que150.DoublePoint;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        //1.我的想法，全部存hashmap里，然后循环一遍，判断target-numbers[i]存不存在即可。时间复杂度On,空间复杂度On。但是要求空间复杂度O(1)；
        //2.第二个想法：循环一遍，每一遍二分查找target-numbers[i]，时间复杂度O(nlogn)，空间复杂度O(1)。符合要求。
        //题解：跟我的想法二一模一样的。
        //题解2：最好的办法是用双指针，时间复杂度只有O(n)。
        for (int i = 0; i < numbers.length; i++) {
            int left = i+1;//前面的不需要查了
            int right = numbers.length-1;
            while (left<=right){//二分查找，等于是有可能的，可能最后一次需要left = mid+1的操作
                int mid = (right-left)/2 + left;
                if (numbers[mid]==target-numbers[i]){
                    return new int[]{i+1,mid+1};
                } else if (numbers[mid] > target - numbers[i]) {
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }
        return new int[]{-1,-1};
    }
    //双指针
    public int[] twoSumBest(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}
