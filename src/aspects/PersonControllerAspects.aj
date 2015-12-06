package aspects;
import controllers.PersonController;
public aspect PersonControllerAspects {

	private static int PersonController.NEXT_ID = 0;
	
	public static int PersonController.getAndIncrementID(){
		return PersonController.NEXT_ID++;
	}	
	
}
