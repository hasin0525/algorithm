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
	int search(TreeNode root){
		if(root == null) {
			return 0;
		}
		
		int lc = root.left;
		int rc = root.right;
		
		answer += (Math.abs(lc) + Math.abs(rc));
		
		return root.val + lc + rc -1;
	}
	
    public int distributeCoins(TreeNode root) {
    	answer = 0;
    	search(root);
        return answer;
    }
}