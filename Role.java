package employeeTaskManager;

import java.util.List;

public class Role {
	 private int roleNum;
	    static int MAX_NUM = 3;
	    private TaskList tasks = new TaskList();
	    
	    Role(int newRoleNum) {
	        setRoleNum(newRoleNum);
	    }
	    
	    public void setRoleNum(int newRoleNum) {
	        if(newRoleNum > MAX_NUM) {
	            newRoleNum = 1;
	        }
	        roleNum = newRoleNum;
	    }
	    
	    public int getRoleNum() {
	        return roleNum;
	    }
	    
	    public void increaseMaxNum(int numIncrease) {
	        int index = 0;
	        while(index < numIncrease) {
	            MAX_NUM++;
	            index++;
	        }
	    }
	    
	    public void decreaseMaxNum(int numDecrease) {
	        int index = 0;
	        while(index < numDecrease && MAX_NUM <= 0) {
	            MAX_NUM--;
	        }
	    }
	    
	    public void changeRoleNum(int newRoleNum) {
	        setRoleNum(newRoleNum);
	    }
	    
	    public int getMaxNum() {
	        return MAX_NUM;
	    }
	    
	    private void setTaskList() {
	        
	    }
	    
	    public List<String> getTaskList() {
	        return tasks.getTaskList();
	    }
}
