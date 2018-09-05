package sword;


public class Solution_8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null) return null;
        
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        else{ 
            while(pNode.next!=null){
                if (pNode.next.left == pNode) return pNode.next;
                else pNode = pNode.next;
            }
            return null;
        }
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}