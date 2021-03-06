package aspects;

import main.Main;
import controllers.ControllerFactory;
import entities.Person;
import entities.Teacher;
import exceptions.NotImplementedException;

public aspect MainAspects {
	
	/**
	 * Requisito 3: Declare soft.
	 */
	declare soft: NotImplementedException : withincode(* Main.main(*));
	
	/**
	 * Requisitos 2.3 e 5: Advice around e override com around.
	 */
	@SuppressWarnings("unchecked")
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
	
	/**
	 * Requisito 6: Intertype declaration
	 */
	public static void Main.printWelcome() {
		System.out.println("Seja bem vindo ao");
		System.out.println("   _____      _                 _ __  __                                   ");
		System.out.println("  / ____|    | |               | |  \\/  |                                  ");
		System.out.println(" | (___   ___| |__   ___   ___ | | \\  / | __ _ _ __   __ _  __ _  ___ _ __ ");
		System.out.println("  \\___ \\ / __| '_ \\ / _ \\ / _ \\| | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ | '__|");
		System.out.println("  ____) | (__| | | | (_) | (_) | | |  | | (_| | | | | (_| | (_| |  __| |   ");
		System.out.println(" |_____/ \\___|_| |_|\\___/ \\___/|_|_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_|   ");
		System.out.println("                                                            __/ |          ");
		System.out.println("                                                           |___/           ");
	}
	
	/**
	 * Requisito 2.1: Advice before
	 */
	before(): execution(* Main.main(*)) {
		Main.printWelcome();
	}
}
