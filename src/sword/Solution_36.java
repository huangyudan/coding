package sword;

//解题思路：
//1.将左子树构造成双链表，并返回链表头节点。
//2.定位至左子树双链表最后一个节点。
//3.如果左子树链表不为空的话，将当前root追加到左子树链表。
//4.将右子树构造成双链表，并返回链表头节点。
//5.如果右子树链表不为空的话，将该链表追加到root节点之后。
//6.根据左子树链表是否为空确定返回的节点。
public class Solution_36 {
    public static TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
    // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
    // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
    // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
    // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
    // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }

    public static void main(String[] args){
        //            10
        //          /   \
        //         6     14
        //       /  \   / \
        //      4    8 12  16
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(6);
        root.right = new TreeNode<Integer>(14);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(8);
        root.right.left = new TreeNode<Integer>(12);
        root.right.right = new TreeNode<Integer>(16);
        TreeNode<Integer> result = Convert(root);
        while (result!=null){
            System.out.println(result.val);
            result = result.right;
        }

    }

}