import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
        int val = arr.get(n - 1);
        for (int i = n - 2; i >= 0; --i) {
            int cur = arr.get(i);
            boolean stop = false;
            if (cur >= val) {
                arr.set(i + 1, cur);
            } else {
                arr.set(i + 1, val);
                stop = true;
            }
            for (int j: arr) {
                System.out.print(j + " ");
            }
            System.out.println();
            if (stop) {
                return;
            }
        }
        arr.set(0, val);
        for (int j: arr) {
            System.out.print(j + " ");
        }
    }

}

public class insertionsort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
