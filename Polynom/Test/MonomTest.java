import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;

class MonomTest {


	Monom m1= new Monom(2,4);
	Monom m6= new Monom(2,4);
	Monom m2= new Monom(1,5);
	Monom m3= new Monom(0,0);
	Monom m4= new Monom(3,4);
	Monom m5= new Monom (0,4);
	Monom m7= new Monom (8,0);	

	/*Constructor*/
	@Test 
	void testvalConstructor(){
		// negative power
		try {
			Monom mval= new Monom(2,-4);
			fail("Error");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//simple monom
		Monom msimple= new Monom(5,4);
		assertEquals(5, msimple.get_coefficient()) ;
		assertEquals(4, msimple.get_power());
	}
	@Test
	void testOtherConstructor() {
		Monom mOther= new Monom (m1.get_coefficient(),m1.get_power());
		assertEquals(2, mOther.get_coefficient()) ;
		assertEquals(4, mOther.get_power());

	}

	@Test
	void testDefaultConstructor() {
		Monom mdef= new Monom ();
		assertEquals(2, mdef.get_coefficient()) ;
		assertEquals(3, mdef.get_power());;
	}

	/*getCoefficient*/
	@Test
	void testgetCoefficient() {
		assertEquals(2, m1.get_coefficient());
		assertEquals(0, m3.get_coefficient());
	}
	/*getPower*/
	@Test
	void testgetPower() {
		assertEquals(4, m1.get_power());
		assertEquals(0, m3.get_power()); 
	}

	/*derivative*/
	@Test
	void testderivative() {
		//derivative of simple monom
		assertEquals(8, m1.derivative().get_coefficient()) ;
		assertEquals(3, m1.derivative().get_power());;
		//derivative of monom zero 
		assertEquals(0, m3.derivative().get_coefficient()) ;
		assertEquals(0, m3.derivative().get_power());;
		////derivative of monom with power is not 0 but the coefficient is
		assertEquals(0, m5.derivative().get_coefficient()) ;
		assertEquals(0, m5.derivative().get_power());;
	}
	/*add*/
	@Test
	void addTestSamepower() {
		//same power (3,4)
		m1.add(m4);
		assertEquals(5, m1.get_coefficient());
		assertEquals(4, m1.get_power());
	}
	@Test
	void addTestDifferentpower() {
		Monom m1= new Monom(2,4);
		// add different power (1,5)
		try {
			m1.add(m2);
			fail("Error");}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	void addTestZeroMonom() {
		Monom m1= new Monom(2,4);
		//add (0,0)
		m1.add(m3);
		assertEquals(4, m1.get_power());
		assertEquals(2, m1.get_coefficient());
	}
	@Test
	void addTestZeroCoefAndPowerNumber() {
		Monom m1= new Monom(2,4);
		//add (0,8)
		m1.add(m5);
		assertEquals(4, m1.get_power());
		assertEquals(2, m1.get_coefficient());
	}
/* multiply*/
	@Test
	void multiplyTestDifferentpower() {

		m1.multiply(m2);
		assertEquals(2, m1.get_coefficient());
		assertEquals(9, m1.get_power());
	}
	@Test
	void multiplyTestWithMonomZero() {
		//multiply this monom with monom (0,0)
		Monom m1= new Monom(2,4);
		m1.multiply(m3);
		assertEquals(0, m1.get_coefficient());
		assertEquals(0, m1.get_power());
	}
	@Test
	void multiplyTestWithCoefZero() {
		//multiply with monom (0,8)
		Monom m1= new Monom(2,4);
		m1.multiply(m5);
		assertEquals(0, m1.get_coefficient());
		assertEquals(0, m1.get_power());
	}
	@Test
	void multiplyTestWithPowerZero() {
		//multiply with monom (8,0)
		Monom m1= new Monom(2,4);
		m1.multiply(m7);
		assertEquals(16, m1.get_coefficient());
		assertEquals(4, m1.get_power());
	}
	/*isZero*/
	@Test
	void isZeroTest1() {
		//check (2,4)
		boolean isZero = m1.isZero();
		assertFalse(isZero);
	}

	@Test
	void isZeroTest2() {
		//check (0,0)
		boolean isZero = m3.isZero();
		assertTrue(isZero);
	}

	@Test
	void isZeroTest3() {
		//check (0,4)
		boolean isZero = m5.isZero();
		assertTrue(isZero);
	}

	@Test
	void isZeroTest4() {
		//check (8,0)
		boolean isZero = m7.isZero();
		assertFalse(isZero);
	}
/*valueAtx*/
	@Test
	void valueAtx1() {
		//m1 (2,4)
		int x=2;
		double result= m1.f(x);
		assertEquals(32, result);
	}

	@Test
	void valueAtx2() {
		//m3 (0,0)
		int x=2;
		double result= m3.f(x);
		assertEquals(0, result);
	}

	@Test
	void valueAtx3() {
		//m5 (0,8)
		int x=2;
		double result= m5.f(x);
		assertEquals(0, result);
	}
	@Test
	void valueAtx4() {
		//m7 (8,0)
		int x=2;
		double result= m7.f(x);
		assertEquals(8, result);
	}
	/*toString*/
	@Test
	void toStringTest() {
		String Monom= "3*x^2";
		assertEquals("3*x^2", Monom);
	}
	/* stringConstructor*/

	@Test
	void teststringConstructor1() {
		Monom m = new Monom ("2x^8");
		assertEquals("2.0x^8", m.toString());
	}
	@Test
	void teststringConstructor2() {
		try {
		Monom m = new Monom ("2x^8...");
		System.out.println(m);
				fail("worng input");
			}

			catch(Exception e){
				System.out.println(e.getMessage());
			}}
	
	

}

