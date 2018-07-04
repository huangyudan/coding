package sword;

public class Solution_37 {
    public static String serialize(TreeNode<Integer> root){
        if(root==null)
            return "$,";
        StringBuilder result = new StringBuilder();
        result.append(root.val);
        result.append(",");
        result.append(serialize(root.left));
        result.append(serialize(root.right));
        return result.toString();
    }
    public static TreeNode<Integer> deserialize(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        return deserializeCore(stringBuilder);
    }
    public static TreeNode<Integer> deserializeCore(StringBuilder stringBuilder){
        if(stringBuilder.length()==0)
            return null;
        String num = stringBuilder.substring(0,stringBuilder.indexOf(","));
        stringBuilder.delete(0,stringBuilder.indexOf(","));
        stringBuilder.deleteCharAt(0);
        if(num.equals("$"))
            return null;
        TreeNode<Integer> node = new TreeNode<>(Integer.parseInt(num));
        node.left = deserializeCore(stringBuilder);
        node.right = deserializeCore(stringBuilder);
        return node;
    }
    public static void main(String[] args){
        //             1
        //          /    \
        //         2      3
        //       /  \    / \
        //      4    8  5   6
        //    1,2,4,$,$,$,3,5,$,$,6,$,$
        TreeNode<Integer> root = new TreeNode<Integer>(8);
        root.left = new TreeNode<Integer>(6);
        root.right = new TreeNode<Integer>(10);
        root.left.left = new TreeNode<Integer>(5);
        root.left.right = new TreeNode<Integer>(7);
        root.right.left = new TreeNode<Integer>(9);
        root.right.right = new TreeNode<Integer>(11);
        System.out.println("原始树：");
        root.PrintInLine();
        String result = serialize(root);
        System.out.println("序列化结果："+result);
        TreeNode<Integer> deserializeRoot = deserialize(result);
        System.out.println("反序列后的树：");
        deserializeRoot.PrintInLine();
    }
}

