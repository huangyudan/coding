package sword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution_54 {
    public static void visit(TreeNode<Integer> node){
        System.out.print(node.val+"-");
    }
    //前序pre
    public static void dfs_pre(TreeNode<Integer> root){
        if (root==null) return;
        visit(root);
        dfs_pre(root.left);
        dfs_pre(root.right);
    }
    //后序post
    public static void dfs_post(TreeNode<Integer> root){
        if (root==null) return;
        dfs_post(root.left);
        dfs_post(root.right);
        visit(root);
    }

    //中序 in
    public static void dfs_in(TreeNode<Integer> root){
        if (root==null) return;
        dfs_in(root.left);
        visit(root);
        dfs_in(root.right);
    }


    //非递归实现
    public static void dfs_pre2(TreeNode<Integer> root){
        if (root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node==null) continue; //接着pop
            System.out.print(node.val+"-");
            stack.push(node.right);
            stack.push(node.left);
        }
    }

    //前序是根-左-右  后序是左-右-根  是根右左的倒序
    public static void dfs_post2(TreeNode<Integer> root){
        if (root==null) return;
        ArrayList<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node==null) continue; //接着pop
            ret.add((Integer) node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ret);
        for (int i:ret) {
            System.out.print(i+"-");
        }
    }
    public static void dfs_in2(TreeNode<Integer> root){
        if (root==null) return;
        ArrayList<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur=root;
        while(cur!=null ||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add((Integer) node.val);
            cur = node.right;
        }

        for (int i:ret) {
            System.out.print(i+"-");
        }
    }


    private static int count=0;
    private static int ret;
    public static void dfs_in_k(TreeNode<Integer> root,int k){
        if (root==null) return;
        dfs_in_k(root.left,k);
//        visit(root);
        count++;
        if (count==k){
            ret = root.val;
        }
        dfs_in_k(root.right,k);
    }


    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(4);
        root.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(8);
        dfs_pre(root);
        System.out.println();
        dfs_pre2(root);
        System.out.println();
        dfs_in(root);
        System.out.println();
        dfs_in2(root);
        System.out.println();
        dfs_post(root);
        System.out.println();
        dfs_post2(root);
        System.out.println();
        dfs_in_k(root,3);//4
        System.out.println(ret);//7

    }
}

