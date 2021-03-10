package employeeTaskManager;

import java.util.ArrayList;

public class EmployeeList {
	 private ArrayList<Employee> employees = new ArrayList();
	    
	    public void addEmployee(String name, int role) {
	        employees.add(new Employee(name, role));
	    }
	    
	    public void printList() {
	        for(int i = 0; i < employees.size(); i++) {
	            System.out.println(employees.get(i).getName());
	        }
	    }
	    
	    public boolean exists(String name) {
	        boolean exists = false;
	        for(Employee employee: employees) {
	            if(employee.getName().equalsIgnoreCase(name)) 
	                exists = true;
	        }
	        return exists;
	    }
	    
	    public Employee findEmployee(String name) {
	        Employee search = new Employee("");
	        
	        for(Employee employee: employees) {
	            if(employee.getName().equalsIgnoreCase(name))
	                search = employee;
	        }
	        return search;
	    }

}
