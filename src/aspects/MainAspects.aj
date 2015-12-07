package aspects;

import main.Main;
import controllers.TeacherController;
import entities.Person;
import entities.Teacher;
import exceptions.NotImplementedException;

public aspect MainAspects {
	
	declare soft: NotImplementedException : withincode(* Main.main(*));
	
	void around(): execution(* Main.registerTeacher()) {
		System.out.println("-- Cadastro de Professor --");
		
		System.out.println("Dados do Professor");
		Person teacherPerson = Main.registerPerson();
		
		System.out.print("Salario: ");
		double salary = Main.in.nextDouble();
		
		Teacher teacher = new Teacher(teacherPerson, salary);
		TeacherController.save(teacher);
		System.out.println("Professor " + teacher.getName() + " cadastrado com sucesso.");
	}
}
