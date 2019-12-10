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
	int search(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int lh = search(root.left);
		int rh = search(root.right);
		if(lh == -1) return -1;
		if(rh == -1) return -1;
		if(Math.abs(lh - rh) > 1) {
			return -1;
		}
		return Math.max(lh, rh) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		return search(root) <= 1;
	}
}