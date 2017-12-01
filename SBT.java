class SelfBalanceTree{

	//attribute
	private BNode root;
	private static final boolean $DEBUG = false;

	//constructor
	public SelfBalanceTree(){
		root = null;
	}

	//inorder traversal
	public void inorder(){
		inorder(root);
	}

	private void inorder(BNode r){
		if(r!=null){
			inorder(r.left);
			System.out.print(r.data +"[" +r.height +"] ");
			inorder(r.right);
		}
	}

	//find Height
	private int height(BNode t){
		return t == null ? -1 : t.height;
	}

	//max of left and right
	private int max(int lhs, int rhs){
		return lhs > rhs ? lhs : rhs;
	}

	//insert a number
	public void insert(Fraction data){
		root = insert(data, root);
	}

	public void delete(Fraction data){
		root = delete(data, root);
	}

	/*
	if greater than, return 1
	if less than, return 2
	if neither, return 0
	*/

	//insert x to tree tinsert data recursively

	private BNode insert(Fraction x, BNode t){
		if(t== null) t = new BNode(x);
		else if (x.fracCompare(x,t.data) == 2){
			t.left = insert(x,t.left);
			if(height(t.left) - height(t.right) == 2)
				if (x.fracCompare(x,t.left.data) == 2) t = rotateWithLeftChild(t);
				else t = doubleWithLeftChild(t);
		} else if (x.fracCompare(x,t.data) == 1){
			t.right = insert (x, t.right);
			if (height(t.right) - height (t.left) == 2)
				if (x.fracCompare(x, t.right.data) == 1) t = rotateWithRightChild(t);
				else t = doubleWithRightChild(t);
		}else ;
		t.height = max(height(t.left),height(t.right))+1;
		return t;
	}

	private BNode delete(Fraction x, BNode t){
		if(t== null){
			System.out.println("No tree to delete from.");
			t = null;
		}

		return t;
	}

	//Rotate binary tree node with left child
	private BNode rotateWithLeftChild(BNode k2){
		if($DEBUG) System.out.print("\nRotate	" +k2 +" With Left Child");
		BNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right))+1;
		k1.height = max(height(k1.left), k2.height) +1;
		return k1;
	}

	//Rotate binary tree node with right child
	private BNode rotateWithRightChild(BNode k1){
		if($DEBUG) System.out.print("\nRotate	" +k1 +" With Right Child");
		BNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right))+1;
		k2.height = max(height(k2.right), k1.height) +1;
		return k2;
	}

	/*
	Double rotate binary tree node: first left child with its
	right child then node k3 with new left child
	*/
	private BNode doubleWithLeftChild(BNode k3){
		if($DEBUG) System.out.println("\nDouble	" +k3 +" With Left Child");
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	/*
	Double rotate binary tree node: first right child with its
	left child then node k1 with new right child
	*/
	private BNode doubleWithRightChild(BNode k1){
		if($DEBUG) System.out.println("\nDouble	" +k1 +" With Right Child");
		k1.left = rotateWithLeftChild(k1.left);
		return rotateWithRightChild(k1);
	}
}
