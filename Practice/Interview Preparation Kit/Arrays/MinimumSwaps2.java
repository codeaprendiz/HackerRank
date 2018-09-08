import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void swap(int arr[],int i,int j) {
        int temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        return findMinSwapsToSort(arr);
    }
    
    /**References - 
     * STACKOVERFLOW - https://stackoverflow.com/questions/15152322/compute-the-minimal-number-of-swaps-to-order-a-sequence/15152602#15152602
     * GEEKFORGEEKS - https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
     * Finds the minimum number of swaps to sort given array in increasing order.
     * @param ar array of <strong>non-negative distinct</strong> integers. 
     * input array will be overwritten during the call!
     * @return min no of swaps
     */
public static int findMinSwapsToSort(int[] ar) {
    int n = ar.length;
    Map<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < n; i++) {
        m.put(ar[i], i);
    }
    Arrays.sort(ar);
    for (int i = 0; i < n; i++) {
        ar[i] = m.get(ar[i]);
    }
    m = null;
    int swaps = 0;
    for (int i = 0; i < n; i++) {
        int val = ar[i];
        if (val < 0) continue;
        while (val != i) {
            int new_val = ar[val];
            ar[val] = -1;
            val = new_val;
            swaps++;
        }
        ar[i] = -1;
    }
    return swaps;
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

