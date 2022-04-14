import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BST {
	private Node root; 
    //Basic Node definition. Each Node contains a Value, a left child, and a right child
    class Node { 
        int val; 
        Node left, right; 
  
        public Node(int value) { 
        	val = value; 
            left =null;
            right = null; 
        } 
    } 
  
  
    public BST(int rootValue) {  
        root = new Node(rootValue);  
    } 
  
    //insert Value into the appropriate spot in the tree
    private Node insert(Node root,int value) { 
  

        if (root == null) { 
            root = new Node(value); 
            return root; 
        } 
  
        if (value < root.val) 
            root.left = insert(root.left, value); 
        else if (value > root.val) 
            root.right = insert(root.right, value); 
  
        return root; 
    } 
  
 
    //finish code to print all values with an inorder traversal
    void inorderTraversal(Node root) {

        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    void preorderTraversal(Node root){

        if(root == null){
            return;
        }
        else{
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

    }

    void postorderTraversal(Node root){

        if(root == null){
            return;
        }
        else{
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    private void search(Node root, int key){

        //if value is not found in tree
        if(root == null){
        System.out.println("Value not found in tree");
        return;
        }

        ///value is found in tree
        if(root.val == key){
            System.out.println("Value is found in tree");
            return;
        }

        /*If provided/ available value is less than the value of root node, recurse left subtree
        else recurse right subtree */

        if(key < root.val){
            search(root.left, key);
        }
        else{
            search(root.right, key);
        }
    }
  
    public static void main(String[] args) throws IOException {

    	//create tree with a root of 5
        BST tree = new BST(5);   
      
        tree.insert(tree.root,2); 
        tree.insert(tree.root,7); 
        tree.insert(tree.root,10); 
        tree.insert(tree.root,4); 
        tree.insert(tree.root,1);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Search Tree: ");
        String input = reader.readLine();
        int number = Integer.parseInt(input);

        tree.search(tree.root, number);
        System.out.println("");


        //start traversal at root
        System.out.println("Inorder Traversal Tree");
        tree.inorderTraversal(tree.root);
        System.out.println("\n\nPreorder Traversal Tree");
        tree.preorderTraversal(tree.root);
        System.out.println("\n\nPostorder Traversal Tree");
        tree.postorderTraversal(tree.root);
    }
}