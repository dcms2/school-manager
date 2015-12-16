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
import exceptions.NotImplementedException;

public class Main {
	
	public static Scanner in = new Scanner(System.in);

	/**
	 * Possible menu actions
	 */
	final static int REGISTER_STUDENT = 1;
	final static int REGISTER_TEACHER = 2;
	final static int VIEW_STUDENT = 3;
	final static int VIEW_TEACHER = 4;

	public static void main(String[] args) {
		boolean running = true;
		
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
	
	public static void clear() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	/**
	 * Prints all possible user actions and respective codes
	 */
	public static void printMenu() {
		System.out.println("------------- MENU -------------");
		System.out.println("  " + REGISTER_STUDENT + ") Cadastrar aluno");
		System.out.println("  " + REGISTER_TEACHER + ") Cadastrar professor");
		System.out.println("  " + VIEW_STUDENT + ") Visualizar estudantes");
		System.out.println("  " + VIEW_TEACHER + ") Visualizar professores");
		System.out.println("\nDigite o numero da opcao desejada: ");
	}
	
	/**
	 * Requests all the information necessary for a Person and then returns a Person object.
	 * @return Person
	 */
	public static Person registerPerson() {
		String name;
		int sexInput;  
		Sex sex;
		Calendar birthDate; 
		String city, country, street;
		String email;
		
		System.out.print("Nome completo: ");
		name = in.nextLine();
		
		System.out.print("Data de nascimento(ex: 10/08/1991): "); 
		String line[] = in.nextLine().split("/");
		birthDate = new GregorianCalendar(Integer.parseInt(line[2]), Integer.parseInt(line[1]) - 1, Integer.parseInt(line[0]));
		
		System.out.println("Sexo:\n(1)-Masculino\n(2)-Feminino");
		sexInput = in.nextInt();
		sex = (sexInput == 1) ? Sex.Male : Sex.Female;
		in.nextLine();
		
		System.out.println("Cadastro de Endereço:");

		System.out.print("Logradouro: ");
		street = in.nextLine();
		
		System.out.print("Cidade: ");
		city = in.nextLine();
		
		System.out.print("País: ");
		country = in.nextLine();
		
		System.out.print("Email: ");
		email = in.nextLine();
		 
		Address address = new Address(city, country, street);
		Person person = new Person(name, birthDate, sex, address, email);		
		return person;
	}
	
	/**
	 * Requests all the information necessary for a Student and then saves the student object.
	 */
	public static void registerStudent() {
		System.out.println("-- Cadastro de Aluno --");
		
		Controller<Person> person_controller = ControllerFactory.getInstance(ControllerFactory.PERSON);
		
		System.out.println("Dados do Pai");
		Person father = listOrRegisterParent(person_controller.getBySex(Sex.Male));
		person_controller.save(father);
		System.out.println();
		
		System.out.println("Dados da Mâe");
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
	
	/**
	 * Teacher registration method.
	 */
	public static void registerTeacher() throws NotImplementedException {
		throw new NotImplementedException();
	}
	
	/**
	 * Displays all the data relative to a controller.
	 */
	public static void viewControllerData(String title, Controller controller) {
		System.out.println(title);
		ArrayList data = controller.getAll();
		for (Object o : data) {
			System.out.println(((Person) o).getId() + ") " + ((Person) o).getName());
		}
		System.out.println("\n");
	}
	
	/**
	 * Prompts the user for the selection of an existing person or the creation of a new one.
	 */
	public static Person listOrRegisterParent(ArrayList<Person> people) {
		System.out.println("Selecione uma das pessoas já registradas ou deixe em branco para criar uma nova");
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