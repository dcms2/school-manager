package aspects;
import controllers.StudentController;
public aspect StudentControllerAspects {
	
	public static int StudentController.getAndIncrementID(){
		int next_id = StudentController.getNEXT_ID();
		StudentController.setNEXT_ID(next_id+1);
		return next_id;
	}	
}
