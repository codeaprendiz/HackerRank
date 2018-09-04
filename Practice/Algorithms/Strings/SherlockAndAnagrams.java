import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static ArrayList<String> findAllSubs(String A) {
        ArrayList<String> listOfSubs=new ArrayList<String>();
        for (int i = 0; i < A.length(); i++) {
        for (int j = i+1; j <= A.length(); j++) {
            listOfSubs.add(A.substring(i,j));
        }
    }
        return listOfSubs;
    }
    
    public static boolean checkAnagram(String str1, String str2) {

        if (str1.length() != str2.length())
          return false;

        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    static int sherlockAndAnagrams(String s){
        int result=0;
        ArrayList<String> listOfSubStrings=findAllSubs(s);
        for(int i=0;i<listOfSubStrings.size()-1;i++) {
        	String base=listOfSubStrings.get(i);
        	for(int j=i+1;j<listOfSubStrings.size();j++) {
        		String comp=listOfSubStrings.get(j);
        		if(checkAnagram(base,comp))
        			result++;
        	}
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}
