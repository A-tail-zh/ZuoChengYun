package E027;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class E027_1 {

    /**
    链表
     */
    public static class ListNode{
        public int val;
        public ListNode next;
    }

    /**
     * 合并K个有序链表
     * @param arr 需要排序的链表数组
     * @return 合并后有序链表的头部
     */
    public static ListNode mergeKLists(ArrayList<ListNode> arr){
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)-> a.val - b.val );

        for(ListNode h: arr) if(h != null) heap.add(h);

        if(heap.isEmpty()) return null;

        ListNode h = heap.poll();
        ListNode pre = h;

        if(pre.next != null){
            heap.add(pre.next);
        }

        while (!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if(cur.next != null){
                heap.add(cur.next);
            }
        }
        return h;
    }

}


