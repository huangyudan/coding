package sword;

public class RandomListNode {
    int val;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        RandomListNode cur = this;
        while (cur != null) {
            ret.append(cur.val);
            if (cur.random != null)
                ret.append("(" + cur.random.val + ")");
            else {
                ret.append("(_)");
            }
            ret.append('\t');
            cur = cur.next;
        }
        return ret.toString();
    }
}
