class SelfBalanceTree{

	//attribute
	private BNode root;
	private static final boolean $DEBUG = true;

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
			System.out.print(r);
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
		root = insert(data, root, 1);
	}

	public void insert(Fraction data, int q){
		root = insert(data, root, q);
	}

	public void delete(Fraction data){
		root = delete(data,root,1);
	}

	public void delete(Fraction data, int q){
		root = delete(data, root, q);
	}

	/*
	if greater than, return 1
	if less than, return 2
	if neither, return 0
	*/

	//insert x to tree t insert data recursively

	private BNode insert(Fraction x, BNode t, int q){
		if(t== null) t = new BNode(x,q);
		else if (x.fracCompare(x,t.data) == 2){
			t.left = insert(x,t.left,q);
			if(height(t.left) - height(t.right) == 2){
				if (x.fracCompare(x,t.left.data) == 2) t = rotateWithLeftChild(t);
				else t = doubleWithLeftChild(t);
			}
		} else if (x.fracCompare(x,t.data) == 1){  //========
			t.right = insert (x, t.right,q);
			if (height(t.right) - height (t.left) == 2){
				if (x.fracCompare(x, t.right.data) == 1) t = rotateWithRightChild(t);
				else t = doubleWithRightChild(t);
			}
		}else{		//if equal ==============
			t.addToQuantity(q);
		}
		t.height = max(height(t.left),height(t.right))+1;
		return t;
	}

	//delete x from t
	private BNode delete(Fraction x, BNode t, int q){
		if(t == null){
			t = null;
			System.out.println("No tree to delete from.");
			return t;
		}else if(x.fracCompare(x,t.data) == 2){	//search left tree
			t.left =  delete(x, t.left, q);
		}else if(x.fracCompare(x,t.data) == 1){	//search right tree
			t.right = delete(x, t.right, q);
		}else{																	//node found
			//subtract quantity and check if 0
			t.subFromQuantity(q);
			if(t.quantity<=0){
				if(t.left == null && t.right == null){
					return null;
				}else if(t.right == null){

					return t.left;
				}else if(t.left == null){

					return t.right;
				}else{
					t.data = min(t.right);
					t.right = delete(t.data, t.right, q);
				}
			}
		}		//node found
		t.height = max(height(t.left),height(t.right))+1;

		//rebalancing
		if(height(t.left)>height(t.right)){      //==============
			if(height(t.left) - height(t.right) == 2){
				if (height(t.left.left) - height(t.left.right) >= 0) t = rotateWithLeftChild(t);
				else t = doubleWithLeftChild(t);
			}
		}else if(height(t.left)<height(t.right)){
			if (height(t.right) - height (t.left) == 2){
				if (height(t.right.left) - height(t.right.right) < 0) t = rotateWithRightChild(t);
				else t = doubleWithRightChild(t);
			}
		}//rebalancing

		return t;
	}

//finds minimum value in tree
	private Fraction min(BNode t){
		if(t.left == null) return t.data;
		return min(t.left);
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
		System.out.print("\nDouble	" +k3 +" With Left Child");
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	/*
	Double rotate binary tree node: first right child with its
	left child then node k1 with new right child
	*/
	private BNode doubleWithRightChild(BNode k1){
		System.out.print("\nDouble	" +k1 +" With Right Child");
		k1.left = rotateWithLeftChild(k1.left);
		return rotateWithRightChild(k1);
	}
}
