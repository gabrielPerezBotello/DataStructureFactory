package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Student.java class
 * 
 * @author Gabriel Perez-Botello gperezb
 *
 */
public class StudentTest {
	/** Tester student object. */
	private Student sOne;
	/** Tester student object. */
	private Student sTwo;
	/** Tester student object. */
	private Student sThree;
	/** Tester student object. */
	private Student sFour;
	/** Tester student object. */
	private Student sFive;

	/**
	 * Sets up tester student objects for repeated tests.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
	}

	/**
	 * Tests the setFirst() method.
	 */
	@Test
	public void testSetFirst() {
		sOne.setFirst("newOne");
		assertEquals("newOne", sOne.getFirst());
	}

	/**
	 * Tests the setLast() method.
	 */
	@Test
	public void testSetLast() {
		sOne.setLast("newOne");
		assertEquals("newOne", sOne.getLast());
	}

	/**
	 * Tests the setId() method.
	 */
	@Test
	public void testSetId() {
		sOne.setId(100);
		assertEquals(100, sOne.getId());
	}

	/**
	 * Tests the setGpa() method.
	 */
	@Test
	public void testSetGpa() {
		sOne.setGpa(3.51);
		assertEquals(3.51, sOne.getGpa(), 0.001);
	}

	/**
	 * Tests the setUnityID() method.
	 */
	@Test
	public void testSetUnityID() {
		sOne.setUnityID("oneUnity");
		assertEquals("oneUnity", sOne.getUnityID());
	}

	/**
	 * Tests the compareTo() method.
	 */
	@Test
	public void testCompareTo() {
		assertTrue(sOne.compareTo(sTwo) < 0);
		assertTrue(sTwo.compareTo(sOne) > 0);
		assertSame(sOne.compareTo(sOne), 0);
		assertSame(sTwo.compareTo(sTwo), 0);
	}

	/**
	 * Tests the equals() method.
	 */
	@Test
	public void testEquals() {
		assertTrue(sOne.equals(sOne));
		assertFalse(sOne.equals(sFive));
		assertFalse(sOne.equals(sFour));
	}

	/**
	 * Tests the toString() method.
	 */
	@Test
	public void testToString() {
		assertEquals(
				"Student: first = OneFirst, last = OneLast, id = 1, creditHours = 1, gpa = 1.0, unityID = oneUnityID./n",
				sOne.toString());
		assertEquals(
				"Student: first = ThreeFirst, last = ThreeLast, id = 3, creditHours = 3, gpa = 3.0, unityID = threeUnityID./n",
				sThree.toString());
	}
}
