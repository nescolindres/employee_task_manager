package employeeTaskManager;
import java.sql.*;
import java.util.Scanner;
public class EmployeeTaskManager {
	   // JDBC driver name and database url   
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "";

//Credientials for logging into DB. Change values for diff users.
    static final String USER = "";
    static final String PW = "";

    public static void main(String[] args) throws SQLException {
        EmployeeTaskManager console = new EmployeeTaskManager();
        //check DB connection then close connection
        Connection conn = console.connect();
        try {
            console.closeConn(conn);
            //fill employee list
            EmployeeList employees = console.fillList();
            console.showMenu(employees);
        } catch (Exception e) {
            System.out.println("Error connecting to Database");
        }
    }

    public Connection connect() {
        Connection conn = null;
        //Statement stmt = null;
        try {
            //Registering JDBC driver 
            Class.forName("com.mysql.jdbc.Driver");

            // Opening a connection
            System.out.println("Connecting to a selected database");
            conn = DriverManager.getConnection(DB_URL, USER, PW);
            System.out.println("Connected database succesfully");

        } catch (ClassNotFoundException ex) {
            //handles errors for JDBC
            System.out.println("Error in Driver class");
            ex.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error with SQL command");
            e.printStackTrace();
        }
        //return connection so it can be used by other methods
        return conn;
    }

    public void closeConn(Connection conn) {
        //close the DB connection
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void showMenu(EmployeeList employees) throws SQLException {
        Scanner input = new Scanner(System.in);
        int selection = 0;
        int exitProgram = 4;

        while (selection != exitProgram) {
            System.out.println("Database Menu");
            System.out.println("================");
            System.out.println("1. View Employees");
            System.out.println("2. Change Employees");
            System.out.println("3.....");
            System.out.println("4. Exit program");
            selection = input.nextInt();

            switch (selection) {
                case 1:
                    viewEmployees(employees);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    }

    public EmployeeList fillList() {
        //initialize connection, statement, and employee list
        Connection conn = null;
        Statement stmt = null;
        //initialize list of all employees in the system
        EmployeeList employees = new EmployeeList();
        try {
            conn = connect();
            //create and execute SQL statement to retrieve all employee data
            stmt = conn.createStatement();
            String sql = "Select * FROM employees";
            ResultSet rs = stmt.executeQuery(sql);

            //Extracting data from result set
            while (rs.next()) {
                //retrieve name and role ID information to populate list
                String name = rs.getString("name");
              //  int role = rs.getInt("role_id");
              //  employees.addEmployee(name, role);
            }
            rs.close();
        } catch (SQLException se) {
            System.out.println("Invalid query");
        } finally {
            //close connection
            closeConn(conn);
        }
        return employees;
    }


    public static void viewEmployees(EmployeeList employees) {
        employees.printList();
    }

    public static void editList(EmployeeList employees) {
        Scanner input = new Scanner(System.in);
        String name = "";

        do {
            System.out.println("Employees currently in the system: ");
            viewEmployees(employees);
            System.out.println("Enter the name of the employee you would like to change or enter 'Quit' to quit: ");
            name = input.nextLine();
            if(employees.exists(name)) {
                editEmployee(employees.findEmployee(name));
            }
        } while (!name.equalsIgnoreCase("Quit"));
    }
    
    public static void editEmployee(Employee employee) {
        Scanner input = new Scanner(System.in);
        String choice = "";
        
        System.out.println("What would you like to change: Name, Role, or Both?");
        choice = input.nextLine();
        choice = choice.toUpperCase();
        
        switch(choice) {
            case "NAME": 
                System.out.println("Enter new name: ");
                break;
            case "ROLE":
                System.out.println("Enter new role number");
                break;
            case "BOTH":
                break;
        }
                
    }
    
    public static void removeEmployee(EmployeeList employees, Employee remove) {
        
    }
}
