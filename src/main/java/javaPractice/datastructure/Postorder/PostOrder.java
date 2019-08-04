package javaPractice.datastructure.Postorder;
//Postorder traversal of Binary Tree without recursion and without stack
// Java program or postorder traversal

/*
Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
class PostOrder
{

    /* A binary tree node has data,
        pointer to left child
        and a pointer to right child */
    static class Node
    {
        int data;
        Node left, right;
        boolean visited;
    }

    static void postorder( Node head)
    {
        Node temp = head;
        while (temp != null &&
                temp.visited == false)
        {

            // Visited left subtree
            if (temp.left != null &&
                    temp.left.visited == false)
                temp = temp.left;

                // Visited right subtree
            else if (temp.right != null &&
                    temp.right.visited == false)
                temp = temp.right;

                // Print node
            else
            {
                System.out.printf("%d ", temp.data);
                temp.visited = true;
                temp = head;
            }
        }
    }

    static Node newNode(int data)
    {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        node.visited = false;
        return (node);
    }

    /* Driver code*/
    public static void main(String []args)
    {
        Node root = newNode(8);
        root.left = newNode(3);
        root.right = newNode(10);
        root.left.left = newNode(1);
        root.left.right = newNode(6);
        root.left.right.left = newNode(4);
        root.left.right.right = newNode(7);
        root.right.right = newNode(14);
        root.right.right.left = newNode(13);
        postorder(root);
    }
}

// This code is contributed by Arnab Kundu
