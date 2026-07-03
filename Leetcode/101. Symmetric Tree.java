class Solution {
    public boolean isSymmetric(TreeNode root) {
              return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode  l, TreeNode r){
        if (l == null || r == null) {
            return l==r;
        }
        return (l.val == r.val) && isMirror(l.left , r.right) && isMirror(l.right , r.left); 
    }
}