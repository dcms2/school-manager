package entities;

enum SubjectName {
	English, Science, History, Math, Geography, PE
}

public class Subject {
	
	private SubjectName name;
	
	private Teacher teacher;
	
	public Subject(SubjectName name, Teacher teacher) {
		this.name = name;
		this.teacher = teacher;
	}
	
	public SubjectName getSubjectName() {
		return this.name;
	}
	
	public Teacher getTeacher() {
		return this.teacher;
	}
}
