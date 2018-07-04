package sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_32 {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if (temp.left!=null) queue.add(temp.left);
            if (temp.right!=null) queue.add(temp.right);
            list.add((Integer) temp.val);
        }
        for (int l:list) System.out.print(l+"-");
        return list;

    }

    public static ArrayList<Integer> PrintInLine(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> rowNumber = new ArrayList<Integer>();
        if (root == null) return list;
        queue.add(root);
        int nextLevel = 0;
        int toBePrinted = 1;
        rowNumber.add(toBePrinted);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            list.add((Integer) temp.val);
            toBePrinted--;
            if (temp.left!=null){
                queue.add(temp.left);
                nextLevel++;
            }
            if (temp.right!=null) {
                queue.add(temp.right);
                nextLevel++;
            }
            if (toBePrinted==0){
                if (nextLevel!=0) rowNumber.add(nextLevel);
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        for (int t:rowNumber) System.out.print(t+"+");
        System.out.println();
        for (int t:list) System.out.print(t+"~");
        System.out.println();
        int start = 0;
        for (int l:rowNumber) {
            for (int i = start; i < start+l ; i++) {
                System.out.print(list.get(i)+"-");
            }
            System.out.println();
            start +=l;
        }
        return list;

    }

    public static void zhizixing(TreeNode root){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        Stack<TreeNode> s;
        if (root == null) return;
        s1.add(root);
        int nextLevel = 0;
        int tobeprinted = 1;
        int layer = 1;
        TreeNode t;
        while (!s1.isEmpty() || !s2.isEmpty()){
                t = s1.pop();
                System.out.print(t.val +"~");
                tobeprinted--;
                if ((layer&1)==1) {
                    if (t.left != null) {
                        s2.push(t.left);
                        nextLevel++;
                    }
                    if (t.right != null) {
                        s2.push(t.right);
                        nextLevel++;
                    }
                }
                else {
                    if (t.right != null) {
                        s2.push(t.right);
                        nextLevel++;
                    }
                    if (t.left != null) {
                        s2.push(t.left);
                        nextLevel++;
                    }
                }
                if (tobeprinted==0){
                    layer++;
                    tobeprinted = nextLevel;
                    nextLevel = 0;
                    s = s2;
                    s2 = s1;
                    s1 = s;
                }
            }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root1 = new TreeNode<>(8);
        root1.left = new TreeNode<>(8);
        root1.right = new TreeNode<>(7);
        root1.left.left = new TreeNode<>(9);
        root1.left.right = new TreeNode<>(2);
        root1.right.left = new TreeNode<>(4);
        root1.right.right = new TreeNode<>(7);
//        ArrayList<Integer> list = PrintFromTopToBottom(root1);
//        for (int l:list) System.out.print(l);
//        PrintInLine(root1);
        zhizixing(root1);
    }
}
