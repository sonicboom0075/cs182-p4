import java.util.*;

class Test{
	public static void main (String [] args){
		String dataLine = readNumbers();
		SelfBalanceTree sbt = new SelfBalanceTree();
		System.out.println("dataLine: " +dataLine);
		String[] stringArr = makeSArray(dataLine);
		System.out.println();
		
		for(int i = 0; i < stringArr.length; i++){
			sbt.insert(Integer.parseInt(stringArr[i]));
		}
		
		System.out.println("\n");
		sbt.inorder();
		System.out.println("-----------------------");
		//System.out.println(dataLine);
		//System.out.println(Arrays.toString(makeSArray(dataLine)));
	}
	
	//readNumbers
	static String readNumbers(){
		//read a line form keyboard (a seg of integers)
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input data to sort: ");
		String s = input.nextLine();

		//trim front and back
		s = s.trim();
		s = s.replaceAll("\\s+", " ");
		
		return s;
	}//readNumbers
	
	static String[] makeSArray(String s){
		//split the line into substrings
		String [] sArr = new String[s.length()];
		sArr = s.split(" ");
		
		for(int i = 0; i < sArr.length; i++){
			System.out.println(sArr[i]);
		}
		
		return sArr;
	}
}