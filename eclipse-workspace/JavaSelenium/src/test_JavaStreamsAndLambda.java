import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test_JavaStreamsAndLambda {
//Count the number of names that start with the alphabet A in the list
	@Test
	public void regular()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekh");
		names.add("Adam");
		names.add("Ram");
		
		int count=0; 
		for(int i=0; i<names.size();i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
		System.out.println("------");
	}	
	@Test
	public void streamFilter()//optimized code in this function compared to above
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekh");
		names.add("Adam");
		names.add("Ram");
		//there is no life for intermediate operation ('starts with filter' here), if there is no terminal operation('count' in this case)
		//terminal operation will execute only when intermediate operation returns true
		long c = names.stream().filter(s->s.startsWith("A")).count();//Lambda expression 
		System.out.println(c);
		//System.out.println("------");
		
		//Stream.of("Abhijeet","Don","Alekh","Adam","Ram");//instead of creating array list collection, stream compatible collection can be created:
		//Stream.of("Abhijeet","Don","Alekh","Adam","Ram").filter(s->s.startsWith("A"));
		//if the action is more than one line then braces can be opened to write the code like below:
		long d = Stream.of("Abhijeet","Don","Alekh","Adam","Ram").filter(s->
		{
			s.startsWith("A");
			//return false;//filter is returning false even if it finds a match, so count will not work
			return true;
		}).count();
		System.out.println(d);
		System.out.println("------");
		
		//print all the names with length greater than 4 in the array list:
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//get all the names with length greater than 4 in the array list, but print only 1st name from that filtered list:
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	@Test
	public void streamMap()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("man");
		names.add("Don");
		names.add("women");
		
		//print names which have last letter as 'a' and convert them to upper case
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("-----------------------------");
		
		//print names which have first letter as 'a' and convert them to upper case after sorting
		List<String> names1 = Arrays.asList("Anil","Don","Alekhya","Adam","Rama");//Arrays.asList converts array to array list
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//merge 2 lists and print them after sorting:
		Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		//check whether Adam is present in the merged list. If its present, true will be returned. If its not, false will be returned:
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));//returns boolean true or false
		System.out.println(flag);
		Assert.assertTrue(flag);//returns true if Adam is present, so script will pass. If this is false, scripts fails
		System.out.println("------");
	}
	@Test
	public void streamCollect()
	{
		//perform modifications/operations and convert to new list
		//collect method operates based on its previous method
		List<String> ls = Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		
		//print first element of this list:
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		//print unique numbers from the array
		//sort the array -> 1,2,3,5,7,9 & then print second number
		//values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		System.out.println("------");
	}
	
}
