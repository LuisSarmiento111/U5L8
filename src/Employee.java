public class Employee {
    private int id;
    private String fullName;
    private static int lastID = 100;
    private static int numOfEmployees = 0;

    public Employee(String first, String last) {
        fullName = first + " " + last;
        lastID++;
        id = lastID;
        numOfEmployees++;
    }

    public int getId() {
        return id;
    }

    public int getLastID() {
        return lastID;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    public String getFullName() {
        return fullName;
    }
}
