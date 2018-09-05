package sword;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_41 {
    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public void Insert(Integer num){
        if (count%2==0){
            //当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        }
        else{
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }
    public Double GetMedian(){
        if (count %2==0){
            return new Double((minHeap.peek()+maxHeap.peek())/2.0);
        }
        else{
            return new Double(minHeap.peek());
        }
    }
}
