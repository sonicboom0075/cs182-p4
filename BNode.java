class BNode{
	int data;
	int height;
	BNode left,right;
	
	public BNode(){
		left = null;
		right = null;
		data = 0;
		height = 0;
	}
	
	public BNode(int n){
		left = null;
		right = null;
		data = n;
		height = 0;
	}
	
	public String toString(){
		return data +"|" +height;
	}
}