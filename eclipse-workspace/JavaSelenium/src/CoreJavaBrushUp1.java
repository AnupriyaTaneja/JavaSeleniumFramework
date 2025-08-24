public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
	/*	int myNum = 5;
		String website = "www.google.com";
		char letter = 'a';
		float f = 7.84f;
		double dec = 5.99;
		boolean b = true;
		System.out.println ("Value of myNum is: "+ myNum);
		System.out.println ("Value of website is: "+ website);
		System.out.println ("Value of letter is: "+ letter);
		System.out.println ("Value of f is: "+ f);
		System.out.println ("Value of dec is: "+ dec);
		System.out.println ("Value of b is: "+ b);*/
		
		int[] arr = new int[5];
		arr[0] = 10; arr[1] = 20; arr[2] = 30; arr[3] = 40; arr[4] = 50;
		
		//int[] arr2 = {1,2,3,4,5};
		//System.out.println("Value of 3rd item in arr2 is: " + arr2[2]);
		
		System.out.println("Values in arr are:");
		for (int i=0; i<arr.length; i++) 
		{
			System.out.println(arr[i]);
		}
		
		String[] name = {"Anu", "priya", "Taneja"};
		for (int i=0; i<name.length; i++)
		{
			System.out.println(name[i]);
		}
		
		//Enhanced for loop
		for (String s : name) //pick one item from name array and store it in the variable s
		{
			System.out.print(s + " ");
		}
	}

}
