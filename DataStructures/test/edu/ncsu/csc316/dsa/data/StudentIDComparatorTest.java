package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests StudentIDComparator java class.
 * 
 * @author Gabriel Perez-Botello gperezb
 */
public class StudentIDComparatorTest {

	/** Tester Student object 1. */
	private Student sOne;
	/** Tester Student object 2. */
	private Student sTwo;
	/** Tester Student object 3. */
	private Student sThree;
	/** Tester Student object 4. */
	private Student sFour;
	/** Tester Student object 5. */
	private Student sFive;

	/** Constructs a tester StudentIDComparator object. */
	private StudentIDComparator comparator;

	/**
	 * Sets up the student object to ensure repeatable testing.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

		comparator = new StudentIDComparator();
	}

	/**
	 * Tests StudentIDComparator class's logic and ensures proper comparisons for
	 * the program.
	 */
	@Test
	public void testCompare() {
		assertTrue(this.comparator.compare(sOne, sTwo) < 0);
		assertFalse(this.comparator.compare(sTwo, sOne) < 0);
		assertTrue(this.comparator.compare(sThree, sTwo) > 0);
		assertTrue(this.comparator.compare(sFour, sTwo) > 0);
		assertTrue(this.comparator.compare(sFour, sOne) > 0);
		assertTrue(this.comparator.compare(sFive, sTwo) > 0);
		assertFalse(this.comparator.compare(sTwo, sOne) < 0);
		assertFalse(this.comparator.compare(sTwo, sOne) < 0);
		assertFalse(this.comparator.compare(sFive, sTwo) < 0);
		assertFalse(this.comparator.compare(sFour, sThree) < 0);
	}

}
