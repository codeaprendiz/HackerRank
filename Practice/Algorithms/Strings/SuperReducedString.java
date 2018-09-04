

import java.util.*;
public class SuperReducedString {

	private static String super_reduced_string(String s) {
		StringBuilder sb=new StringBuilder(s);
		StringBuilder ans=new StringBuilder();
		sb.reverse();
		Stack<Character> stack=new Stack<Character>();
		stack.push('$');
		int i=0;
		while(i<sb.length()) {
			char ch1=sb.charAt(i);
			char ch2=stack.peek();
			if(ch1!=ch2)
				stack.push(ch1);
			else
				stack.pop();
			i++;			
		}
		while(stack.peek() != '$')
			ans.append(stack.pop());
		return ans.toString();
	}

   public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      String s = in.next();
      String result = super_reduced_string(s);
      if(result.length()==0)
    	  System.out.println("Empty String");
      else
      System.out.println(result);
   }
}
