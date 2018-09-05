package sword;

public class Solution_55 {
    public int treeDepth(TreeNode<Integer> root){
        if(root==null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left>right?(left+1):(right+1);
    }

    private boolean isBalanced = true;
    public boolean IsBalanced(TreeNode<Integer> root){
        getDepth(root);
        return isBalanced;
    }

    public int getDepth(TreeNode<Integer> root){
        if (root==null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left-right)>1){
            isBalanced = false;
        }
        return right>left?right+1:left+1;
    }



    public static void main(String[] args){
        Solution_55 s = new Solution_55();
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(7);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        System.out.println(s.treeDepth(root));
        System.out.println(s.IsBalanced(root));
    }

}
