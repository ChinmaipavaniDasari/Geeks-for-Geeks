/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int nodeSum(Node root, int l, int r) {
        // code here
         return bst(root,l,r);
    }
     public int bst(Node root,int l,int r){
        int sum=0;
        if(root==null) return 0;
        sum+=bst(root.left,l,r);
        if(root.data>=l&&root.data<=r)
        {
            sum+=root.data;
        }
        sum+=bst(root.right,l,r);
        return sum;
    }
}
