import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		boolean running = true;
		Scanner in = new Scanner(System.in);
		printWelcome();
		
		try {
			ResultSet s = Database.getInstance().executeQuery("SELECT * FROM person");
			 while(s.next())
	          {
	            // read the result set
	            System.out.println("name = " + s.getString("name"));
	            System.out.println("id = " + s.getInt("id"));
	          }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (running) {
			printMenu();
			int opt = in.nextInt();
			
			clear();
		}
		
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
		System.out.println("  1) Cadastrar aluno");
		System.out.println("  2) Cadastrar professor");
		System.out.println("\nDigite o número da ação desejada: ");
	}
}
