package javaPractice.datastructure.mydatastructure.CircularLinkedList;

//public class CircularLinkedListConvertBinaryTree {
//}


class BNode
{
    int val;
    BNode left,right;

    public BNode(int val)
    {
        this.val = val;
        left = right = null;
    }
}

// A class to represent a tree
class CircularLinkedListConvertBinaryTree
{
    BNode root;
    public CircularLinkedListConvertBinaryTree()
    {
        root = null;
    }

    // concatenate both the lists and returns the head
    // of the List
    public BNode concatenate(BNode leftList,BNode rightList)
    {
        // If either of the list is empty, then
        // return the other list
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        // Store the last Node of left List
        BNode leftLast = leftList.left;

        // Store the last Node of right List
        BNode rightLast = rightList.left;

        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.right = rightList;
        rightList.left = leftLast;

        // left of first node refers to
        // the last node in the list
        leftList.left = rightLast;

        // Right of last node refers to the first
        // node of the List
        rightLast.right = leftList;

        // Return the Head of the List
        return leftList;
    }

    // Method converts a tree to a circular
    // Link List and then returns the head
    // of the Link List
    public BNode bTreeToCList(BNode root)
    {
        if (root == null)
            return null;

        // Recursively convert left and right subtrees
        BNode left = bTreeToCList(root.left);
        BNode right = bTreeToCList(root.right);

        // Make a circular linked list of single node
        // (or root). To do so, make the right and
        // left pointers of this node point to itself
        root.left = root.right = root;

        // Step 1 (concatenate the left list with the list
        //         with single node, i.e., current node)
        // Step 2 (concatenate the returned list with the
        //         right List)
        return concatenate(concatenate(left, root), right);
    }

    // Display Circular Link List
    public void display(BNode head)
    {
        System.out.println("Circular Linked List is :");
        BNode itr = head;
        do
        {
            System.out.print(itr.val+ " " );
            itr = itr.right;
        }
        while (itr != head);
        System.out.println();
    }
}

// Driver Code
class Main
{
    public static void main(String args[])
    {
        // Build the tree
        CircularLinkedListConvertBinaryTree tree = new CircularLinkedListConvertBinaryTree();
        tree.root = new BNode(10);
        tree.root.left = new BNode(12);
        tree.root.right = new BNode(15);
        tree.root.left.left = new BNode(25);
        tree.root.left.right = new BNode(30);
        tree.root.right.left = new BNode(36);

        // head refers to the head of the Link List
        BNode head = tree.bTreeToCList(tree.root);

        // Display the Circular LinkedList
        tree.display(head);
    }
}