package employeeTaskManager;

import java.util.List;

public class TaskList {
	  private int roleNum;
	    List<String> taskList;
	    
	    TaskList() {
	        
	    }
	    TaskList(int newRoleNum) {
	        setRoleNum(newRoleNum);
	    }
	    
	    void setRoleNum(int newRoleNum) {
	        roleNum = newRoleNum;
	    }
	    
	    public int getRoleNum() {
	        return roleNum;
	    }
	    
	    private boolean setTaskList() {
	        return false;
	    }
	    
	    public List<String> getTaskList() {
	        return taskList;
	    }
	    
}
