package sword;

import java.util.ArrayList;

public class Solution_34 {
    private static ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> p = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null) return path;
        target -= (int) root.val;
        p.add((Integer) root.val);
//        for (int j : p){
//            System.out.print(j+"-");
//        }
//        System.out.println();
        if (root.left==null && root.right==null && target==0){
//            path.add(p);
            path.add(new ArrayList<Integer>(p)); //不new的话就只是添加了一个引用，后期p再被修改的话，path中的引用也被修改
        }
        if (root.left!=null) FindPath(root.left,target);
        if (root.right!=null) FindPath(root.right,target);
        p.remove(p.size()-1);
        //这里为什么不把target加回去？因为targrt在递归中就是他所在那层的值，下一层递归所改变的值不会递归到上一层，不需要加回去。
        return path;
    }


    public static void main(String[] args) {
        //            10
        //          /   \
        //         5     12
        //       /  \
        //      4    7
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(5);
        root.right = new TreeNode<Integer>(12);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(7);
        ArrayList<ArrayList<Integer>> path = FindPath(root,15);
        for (ArrayList<Integer> i:path){
            for (int j : i){
                System.out.print(j+"-");
            }
            System.out.println();
        }
    }

}


