/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    static int sum = 0;
    public static void transformTree(Node root) {
        // code here
        sum = 0;
         helper(root);
    }
    static void helper(Node root){
        // inorder: left->root->right
        // inorder traversal of tree -> ascending order
        // reverse inorder traversal -> descending order
        if(root == null) return;
        helper(root.right);
        int temp = root.data;
        root.data = sum;
        sum+=temp;
        helper(root.left);
    }
}