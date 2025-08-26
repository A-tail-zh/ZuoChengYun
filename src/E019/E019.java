package E019;

import java.io.*;

public class E019 {
    public static void main(String[] args) throws IOException {
        //把文件读到内从中
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //一个一个读数字
        StreamTokenizer in = new StreamTokenizer(br);

        //提交答案也是一个文件托管
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while(in.nextToken() != StreamTokenizer.TT_EOF){
            int n = (int)in.nval;
            in.nextToken();
            int m = (int)in.nval;
            int[][] arr = new int[n][m];
            for (int i = 0; i < n;i++)
                for (int j = 0 ;j < m;j++){
                    in.nextToken();
                    arr[i][j] = (int)in.nval;
                }
            out.println();
        }
        out.flush();
        out.close();



    }

}
