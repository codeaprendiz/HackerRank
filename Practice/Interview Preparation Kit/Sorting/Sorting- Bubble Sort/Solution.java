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
    
    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int res=bubbleSort(a,a.length);
    System.out.println("Array is sorted in " + res +" swaps.");
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[a.length-1]);        
    }

    static int bubbleSort(int arr[],int size) {
        boolean sorted=false;
        int noOfSwaps=0;
        for(int i=0;i<size;i++) {
            sorted=true;
            for(int j=1;j<size-i;j++) 
                if(arr[j-1]>arr[j]) {
                    swap(arr,j,j-1); 
                    sorted=false;
                    noOfSwaps+=1;
                }
            if(sorted==true) break;
        }
        return noOfSwaps;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
