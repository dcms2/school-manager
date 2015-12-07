package aspects;

import main.Main;
import exceptions.NotImplementedException;

public aspect MainAspects {
	
	declare soft: NotImplementedException : withincode(* Main.main(*));
	
	void around(): execution(* Main.registerTeacher()) {
		System.out.println("Going to implement");
	}
}
