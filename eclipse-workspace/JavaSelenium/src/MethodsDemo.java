
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodsDemo obj = new MethodsDemo();
		String s = obj.getData();
		System.out.println(s);
		
		String s2 = getData2();
		System.out.println(s2);
		
		MethodsDemo2 obj2 = new MethodsDemo2();
		obj2.getUserData();
	}
	 
	public String getData()
	{
		System.out.println("hello world");
		return "String function";
	}
	
	public static String getData2()//belongs to class hence no need to create obj, simply call in main method (line 10)
	{
		System.out.println("hello world static func");
		return "Static function";
	}
}
