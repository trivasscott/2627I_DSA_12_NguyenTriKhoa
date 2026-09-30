import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
    // Write your code here
        for (int i = 1; i < n; ++i) {
            List<Integer> tmpArr = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                tmpArr.add(arr.get(j));
            }
            Collections.sort(tmpArr);
            for (int j: tmpArr) {
                System.out.print(j + " ");
            }
            for (int j = i + 1; j < n; ++j) {
                System.out.print(arr.get(j) + " ");
            }
            System.out.println();
        }
    }

}

public class insertionsort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
