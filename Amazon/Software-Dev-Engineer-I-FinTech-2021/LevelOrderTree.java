import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class LevelOrderTree {
    int data;
    Node left;
    Node right;
    
    /**
     * height method solution
     * 
     * @param root receive node root
     * @return int height root value
     */
    public static int height(Node root)
    {
        if(root == null)
        { return(0); }
        else
        {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            
            if(leftHeight < rightHeight)
            { return(rightHeight + 1); }
            else
            { return(leftHeight + +1); }
        }//end if
    }//end height()
    
    /**
     * printByLevelOrder method
     *
     * Print tree data by passing each level
     *
     * @param root of tree
     * @param level of tree
     */
    public static void printByLevelOrder(Node root, int level)
    {
        if(root == null)
        { return; }
            
        if(level == 1)
        { System.out.print(root.data + " "); }
        else if(level > 1)
        {
            printByLevelOrder(root.left, level - 1);
            printByLevelOrder(root.right, level - 1);
        }//end if
    }//end printByLevelOrder()
    
    /**
     * levelOrder method
     *
     * Print all data following tree level order.
     *
     * @param root Receive root node
     */
	public static void levelOrder(Node root) 
    {
        int seeHeight = height(root);
        
        for(int i = 1; i <= seeHeight; i++)
        { printByLevelOrder(root, i); }
    }//end levelOrder()

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}