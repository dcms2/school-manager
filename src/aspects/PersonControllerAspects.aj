package aspects;

import controllers.PersonController;

public privileged aspect PersonControllerAspects {

	public static int PersonController.NEXT_ID;
	
	public static int PersonController.getAndIncrementID() {
		return PersonController.NEXT_ID++;
	}
}