package E030;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//设计有setAll功能的哈希表
//https://www.nowcoder.com/practice/7c4559f138e74ceb9ba57d76fd169967
//哈希表常见的三个操作时put、get和containsKey，而且这三个操作的时间复杂度为O(1)。现在想加一个setAll功能，就是把所有记录value都设成统一的值。请设计并实现这种有setAll功能的哈希表，并且put、get、containsKey和setAll四个操作的时间复杂度都为O(1)。
//        [友情提示]: C++选手若有需要可以使用unordered_map替换map来将复杂度从O(log n)降为O(1)
//输入描述：
//第一行一个整数N表示操作数。
//接下来N行，每行第一个数字opt代表操作类型
//        若opt=1，接下来有两个整数x, y表示设置key=x对应的value=y
//        若opt=2，接下来一个整数x，表示查询key=x对应的value，若key=x不存在输出-1
//若opt=3，接下来一个整数x，表示把加入过的所有的key对应的value都设置为x
//输出描述：
//对于每个操作2，输出一个整数表示答案
public class E030_1 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);

        PrintWriter out =  new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int)in.nval;
            SetAllHashMap map = new SetAllHashMap();
            for (int i = 0 ; i < n; i++) {
                in.nextToken();
                int x = (int)in.nval;
                if (x == 1) {
                    in.nextToken();
                    int key = (int)in.nval;
                    in.nextToken();
                    int value = (int)in.nval;
                    map.put(key, value);
                } else if (x == 2) {
                    in.nextToken();
                    int key = (int)in.nval;
                    out.println(map.get(key));
                } else {
                    in.nextToken();
                    int setAllValue = (int)in.nval;
                    map.containKey(setAllValue);
                }
            }

        }
        out.flush();
        out.close();
        br.close();
    }

}
class  SetAllHashMap {
    private Map<Integer, Integer[]> map;
    private int countTime;
    private int setAllTime;
    private int setAllValue;

    public SetAllHashMap() {
        this.map = new HashMap<>();
        countTime = 0;
        setAllTime = -1;
        setAllValue = 0;
    }

    public void put(int key, int value) {
        map.put(key, new Integer[] {value, countTime++});
    }

    public void containKey(int value) {
        this.setAllValue = value;
        this.setAllTime = countTime++;
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            return map.get(key)[1] < setAllTime ? setAllValue : map.get(key)[0];
        }
    }
}
