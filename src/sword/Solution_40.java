package sword;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Solution_40 {
//    public ArrayList<Integer> GetLeastNumbers(int[] input,int k){
//        ArrayList<Integer> result = new ArrayList<>();
//        int length = input.length;
//        if (k>length || k==0) return result;
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        for (int i = 0; i < length ; i++) {
//            if (maxHeap.size()!=k){
//                maxHeap.offer(input[i]);
//            }
//            else if(maxHeap.peek()>input[i]){
//                maxHeap.poll();
//                maxHeap.offer(input[i]);
//            }
//        }
//
//        for (Integer integer:maxHeap) {
//            result.add(integer);
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num ; i++) {
            nums[i] = in.nextInt();
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int n : nums) {
            maxHeap.add(n);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        ArrayList<Integer> ret = new ArrayList<>(maxHeap);
        List<Integer> aaa = new ArrayList<>();
        aaa.addAll(ret);
        Collections.sort(aaa);
        for (int i = 0; i <aaa.size() ; i++) {
            System.out.print(aaa.get(i));
            if (i!=aaa.size()-1){
                System.out.print(",");
            }

        }

    }
}
