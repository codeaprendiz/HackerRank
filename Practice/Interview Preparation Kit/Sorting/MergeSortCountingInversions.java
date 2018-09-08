import java.util.Scanner;
import java.util.Arrays;
/*
References - https://www.geeksforgeeks.org/counting-inversions/
           - https://github.com/RodneyShag/HackerRank_solutions/blob/master/Cracking%20the%20Coding%20Interview/Algorithms/Merge%20Sort%20-%20Counting%20Inversions/Solution.java
Suppose we know the number of inversions in the left half and right half of the array (let be inv1 and inv2), 
what kinds of inversions are not accounted for in Inv1 + Inv2? The answer is – the inversions we have to count 
during the merge step. Therefore, to get number of inversions, we need to add number of inversions in left subarray, 
right subarray and merge().
How to get number of inversions in merge()?
In merge process, let i is used for indexing left sub-array and j for right sub-array. At any step in merge(), 
if a[i] is greater than a[j], then there are (mid – i) inversions. because left and right subarrays are sorted, 
so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j]
*/


// We basically implement MergeSort and 
//  1) Add "swaps" counter and 1 line of code to count swaps when merging
//  2) Use "long" instead of "int" to avoid integer overflow
    
//  Time Complexity: O(n log n)
// Space Complexity: O(n)
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        while (testcases-- > 0) {
            int n = scan.nextInt();
            int [] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scan.nextInt();
            }
            MergeSort ms = new MergeSort();
            System.out.println(ms.mergeSort(array));
        }
        scan.close();
    }

    private static class MergeSort {
        /* Our array has up to n = 100,000 elements. That means there may be O(n^2) swaps. 
           n^2 is 10,000,000,000. A Java int has max value 2,147,483,647 so we use a long 
           to avoid integer overflow */
        private long swaps = 0;
    
        public long mergeSort(int [] array) {
            int [] helper = new int[array.length];
            mergeSort(array, helper, 0, array.length - 1);
            return swaps;
        }

        private void mergeSort(int [] array, int [] helper, int start, int end) {
            if (start < end) {
                int mid = (start + end) / 2;
                mergeSort(array, helper, start, mid);
                mergeSort(array, helper, mid + 1, end);
                merge(array, helper, start, mid, end);
            }
        }

        private void merge(int [] array, int [] helper, int start, int mid, int end) { 
            /* Fill helper array with same elements as original array */
            for (int i = start; i <= end; i++) { // notice "i" goes from "start" to "end", not "0" to "array.length"
                helper[i] = array[i];
            }

            int curr  = start;
            int left  = start;
            int right = mid + 1;

            /* Loop through helper[] left and right halves and continuously copy smaller element to array[] */
            while (left <= mid && right <= end) {
                if (helper[left] <= helper[right]) {
                    array[curr++] = helper[left++];
                } else {
                    /* Each time we choose element from right side, we count up how many elements
                       it is less than from left side. This is equivalent to counting swaps. */
                    swaps += mid + 1 - left;
                    array[curr++] = helper[right++];
                }
            }

            /* Copy remaining elements of left half. Right half elements are already in proper place */
            while (left <= mid) {
                array[curr++] = helper[left++];
            }
        }
    }
}
