
public class BinarySearchTree_New {

	public Node root;
	public class Node {
		private Node left;
		private Node right;

		int data;


		@Override
		public String toString() {
			return "BinarySearchTree_New [left=" + left + ", right=" + right + ", data=" + data + "]";
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

	//O(n) Time Complexity , O(n) Space Complexity
	public Node findInRecursiveMode(Node root, int dataToBeFind) {
		Node temp;
		temp = root;
		if (temp == null) {
			return null;
		} else if (temp.getData() == dataToBeFind) {
			return temp;
		} else if (temp.getData() > dataToBeFind) {
			return findInRecursiveMode(temp.getLeft(), dataToBeFind);
		} else {
			return findInRecursiveMode (temp.getRight(), dataToBeFind);
		}
	}

	//O(n) Time Complexity , O(1) Space Complexity
	public Node findInNonRecursiveMode(Node root, int dataToBeFind) {
		Node temp;
		temp = root;
		if (temp == null) {
			return null;
		}
		while(temp !=  null) {
			if(temp.getData() == dataToBeFind) {
				return temp;
			} else if (temp.getData() > dataToBeFind) {
				temp = temp.getLeft();
			} else {
				temp=temp.getRight();
			}
		}
		return null;
	}

	public Node findMinElementUsingNonRecursion(Node root) {
		Node minparent;
		minparent = minElementParent(root);
		if (minparent != null && minparent.getLeft()!= null) {
			return minparent.getLeft();
		}else {
			return minparent; // if root is the minimum element
		}
	}
	
	public Node findMinUsingRecursion(Node node){
		
		
		if (node.getLeft() == null) {
			return node;
		}

		return findMinUsingRecursion(node.getLeft());
	}
	
	
	public Node deleteNodeInRecursion(Node node, int nodeToBeDeleted)
	{

		if (node == null) {
			return node;
		} else if (nodeToBeDeleted < node.getData()) {
			node.setLeft(deleteNodeInRecursion(node.getLeft(), nodeToBeDeleted));
		}

		else if (nodeToBeDeleted > node.getData()) {
			node.setRight(deleteNodeInRecursion(node.getRight(), nodeToBeDeleted));
		} else {
			if (node.getLeft() == null) {
				return node.getRight();
			}
			if (node.getRight() == null) {
				return node.getLeft();
			}
			if (node.getRight() != null && node.getLeft() != null) {
				Node temp = findMinElementUsingNonRecursion(node.getRight());
				node.setData(temp.getData());
				node.setRight(deleteNodeInRecursion(node.getRight(), temp.getData()));
			}
		}

		return node;
	}

	
	public Node findMinParentUsingRecursion(Node node){
		
		Node parent = node;
		node = node.getLeft();
		
		if (node == null || node.getLeft() == null) {
			return parent;
		} 
		
		return findMinParentUsingRecursion(node);
	}
	
	public Node findMaxUsingRecursion(Node node) {
		if (node.getRight() == null)
			return node;

		return findMinUsingRecursion(node.getRight());
	}
	
	
	//delete
	
	public Node minElementParent(Node root) {
		Node parent,min;
		parent = root;
		min =root;
		while(min != null) {
			if (min.getLeft() == null)
			{
				return parent;
			}
			else
			{
				parent =min;
				min = min.getLeft();
			}
		}
		return null;

	}
	public Node maxElement(Node root) {
		Node maxparent;
		maxparent = maxElementParent(root);
		if(maxparent != null && maxparent.getRight() != null ) {
			return maxparent.getRight();
		}else {
			return maxparent; // if root is the maximum element
		}

	}
	public Node maxElementParent(Node root) {
		Node parent,max;
		parent= root;
		max=root;
		while(max != null) {			
			if (max.getRight() == null)
			{
				return parent;
			}
			else
			{
				parent = max;
				max = max.getRight();
			}
		}
		return null;

	}

	public void insertNode(int data) {
		Node nodeToBeAdded  = new Node();
		nodeToBeAdded.setData(data);	
		Node temp;
		temp = root;
		if(root==null){
			root = nodeToBeAdded;
			return;
		}

		while(temp != null) {
			if(data < temp.getData()) {
				if (temp.getLeft() == null) 
				{					
					temp.setLeft(nodeToBeAdded);
					return ;
				} else {
					temp = temp.getLeft();
				}
			} else if(data > temp.getData()) {
				if (temp.getRight() == null) {					
					temp.setRight(nodeToBeAdded);
					return ;
				} else {
					temp= temp.getRight();
				}
			} else {
				return ;
			}
		}
		return;
	}

	public void deleteNode(Node root, int deleteNodeValue) {
		Node parent, current;
		parent = root;
		current = root;
		boolean isLeftChild = false;
		if (root == null) {
			return ;
		}		
		else {
			while(current.getData() != deleteNodeValue) {
				parent = current;
				if (deleteNodeValue < current.getData()) {
					current = current.getLeft();
					isLeftChild = true;
				} else {
					current = current.getRight();
					isLeftChild = false;
				}
			}
			if (current.getData() == deleteNodeValue) {
				//if value to be deleted id leaf node
				if(current.getLeft() == null && current.getRight()== null) {
					if (root == current) {
						root = null; //if root element is the only one and has to be deleted		
					}else if(isLeftChild) {
						parent.setLeft(null);
					}else {
						parent.setRight(null);
					}
					// if node to be deleted had only one child
				}else if(current.getLeft()== null && current.getRight() != null) {
					if(root == current) {
						root=current.getRight();
					}
					else if (isLeftChild) {
						parent.setLeft(current.getRight());
					}
					else {
						parent.setRight(current.getRight());
					}
				}// if node to be deleted has 2 children
				else if(current.getRight() == null && current.getLeft() != null) {
					if(root == current) {
						root=current.getLeft();
					}

					else if(isLeftChild) {
						parent.setLeft(current.getLeft());
					}
					else {
						parent.setLeft(current.getLeft());  
					}

				}else if(current.getLeft() != null && current.getRight() != null) {
					Node temp;
					temp = maxElementParent(current.getLeft());
					root.setData(temp.getRight().getData());
					temp.setRight(temp.getRight().getLeft());

				}
			}

		}


	}

	
	
	
	public void deleteNode(int deleteNodeValue) {
		deleteNode(root, deleteNodeValue);
	}


	public static void main(String a[]) {
		BinarySearchTree_New binaryTree = new BinarySearchTree_New();
		Node elementrec,element;
		binaryTree.insertNode(3);
		binaryTree.insertNode(6);
		binaryTree.insertNode(9);
		binaryTree.insertNode(4);
		binaryTree.insertNode(7);
		binaryTree.insertNode(5);
		binaryTree.insertNode(1);
		binaryTree.insertNode(2);
		binaryTree.insertNode(0);
		binaryTree.insertNode(10);
		binaryTree.deleteNodeInRecursion(binaryTree.root, 3);
		element = binaryTree.findInNonRecursiveMode(binaryTree.root,8);
		elementrec = binaryTree.findInRecursiveMode(binaryTree.root,5);
		
		
		//Node node =binaryTree.minElementParent(binaryTree.root);		
	//System.out.println(node);
		System.out.println("Binary tree structure" + binaryTree.toString());
		System.out.println("find element I nNonRecursive Mode " + element);
		System.out.println("find element In RecursiveMode" + elementrec);

	}

	@Override
	public String toString() {
		return "BinarySearchTree_New [root=" + root + "]";
	}

	public BinarySearchTree_New(){
		this.root = null;
	}
}
