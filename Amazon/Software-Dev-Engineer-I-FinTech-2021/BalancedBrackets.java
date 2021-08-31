import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {
    /**
     * Check brackets corretly
     * 
     * @param s Receive String
     * @return is Brackets is correct or not
     */
    public static boolean checkBrackets(String s)
    {
        Deque<Character> stack = new ArrayDeque<Character>();
  
        // Traversing the Expression 
        for (int i = 0; i < s.length(); i++)  
        { 
            char x = s.charAt(i); 
  
            if (x == '(' || x == '[' || x == '{')  
            { 
                // Push the element in the stack 
                stack.push(x); 
                continue; 
            } //end if
  
            // IF current current character is not opening 
            // bracket, then it must be closing. So stack 
            // cannot be empty at this point. 
            if (stack.isEmpty())
            { return false; }
            
            char check; 
            switch (x) { 
            case ')': 
                check = stack.pop(); 
                if (check == '{' || check == '[') 
                { return false; } 
                break; 
  
            case '}': 
                check = stack.pop(); 
                if (check == '(' || check == '[') 
                { return false; }
                break; 
  
            case ']': 
                check = stack.pop(); 
                if (check == '(' || check == '{') 
                { return false; }
                break; 
            }//end switchCase
        }//end for
        
        return(stack.isEmpty());
    }//end chackBrackets()
    
    /**
     * Tells if strings brackets is balanced or not
     * 
     * @param s Receive String
     */
    public static String isBalanced(String s)
    {
        String response = "NO";
        
        if(checkBrackets(s) == true)
        { response = "YES"; }
        
        return(response);
    }//end isBalanced()

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
