public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		//string is an object that represents sequence of characters
		/*String s = "ABC DEF GHI";
		String s1 = "ABC DEF GHI";//if value of s1 is same as s, in back end java will point s1 to same s object instead of creating new obj
		String s5 = "hello";
		String s2 = new String("Welcome");
		String s3 = new String("Welcome");//even though s2 & s3 have same value, due to this obj creation via new, a new obj will get created*/
		
		String str = "Anu Priya Taneja";
		String[] splittedString = str.split(" ");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[2]);
		String[] splittedString2 = str.split("Priya");
		System.out.println(splittedString2[0]);//will include the space between Anu and Priya
		System.out.println(splittedString2[1]);//will include the space between Priya and Taneja
		//to get rid of left and right spaces
		System.out.println(splittedString2[1].trim());
		
		for (int i=0; i<str.length(); i++) //to iterate the elements of the string
		{
			System.out.println(str.charAt(i));
		}
		System.out.println("*********************************");

		//to print elements of string in reverse order
		for (int i=str.length()-1; i>=0; i--) 
		{
			System.out.println(str.charAt(i));
		}
		
	}

}
