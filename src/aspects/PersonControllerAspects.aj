package aspects;

import controllers.PersonController;

public privileged aspect PersonControllerAspects {

	public static int PersonController.getAndIncrementID() {
		return PersonController.nextId++;
	}	
}
