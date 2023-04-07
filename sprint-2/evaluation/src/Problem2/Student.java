package Problem2;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private double marks;
	private double attendance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public double getAttendance() {
		return attendance;
	}
	public void setAttendance(float attendance) {
		this.attendance = attendance;
	}
	public Student(String name, double d, double e) {
		super();
		this.name = name;
		this.marks = d;
		this.attendance = e;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + ", attendance=" + attendance + "]";
	}
}
