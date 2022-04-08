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
        if (root != null) { 
            System.out.println(root.val); 
        } 
    } 
  
    public static void main(String[] args) { 
    	//create tree with a root of 5
        BST tree = new BST(5);   
      
        tree.insert(tree.root,2); 
        tree.insert(tree.root,7); 
        tree.insert(tree.root,10); 
        tree.insert(tree.root,4); 
        tree.insert(tree.root,1);  
  
        //start traversal at root
        tree.inorderTraversal(tree.root); 
    } 
}