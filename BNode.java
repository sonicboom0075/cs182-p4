class BNode{
	Fraction data;
	int height;
	BNode left,right;

	public BNode(){
		left = null;
		right = null;
		data = new Fraction(0);
		height = 0;
	}

	public BNode(Fraction n){
		left = null;
		right = null;
		data = n;
		height = 0;
	}

	public String toString(){
		return data +"|" +height;
	}
}
