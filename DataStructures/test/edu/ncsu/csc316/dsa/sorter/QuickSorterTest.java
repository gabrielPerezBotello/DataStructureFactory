package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.sorter.QuickSorter.FirstElementSelector;
import edu.ncsu.csc316.dsa.sorter.QuickSorter.LastElementSelector;
import edu.ncsu.csc316.dsa.sorter.QuickSorter.MiddleElementSelector;

/**
 * Tests QuickSorter.java class's insertion sorter algorithm along with it's
 * ability to sort student objects.
 * 
 * @author Gabriel Perez-Botello gperezb
 *
 */
public class QuickSorterTest {

	/** Tester gpa comparator to be used for custom comparator testing. */
	private StudentGPAComparator gpaComp = new StudentGPAComparator();
	
	/** Tester pivot selector to be used for custom selector testing. */
	private FirstElementSelector firstPivot = new FirstElementSelector();
	/** Tester pivot selector to be used for custom selector testing. */
	private LastElementSelector lastPivot = new LastElementSelector();
	/** Tester pivot selector to be used for custom selector testing. */
	private MiddleElementSelector middlePivot = new MiddleElementSelector();
	
	/** Tester array containing String objects in an ascending order. */
	private String[] dataAscending = { "1", "2", "3", "4", "5" };
	/** Tester array containing String objects in a descending order. */
	private String[] dataDescending = { "5", "4", "3", "2", "1" };
	/** Tester array containing String objects in a random order. */
	private String[] dataRandom = { "4", "1", "5", "3", "2" };

	/**
	 * QuickSorter object to be used for testing the QuickSorter.java class.
	 */
	private QuickSorter<String> stringSorter;
	/**
	 * QuickSorter object to be used for testing the QuickSorter.java class.
	 */
	private QuickSorter<Student> studentSorter;
	/**
	 * QuickSorter object to be used for testing the QuickSorter.java class.
	 */
	private QuickSorter<Student> studentSorter1;
	/**
	 * QuickSorter object to be used for testing the QuickSorter.java class.
	 */
	private QuickSorter<Student> studentSorter2;
	/**
	 * QuickSorter object to be used for testing the QuickSorter.java class.
	 */
	private QuickSorter<Student> studentSorter3;
	/**
	 * QuickSorter object to be used for testing the QuickSorter.java class.
	 */
	private QuickSorter<Student> studentSorter4;

	/** Tester student object to be used in testing. */
	private Student s1 = new Student("firsta", "lasta", 1, 3, 0.1, "flasta");
	/** Tester student object to be used in testing. */
	private Student s1Same = new Student("firsta", "lasta", 1, 3, 0.2, "flasta");
	/** Tester student object to be used in testing. */
	private Student s2 = new Student("firstb", "lasta", 2, 3, 1.5, "flastb");
	/** Tester student object to be used in testing. */
	private Student s3 = new Student("firstb", "lastb", 3, 3, 2.5, "flastb");
	/** Tester student object to be used in testing. */
	private Student s4 = new Student("firstb", "lastb", 4, 3, 3.0, "flastb");
	/** Tester student object to be used in testing. */
	private Student s5 = new Student("firsta", "lastb", 5, 3, 1.7, "flasta");
	/** Tester student object to be used in testing. */
	private Student s6 = new Student("firsta", "lasta", 6, 3, 1.0, "flasta");

	/**
	 * Tester array to be used for the insertion sorting algorithm. Data is in
	 * correct order already.
	 */
	private Student[] studentCorrect = { s4, s3, s2, s5, s6, s1Same, s1 };
	/**
	 * Tester array for insertion sorting algorithm has students in descending order
	 */
	private Student[] studentDescending = { s1, s1Same, s6, s5, s2, s3, s4 };
	/**
	 * Tester array for insertion sorting algorithm has random order for students
	 */
	private Student[] studentRandom = { s5, s2, s4, s3, s1Same, s6, s1 };

	/**
	 * Sets up integerSorter as a new QuickSorter object to help keep tests
	 * repeatable.
	 */
	@Before
	public void setUp() {
		stringSorter = new QuickSorter<String>();
		studentSorter = new QuickSorter<Student>();
		studentSorter1 = new QuickSorter<Student>(gpaComp);
		studentSorter2 = new QuickSorter<Student>(gpaComp, firstPivot);
		studentSorter3 = new QuickSorter<Student>(gpaComp, lastPivot);
		studentSorter4 = new QuickSorter<Student>(gpaComp, middlePivot);

	}

	/**
	 * Tests the Insertion Sorting algorithm using 3 different arrays
	 */
	@Test
	public void testSortIntegers() {
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
	 * Tests the Insertion Sorting algorithm's ability to sort Student objects.
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
	
	/**
	 * Tests the selection Sorting algorithm's ability to sort Student objects.
	 */
	@Test
	public void testSortStudentGPA() {
		studentSorter1.sort(studentCorrect);
		assertTrue(s4.equals(studentCorrect[0]));
		assertTrue(s3.equals(studentCorrect[1]));
		assertTrue(s5.equals(studentCorrect[2]));
		assertTrue(s2.equals(studentCorrect[3]));
		assertTrue(s6.equals(studentCorrect[4]));
		assertTrue(s1Same.equals(studentCorrect[5]));
		assertTrue(s1.equals(studentCorrect[6]));

		studentSorter1.sort(studentDescending);
		assertTrue(s4.equals(studentDescending[0]));
		assertTrue(s3.equals(studentDescending[1]));
		assertTrue(s5.equals(studentDescending[2]));
		assertTrue(s2.equals(studentDescending[3]));
		assertTrue(s6.equals(studentDescending[4]));
		assertTrue(s1Same.equals(studentDescending[5]));
		assertTrue(s1.equals(studentDescending[6]));

		studentSorter1.sort(studentRandom);
		assertTrue(s4.equals(studentRandom[0]));
		assertTrue(s3.equals(studentRandom[1]));
		assertTrue(s5.equals(studentRandom[2]));
		assertTrue(s2.equals(studentRandom[3]));
		assertTrue(s6.equals(studentRandom[4]));
		assertTrue(s1Same.equals(studentRandom[5]));
		assertTrue(s1.equals(studentRandom[6]));
	}
	
	/**
	 * Tests the selection Sorting algorithm's ability to sort Student objects with first pivot selector.
	 */
	@Test
	public void testSortStudentGPAFirst() {
		studentSorter2.sort(studentCorrect);
		assertTrue(s4.equals(studentCorrect[0]));
		assertTrue(s3.equals(studentCorrect[1]));
		assertTrue(s5.equals(studentCorrect[2]));
		assertTrue(s2.equals(studentCorrect[3]));
		assertTrue(s6.equals(studentCorrect[4]));
		assertTrue(s1Same.equals(studentCorrect[5]));
		assertTrue(s1.equals(studentCorrect[6]));

		studentSorter2.sort(studentDescending);
		assertTrue(s4.equals(studentDescending[0]));
		assertTrue(s3.equals(studentDescending[1]));
		assertTrue(s5.equals(studentDescending[2]));
		assertTrue(s2.equals(studentDescending[3]));
		assertTrue(s6.equals(studentDescending[4]));
		assertTrue(s1Same.equals(studentDescending[5]));
		assertTrue(s1.equals(studentDescending[6]));

		studentSorter2.sort(studentRandom);
		assertTrue(s4.equals(studentRandom[0]));
		assertTrue(s3.equals(studentRandom[1]));
		assertTrue(s5.equals(studentRandom[2]));
		assertTrue(s2.equals(studentRandom[3]));
		assertTrue(s6.equals(studentRandom[4]));
		assertTrue(s1Same.equals(studentRandom[5]));
		assertTrue(s1.equals(studentRandom[6]));
	}
	
	/**
	 * Tests the selection Sorting algorithm's ability to sort Student objects with last pivot selector.
	 */
	@Test
	public void testSortStudentGPALast() {
		studentSorter3.sort(studentCorrect);
		assertTrue(s4.equals(studentCorrect[0]));
		assertTrue(s3.equals(studentCorrect[1]));
		assertTrue(s5.equals(studentCorrect[2]));
		assertTrue(s2.equals(studentCorrect[3]));
		assertTrue(s6.equals(studentCorrect[4]));
		assertTrue(s1Same.equals(studentCorrect[5]));
		assertTrue(s1.equals(studentCorrect[6]));

		studentSorter3.sort(studentDescending);
		assertTrue(s4.equals(studentDescending[0]));
		assertTrue(s3.equals(studentDescending[1]));
		assertTrue(s5.equals(studentDescending[2]));
		assertTrue(s2.equals(studentDescending[3]));
		assertTrue(s6.equals(studentDescending[4]));
		assertTrue(s1Same.equals(studentDescending[5]));
		assertTrue(s1.equals(studentDescending[6]));

		studentSorter3.sort(studentRandom);
		assertTrue(s4.equals(studentRandom[0]));
		assertTrue(s3.equals(studentRandom[1]));
		assertTrue(s5.equals(studentRandom[2]));
		assertTrue(s2.equals(studentRandom[3]));
		assertTrue(s6.equals(studentRandom[4]));
		assertTrue(s1Same.equals(studentRandom[5]));
		assertTrue(s1.equals(studentRandom[6]));
	}
	
	/**
	 * Tests the selection Sorting algorithm's ability to sort Student objects with middle pivot selector.
	 */
	@Test
	public void testSortStudentGPAMiddle() {
		studentSorter4.sort(studentCorrect);
		assertTrue(s4.equals(studentCorrect[0]));
		assertTrue(s3.equals(studentCorrect[1]));
		assertTrue(s5.equals(studentCorrect[2]));
		assertTrue(s2.equals(studentCorrect[3]));
		assertTrue(s6.equals(studentCorrect[4]));
		assertTrue(s1Same.equals(studentCorrect[5]));
		assertTrue(s1.equals(studentCorrect[6]));

		studentSorter4.sort(studentDescending);
		assertTrue(s4.equals(studentDescending[0]));
		assertTrue(s3.equals(studentDescending[1]));
		assertTrue(s5.equals(studentDescending[2]));
		assertTrue(s2.equals(studentDescending[3]));
		assertTrue(s6.equals(studentDescending[4]));
		assertTrue(s1Same.equals(studentDescending[5]));
		assertTrue(s1.equals(studentDescending[6]));

		studentSorter4.sort(studentRandom);
		assertTrue(s4.equals(studentRandom[0]));
		assertTrue(s3.equals(studentRandom[1]));
		assertTrue(s5.equals(studentRandom[2]));
		assertTrue(s2.equals(studentRandom[3]));
		assertTrue(s6.equals(studentRandom[4]));
		assertTrue(s1Same.equals(studentRandom[5]));
		assertTrue(s1.equals(studentRandom[6]));
	}
}