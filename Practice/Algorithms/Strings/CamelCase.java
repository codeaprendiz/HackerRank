import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int i=0,count=1;
        while(i<s.length()) {
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90) 
                count++;
            i++;
        }
        System.out.println(count);
    }
}

