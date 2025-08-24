package test;

import org.testng.annotations.Test;

public class intro {

	@Test(groups="Smoke")
	public void Hi() {
		System.out.println("hello");
	}
	
	@Test
	public void Bye() {
		System.out.println("bye");
	}
}
