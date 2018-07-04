package sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(){
        this.left = null;
        this.right = null;
    }

    public TreeNode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public ArrayList<Integer> PrintInLine() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> rowNumber = new ArrayList<Integer>();
        if (this == null) return list;
        queue.add(this);
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

}

