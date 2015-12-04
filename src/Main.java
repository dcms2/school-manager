import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import controllers.StudentController;

import entities.Address;
import entities.Person;
import entities.Sex;
import entities.Student;

public class Main {
	static Scanner in = new Scanner(System.in);
	final static int REGISTER_STUDENT = 1;
	final static int REGISTER_TEACHER = 2; 
	
	
	public static void main(String[] args){
		
		boolean running = true;
		
		printWelcome();
		
		while (running) {
			printMenu();
			int opt = in.nextInt();
			in.nextLine();
			switch (opt) {
			case REGISTER_STUDENT:
				Person father, mother, studentPerson;
				System.out.println("Cadastrando os dados do aluno:");
				studentPerson = retrievePerson(); 
				father = listAndGet(StudentController.getFathers(), "pai");
				if(father == null ) {
					System.out.println("Cadastrando os dados do pai:");
					father = retrievePerson();
					System.out.println("Pai " + father + " cadastrado com sucesso");
					StudentController.addFather(father);
				}
				mother = listAndGet(StudentController.getMothers(), "mãe");				
				if(mother == null ) {
					System.out.println("Cadastrando os dados da mãe:");
					mother = retrievePerson();
					System.out.println("Mãe " + mother + " cadastrado com sucesso");
					StudentController.addMother(mother);					
				}
				Student student = new Student(studentPerson, father, mother);
				StudentController.addStudent(student );
				System.out.println("Estudante: " + student + " cadastrado com sucesso.");
				break;

			default:
				break;
			}
			clear();
		}
		
		in.close();
	}
	
	public static void printWelcome(){
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
	
	public static void clear(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void printMenu(){
		System.out.println("------------- MENU -------------");
		System.out.println("  "+REGISTER_STUDENT+") Cadastrar aluno");
		System.out.println("  "+REGISTER_TEACHER+") Cadastrar professor");
		System.out.println("\nDigite o n�mero da a��o desejada: ");
	}
	
	
	static Person retrievePerson(){
		Sex[] sexOptions = {null, Sex.Male, Sex.Female};
		Person person = null;
		String name;
		int sexInput;  
		Sex sex;
		String dateInput; 
		Date birthdate; 
		Address address;
		String city, country, street;
		String email;
		System.out.println("Nome:");
		name = in.nextLine();
		if(name.isEmpty()) name = in.nextLine();
		System.out.println("Data de nascimento no formato (DD/MM/AAAA):"); //  VALIDAR DEPOIS COM ASPECTO 
		dateInput = in.nextLine();
		birthdate = new Date(dateInput);
		System.out.println("Sexo:\n(1)-Masculino\n(2)-Feminino");
		sexInput = in.nextInt(); 
		in.nextLine();
		sex = sexOptions[sexInput];
		
		System.out.println("Cadastro de Endereço:");

		System.out.println("Rua");
		street = in.nextLine();
		System.out.println("Cidade:");
		city = in.nextLine();
		System.out.println("País:");
		country = in.nextLine();
		address = new Address(city, country, street);
		System.out.println("Email:");
		email = in.nextLine();
	
		person = new Person(name, birthdate, sex, address, email, StudentController.getAndIncrementID() );		
		return person;
	}
	
	
	public static Person listAndGet(ArrayList<Person> retrieved, String type){
		Person person = null;
		int opt;  
		System.out.println("Qual desses se identifica como " + type + " do aluno?");
		for(int i =0 ; i < retrieved.size(); i++) { 
			System.out.println("(" + i+") " + retrieved.get(i).getName() );
		}
		System.out.println("(" + retrieved.size() +") " + "Não cadastrado ");
		opt = in.nextInt();
		in.nextLine();
		if(opt == retrieved.size() ) return null;
		return retrieved.get(opt); 
	}
	
	

	
}

















