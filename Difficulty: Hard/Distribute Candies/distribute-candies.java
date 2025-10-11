/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static int solve(Node root,int moves[]){
        if(root == null){
            return 0;
        }
        int l = solve(root.left,moves);
        int r = solve(root.right,moves);
        int totalExtraCandies = (l+r+root.data)-1;
        moves[0] += Math.abs(l)+Math.abs(r);
        return  totalExtraCandies;
    }
    public int distCandy(Node root) {
        // code here
        if(root==null || (root.left==null && root.right== null)){
            return 0;
        }
        int moves[]={0};
        solve(root,moves);
        return moves[0];
    }
}