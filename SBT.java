class SelfBalanceTree{
	
	//attribute
	private BNode root;
	
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
			System.out.println(r.data +"|" +r.height +" ");
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
	public void insert(int data){
		root = insert(data, root);
	}
	
	//insert x to tree tinsert data recursively
	
	private BNode insert(int x, BNode t){
		if(t== null) t = new BNode(x);
		else if (x < t.data){
			t.left = insert(x,t.left);
			if(height(t.left) - height(t.right) == 2)
				if (x < t.left.data) t = rotateWithLeftChild(t);
				else t = doubleWithLeftChild(t);
		} else if (x > t.data){
			t.right = insert (x, t.right);
			if (height(t.right) - height (t.left) == 2)
				if (x > t.right.data) t = rotateWithRightChild(t);
				else t = doubleWithRightChild(t);
		}else ;
		t.height = max(height(t.left),height(t.right))+1;
		return t;
	}
	
	//Rotate binary tree node with left child
	private BNode rotateWithLeftChild(BNode k2){
		System.out.print("\nRotate	" +k2 +" With Left Child");
		BNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right))+1;
		k1.height = max(height(k1.left), k2.height) +1;
		return k1;
	}
	
	//Rotate binary tree node with right child
	private BNode rotateWithRightChild(BNode k1){
		System.out.print("\nRotate	" +k1 +" With Right Child");
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
		System.out.println("\nDouble	" +k3 +" With Left Child");
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	
	/*
	Double rotate binary tree node: first right child with its
	left child then node k1 with new right child
	*/
	private BNode doubleWithRightChild(BNode k1){
		System.out.println("\nDouble	" +k1 +" With Right Child");
		k1.left = rotateWithLeftChild(k1.left);
		return rotateWithRightChild(k1);
	}
}