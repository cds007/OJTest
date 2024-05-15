package Que150.fenzhi16;




public class Solution108 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
        //这题有三种构建方法，构建出来的平衡二叉搜索树是不一样的，我们选一种即可。
        //用二分查找构建平衡二叉搜索树其实从直观逻辑上来看是完全没有问题的，证明可能需要数学归纳法
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        // 总是选择中间位置右边的数字作为根节点
        //int mid = (left + right + 1) / 2;
        // 选择任意一个中间位置数字作为根节点
        //int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
