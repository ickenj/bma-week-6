/**
 * @date 10/11/2012
 * @description BMA - Week 6 Assignment
 */

import java.util.Date;
import java.text.*;

/**
 * @author Joanne Icken
 *
 */

public class Assignment {

	private void main (String[] args) {

		Task items[] = new Task[3];
		// What arguments were passed in
	    if(args[0] == null) {
	        System.out.println("Proper Usage is: date, name, description, category, state");
	        System.exit(0);
	    } else {
	    	// initalize array
	    	for (int i = 0; i < items.length; i++) {
	    		items[i] = new ShowTaskTodo();
	    }
	    	
	    items[0] = new ShowTaskTodo();
	    items[1] = new ShowTaskTodo("Task1", new Date(), "This is task 1", "Home");
	    items[2] = new ShowTaskTodo("Task2", new Date(), "This is task 2", "Work");
	    items[3] = new ShowTaskTodo("Task3", new Date(), "This is task 3", "Work");
	    
	    for (int i=0; i < items.length; i++) {
	    	System.out.println("Task Data: " + i + "\n");
	    	System.out.println(items[i].ShowTaskTodo());
	    	System.out.println("toString Data: " + "\n");
	    	System.out.println(items[i].toString());
	    }
	}
}


abstract class Task {

	abstract String ShowTaskTodo();
	
	// instance variables
	private Date task_date;
	private String task_desc;


	Task() { 
	// constructor methods for class Task
		this.task_date  = null;
		this.task_desc  = "";
	}
	
	Task(Date dt, String Description) {
		// constructor method for class Task
		this.task_date = dt;
		this.task_desc = Description;
	}
	
	// methods for accessing
	String getTaskDescription() { return task_desc; }
	void setTaskDescription( String descript ) { task_desc=descript; }
	
	Date getTaskDate () { return task_date; }
	void setTaskDate ( Date dt ) { task_date = dt; }
	
}

class TaskTodo extends Task {
	private String taskName;
	private Date taskCompleteDate;
	private Date taskDueDate;
	private String taskCategory;
	private int taskId;
	private String taskState;

	TaskTodo() {
		super();
	}
	
	TaskTodo( Date dt, String Name, String Desc, String Categ, String State, 
			Date CompleteDate, Date DueDate) {
		super(dt,Desc);
		
		setTaskName(Name);
		setTaskCompleteDate(CompleteDate);
		setTaskDueDate(DueDate);
		setTaskCategory(Categ);
		setTaskState(State);
	}

	String getTaskCategory() { return taskCategory; }
	void setTaskCategory( String category ) { taskCategory=category; }
	
	String getTaskState() { return taskState; }
	void setTaskState( String state ) { taskState=state; }

	String getTaskName () { return taskName; }
	void setTaskName ( String name ) { taskName=name; }
	
	Date getTaskCompleteDate () { return taskCompleteDate; }
	void setTaskCompleteDate (Date completedt) { taskCompleteDate = completedt; }
	
	Date getTaskDueDate () { return taskDueDate; }
	void setTaskDueDate (Date duedt) { taskDueDate = duedt; }
	
	public String toString() {
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		String dtString;
		Date task_date = getTaskDate();
		if ( task_date == null ) {
			dtString = "";
		}	else {
			dtString = dateformat.format(task_date);
		}
		return "Task Name: Task Description: " + getTaskDescription() +  
			"Task Category: " + getTaskCategory() + "Task ID: " + 
			"Task State: " + getTaskState() + "Task Date: " + dtString;
	}
	
	String ShowTaskTodo() {
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		String dtString;
		Date task_date = getTaskDate();
		if ( task_date == null ) {
			dtString = "";
		}	else {
			dtString = dateformat.format(task_date);
		}
		return "Task Name: \n" + "Task Description: " + getTaskDescription() + "\n" + 
			"Task Category: "  + getTaskCategory() + "\n" + "Task ID: \n" + 
			"Task State: " + getTaskState() + "\n" + "Task Date: " + dtString;
	}
		
	String addTask() { return "added"; }
	
	String deleteTask() { return "deleted"; }
		
	String modifyTask() { return "modified"; }
		
	String displayTaskbyCategory() { return "displayed"; }

	String sortTaskList() { return "sorted"; }
 
	String storeTask() { return "stored"; }
		
	String helpTask() { return "helped"; }
}

}
	
