package leetcode.dataStructure.Tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class l_144_前序遍历 {
    public static class Guide {
        int opt; // 0：visit  1:print
        TreeNode node;
        Guide(int opt,TreeNode node){
            this.opt = opt;
            this.node = node;
        }

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<Guide> path = new ArrayDeque<>();
        path.addFirst(new Guide(0,root));

        while(!path.isEmpty()){
            Guide current = path.removeFirst();
            if(current.node==null) continue;
            if (current.opt==1){
                result.add(current.node.val);
            }else{
                path.addFirst(new Guide(0,current.node.right));
                path.addFirst(new Guide(0,current.node.left));
                path.addFirst(new Guide(1,current.node));
            }

        }
        return result;

    }

}
