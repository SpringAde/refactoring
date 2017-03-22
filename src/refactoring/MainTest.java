package refactoring;

import refactoring.dto.Customer;
import refactoring.dto.Movie;
import refactoring.dto.Rental;
import refactoring.price.Price;

public class MainTest {

	public static void main(String[] args) {
		Movie mc1 = new Movie("니모를 찾아서", Price.CHILDREN);
		Movie mc2 = new Movie("말레피센트", Price.CHILDREN);

		Movie mr1 = new Movie("명량", Price.REGULAR);
		Movie mr2 = new Movie("변호사", Price.REGULAR);

		Movie mn1 = new Movie("미녀와 야수", Price.NEW_RELEASE);
		Movie mn2 = new Movie("공조", Price.NEW_RELEASE);
		
		Movie ma1 = new Movie("니이모를 찾아서", Price.ADULT);
		Movie ma2 = new Movie("니고모를 찾아서", Price.ADULT);
		Movie ma3 = new Movie("니숙모를 찾아서", Price.ADULT);

		Rental r1 = new Rental(mc1, 3);
		Rental r2 = new Rental(mc2, 4);
		Rental r3 = new Rental(mr1, 2);
		Rental r4 = new Rental(mr2, 3);
		Rental r5 = new Rental(mn1, 2);
		Rental r6 = new Rental(mn1, 3);
		
		Rental r7 = new Rental(ma1, 3);
		Rental r8 = new Rental(ma2, 2);
		Rental r9 = new Rental(ma3, 3);
		
		

		Customer c1 = new Customer("전지현");
		c1.addRental(r1);
		c1.addRental(r3);
		c1.addRental(r5);
		c1.addRental(r7);
		

		Customer c2 = new Customer("현빈");
		c2.addRental(r2);
		c2.addRental(r4);
		c2.addRental(r6);
		c2.addRental(r8);
		

		System.out.println("=============html=============");
		System.out.println(c1.htmlstatement());
		System.out.println("=============html=============");
		System.out.println(c2.htmlstatement());
		
		System.out.println("*****************************");		
		System.out.println("*****************************");

		System.out.println("===============================");
		System.out.println(c1.Statement());
		System.out.println("===============================");
		System.out.println(c2.Statement());
	}
}
