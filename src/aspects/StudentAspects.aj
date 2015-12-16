package aspects;
import entities.*;

/**
 * 
 * Requisito 4: Declare parents
 *
 */
public aspect StudentAspects {
	declare parents: Student extends Person;
}