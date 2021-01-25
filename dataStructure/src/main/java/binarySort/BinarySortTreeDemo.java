package binarySort;

public class BinarySortTreeDemo {
	public static void main(String[] args) {
		int[] arr = {7, 3, 10, 12, 5, 1, 9, 0};
		BinarySortTree binarySortTree = new BinarySortTree();
		for (int i = 0; i < arr.length; i++) {
			binarySortTree.add(new Node(arr[i]));
		}
		binarySortTree.inOrder();
//		binarySortTree.preOrder();
//		binarySortTree.postOrder();
		binarySortTree.deleteNode(3);

		binarySortTree.inOrder();
	}
}

class BinarySortTree {
	private  Node root;
	// 添加节点
	public void add(Node node) {
		if(root == null) {
			root = node;
		} else {
			root.addNode(node);
		}
	}
	// 中序遍历
	public void inOrder() {
		if(root == null) {
			System.out.println("树是空的...");
			return;
		}
		root.inOrder();
	}
	// 先序遍历
	public void preOrder() {
		if(root == null) {
			System.out.println("树是空的...");
			return;
		}
		root.preOrder();
	}
	// 候选遍历
	public void postOrder() {
		if(root == null) {
			System.out.println("树是空的...");
			return;
		}
		root.postOrder();
	}
	// 查找要删除的节点
	public Node search(int value){
		if(root == null) {
			return null;
		} else {
			return root.searchNode(value);
		}
	}
	// 查找要删除的父节点
	public Node searchParent(int value){
		if(root == null) {
			return null;
		} else {
			return root.searchParent(value);
		}
	}

	/**
	 *	删除子树中最小的节点,并返回
	 * @param node 子树的根节点
	 * @return 返回子树中最小的节点值,
	 */
	public int delRightTreeMin(Node node) {
		Node target = node;
		while (true) {
			if(target.left == null) {
				break;
			}
			target = target.left;
		}
		node.delNode(target.value);
		return target.value;
	}
	// 删除节点
	public void deleteNode(int value){
		if(root == null) {
			return;
		} else {
			Node target = search(value);

			if(target == null) {
				return;
			}
			// 如果target是根节点
			if(root.left == null && root.right == null) {
				root = null;
			}
			Node parent = searchParent(value);

			if(target.left == null && target.right  == null) {
				/**
				 * 情况1: 删除叶子节点
				 * 1.需要找到删除的节点targetNode
				 * 2.找到targetNode的父节点, parent
				 * 3.确定targetNode是parent的左子节点,还是右子节点
				 * 4.如果是左子节点 parent.left = null
				 * 5.如果是右子节点 parent.right = null
				 */
				if(parent.left != null && parent.left.value == value) {
					parent.left = null;
				} else if(parent.right != null && parent.right.value == value) {
					parent.right = null;
				}
			} else if(target.left != null && target.right != null) {
				/**
				 * 情况3: 有2个叶子的树
				 * 1.需要找到删除的节点targetNode
				 * 2.找到targetNode的父节点, parent
				 * 3.从target的右子树找到最小的节点(或者从左子树中找到最大的节点)
				 * 4.删除该节点,然后把该节点替换到targetNode的位置
				 */
				int minValue = delRightTreeMin(target);
				target.value = minValue;
			} else {
				/**
				 * 情况2: 只有一个叶子的树
				 * 1.需要找到删除的节点targetNode
				 * 2.找到targetNode的父节点, parent
				 * 3.确定targetNode是parent的左子节点,还是右子节点
				 * 4.确定target的叶子节点是左子节点还是右子节点
				 * 5.如果target有左子节点
				 * 5.1如果target是parent的左子节点
				 * parent.left = target.left
				 * 5.2如果target是parent的右子节点
				 * parent.right = target.left
				 *
				 * 6如果target有右子节点
				 * 6.1 如果target是parent的左子节点
				 * parent.left= target.right
				 * 6.2 如果target是parent的右子节点
				 * parent.right = target.right
				 *
				 */
				if(target.left != null && target.right == null) {
					if(parent != null) {
						if(parent.left.value == value) {
							parent.left = target.left;
						} else if(parent.right.value == value) {
							parent.right = target.left;
						}
					} else {
						root = target.left;
					}
				} else if(target.right != null && target.left == null) {
					if(parent != null) {
						if(parent.left.value == value) {
							parent.left= target.right;
						} else if(parent.right.value == value) {
							parent.right = target.right;
						}
					} else {
						root = target.right;
					}
				}
			}
		}
	}

}

class Node {
	int value;
	Node left;
	Node right;
	public Node(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				'}';
	}
	// 添加节点
	public void addNode(Node node) {
		if(node == null) {
			return;
		}
		if(node.value < this.value) {
			if(this.left == null) {
				this.left = node;
			} else {
				this.left.addNode(node);
			}
		} else {
			if(this.right == null) {
				this.right = node;
			} else {
				this.right.addNode(node);
			}
		}
	}
	// 查找目标节点
	public Node searchNode(int value) {
		if(this.value == value) {
			return this;
		} else if(this.value > value) {
			if(this.left == null) {
				return null;
			}
			return this.left.searchNode(value);
		} else {
			if(this.right == null) {
				return null;
			}
			return this.right.searchNode(value);
		}
	}
	// 查找目标节点的父节点
	public Node searchParent(int value) {
		if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			if(this.left != null && this.value > value) {
				return this.left.searchParent(value);
			} else if(this.right != null && this.value < value){
				return this.right.searchParent(value);
			} else {
				return null;
			}
		}
	}
	//递归删除结点
	//1.如果删除的节点是叶子节点，则删除该节点
	//2.如果删除的节点是非叶子节点，则删除该子树
	public void delNode(int value) {
		/**
		 *  1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
		 * 	2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
		 * 	3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
		 * 	4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
		 * 	5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.
		 */

		// 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
		if(this.left != null && this.left.value == value) {
			this.left = null;
			return;
		}
		// 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
		if(this.right != null && this.right.value == value) {
			this.right = null;
			return;
		}
		// 向左子树进行递归删除
		if(this.left != null) {
			this.left.delNode(value);
		}
		// 则应当向右子树进行递归删除
		if(this.right != null) {
			this.right.delNode(value);
		}
	}
	// 更新节点

	// 中序遍历
	public void
	inOrder() {
		if(this.left != null) {
			this.left.inOrder();
		}
		System.out.println(this.value);
		if(this.right != null) {
			this.right.inOrder();
		}
	}
	// 先序遍历
	public void preOrder(){
		System.out.println(this.value);
		if(this.left != null) {
			this.left.preOrder();
		}

		if(this.right != null) {
			this.right.preOrder();
		}
	}
	// 后续遍历
	public void postOrder() {
		if(this.left != null) {
			this.left.postOrder();
		}

		if(this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this.value);
	}
}