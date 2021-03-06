package javaPractice.datastructure.preorder;

import java.util.Stack;
//https://javarevisited.blogspot.com/2016/07/binary-tree-preorder-traversal-in-java-using-recursion-iteration-example.html

/*
 * Java Program to traverse a binary tree using PreOrder traversal.
 * In PreOrder the node value is printed first, followed by visit
 * to left and right subtree.
 * input:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * output: 1 2 3 4 5 6
 */

/*
Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
public class PreOrderTraversal {

    public static void main(String[] args) throws Exception {

        // construct the binary tree given in question
        BinaryTree bt = new BinaryTree();
        BinaryTree.TreeNode root = new BinaryTree.TreeNode("1");
        bt.root = root;
        bt.root.left = new BinaryTree.TreeNode("2");
        bt.root.left.left = new BinaryTree.TreeNode("3");

        bt.root.left.right = new BinaryTree.TreeNode("4");
        bt.root.right = new BinaryTree.TreeNode("5");
        bt.root.right.right = new BinaryTree.TreeNode("6");

        // printing nodes in recursive preOrder traversal algorithm
        bt.preOrder();

        System.out.println();

        // traversing binary tree in PreOrder without using recursion
        bt.preOrderWithoutRecursion();

    }

}

class BinaryTree {
    static class TreeNode {
        String data;
        TreeNode left, right;

        TreeNode(String value) {
            this.data = value;
            left = right = null;
        }

        boolean isLeaf() {
            return left == null ? right == null : false;
        }

    }

    // root of binary tree
    TreeNode root;

    /**
     * Java method to print tree nodes in PreOrder traversal
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * traverse the binary tree in PreOrder
     *
     * @param node
     *          - starting node, root
     */
    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.printf("%s ", node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Java method to visit tree nodes in PreOrder traversal without recursion.
     */
    public void preOrderWithoutRecursion() {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            TreeNode current = nodes.pop();
            System.out.printf("%s ", current.data);

            if (current.right != null) {
                nodes.push(current.right);
            }
            if (current.left != null) {
                nodes.push(current.left);
            }
        }
    }

}
