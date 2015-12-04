package entities;

import java.util.ArrayList;

public class Class {

	private Student representant;
	
	private ArrayList<Student> students;
	
	private ArrayList<Subject> subjects;
	
	public Class(ArrayList<Subject> subjects, ArrayList<Student> students) {
		this(subjects, students, null);
	}
	
	public Class(ArrayList<Subject> subjects, ArrayList<Student> students, Student representant) {
		this.subjects = subjects;
		this.students = students;
		this.representant = representant;
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}
	
	public void setRepresentant(int position) {
		this.representant = this.students.get(position);
	}
	
	public Student getRepresentant() {
		return this.representant;
	}
		
	public ArrayList<Student> getStudents() {
		return this.students;
	}
	
	public ArrayList<Subject> getSubject() {
		return this.subjects;
	}
}
