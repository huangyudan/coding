package sword;

public class Solution_28 {
    public static boolean isSymmetrical(TreeNode pRoot){
        return isSymmetrical(pRoot,pRoot);
    }
    public static boolean isSymmetrical(TreeNode p1,TreeNode p2){
        if (p1==null && p2==null) return true;
        if (p1==null || p2==null) return false;
        if (p1.val != p2.val) return false;
        return isSymmetrical(p1.left,p2.right) && isSymmetrical(p1.right,p2.left);
    }
    public static void main(String[] args){
        TreeNode<Integer> root1 = new TreeNode<>(8);
        root1.left = new TreeNode<>(6);
        root1.right = new TreeNode<>(6);
        root1.left.left = new TreeNode<>(5);
        root1.left.right = new TreeNode<>(7);
        root1.right.left = new TreeNode<>(7);
        root1.right.right = new TreeNode<>(5);
        System.out.println(isSymmetrical(root1));
        TreeNode<Integer> root2 = new TreeNode<>(8);
        root2.left = new TreeNode<>(6);
        root2.right = new TreeNode<>(9);
        root2.left.left = new TreeNode<>(5);
        root2.left.right = new TreeNode<>(7);
        root2.right.left = new TreeNode<>(6);
        root2.right.right = new TreeNode<>(5);
        System.out.println(isSymmetrical(root2));
        TreeNode<Integer> root3 = new TreeNode<>(8);
        root3.left = new TreeNode<>(6);
        root3.right = new TreeNode<>(9);
        root3.left.left = new TreeNode<>(5);
        root3.left.right = new TreeNode<>(7);
        root3.right.left = new TreeNode<>(6);
        root3.right.right = new TreeNode<>(5);
        System.out.println(isSymmetrical(root3));
    }

}
