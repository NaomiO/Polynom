import static org.junit.jupiter.api.Assertions.*;

import javax.swing.plaf.synth.SynthPasswordFieldUI;
import javax.swing.plaf.synth.SynthSeparatorUI;
import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;
import myMath.Polynom_able;



class PolynomTest {

//	/*DefaultConstructor*/
//
//	@Test
//	void DefaultConstructorTest() {
//		Polynom p1= new Polynom ();
//		Polynom p2= new Polynom ("0.0");
//		boolean check= p1.equals(p2);
//		assertEquals(true,check);
//	}

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
		Polynom sub= new Polynom ("-1.0 + 2.0x^3 + 1.0x^10");
		 boolean check= p11.equals(sub);
		assertEquals(true, check);
	}
	
	
	@Test
	void substractPolynomable2() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p7= new Polynom("0");
		p11.substract(p7);
		Polynom sub= new Polynom ("2.0x^3 + 5.0x^10");
		 boolean check= p11.equals(sub);
		assertEquals(true, check);
	}
	
	@Test
	void substractPolynomable3() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p7= new Polynom("-2.0x^3 -5.0x^10");
		p11.substract(p7);
		Polynom sub= new Polynom ("4.0x^3 + 10.0x^10");
		 boolean check= p11.equals(sub);
		assertEquals(true, check);
	}
	@Test
	void substractPolynomable4() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10 + 4.0x^50");
		Polynom_able p7= new Polynom("2.0x^3 + 5.0x^10 + 4.0x^50");
		p11.substract(p7);
		Polynom sub= new Polynom ("0");
		 boolean check= p11.equals(sub);
		assertEquals(true, check);
	}
	@Test
	void substractPolynomable5() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10 + 4.0x^50");
		Polynom_able p7= new Polynom("0");
		p11.substract(p7);
		Polynom sub= new Polynom ("2.0x^3 + 5.0x^10 + 4.0x^50");
		 boolean check= p11.equals(sub);
		assertEquals(true, check);
	}
	
	@Test
	void substractPolynomable6() {
		Polynom p11= new Polynom ("0");
		Polynom_able p7= new Polynom("2.0x^3 + 5.0x^10 + 4.0x^50");
		p11.substract(p7);
		Polynom sub= new Polynom ("-2.0x^3 -5.0x^10  -4.0x^50");
		 boolean check= p11.equals(sub);
		assertEquals(true, check);
	}

	/*multiplyPolynomable*/
	
	@Test
	void multiplyPolynomable1() {
		Polynom p= new Polynom ("2.0x^3 + 5.0x^10 + 4.0x^50");
		Polynom_able p1= new Polynom("0.0");
		Polynom mult = new Polynom ("0.0");
		p.multiply(p1);
		boolean check= p.equals(mult);
		assertEquals(true, check);
	}
	
	@Test
	void multiplyPolynomable2() {
		Polynom p= new Polynom ("2.0x^3 + 5.0x^10 + 4.0x^50");
		Polynom_able p1= new Polynom("2.0x^3 + 5.0x^10");
		Polynom mult = new Polynom ("4.0x^6 + 20.0x^13 + 25.0x^20 + 8.0x^53 + 20.0x^60");
		p.multiply(p1);
		boolean check= p.equals(mult);
		assertEquals(true, check);
	}
	
	@Test
	void multiplyPolynomable3() {
		Polynom p= new Polynom ("2.0x^3 + 5.0x^10 + 4.0x^50");
		Polynom_able p1= new Polynom("2");
		Polynom mult = new Polynom ("4.0x^3 + 10.0x^10 + 8.0x^50");
		p.multiply(p1);
		boolean check= p.equals(mult);
		assertEquals(true, check);
	}
	
	/*equalsPolynom*/
	
	@Test
	void equalsPolynom1() {
		Polynom_able p= new Polynom("0");
		Polynom p1= new Polynom("4x^8+1");
		boolean equal = p1.equals(p);
		assertFalse(equal); 
	}
	
	@Test
	void equalsPolynom2() {
		Polynom_able p= new Polynom("4x^8+5");
		Polynom p1= new Polynom("4x^8+1");
		boolean equal = p1.equals(p);
		assertFalse(equal); 
	}
	
	@Test
	void equalsPolynom3() {
		Polynom_able p= new Polynom("4x^8+1+5x^5");
		Polynom p1= new Polynom("4x^8+1");
		boolean equal = p1.equals(p);
		assertFalse(equal); 
	}
	
	/*isZero*/
	@Test
	void isZero1() {
	Polynom p1= new Polynom("4x^8+1");
	Polynom p2= new Polynom("0");
	boolean isZero = p1.equals(p2);	
	assertEquals(false, isZero);
	}
	
	@Test
	void isZero2() {
	Polynom p1= new Polynom("0");
	Polynom p2= new Polynom("0");
	boolean isZero = p1.equals(p2);	
	assertEquals(true, isZero);
	}
	
	@Test
	void isZero3() {
	Polynom p1= new Polynom("0+5x");
	Polynom p2= new Polynom("0");
	boolean isZero = p1.equals(p2);	
	assertEquals(false, isZero);
	}
	
	@Test
	void testroot1() {
	Polynom p2 = new Polynom("-2x^3 + 7x^5");
	double result1= p2.root(-0.4, 0.4, 0.0001);
	assertEquals(0, result1);
	}
	
	@Test
	void testroot2() {
	Polynom p3 = new Polynom("5.2x^1 -2.7x^4 -4x^3 + 7");
	double result2= p3.root(0, 2, 0.0001);
	assertEquals(1.2230606079101562, result2);
	
	}
	
	@Test
	void testroot3() {
	Polynom p3 = new Polynom("5.2x^1 -2.7x^4 -4x^3 + 7");
	double result3= p3.root(-2, 0, 0.0001);
	assertEquals(-1.427581787109375, result3);
	
	}

	
	

	
	//Monom m1= new Monom(2,4);
	//Monom m6= new Monom(2,4);
	//Monom m2= new Monom(1,5);
	//Monom m3= new Monom(0,0);
	//Monom m4= new Monom(3,4);
	//Monom m5= new Monom (0,4);
	//Monom m7= new Monom (8,0);


}
