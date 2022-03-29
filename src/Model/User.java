package Model;

public class User {
    private String firstname;
    private String lastname;
    private String id;
    private String department;

    public User() {
        // empty constructor
    }

    public User(String firstname, String lastname, String id , String department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.department = department;
    }

    // getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getID() {
        return id;
    }

    public String getDepartment() {
        return department;
    }
}
