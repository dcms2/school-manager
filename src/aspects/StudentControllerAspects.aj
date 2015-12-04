package aspects;
import controllers.StudentController;
public aspect StudentControllerAspects {

	
	private static int StudentController.NEXT_ID = 0;
	
	public static int StudentController.getAndIncrementID(){
		return StudentController.NEXT_ID++;
	}	
}
