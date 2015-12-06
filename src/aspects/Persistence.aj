package aspects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import entities.Person;
import entities.Student;

import controllers.PersonController;
import controllers.StudentController;

public aspect Persistence {
	
	pointcut create():
		execution(static * (PersonController || StudentController).save(Person||Student));
		
	after(Person p) returning: create() && args(p){
		String filename = "";
		if(p instanceof Student){
			filename = "students.csv";
		}else{
			filename = "persons.csv";
		}
		try {
			if (Files.notExists(Paths.get(filename), LinkOption.NOFOLLOW_LINKS))
			    Files.createFile(Paths.get(filename));
			Files.write(Paths.get(filename), (p.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Erro ao persistir dados.");
		}
	}
	
}
