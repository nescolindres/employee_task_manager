package employeeTaskManager;

public class Employee {
	
	 private String name;
	    private Role role;
	    private boolean exists = false;
	    private static int MAX_ROLE = 3;
	    
	    Employee(String newName) {
	        setName(newName);
	    }
	    
	    Employee(String newName, int newRole) {
	        setName(newName);
	        setRole(newRole);
	    }
	    
	    public void setName(String newName) {
	        name = newName;
	    }
	    
	    public void setRole(int newRole) {
	        role.setRoleNum(newRole);
	    }
	    
	    public String getName() {
	        return name;
	    }
	    
	    public int getRoleNum() {
	        return role.getRoleNum();
	    }
	    
	    public String getRole() {
	        return role.toString();
	    }
	    
	    public void checkExists() {
	        
	    }
	    
	    public boolean add() {
	        return false;
	    }
	    
	    public boolean remove() {
	        return false;
	    }
	    
	    /**
	     * Automatically add one to role number unless MAX_ROLE is reached
	     * then wrap back around to one
	     */
	    public void generateRole() {
	        int roleNum = role.getRoleNum();
	        //check if role num == max role and if so change to 1
	        if(roleNum == MAX_ROLE) {
	            setRole(1);
	        }
	        //otherwise add one
	        else
	            setRole(roleNum++);
	        
	        //call getRoleNum to print the new role number
	        getRoleNum(); 
	    }

}
