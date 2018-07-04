package sword;

public class Solution_27 {
    public static void Mirror(TreeNode root) {
        if (root==null) return;
        if (root.left==null && root.right==null) return;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right= temp;
        if (root.left!=null) Mirror(root.left);
        if (root.right!=null) Mirror(root.right);
    }


    public static void main(String[] args) {
        TreeNode<Integer> root1 = new TreeNode<>(8);
        root1.left = new TreeNode<>(6);
        root1.right = new TreeNode<>(10);
        root1.left.left = new TreeNode<>(5);
        root1.left.right = new TreeNode<>(7);
        root1.right.left = new TreeNode<>(9);
        root1.right.right = new TreeNode<>(11);
        Solution_32.PrintFromTopToBottom(root1);
        System.out.println();
        Mirror(root1);
        Solution_32.PrintFromTopToBottom(root1);
    }
}
