package sysImplementation;

/*
 * Do not modify this class, otherwise you will not pass release/secret tests
 */
public class Student implements Comparable<Student> {

	private int id;
	
	public Student (int id) {
		this.id = id;
	}
	

	public String toString() {
		return "Id: " + id;
	}

	public int compareTo(Student other) {
		if (id < other.id) {
			return -1;
		} else if (id == other.id) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

}