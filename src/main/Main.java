package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import controllers.Controller;
import controllers.ControllerFactory;
import entities.Address;
import entities.Person;
import entities.Sex;
import entities.Student;
import entities.Teacher;
import exceptions.NotImplementedException;

public class Main {
	
	public static Scanner in = new Scanner(System.in);

	final static int REGISTER_STUDENT = 1;
	final static int REGISTER_TEACHER = 2;
	final static int VIEW_STUDENT = 3;
	final static int VIEW_TEACHER = 4;

	public static void main(String[] args) {
		boolean running = true;
		
		printWelcome();
		
		while (running) {
			printMenu();
			int opt = in.nextInt();
			in.nextLine();
			switch (opt) {
			case REGISTER_STUDENT:
				registerStudent();
				break;
			case REGISTER_TEACHER:
				registerTeacher(); 
				break;
			case VIEW_STUDENT:
				viewControllerData("-- Estudantes cadastrados --", ControllerFactory.getInstance(ControllerFactory.STUDENT));
				break;
			case VIEW_TEACHER:
				viewControllerData("-- Professores cadastrados --", ControllerFactory.getInstance(ControllerFactory.TEACHER));
				break;
			default:
				break;
			}
			clear();
		}
		
		in.close();
	}
	
	public static void printWelcome() {
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
	
	public static void clear() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void printMenu() {
		System.out.println("------------- MENU -------------");
		System.out.println("  " + REGISTER_STUDENT + ") Cadastrar aluno");
		System.out.println("  " + REGISTER_TEACHER + ") Cadastrar professor");
		System.out.println("  " + VIEW_STUDENT + ") Visualizar estudantes");
		System.out.println("  " + VIEW_TEACHER + ") Visualizar professores");
		System.out.println("\nDigite o numero da opcao desejada: ");
	}
	
	public static Person registerPerson() {
		String name;
		int sexInput;  
		Sex sex;
		Calendar birthDate; 
		String city, country, street;
		String email;
		
		System.out.print("Nome completo:");
		name = in.nextLine();
		
		System.out.print("Data de nascimento(ex: 10/08/1991):"); 
		String line[] = in.nextLine().split("/");
		birthDate = new GregorianCalendar(Integer.parseInt(line[2]), Integer.parseInt(line[1]) - 1, Integer.parseInt(line[0]));
		
		System.out.println("Sexo:\n(1)-Masculino\n(2)-Feminino");
		sexInput = in.nextInt();
		sex = (sexInput == 1) ? Sex.Male : Sex.Female;
		in.nextLine();
		
		System.out.println("Cadastro de Endere�o:");

		System.out.print("Logradouro: ");
		street = in.nextLine();
		
		System.out.print("Cidade: ");
		city = in.nextLine();
		
		System.out.print("Pa�s: ");
		country = in.nextLine();
		
		System.out.print("Email: ");
		email = in.nextLine();
		 
		Address address = new Address(city, country, street);
		Person person = new Person(name, birthDate, sex, address, email);		
		return person;
	}
	
	public static void registerStudent() {
		System.out.println("-- Cadastro de Aluno --");
		
		Controller<Person> person_controller = ControllerFactory.getInstance(ControllerFactory.PERSON);
		
		System.out.println("Dados do Pai");
		Person father = listOrRegisterParent(person_controller.getBySex(Sex.Male));
		person_controller.save(father);
		System.out.println();
		
		System.out.println("Dados da M�e");
		Person mother = listOrRegisterParent(person_controller.getBySex(Sex.Female));
		person_controller.save(mother);
		System.out.println();
		
		System.out.println("Dados do aluno");
		Person studentPerson = registerPerson();
		System.out.println();
		
		Student student = new Student(studentPerson, father, mother);
		ControllerFactory.getInstance(ControllerFactory.STUDENT).save(student);
		System.out.println("Estudante " + student.getName() + " cadastrado com sucesso.");
	}
	
	public static void registerTeacher() throws NotImplementedException {
		throw new NotImplementedException();
	}
	
	public static void viewControllerData(String title, Controller controller) {
		System.out.println(title);
		ArrayList data = controller.getAll();
		for (Object o : data) {
			System.out.println(((Person) o).getId() + ") " + ((Person) o).getName());
		}
		System.out.println("\n");
	}
	
	public static Person listOrRegisterParent(ArrayList<Person> people) {
		System.out.println("Selecione uma das pessoas j� registradas ou deixe em branco para criar uma nova");
		for (Person p: people) {
			System.out.println(p.getId() + ") " + p.getName());
		}
		System.out.print("> ");
		String r = in.nextLine();
		Person person = null;
		if (r.isEmpty()) {
			person = registerPerson();
		} else {
			Controller<Person> controller = ControllerFactory.getInstance(ControllerFactory.PERSON); 
			person = controller.getByID(Integer.parseInt(r));
		}
		return person;
	}
}