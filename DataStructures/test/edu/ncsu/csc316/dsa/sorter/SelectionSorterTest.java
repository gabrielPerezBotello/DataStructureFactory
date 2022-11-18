package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Tests SelectionSorter.java class's selection sorter algorithm along with it's
 * ability to sort student objects.
 * 
 * @author Gabriel Perez-Botello gperezb
 *
 */
public class SelectionSorterTest {

	/** Tester gpa comparator to be used for custom comparator testing. */
	private StudentGPAComparator gpaComp = new StudentGPAComparator();

	/** Tester id comparator to be used for custom comparator testing. */
	private StudentIDComparator idComp = new StudentIDComparator();

	/**
	 * SelectionSorter object to be used for testing the SelectionSorter.java class.
	 */
	private SelectionSorter<Student> studentSort1;
	/**
	 * SelectionSorter object to be used for testing the SelectionSorter.java class.
	 */
	private SelectionSorter<Student> studentSorter;

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
	 * Tester array to be used for the selection sorting algorithm. Data is in
	 * correct order already.
	 */
	private Student[] studentCorrect = { s4, s3, s2, s5, s6, s1Same, s1 };
	/**
	 * Tester array for selection sorting algorithm has students in descending order
	 */
	private Student[] studentDescending = { s1, s1Same, s6, s5, s2, s3, s4 };
	/**
	 * Tester array for selection sorting algorithm has random order for students
	 */
	private Student[] studentRandom = { s5, s2, s4, s3, s1Same, s6, s1 };

	/**
	 * Sets up integerSorter as a new SelectionSorter object to help keep tests
	 * repeatable.
	 */
	@Before
	public void setUp() {
		studentSorter = new SelectionSorter<Student>(gpaComp);

		studentSort1 = new SelectionSorter<Student>(idComp);
	}

	/**
	 * Tests the selection Sorting algorithm's ability to sort Student objects.
	 */
	@Test
	public void testSortStudentGPA() {
		studentSorter.sort(studentCorrect);
		assertTrue(s4.equals(studentCorrect[0]));
		assertTrue(s3.equals(studentCorrect[1]));
		assertTrue(s5.equals(studentCorrect[2]));
		assertTrue(s2.equals(studentCorrect[3]));
		assertTrue(s6.equals(studentCorrect[4]));
		assertTrue(s1Same.equals(studentCorrect[5]));
		assertTrue(s1.equals(studentCorrect[6]));

		studentSorter.sort(studentDescending);
		assertTrue(s4.equals(studentDescending[0]));
		assertTrue(s3.equals(studentDescending[1]));
		assertTrue(s5.equals(studentDescending[2]));
		assertTrue(s2.equals(studentDescending[3]));
		assertTrue(s6.equals(studentDescending[4]));
		assertTrue(s1Same.equals(studentDescending[5]));
		assertTrue(s1.equals(studentDescending[6]));

		studentSorter.sort(studentRandom);
		assertTrue(s4.equals(studentRandom[0]));
		assertTrue(s3.equals(studentRandom[1]));
		assertTrue(s5.equals(studentRandom[2]));
		assertTrue(s2.equals(studentRandom[3]));
		assertTrue(s6.equals(studentRandom[4]));
		assertTrue(s1Same.equals(studentRandom[5]));
		assertTrue(s1.equals(studentRandom[6]));
	}

	/**
	 * Tests the selection Sorting algorithm's ability to sort Student objects via
	 * ID.
	 */
	@Test
	public void testSortStudentID() {
		studentSort1.sort(studentCorrect);
		assertTrue(s1.equals(studentCorrect[0]));
		assertTrue(s1Same.equals(studentCorrect[1]));
		assertTrue(s2.equals(studentCorrect[2]));
		assertTrue(s3.equals(studentCorrect[3]));
		assertTrue(s4.equals(studentCorrect[4]));
		assertTrue(s5.equals(studentCorrect[5]));
		assertTrue(s6.equals(studentCorrect[6]));

		studentSort1.sort(studentDescending);
		assertTrue(s1.equals(studentDescending[0]));
		assertTrue(s1Same.equals(studentDescending[1]));
		assertTrue(s2.equals(studentDescending[2]));
		assertTrue(s3.equals(studentDescending[3]));
		assertTrue(s4.equals(studentDescending[4]));
		assertTrue(s5.equals(studentDescending[5]));
		assertTrue(s6.equals(studentDescending[6]));

		studentSort1.sort(studentRandom);
		assertTrue(s1.equals(studentRandom[0]));
		assertTrue(s1Same.equals(studentRandom[1]));
		assertTrue(s2.equals(studentRandom[2]));
		assertTrue(s3.equals(studentRandom[3]));
		assertTrue(s4.equals(studentRandom[4]));
		assertTrue(s5.equals(studentRandom[5]));
		assertTrue(s6.equals(studentRandom[6]));
	}
}