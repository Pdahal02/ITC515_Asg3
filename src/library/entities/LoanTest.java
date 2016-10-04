package library.entities;

import static org.junit.Assert.*;
import java.util.*;

//import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import library.interfaces.entities.IMember;
/**
* @author Pravin
*
*/
public class LoanTest {
	public static Loan loan;
	public static Loan loan1;	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Book b1= new Book("Pravin", "Welcome to JUnit testing", "12345", 9999);
		Book b2= new Book("Pravin", "Welcome to JUnit testing", "12345", 00023);

		Member m1= new Member("Pravin","Dahal","12345","Pravin@gmail.com",1234);
		//Date d1 = (new GregorianCalendar(2016, 9, 15)).getTime();
		//Date d2= new Date();
		Calendar returnDate = Calendar.getInstance();
		returnDate.setTime(new Date()); // Now use today date.
		returnDate.add(Calendar.DATE, 15);
		loan = new Loan(b1, m1, Calendar.getInstance().getTime(), returnDate.getTime());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -12);
		returnDate.setTime(new Date());
		returnDate.add(Calendar.DATE, +1);
		loan1 =new Loan(b2,m1,cal.getTime(), returnDate.getTime());
		//System.out.println(loan1.toString());
		//loan1.checkOverDue(Calendar.getInstance().getTime());
		//loan1.commit(1);
		//loan1.complete();

		//Date d2 = new Date(2016, 10, 15);
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoan() {
		boolean b = loan instanceof Loan;
		assertTrue(b);
		}

	@Test
	public void testCommit() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testComplete() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testIsOverDue() {
		boolean check = loan1.isOverDue();
		assertTrue(check);
		}

	@Test
	public void testCheckOverDue() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testGetBorrower() {
		IMember  borrower=loan.getBorrower();
		assertEquals("Maching borrower",1234,borrower.getID());
	}

	@Test
	public void testGetBook() {
		Book b1= new Book("Pravin", "Welcome to JUnit testing", "123456", 9999);
		int id =b1.getID();
		assertEquals("Maching book",9999,id);
	}

	@Test
	public void testGetID() {
		Member m= new Member("Pravin","Dahal","123456","prav.dahl17@gmail.com",2222);
		int id= m.getID();
		assertEquals("Matching Member Id", 2222, id);
	}

	@Test
	public void testGetState() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");//have to implement
	}

}
