import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		
		int[] arr = {1,2,4,5,6,7,8,9,10,122};
		//print only multiples of 2
		
		for (int i=0; i<arr.length; i++)
		{
			if (arr[i] % 2 == 0)
			{
				System.out.println("Even:"+ arr[i]);
				break;//if we only want to see whether array has any num which is multiple of 2, we can simply use break so that
				//we can end the execution when first such item is found and array is not required to be fully traversed
			}
			else
			{
				System.out.println("Odd:" + arr[i]);
			}
		}
		//ArrayList can be used when size of array is not pre-defined and grows dynamically
		List<String> al = new ArrayList<String>();
		al.add("Java");
		al.add("Selenium");
		al.add("Course");
		al.add("Udemy");
		//al.remove(0);//removes item at provided index
		System.out.println(al.get(3));
		System.out.println("****************");

		//to get size of array we use length, for array list we use size() method
		for (int i=0; i<al.size(); i++)
		{
			System.out.println(al.get(i));
		}
		System.out.println("****************");
		for (String s : al)
		{
			System.out.println(s);
		}
		System.out.println("****************");

		//check whether the word Selenium is present in the arraylist
		System.out.println(al.contains("Selenium"));//prints true if the item is present 
		//contains is not available for normal Array
		
		//convert Array to ArrayList
		String[] name = {"Anu", "Priya", "Taneja"};
		List<String> nameArrayList = Arrays.asList(name);
		nameArrayList.contains("Taneja");
	}

}
