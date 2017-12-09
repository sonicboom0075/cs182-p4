class BNode{
	Fraction data;
	int height;
	int quantity;
	BNode left,right;

	public BNode(){
		left = null;
		right = null;
		data = new Fraction(0);
		height = 0;
		quantity = 1;
	}

	public BNode(Fraction n){
		left = null;
		right = null;
		data = n;
		height = 0;
		quantity = 1;
	}

	public BNode(Fraction n, int q){
		left = null;
		right = null;
		data = n;
		height = 0;
		quantity = q;
	}

	public void addToQuantity(int q){
		quantity += q;
	}

	public void subFromQuantity(int q){
		quantity -= q;
	}

	public String toString(){
		return data +"(" +quantity +")" +"[" +height +"] ";
	}
}
