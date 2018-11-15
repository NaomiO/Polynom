import static org.junit.jupiter.api.Assertions.*;

import javax.swing.plaf.synth.SynthPasswordFieldUI;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;
import myMath.Polynom_able;

class PolynomTest {

	/*DefaultConstructor*/

	@Test
	void DefaultConstructorTest() {
		Polynom p1= new Polynom ();
		Polynom p2= new Polynom ("0.0");
//		System.out.println(p2);
//		System.out.println(p1);
//		boolean check= p1.equals(p2);
	String polynom= p1.toString();
		assertEquals("0.0",polynom);
		//assertTrue(check);
	}

	/* CopyConstructor*/

	@Test
	void CopyConstructorTest() {
		Polynom p2= new Polynom ("2.0x^3 + 5.0x^8");
		Polynom p3= new Polynom (p2);
		boolean check = p3.equals(p2);
		assertTrue(check);
		
	}

	/*valueAtx*/

	@Test
	void valueAtx1() {
		Polynom p4= new Polynom ("2.0x^3 + 5.0x^8");
		int x=0;
		double result= p4.f(x);
		assertEquals(0.0, result);
	}
	@Test
	void valueAtx2() {
		Polynom p5= new Polynom ("2.0");
		int x=1;
		double result= p5.f(x);
		assertEquals(2.0, result);
	}

	/* stringConstructor*/

	@Test
	void stringConstructor() {
//////////////////////////////////////////////////////////////
	}

	/*addPolynomAble*/

	@Test
	void addPolynomAble1() {
		//add simple polynom able
		Polynom p6= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p7= new Polynom("4x^10 + 1");
		p6.add(p7);
		String p= p6.toString();

		assertEquals("1.0 + 2.0x^3 + 9.0x^10", p);
	}

	@Test
	void addPolynomAble2() {
		//need to delete 0 
		//add zero polynom able
		Polynom p8= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p9= new Polynom();
		Polynom_able expected= new Polynom("2x^3 + 5x^10");
		p8.add(p9);
		assertEquals(true, p8.equals(expected));
	}
	// 	//Polynom to der
	//	//0.2*x^4-1.5*x^3+3*x^2-x-5
	//	
	//	/*check root*/
	//	@Test
	//	void Test2222() {
	//		Polynom_able p7 = new Polynom("-5.0 -1.0x^1 + 3.0x^2 -1.5x^3 + 0.2x^4" );
	//		assertEquals("-5.0 -1.0x^1 + 3.0x^2 -1.5x^3 + 0.2x^4" , p7);
	//	}
	
	
	/*PolynomAddMonom*/
	@Test
	void addMonom1() {
		//need to delete 0 
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Monom m1= new Monom(0,0);
		p11.add(m1);
		Polynom pnew = new Polynom ("2.0x^3 + 5.0x^10");
		boolean check= p11.equals(pnew);
		assertEquals(true, check);
	}

	@Test
	void addMonom2() {
		//add simple Monom
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Monom m1= new Monom(5,4);
		p11.add(m1);
		Polynom_able pnew= new Polynom ("2.0x^3 + 5.0x^4 + 5.0x^10");
		boolean check= p11.equals(pnew);
		assertTrue(check);
	}
	@Test
	void addMonom3() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Monom m1= new Monom(5,3);
		p11.add(m1);
		Polynom pnew= new Polynom ("7.0x^3 + 5.0x^10");
		boolean check = p11.equals(pnew);
		assertEquals(true,check );
	}

	@Test
	void addMonom4() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Monom m1= new Monom(4,0);
		p11.add(m1);
		Polynom pnew= new Polynom ("4 + 2.0x^3 + 5.0x^10");
		boolean check = p11.equals(pnew);
		assertEquals(true, check);
	}

	/*substract a Polynom_able*/
	@Test
	void substractPolynomable1() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p7= new Polynom("4x^10 + 1");
		p11.substract(p7);
		Polynom abs= new Polynom ("-1.0 + 2.0x^3 + 1.0x^10");
		 boolean check= p11.equals(abs);
		assertEquals(true, check);
	}
	
	
	@Test
	void substractPolynomable2() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p7= new Polynom("0");
		p11.substract(p7);
		Polynom abs= new Polynom ("2.0x^3 + 5.0x^10");
		 boolean check= p11.equals(abs);
		assertEquals(true, check);
	}
	
	@Test
	void substractPolynomable3() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p7= new Polynom("-2.0x^3 -5.0x^10");
		p11.substract(p7);
		Polynom abs= new Polynom ("4.0x^3 + 10.0x^10");
		 boolean check= p11.equals(abs);
		assertEquals(true, check);
	}
	@Test
	void substractPolynomable4() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10 + 4.0x^50");
		Polynom_able p7= new Polynom("2.0x^3 + 5.0x^10 + 4.0x^50");
		p11.substract(p7);
		Polynom abs= new Polynom ("0");
		 boolean check= p11.equals(abs);
		assertEquals(true, check);
	}








}
