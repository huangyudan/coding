package leetcode.dataStructure.Tree;
//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//        10
//        /  \
//        5   -3
//        / \    \
//        3   2   11
//        / \   \
//        3  -2   1
//
//        Return 3. The paths that sum to 8 are:
//
//        1.  5 -> 3
//        2.  5 -> 2 -> 1
//        3. -3 -> 11
// 路径只要连续 就行，不一定从根到叶子

public class l_437_判断树存在多少条路径和为n {
    public int pathSum(TreeNode root, int sum){
        if (root==null) return 0;
        int ret = pathSumStartWithRoot(root,sum)+ pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }
    // 这边是一定要从root开始的，不然会重复计算
    public int pathSumStartWithRoot(TreeNode root,int sum){
        if (root==null) return 0;
        int ret = 0;
        if (root.val == sum) {
            ret++;
        }
        ret += pathSumStartWithRoot(root.left,sum-root.val) + pathSumStartWithRoot(root.right,sum-root.val);
        return ret;
    }
}
