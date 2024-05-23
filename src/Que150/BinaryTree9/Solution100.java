package Que150.BinaryTree9;

public class Solution100 {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //中序、前序、后序遍历应该都可以的
        if (p==null&&q==null){
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        }
        if (p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
