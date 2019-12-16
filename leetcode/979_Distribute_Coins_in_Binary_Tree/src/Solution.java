/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int answer;
    int search(TreeNode root) {
        if(root==null) return 0;
        
        int l = search(root.left);
        int r = search(root.right);
        
        answer += (Math.abs(l) + Math.abs(r));
        
        return root.val + l + r - 1;
    }
    public int distributeCoins(TreeNode root) {
        answer = 0;
        search(root);
        return answer;
    }
}