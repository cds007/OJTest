public class DistributeNumbers {
    public static void main(String[] args) {
        DistributeNumbers distributeNumbers = new DistributeNumbers();
        int[] a = distributeNumbers.fun(3);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public int[] fun(int n){
        int cur = n;//当前插入数字
        int[] nums = new int[n*(n+1)/2];
        int start = 0;//插入时初始点
        int end = 0;
        while (cur>0){
            for (int k = 0; k < cur; k++) {
                nums[start+k*2] = cur;
                end = start+k*2;
            }

            if (nums[start+1]==0) start = start+1;
            else{
                while (nums[end]!=0){
                    end++;
                }
                start = end;
            }
            cur--;
        }
        return nums;
    }
}
