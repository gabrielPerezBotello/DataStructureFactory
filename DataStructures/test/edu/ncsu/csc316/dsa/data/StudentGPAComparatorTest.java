package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests StudentGPAComparator class.
 * 
 * @author Gabriel Perez-Botello gperezb
 */
public class StudentGPAComparatorTest {

	/** Student one tester object. */
	private Student sOne;
	/** Student two tester object. */
	private Student sTwo;
	/** Student three tester object. */
	private Student sThree;
	/** Student four tester object. */
	private Student sFour;
	/** Student five tester object. */
	private Student sFive;

	/** Tester StudentGPAComparator object. */
	private StudentGPAComparator comparator;

	/**
	 * Sets up tester student objects for test consistency.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

		comparator = new StudentGPAComparator();
	}

	/**
	 * Tests the compare method.
	 */
	@Test
	public void testCompare() {
		assertTrue(this.comparator.compare(sTwo, sOne) < 0);
		assertFalse(this.comparator.compare(sOne, sTwo) < 0);
		assertTrue(this.comparator.compare(sThree, sTwo) < 0);
		assertTrue(this.comparator.compare(sFour, sOne) < 0);
		assertTrue(this.comparator.compare(sFive, sOne) < 0);
		assertTrue(this.comparator.compare(sFour, sThree) < 0);
		assertFalse(this.comparator.compare(sOne, sTwo) < 0);
		assertFalse(this.comparator.compare(sOne, sThree) < 0);
		assertFalse(this.comparator.compare(sThree, sFour) < 0);
		assertFalse(this.comparator.compare(sTwo, sFive) < 0);
	}

}
