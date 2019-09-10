import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {

	class TreeNode {
		int x, y, index;
		TreeNode left, right;

		public TreeNode(int x, int y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}
	}

	TreeNode tree;

	TreeNode add(TreeNode tree, TreeNode node) {
		if (tree == null) {
			return node;
		}
		if (tree.x > node.x) {
			tree.left = add(tree.left, node);
		} else if (tree.x < node.x) {
			tree.right = add(tree.right, node);
		}
		return tree;
	}

	void preorder(TreeNode node, int[] answer, int[] index) {
		if (node == null) {
			return;
		}
		answer[index[0]++] = node.index;
		preorder(node.left, answer, index);
		preorder(node.right, answer, index);
	}

	void postorder(TreeNode node, int[] answer, int[] index) {
		if (node == null) {
			return;
		}
		postorder(node.left, answer, index);
		postorder(node.right, answer, index);
		answer[index[0]++] = node.index;
	}

	public int[][] solution(int[][] nodeinfo) {

		List<TreeNode> nodelist = new LinkedList<>();
		for (int i = 0; i < nodeinfo.length; i++) {
			nodelist.add(new TreeNode(nodeinfo[i][0], nodeinfo[i][1], i + 1));
		}

		Collections.sort(nodelist, new Comparator<TreeNode>() {
			public int compare(TreeNode t1, TreeNode t2) {
				return t2.y - t1.y;
			}
		});

		for (TreeNode node : nodelist) {
			tree = add(tree, node);
		}

		int[][] answer = new int[2][nodeinfo.length];
		preorder(tree, answer[0], new int[1]);
		postorder(tree, answer[1], new int[1]);
		return answer;
	}
}