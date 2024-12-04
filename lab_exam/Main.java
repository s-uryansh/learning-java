package lab_exam;
//=======================================//
//      Main class //
//=======================================//

public class Main {
    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        Google google = new Google(alphabet);
        Youtube youtube = new Youtube(alphabet);
        Deepmind deepmind = new Deepmind(alphabet);
//=======================================//
        // Add employees to companies
//=======================================//
alphabet.addEmployee("A");
        google.addEmployee("A");
        google.addEmployee("B");
        youtube.addEmployee("B");
        youtube.addEmployee("C");
        deepmind.addEmployee("D");
//=======================================//
        // Print employee lists
//=======================================//

        System.out.print("Employee list of Alphabet: ");
        for (String employee : alphabet.getEmployees()) {
            System.out.print(employee + " ");
        }
        System.out.println();

        System.out.print("Employee list of Google: ");
        for (String employee : google.getEmployees()) {
            System.out.print(employee + " ");
        }
        System.out.println();

        System.out.print("Employee list of Youtube: ");
        for (String employee : youtube.getEmployees()) {
            System.out.print(employee + " ");
        }
        System.out.println();

        System.out.print("Employee list of Deepmind: ");
        for (String employee : deepmind.getEmployees()) {
            System.out.print(employee + " ");
        }
        System.out.println();
    }
}
abstract class Company {
    
    private String[][] employeeDB = new String[4][10];
    private int[] employeeCount = new int[4];
    private String companyId;

    public abstract void addEmployee(String employeeName);
    public abstract String[] getEmployees();

    public String getID() {
        return companyId;
    }

    public void setID(String companyId) {
        this.companyId = companyId;
    }

//=======================================//
    // Add employee to the database
//=======================================//
protected void addEmployeeToDB(int companyRow, String employeeName) {
        for (int i = 0; i < employeeCount[companyRow]; i++) {
            if (employeeDB[companyRow][i].equals(employeeName)) {
                return;
            }
        }
        employeeDB[companyRow][employeeCount[companyRow]++] = employeeName;
    }

//=======================================//
    // get employees from the database
//=======================================//
protected String[] getEmployee(int companyRow) {
        String[] employees = new String[employeeCount[companyRow]];
        for (int i = 0; i < employeeCount[companyRow]; i++) {
            employees[i] = employeeDB[companyRow][i];
        }
        return employees;
    }

    protected String[][] getemployeeDB() {
        return employeeDB;
    }
}

class Alphabet extends Company {
    public Alphabet() {
        setID("Alphabet");
    }

    
    public void addEmployee(String employeeName) {
        addEmployeeToDB(0, employeeName);
    }

    
    public String[] getEmployees() {
        return getEmployee(0);
    }
}

class Google extends Company {
    private Company parent;

    public Google(Company parent) {
        setID("Google");
        this.parent = parent;
    }

    
    public void addEmployee(String employeeName) {
        addEmployeeToDB(1, employeeName);
        parent.addEmployee(employeeName);
    }

    
    public String[] getEmployees() {
        return getEmployee(1);
    }
}

class Youtube extends Company {
    private Company parent;

    public Youtube(Company parent) {
        setID("Youtube");
        this.parent = parent;
    }

    
    public void addEmployee(String employeeName) {
        addEmployeeToDB(2, employeeName);
        parent.addEmployee(employeeName);
    }

    
    public String[] getEmployees() {
        return getEmployee(2);
    }
}

class Deepmind extends Company {
    private Company parent;

    public Deepmind(Company parent) {
        setID("Deepmind");
        this.parent = parent;
    }

    
    public void addEmployee(String employeeName) {
        addEmployeeToDB(3, employeeName);
        parent.addEmployee(employeeName);
    }

    
    public String[] getEmployees() {
        return getEmployee(3);
    }
}




