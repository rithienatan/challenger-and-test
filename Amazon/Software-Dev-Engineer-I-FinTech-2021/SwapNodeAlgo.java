import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SwapNodeAlgo {
        static class Node {
        int index;
        int depth;
        Node left;
        Node right;

        public Node(int index, int depth, Node left, Node right) {
            this.depth = depth;
            this.index = index;
            this.left = left;
            this.right = right;
        }
    }

    static void printInOrder(Node cur, List<Integer> result) {

        if (cur == null) {
            return ;
        }

        printInOrder(cur.left, result);
        //System.out.print(cur.index + " ");
        result.add(cur.index);
        printInOrder(cur.right, result);        
    }

    static void swapInOrder(Node cur, int depth, int k) {

        if (cur == null) {
            return ;
        }

        swapInOrder(cur.left, depth + 1, k);
        //System.out.print("cur.index: " + cur.index);
        swapInOrder(cur.right, depth + 1, k);

        if (depth >=k && depth % k == 0 ) {
            Node tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
        }

    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int numOfNodes = indexes.length;
        int numOfQueries = queries.length;
        int[][] result = new int[numOfQueries][numOfNodes];


        Node root = new Node(1, 1, null, null);
        Node cur = root;

        Queue<Node> nodes = new LinkedList<Node>();
        nodes.offer(cur);

        int N = 0; // = numOfNodes;
        while (N < numOfNodes) {
            cur = nodes.poll();
            int leftData = indexes[N][0];
            int rightData = indexes[N][1];
            //System.out.println("left,right: " + leftData + " " + rightData + " cur: " + cur );
            cur.left = (leftData==-1)? null: new Node(leftData, cur.depth+1, null, null);
            cur.right = (rightData==-1)? null: new Node(rightData, cur.depth+1, null, null);

            if (cur.left != null && cur.left.index != -1) 
                nodes.offer(cur.left);
            if (cur.right != null && cur.right.index != -1) 
                nodes.offer(cur.right);

            N++;
        }

        //TODO: till here we have formed the tree, [not checked yet]
        for (int i = 0; i < numOfQueries; i++) {
            swapInOrder(root, 1, queries[i]);
            List<Integer> res = new ArrayList();
            printInOrder(root, res);
            result[i] = res.stream().mapToInt(r->r).toArray();
        }


        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}