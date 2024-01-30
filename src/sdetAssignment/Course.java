package sdetAssignment;

public class Course {
	private String name;
	private String course;
	private String fee;
	
	public Course(String name, String course, String fee) {
		this.name = name;
		this.course = course;
		this.fee = fee;
	}
	
	public String getName() {
		return name;
			}
	public String getCourse() {
		return course;
	}
	public String getFee() {
		return fee;
	}
	
	@Override
	public String toString() {
		return "Name:" + name + ",Course:" + course + ",Fee:" + fee;
	}
}
