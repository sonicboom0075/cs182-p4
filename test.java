import java.util.*;

class Test{
	public static String fakeinput = "    2/9       1/7 5/8 3/3 1 7/1 10/8 7/10 4";
	private static final boolean $DEBUG = true;

	public static void main (String [] args){
		String dataLine = readNumbers();
		SelfBalanceTree sbt = new SelfBalanceTree();
		System.out.println("-----------------------");
		System.out.println("dataLine: " +dataLine);
		System.out.println("-----------------------");
		String[] stringArr = makeSArray(dataLine);
		Fraction[] fractionArr = convertFracArr(stringArr);

		for(int i = 0; i < stringArr.length; i++){
			System.out.println(stringArr[i]);
		}

		System.out.println("-----------------------");

		for(int i = 0; i < stringArr.length; i++){
			sbt.insert(fractionArr[i]);
		}

		System.out.println("\n");
		sbt.inorder();
		System.out.println("\n");
		System.out.println("-----------------------");
	}

	//readNumbers
	static String readNumbers(){
		String s;
		if($DEBUG){
			s = fakeinput;
		}else{
			//read a line form keyboard (a seg of integers)
			Scanner input = new Scanner(System.in);

			System.out.println("Please input data to sort: ");
			s = input.nextLine();
		}
		//trim front and back
		s = s.trim();
		s = s.replaceAll("\\s+", " ");

		return s;
	}//readNumbers

	static String[] makeSArray(String s){
		//split the line into substrings
		String [] sArr = new String[s.length()];
		sArr = s.split(" ");

		return sArr;
	}

	//convertFracArr
	static Fraction[] convertFracArr(String[] sArr){
		//convert String array into Fraction array
		Fraction [] iArr = new Fraction[sArr.length];
		for(int i = 0; i < sArr.length; i++){

			if(!sArr[i].equals("")){
				String [] temp = new String[sArr[i].length()];
				temp = sArr[i].split("/");
				if(temp.length!=2){
					Fraction f = new Fraction(Integer.parseInt(sArr[i]),1);
					iArr[i] = f;
				}else{
					Fraction f = new Fraction(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
					iArr[i] = f;
				}
			}
		}//for
		return iArr;
	}//convertIntArr
}
