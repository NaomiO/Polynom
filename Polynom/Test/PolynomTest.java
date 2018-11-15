import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.synth.SynthPasswordFieldUI;
import javax.swing.plaf.synth.SynthSeparatorUI;
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

		boolean check= p1.equals(p2);

		assertEquals(p2.toString(),p1.toString());
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
		//add zero polynom able
		Polynom p8= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p9= new Polynom();
		Polynom_able expected= new Polynom("2x^3 + 5x^10");
		p8.add(p9);
		assertEquals(true, p8.equals(expected));
	}

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

	/*root*/

	@Test
	void testRoot1() {
		Polynom p2 = new Polynom("-2x^3 + 7x^5");
		double result1= p2.root(-0.4, 0.4, 0.0001);
		assertEquals(0, result1);
	}

	@Test
	void testRoot2() {
		Polynom p3 = new Polynom("5.2x^1 -2.7x^4 -4x^3 + 7");
		double result2= p3.root(0, 2, 0.0001);
		assertEquals(1.2230606079101562, result2);

	}

	@Test
	void testRoot3() {
		Polynom p3 = new Polynom("5.2x^1 -2.7x^4 -4x^3 + 7");
		double result3= p3.root(-2, 0, 0.0001);
		assertEquals(-1.427581787109375, result3);

	}
	/*Polynom able Copy*/

	@Test
	void testPolynomableCopy1(){
		Polynom_able p8 =new Polynom();
		Polynom p7 = new Polynom("-8x^3 + 8");
		p8 = p7.copy();
		assertEquals(true, p8.equals(p7));
	}

	@Test
	void testPolynomableCopy2() {
		Polynom p= new Polynom ("0.0");
		Polynom_able copy= new Polynom();
		copy = p.copy();
		assertEquals(p.toString(),copy.toString());
	}

	/*Polynom able derivative */
	@Test
	void testPolynomableDerivative1() {
		Polynom_able p= new Polynom("4x^8+1+5x^5");
		Polynom_able dr= new Polynom("32x^7+25x^4");
		Polynom_able p2;
		p2= p.derivative();

		boolean equal= p2.equals(dr);
		assertEquals(true, equal);
	}

	@Test
	void testPolynomableDerivative2() {
		Polynom_able p= new Polynom("0");
		Polynom_able dr= new Polynom("0");
		Polynom_able p2;
		p2= p.derivative();
		boolean equal= p2.equals(dr);
		assertEquals(true, equal);
	}
	@Test
	void testPolynomableDerivative3() {
		Polynom_able p= new Polynom("-4x^8+1+5x^5");
		Polynom_able dr= new Polynom("-32x^7+25x^4");
		Polynom_able p2;
		p2= p.derivative();
		boolean equal= p2.equals(dr);
		assertEquals(true, equal);
	}

	/*area*/
	@Test
	void testArea1() {

		Polynom p = new Polynom("x^5 + 3x^8");

		try {
			double result =p.area( 3, 2 , 0.0001 );
			fail("worng input");
		}

		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testArea2() {
		Polynom p11=new Polynom("-8x^3+9");
		double result = p11.area(-1, 4, 0.0001);
		assertEquals(18.0211329327697, result);
	}

	/*Iterator*/
	@Test
	void testIterator() {
		Polynom p = new Polynom("-8x^3+9");
		Iterator<Monom> itr = p.iteretor();
		//second monom
		Monom m = itr.next();
		assertEquals(9, m.get_coefficient());
		assertEquals(0, m.get_power());
		//first monom
		Monom m1=itr.next();
		assertEquals(-8, m1.get_coefficient());
		assertEquals(3, m1.get_power());
	}

	/*addPolynomAble*/

	@Test
	void testAddPolynomAble1() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p12= new Polynom ("2.0x^3 + 5.0x^10");
		p11.add(p12);
		Polynom add = new Polynom ("4.0x^3 + 10.0x^10");
		boolean check= p11.equals(add);
		assertEquals(true, check);
	}
	@Test
	void testAddPolynomAble2() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p12= new Polynom ("2.0x^3 + 5.0x^10 + 3x^5");
		p11.add(p12);
		Polynom add = new Polynom ("4.0x^3 + 10.0x^10 +  3x^5");
		boolean check= p11.equals(add);
		assertEquals(true, check);
	}
	@Test
	void testAddPolynomAble3() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p12= new Polynom ("0.0 + 2.0x^3 + 5.0x^10 + 3x^5");
		p11.add(p12);
		Polynom add = new Polynom ("4.0x^3 + 10.0x^10 +  3x^5");
		boolean check= p11.equals(add);
		assertEquals(true, check);
	}
	@Test
	void testAddPolynomAble4() {
		Polynom p11= new Polynom ("2.0x^3 + 5.0x^10");
		Polynom_able p12= new Polynom ("4 + 2.0x^3 + 5.0x^10 + 3x^5");
		p11.add(p12);
		Polynom add = new Polynom ("4 + 4.0x^3 + 10.0x^10 +  3x^5");
		boolean check= p11.equals(add);
		assertEquals(true, check);
		
	}/*toString*/
	@Test
	void testToString1() {
		Polynom p1= new Polynom ("2.0x^3 + 5.0x^10");
		
		assertEquals("2.0x^3 + 5.0x^10", p1.toString());
	}
	
	@Test
	void testToString2() {
		Polynom p1= new Polynom ("0");
		
		assertEquals("0.0", p1.toString());
	}
	

}
