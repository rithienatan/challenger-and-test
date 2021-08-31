import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class FindTheRunningMeddian {

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        double resposta[] = new double[a.length];
        
        resposta[0] = a[0];
        
        double med = a[0]; 
          
        // max heap to store the smaller half elements  
        PriorityQueue<Integer> smaller = new PriorityQueue<> 
        (Collections.reverseOrder()); 
          
        // min-heap to store the greater half elements  
        PriorityQueue<Integer> greater = new PriorityQueue<>(); 
          
        smaller.add(a[0]); 
        System.out.println(med); 
          
        // reading elements of stream one by one  
        /* At any time we try to make heaps balanced and  
            their sizes differ by at-most 1. If heaps are  
            balanced,then we declare median as average of  
            min_heap_right.top() and max_heap_left.top()  
            If heaps are unbalanced,then median is defined  
            as the top element of heap of larger size */
        for(int i = 1; i < a.length; i++) 
        { 
              
            int x = a[i]; 
              
            // case1(left side heap has more elements)  
            if(smaller.size() > greater.size()) 
            { 
                if(x < med) 
                { 
                    greater.add(smaller.remove()); 
                    smaller.add(x); 
                } 
                else
                    greater.add(x); 
                med = (double)(smaller.peek() + greater.peek())/2; 
            } 
              
            // case2(both heaps are balanced)  
            else if(smaller.size() == greater.size()) 
            { 
                if(x < med) 
                { 
                    smaller.add(x); 
                    med = (double)smaller.peek(); 
                } 
                else
                { 
                    greater.add(x); 
                    med = (double)greater.peek(); 
                } 
            } 
              
            // case3(right side heap has more elements)  
            else
            { 
                if(x > med) 
                { 
                    smaller.add(greater.remove()); 
                    greater.add(x); 
                } 
                else
                    smaller.add(x); 
                med = (double)(smaller.peek() + greater.peek())/2; 
                  
            }
            resposta[i] = med;
        }
        
        return(resposta);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
