package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Tests the BubbleSorter class
 * 
 * @author Gabriel Perez-Botello gperezb
 *
 */
public class BubbleSorterTest {

	/** Tester array containing String objects in an ascending order. */
	private String[] dataAscending = { "1", "2", "3", "4", "5" };
	/** Tester array containing String objects in a descending order. */
	private String[] dataDescending = { "5", "4", "3", "2", "1" };
	/** Tester array containing String objects in a random order. */
	private String[] dataRandom = { "4", "1", "5", "3", "2" };
	/** Tester array containing integers in a random order. */
	private Integer[] intData = { 3, 2, 5, 1, 4 };

	/** BubbleSorter object to be used for testing the class. */
	private BubbleSorter<Integer> intSorter;
	/** Integer comparator to be used for testing. */
	private Comparator<Integer> intComp;

	/**
	 * BubbleSorter object to be used for testing the BubbleSorter.java class.
	 */
	private BubbleSorter<String> stringSorter;
	/**
	 * BubbleSorter object to be used for testing the BubbleSorter.java class.
	 */
	private BubbleSorter<Student> studentSorter;

	/** Tester student object to be used in testing. */
	private Student s1 = new Student("firsta", "lasta", 1, 3, 3.0, "flasta");
	/** Tester student object to be used in testing. */
	private Student s1Same = new Student("firsta", "lasta", 1, 3, 3.0, "flasta");
	/** Tester student object to be used in testing. */
	private Student s2 = new Student("firstb", "lasta", 2, 3, 3.0, "flastb");
	/** Tester student object to be used in testing. */
	private Student s3 = new Student("firstb", "lastb", 3, 3, 3.0, "flastb");
	/** Tester student object to be used in testing. */
	private Student s4 = new Student("firstb", "lastb", 4, 3, 3.0, "flastb");
	/** Tester student object to be used in testing. */
	private Student s5 = new Student("firsta", "lastb", 5, 3, 3.0, "flasta");
	/** Tester student object to be used in testing. */
	private Student s6 = new Student("firsta", "lasta", 6, 3, 3.0, "flasta");

	/**
	 * Tester array to be used for the bubble sorting algorithm. Data is in correct
	 * order already.
	 */
	private Student[] studentCorrect = { s4, s3, s2, s5, s6, s1Same, s1 };
	/**
	 * Tester array for bubble sorting algorithm has students in descending order
	 */
	private Student[] studentDescending = { s1, s1Same, s6, s5, s2, s3, s4 };
	/**
	 * Tester array for bubble sorting algorithm has random order for students
	 */
	private Student[] studentRandom = { s5, s2, s4, s3, s1Same, s6, s1 };

	/**
	 * Sets up integerSorter as a new BubbleSorter object to help keep tests
	 * repeatable.
	 */
	@Before
	public void setUp() {
		stringSorter = new BubbleSorter<String>(null);
		studentSorter = new BubbleSorter<Student>(null);
		intSorter = new BubbleSorter<Integer>(intComp);
	}

	/**
	 * Tests the bubble sorting algorithm using an integer comparator.
	 */
	@Test
	public void testSortIntegers() {
		intSorter.sort(intData);
		assertEquals(1, intData[0].intValue());
		assertEquals(2, intData[1].intValue());
		assertEquals(3, intData[2].intValue());
		assertEquals(4, intData[3].intValue());
		assertEquals(5, intData[4].intValue());

	}

	/**
	 * Tests the bubble Sorting algorithm using 3 different arrays
	 */
	@Test
	public void testSortStrings() {
		stringSorter.sort(dataAscending);
		assertEquals("1", dataAscending[0]);
		assertEquals("2", dataAscending[1]);
		assertEquals("3", dataAscending[2]);
		assertEquals("4", dataAscending[3]);
		assertEquals("5", dataAscending[4]);

		stringSorter.sort(dataDescending);
		assertEquals("1", dataDescending[0]);
		assertEquals("2", dataDescending[1]);
		assertEquals("3", dataDescending[2]);
		assertEquals("4", dataDescending[3]);
		assertEquals("5", dataDescending[4]);

		stringSorter.sort(dataRandom);
		assertEquals("1", dataRandom[0]);
		assertEquals("2", dataRandom[1]);
		assertEquals("3", dataRandom[2]);
		assertEquals("4", dataRandom[3]);
		assertEquals("5", dataRandom[4]);
	}

	/**
	 * Tests the bubble Sorting algorithm's ability to sort Student objects.
	 */
	@Test
	public void testSortStudent() {
		studentSorter.sort(studentCorrect);
		assertTrue(s1.equals(studentCorrect[0]));
		assertTrue(s1Same.equals(studentCorrect[1]));
		assertTrue(s6.equals(studentCorrect[2]));
		assertTrue(s2.equals(studentCorrect[3]));
		assertTrue(s5.equals(studentCorrect[4]));
		assertTrue(s3.equals(studentCorrect[5]));
		assertTrue(s4.equals(studentCorrect[6]));

		studentSorter.sort(studentDescending);
		assertTrue(s1.equals(studentDescending[0]));
		assertTrue(s1Same.equals(studentDescending[1]));
		assertTrue(s6.equals(studentDescending[2]));
		assertTrue(s2.equals(studentDescending[3]));
		assertTrue(s5.equals(studentDescending[4]));
		assertTrue(s3.equals(studentDescending[5]));
		assertTrue(s4.equals(studentDescending[6]));

		studentSorter.sort(studentRandom);
		assertTrue(s1.equals(studentRandom[0]));
		assertTrue(s1Same.equals(studentRandom[1]));
		assertTrue(s6.equals(studentRandom[2]));
		assertTrue(s2.equals(studentRandom[3]));
		assertTrue(s5.equals(studentRandom[4]));
		assertTrue(s3.equals(studentRandom[5]));
		assertTrue(s4.equals(studentRandom[6]));

	}
}
