package sword;

import java.util.Scanner;

public class 鼎复数据 {
//    static class TreeNode{
//        TreeNode left;
//        TreeNode right;
//        int val=-1;
//        TreeNode(){}
//        TreeNode(int val){
//            val = val;
//        }
//    }

    public static TreeNode  buildTree(int[] vals) {
        TreeNode root = new TreeNode(vals[0]);
        for (int i = 1; i < vals.length; i++) {
            TreeNode parent = root;
            while (true) {
                if (vals[i] < (int) parent.val) {
                    if (parent.left == null) {
                        parent.left = new TreeNode();
                        parent.left.val = vals[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                }
                if (vals[i] > (int) parent.val) {
                    if (parent.right == null) {
                        parent.right = new TreeNode();
                        parent.right.val = vals[i];
                        break;
                    } else {
                        parent = parent.right;
                    }

                }

            }
        }
        return root;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int[] v= new int[number];
        for (int i = 0;i<number;i++){
            v[i] = in.nextInt();
        }
        TreeNode a;
        a = buildTree(v);
        System.out.println("end");

    }
}