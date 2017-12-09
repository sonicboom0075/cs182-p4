import java.util.*;

class Test{
	public static String fakeinput = "    2/9(5)       1/7(1) 5/8(23) 3/3(9) 1(4) 7/1(71) 10/8(108) 7/10(10) 4(1)   1/7(6)";
	private static final boolean $DEBUG = true;

	public static void main (String [] args){
		String dataLine = readNumbers();
		SelfBalanceTree sbt = new SelfBalanceTree();
		System.out.println("-----------------------");
		Fraction f = new Fraction(1);
		System.out.println("Delete: " +f);
		sbt.delete(f);
		System.out.println("-----------------------");
		System.out.println("dataLine: " +dataLine);
		System.out.println("-----------------------");
		String[] stringArr = makeSArray(dataLine);
		Fraction[] fractionArr = convertFracArr(stringArr);
		int [] quantityArray = quantityArray(stringArr);

		System.out.println("-----------------------");

		for(int i = 0; i < stringArr.length; i++){
			sbt.insert(fractionArr[i],quantityArray[i]);
		}

		Fraction f1 = new Fraction(10,8);
		Fraction f2 = new Fraction(7);

		System.out.println("\n");
		sbt.inorder();
		System.out.println("\n");
		System.out.println("-----------------------");
		System.out.println("Delete: " +f1 +"(108)");
		sbt.delete(f1,108);
		System.out.println("\n");
		sbt.inorder();
		System.out.println("\n-----------------------");
		System.out.println("\n");
		System.out.println("-----------------------");
		System.out.println("Delete: " +f2 +"(71)");
		sbt.delete(f2,71);
		System.out.println("\n");
		sbt.inorder();
		System.out.println("\n-----------------------");
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
				temp = sArr[i].split("\\(");
				temp = temp[0].split("/");
				if(temp.length!=2){
					Fraction f = new Fraction(Integer.parseInt(temp[0]),1);
					iArr[i] = f;
				}else{
					Fraction f = new Fraction(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
					iArr[i] = f;
				}
			}
		}//for
		return iArr;
	}//convertIntArr

	//makes quantity array from given string
	static int[] quantityArray(String [] sArr){
		int [] qArr = new int[sArr.length];
		for(int i = 0; i < sArr.length; i++){
			if(!sArr[i].equals("")){
				String [] temp = new String[sArr[i].length()];
				temp = sArr[i].split("\\(");
				temp[1] = temp[1].substring(0,temp[1].length()-1);
				qArr[i] = Integer.parseInt(temp[1]);
			}
		}
		return qArr;
	}
}
