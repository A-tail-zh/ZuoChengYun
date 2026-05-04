package E027;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 每一个线段都有start和end两个数据项，表示这条线段在X轴上从start位置开始到end位置结束。
 * 给定一批线段，求所有重合区域中最多重合了几个线段，首尾相接的线段不算重合。
 * 例如：线段[1,2]和线段[2.3]不重合。
 * 线段[1,3]和线段[2,3]重合
 */
public class E027_2 {

    static int MaxSize = 10010;
    static int[][] lines = new int[MaxSize][2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StreamTokenizer in = new StreamTokenizer(br);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int ans = 0;

        in.nextToken();
        int n = (int)in.nval;
        for(int i = 0;i < n; i++){
            in.nextToken();
            lines[i][0] = (int)in.nval;
            in.nextToken();
            lines[i][1] = (int)in.nval;
        }
        Arrays.sort(lines,0,n,(a, b)->a[0] - b[0]);


        for(int i = 0;i < n; i++){
            while (!heap.isEmpty() && heap.peek() <= lines[i][0]){
                heap.poll();
            }
            heap.add(lines[i][1]);
            ans = Math.max(ans,heap.size());
        }



        out.println(ans);
        out.flush();
        out.close();
    }



}
