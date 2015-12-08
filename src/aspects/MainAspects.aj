package aspects;

import main.Main;
import controllers.ControllerFactory;
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
		ControllerFactory.getInstance(ControllerFactory.TEACHER).save(teacher);
		System.out.println("Professor " + teacher.getName() + " cadastrado com sucesso.");
	}
}
