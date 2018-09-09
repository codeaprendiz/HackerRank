import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notArray[]=new int[d],notification=0,i=0;
        for(i=0;i<d;i++){
            notArray[i]=expenditure[i];
        }
        if(d%2==0) {
            while(i<expenditure.length) {
                Arrays.sort(notArray);
                float mid=((float)notArray[d/2-1]+(float)notArray[d/2])/2;
                if((int)(2*mid)<=expenditure[i]) notification++;
                int findDelIndex=findIndex(notArray,expenditure[i-d]);
                notArray[findDelIndex]=expenditure[i];
                i+=1;
            }
        }
        else {
             while(i<expenditure.length) {
                Arrays.sort(notArray);
                int mid=(notArray[(d+1)/2-1]);
                if(2*mid<=expenditure[i]) notification++;
                int findDelIndex=findIndex(notArray,expenditure[i-d]);
                notArray[0]=expenditure[i];
                i+=1;
             }
        }
        return notification;
    }
    
    public static int findIndex(int[] arr,int el) {
        int start=0;
        while(start<arr.length) {
            if(arr[start]==el) 
                return start;
            start+=1;
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
