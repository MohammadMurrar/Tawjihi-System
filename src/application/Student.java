package application;

/* Student class that contains students attributes
 * with compareTo method to order the student by the average
 * and override toString method to print student info*/ 
public class Student implements Comparable<Student> {
	//students attributes
	private int seatNumber;
	private String branch;
	private double average;

	//students constructor  
	public Student(int seatNumber, String branch, double average) {
		super();
		this.seatNumber = seatNumber;
		this.branch = branch;
		this.average = average;
	}

	// students attributes getters and setters
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
	
	//toString method
	@Override
	public String toString() {
		return " [seatNumber =" + seatNumber + ", branch =" + branch + ", average =" + average + "]\n";
	}

	//compareTo method
	@Override
	public int compareTo(Student o) {
		return Double.compare(this.average, o.average);
	}

}
