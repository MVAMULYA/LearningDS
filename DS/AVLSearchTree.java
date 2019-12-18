
public class AVLSearchTree {
	public Node root;

	public class Node{
		private Node left;
		private Node right;
		int data;
		int balanceFactor;

		@Override
		public String toString() {
			return "Node [left=" + left + ", right=" + right + ", data=" + data + ", balanceFactor=" + balanceFactor
					+ "]";
		}
		public int getBalanceFactor() {
			return balanceFactor;
		}
		public void setBalanceFactor(Node node) {

			int leftHeight,rightHeight;

			leftHeight = getHeight(node.getLeft());
			rightHeight = getHeight(node.getRight());

			balanceFactor = leftHeight - rightHeight ;

		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}


	}

	private int getHeight(Node node) {
		// TODO Auto-generated method stub
		int height;
		while(node != null) {
			height = 0;
			if (node.getRight()== null && node.getLeft()== null) {
				return height;
			}
			else if (node.getLeft()==null || node.getRight() == null ) {
				if(node.getLeft()==null) {
					node = node.getRight();
					height++;
				}else if(node.getRight() == null){
					node = node.getLeft();
					height++;
				}
			}else {
				int leftheight, rightheight;
				leftheight = getHeight(node.getLeft());
				rightheight = getHeight(node.getRight());
				height = height + (leftheight > rightheight ? leftheight : rightheight); // Incomplete for what if leftsubtree height is equal to rightsubtree height

			}

		}
		return 0;
	}

	public static void main(String args[]) {
		AVLSearchTree avlt = new AVLSearchTree();
		int height ;
		avlt.insertNode(6);
		avlt.insertNode(5);
		avlt.insertNode(4);
		avlt.insertNode(3);
		avlt.insertNode(2);
		avlt.insertNode(1);
		avlt.insertNode(0);
		avlt.insertNode(3);
		// avlt.deleteNode(3);
		height = avlt.getHeight(avlt.root);
		System.out.println("AVL Tree structure" + avlt.toString());
		System.out.println("height of avl tree"+ height);

	}

	/*private void deleteNode(int nodeTobeDeleted) {
		// TODO Auto-generated method stub

	}*/

	@Override
	public String toString() {
		return "AVLSearchTree [root=" + root + "]";
	}

	private void insertNode(int data) {
		// TODO Auto-generated method stub

		Node nodeToBeAdded  = new Node();
		nodeToBeAdded.setData(data);	
		Node temp;
		temp = root;
		if(root==null){
			root = nodeToBeAdded;

		}

		while(temp != null) {
			if(data < temp.getData()) {
				if (temp.getLeft() == null) 
				{					
					temp.setLeft(nodeToBeAdded);
					updateBalanceFactor(root);
					Node unbalancedNode = getUnbalancedNode(nodeToBeAdded);
					if (unbalancedNode != null) {

						balanceTree(unbalancedNode);	// Incomplete -- should find which node to be sent for balancing.
					}
					updateBalanceFactor(root);
					return;

				} else {
					temp = temp.getLeft();
				}
			} else if(data > temp.getData()) {
				if (temp.getRight() == null) {					
					temp.setRight(nodeToBeAdded);
					updateBalanceFactor(root);
					Node unbalancedNode = getUnbalancedNode(nodeToBeAdded);
					if (unbalancedNode != null) {

						balanceTree(unbalancedNode);	// Incomplete -- should find which node to be sent for balancing.
					}
					updateBalanceFactor(root);
					return;

				} else {
					temp= temp.getRight();
				}
			} else {
				return; // duplicate node isn't added.
			}
		}

	}

	private Node getUnbalancedNode(Node nodeToBeAdded) {
		// TODO Auto-generated method stub
		Node parent;
		if(nodeToBeAdded.getData() == root.getData()) {

			return null;	

		}
		else {

			parent = getParent(nodeToBeAdded);
			while(parent!=null) {
				if( parent.getBalanceFactor() <= 1 && parent.getBalanceFactor() >= -1) {
					parent = getParent(parent);
				}else {
					return parent;
				}
			}
		}
		return null;

	}

	private Node getParent(Node node) {
		// TODO Auto-generated method stub
		Node parent = root;
		while(parent!= null) {
			if(parent.getLeft().getData() < node.getData()) {
				parent = parent.getRight();
			}else if(parent.getLeft().getData() > node.getData()){
				parent = parent.getLeft();
			}else {
				return parent;
			}
		}
		return null;
	}

	private void updateBalanceFactor(Node node) {
		// TODO Auto-generated method stub
		if(node != null) {
			node.setBalanceFactor(node);
			updateBalanceFactor(node.getLeft());			
			updateBalanceFactor(node.getRight());
		}else {
			return;
		}

	}



	private void balanceTree(Node node) {
		// TODO Auto-generated method stub

		if( node.getBalanceFactor() <= 1 && node.getBalanceFactor() >= -1) {
			return;
		}else if(node.getBalanceFactor() > 1) {
			if( getHeight(node.getLeft().getLeft()) > getHeight(node.getLeft().getRight())) {
				rotateLeftRight(node);
			}else {
				rotateLeftLeft(node);
			}

		}else if(node.getBalanceFactor() < 1) {
			if ( getHeight(node.getRight().getLeft()) < getHeight(node.getRight().getRight())){
				rotateRightLeft(node);
			}else {
				rotateRightRight(node);
			}

		}
	}

	private void rotateRightRight(Node node) {
		// TODO Auto-generated method stub
		Node temp;
		temp = node;		
		node.setData(node.getRight().getData());
		node.setLeft(temp);
		temp.setRight(node.getRight().getLeft());
		node.setRight(node.getRight().getRight());


	}

	private void rotateRightLeft(Node node) {
		// TODO Auto-generated method stub
		Node temp;
		temp = node;		
		node.setData(node.getRight().getLeft().getData());
		node.setLeft(temp);
		temp.setRight(node.getRight().getLeft().getLeft());
		node.getRight().setLeft(node.getRight().getLeft().getRight());

	}

	private void rotateLeftLeft(Node node) {
		// TODO Auto-generated method stub
		Node temp;
		temp = node;		
		node.setData(node.getLeft().getData());
		node.setRight(temp);
		temp.setLeft(node.getLeft().getRight());
		node.setLeft(node.getLeft().getLeft());

	}

	private void rotateLeftRight(Node node) {
		// TODO Auto-generated method stub
		Node temp;
		temp = node;		
		node.setData(node.getLeft().getRight().getData());
		node.setRight(temp);
		temp.setLeft(node.getLeft().getRight().getRight());
		node.getLeft().setRight(node.getLeft().getRight().getLeft());


	}

}


