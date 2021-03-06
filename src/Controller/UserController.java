package Controller;

import Model.Database;
import Model.User;
import View.Form;
import View.UserDetails;

import javax.swing.*;
import java.io.File;

public class UserController {
    // database file
    private String databaseFile = "/home/gagan/git/Java_MVC/src/data/database.txt";
    private Database database;
    private Form form;
    private UserDetails userDetails;

    public UserController(Form form, UserDetails userDetails) {
        this.database = new Database();
        this.form = form;
        this.userDetails = userDetails;

        // submit user
        this.form.submitUsers(e -> {
            String firstname = this.form.getFirstname().trim();
            String lastname = this.form.getLastname().trim();
            String id = this.form.getID().trim();
            String department = this.form.getDepartment().trim();

            // simple validations
            if(firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(lastname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }else if(id.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }else if(department.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            this.database.addUser(new User(firstname, lastname,id,department));
            this.database.saveUser(new File(databaseFile));
            this.form.reset(true);
        });

        // load users
        this.form.viewUsers(e -> {
            this.userDetails.getUsers(this.database.loadUsers(new File(databaseFile)));
        });
    }
}
