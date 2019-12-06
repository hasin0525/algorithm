import java.util.LinkedList;
import java.util.List;

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
	search(TreeNode root, int[] to_delete, List<TreeNode> answer){
		search(root.left, to_delete, answer);
		search(root.right, to_delete, answer);
		
		for(int value : to_delete) {
			if(value == root.val) {
				if(root.left != null) {
					answer.add(root.left);
				}
				if(root.right != null) {
					answer.add(root.right);
				}
				root = null;
				break;
			}
		}
	}
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    	List<TreeNode> answer = new LinkedList<>();
        search(root, to_delete, 0, answer);
        return answer;
    }
}