package edu.ncsu.csc316.dsa.data;

import java.util.Objects;

/**
 * A student is comparable and identifiable. Students have a first name, last
 * name, id number, number of credit hours, gpa, and unityID.
 * 
 * @author Dr. King
 * @author Gabriel Perez-Botello gperezb
 *
 */
public class Student implements Comparable<Student>, Identifiable {
	/** String object representing students first name. */
	private String first;
	/** String object representing students last name. */
	private String last;
	/** integer representing student id number. */
	private int id;
	/** integer representing student credit hours. */
	private int creditHours;
	/** double representing student GPA. */
	private double gpa;
	/** String object representing students unity id. */
	private String unityID;

	/**
	 * Constructs a student object with the given parameters.
	 * 
	 * @param first       students first name
	 * @param last        students last name
	 * @param id          students id number
	 * @param creditHours students credit hours
	 * @param gpa         students GPA
	 * @param unityID     students unity ID
	 */
	public Student(String first, String last, int id, int creditHours, double gpa, String unityID) {
		setFirst(first);
		setLast(last);
		setId(id);
		setCreditHours(creditHours);
		setGpa(gpa);
		setUnityID(unityID);
	}

	/**
	 * Returns the student's first name.
	 * 
	 * @return the student's first name
	 */
	public String getFirst() {
		return this.first;
	}

	/**
	 * Sets the student's first name.
	 * 
	 * @param first the student's first name
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Returns the student's last name.
	 * 
	 * @return the student's last name
	 */
	public String getLast() {
		return this.last;
	}

	/**
	 * Sets the student's last name.
	 * 
	 * @param last the students last name
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * Returns the student's id number.
	 * 
	 * @return the students id number
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the student's id number.
	 * 
	 * @param id the id number for the student
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the student's credit hours.
	 * 
	 * @return the student's credit hours
	 */
	public int getCreditHours() {
		return this.creditHours;
	}

	/**
	 * Sets the student's credit hours.
	 * 
	 * @param creditHours the credit hours for the student
	 */
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	/**
	 * Returns the student's GPA.
	 * 
	 * @return the student's GPA
	 */
	public double getGpa() {
		return this.gpa;
	}

	/**
	 * Sets the student's GPA.
	 * 
	 * @param gpa the student's GPA
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * Returns the student's unity id.
	 * 
	 * @return the student's unity id
	 */
	public String getUnityID() {
		return this.unityID;
	}

	/**
	 * Sets the student's unity id.
	 * 
	 * @param unityID the student's unity id
	 */
	public void setUnityID(String unityID) {
		this.unityID = unityID;
	}

	/**
	 * Overrides hashCode() method as is standard when overriding the equals()
	 * method.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(creditHours, first, gpa, id, last, unityID);
	}

	/**
	 * Compares current student object with obj object to determines if the two
	 * objects are equal to each other. Also checks if the two objects have the same
	 * class, and ensures that obj is not null.
	 * 
	 * @param obj the object being compared in the method
	 * @return true if objects have the first name, last name, and id. Else return
	 *         false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;

		return this.last.equals(other.last) && this.first.equals(other.first) && this.id == other.id;
	}

	/**
	 * Compares student objects and defines the natural ordering of student objects.
	 * That ordering being alphabetically by last name in ascending order, then
	 * first name alphabetically in ascending order, and finally student ID number
	 * where no two students will ever have the same Student ID number.
	 * 
	 * @param o the base student object being used in the comparison.
	 * @return 0 if students are the same, 1 if o is less than, and -1 if o is
	 *         greater than student object.
	 */
	@Override
	public int compareTo(Student o) {
		if (this.equals(o)) {
			return 0;
		} else {
			if (this.last.compareTo(o.last) < 0) {
				return -1;
			} else if (this.last.compareTo(o.last) > 0) {
				return 1;
			} else {
				if (this.first.compareTo(o.first) < 0) {
					return -1;
				} else if (this.first.compareTo(o.first) > 0) {
					return 1;
				} else {
					if (this.id - o.id < 0) {
						return -1;
					} else if (this.id - o.id > 0) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Student: first = " + first + ", last = " + last + ", id = " + id + ", creditHours = " + creditHours
				+ ", gpa = " + gpa + ", unityID = " + unityID + "./n";
	}
}
