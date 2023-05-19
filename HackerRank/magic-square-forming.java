import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */
    static int[][][] arr = {{{8,3,4},{1,5,9},{6,7,2}},{{6,7,2},{1,5,9},{8,3,4}},{{4,9,2},{3,5,7},{8,1,6}},{{4,3,8},{9,5,1},{2,7,6}},{{6,1,8},{7,5,3},{2,9,4}},{{2,9,4},{7,5,3},{6,1,8}},{{2,7,6},{9,5,1},{4,3,8}},{{8,1,6},{3,5,7},{4,9,2}}};

    public static int formingMagicSquare(List<List<Integer>> s) {
        int min = -1;
        for(int i = 0; i<8; i++){
            int sum = 0;
            int[][] givenArr = arr[i];
            for(int j = 0; j<3;j++){
                sum += Math.abs(s.get(j).get(0)-givenArr[j][0]);
                sum += Math.abs(s.get(j).get(1)-givenArr[j][1]);
                sum += Math.abs(s.get(j).get(2)-givenArr[j][2]);
            }
            if(min == -1 || min > sum){
                min = sum;
            }
        }
        return min;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] sRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> sRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowTempItems[j]);
                sRowItems.add(sItem);
            }

            s.add(sRowItems);
        }

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
