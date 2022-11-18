package edu.ncsu.csc316.dsa.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;
import edu.ncsu.csc316.dsa.sorter.SelectionSorter;

/**
 * Tests the StudentManager class.
 * 
 * @author Gabriel Perez-Botello gperezb
 *
 */
public class StudentManagerTest {
	/** Tester StudentManager object used for testing the class. */
	private StudentManager sm;
	/**
	 * Tester StudentManager object used for testing the class ability to handle
	 * custom comparators.
	 */
	private StudentManager sm1;
	/**
	 * Tester StudentManager object used for testing the class ability to handle
	 * custom comparators.
	 */
	private StudentManager sm2;

	/** Id comparator to be used in testing. */
	private StudentIDComparator idComp = new StudentIDComparator();
	/** Gpa comparator to be used in testing. */
	private StudentGPAComparator gpaComp = new StudentGPAComparator();

	/** Tester SelectionSorter to sort via gpa descending order. */
	private SelectionSorter<Student> gpaSort = new SelectionSorter<Student>(gpaComp);
	/** Tester SelectionSorter to sort via id ascending order. */
	private SelectionSorter<Student> idSort = new SelectionSorter<Student>(idComp);

	/**
	 * Aids in ensuring tests are properly set up each time they are run.
	 */
	@Before
	public void setUp() {
		sm = new StudentManager("input/student_ascendingID.csv");
		sm1 = new StudentManager("input/student_ascendingID.csv", gpaSort);
		sm2 = new StudentManager("input/student_descendingID.csv", idSort);
	}

	/**
	 * Tests the sort method contained within StudentManager class.
	 */
	@Test
	public void testSort() {
		Student[] sorted = sm.sort();
		assertEquals("Tanner", sorted[0].getFirst());
		assertEquals("Roxann", sorted[1].getFirst());
		assertEquals("Shanti", sorted[2].getFirst());
		assertEquals("Dante", sorted[3].getFirst());
		assertEquals("Cristine", sorted[4].getFirst());
		assertEquals("Ara", sorted[5].getFirst());
		assertEquals("Lewis", sorted[6].getFirst());
		assertEquals("Charlene", sorted[7].getFirst());
		assertEquals("Amber", sorted[8].getFirst());
		assertEquals("Lacie", sorted[9].getFirst());
		assertEquals("Idalia", sorted[10].getFirst());
		assertEquals("Tyree", sorted[11].getFirst());
		assertEquals("Evelin", sorted[12].getFirst());
		assertEquals("Alicia", sorted[13].getFirst());
		assertEquals("Loise", sorted[14].getFirst());
		assertEquals("Nichole", sorted[15].getFirst());
	}

	/**
	 * Additional test cases to test that custom comparators sort the data
	 * correctly.
	 */
	@Test
	public void testSortCustomGPA() {
		Student[] sorted = sm1.sort();
		assertEquals("Nichole", sorted[0].getFirst());
		assertEquals("Alicia", sorted[1].getFirst());
		assertEquals("Charlene", sorted[2].getFirst());
		assertEquals("Cristine", sorted[3].getFirst());
		assertEquals("Dante", sorted[4].getFirst());
		assertEquals("Lacie", sorted[5].getFirst());
		assertEquals("Idalia", sorted[6].getFirst());
		assertEquals("Ara", sorted[7].getFirst());
		assertEquals("Loise", sorted[8].getFirst());
		assertEquals("Tanner", sorted[9].getFirst());
		assertEquals("Amber", sorted[10].getFirst());
		assertEquals("Roxann", sorted[11].getFirst());
		assertEquals("Tyree", sorted[12].getFirst());
		assertEquals("Evelin", sorted[13].getFirst());
		assertEquals("Shanti", sorted[14].getFirst());
		assertEquals("Lewis", sorted[15].getFirst());
	}

	/**
	 * Additional test cases to test that custom comparators sort the data
	 * correctly.
	 */
	@Test
	public void testSortCustomID() {
		Student[] sorted = sm2.sort();
		assertEquals("Amber", sorted[0].getFirst());
		assertEquals("Ara", sorted[1].getFirst());
		assertEquals("Lacie", sorted[2].getFirst());
		assertEquals("Idalia", sorted[3].getFirst());
		assertEquals("Evelin", sorted[4].getFirst());
		assertEquals("Lewis", sorted[5].getFirst());
		assertEquals("Alicia", sorted[6].getFirst());
		assertEquals("Tyree", sorted[7].getFirst());
		assertEquals("Loise", sorted[8].getFirst());
		assertEquals("Roxann", sorted[9].getFirst());
		assertEquals("Nichole", sorted[10].getFirst());
		assertEquals("Charlene", sorted[11].getFirst());
		assertEquals("Shanti", sorted[12].getFirst());
		assertEquals("Cristine", sorted[13].getFirst());
		assertEquals("Tanner", sorted[14].getFirst());
		assertEquals("Dante", sorted[15].getFirst());
	}

}
