package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Tests the RadixSorter.java class
 * 
 * @author Gabriel Perez-Botello gperezb
 *
 */
public class RadixSorterTest {

	/** Tester Student object to be used in test cases. */
	private Student sOne;
	/** Tester Student object to be used in test cases. */
	private Student sTwo;
	/** Tester Student object to be used in test cases. */
	private Student sThree;
	/** Tester Student object to be used in test cases. */
	private Student sFour;
	/** Tester Student object to be used in test cases. */
	private Student sFive;

	/** Tester RadixSorter object with Student type to be used in test cases. */
	private RadixSorter<Student> sorter;

	/**
	 * Sets up student objects to be used in testing to aid in repeat tests.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

		sorter = new RadixSorter<Student>();
	}

	/**
	 * Tests RadixSorter's ability to sort student objects via id numbers.
	 */
	@Test
	public void testSortStudent() {
		Student[] original = { sTwo, sOne, sFour, sThree, sFive };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}

	/**
	 * Tests RadixSorter's ability to sort student objects via id numbers.
	 */
	@Test
	public void testSortStudent1() {
		Student[] original = { sThree, sFive, sFour, sTwo, sOne };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}

	/**
	 * Tests RadixSorter's ability to sort student objects via id numbers.
	 */
	@Test
	public void testSortStudent2() {
		Student[] original = { sOne, sTwo, sThree, sFour, sFive };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}

}
