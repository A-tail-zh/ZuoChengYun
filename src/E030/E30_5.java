package E030;

//295. 数据流的中位数
//https://leetcode.cn/problems/find-median-from-data-stream/description/
//中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
//
//例如 arr = [2,3,4] 的中位数是 3 。
//例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
//实现 MedianFinder 类:
//
//MedianFinder() 初始化 MedianFinder 对象。
//
//void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
//
//double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。

import java.util.PriorityQueue;

public class E30_5 {
    class MedianFinder {

        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a,b)->b - a);//大根堆
            minHeap = new PriorityQueue<>((a,b)->a - b);//小根堆
        }

        public void addNum(int num) {
            if(maxHeap.isEmpty() || maxHeap.peek() >= num){
                maxHeap.add(num);
            }else {
                minHeap.add(num);
            }
            balance();
        }

        public double findMedian() {
            if(((maxHeap.size()+minHeap.size()) & 1) == 1){
                //基数
                return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();

            }
            return (minHeap.peek()+maxHeap.peek()) /2.0;

        }

        private void balance(){
            if(Math.abs(maxHeap.size() - minHeap.size()) == 2){
                if(maxHeap.size()>minHeap.size()){
                    minHeap.add(maxHeap.poll());
                }else {
                    maxHeap.add(minHeap.poll());
                }
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
