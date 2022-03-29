package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Form extends JPanel {

    private JTextField firstnameField;
    private JTextField lastNameField;
    private JTextField idField;
    private JTextField departmentField;

    private JButton addButton;
    private JButton viewButton;

    public Form() {

        JLabel firstnameLabel = new JLabel("First Name: ");
        JLabel lastnameLabel = new JLabel("Last Name: ");
        JLabel idLabel = new JLabel("ID: ");
        JLabel departmentLabel = new JLabel("Department: ");

        firstnameField = new JTextField(25);
        lastNameField = new JTextField(25);
        idField = new JTextField(25);
        departmentField = new JTextField(25);

        addButton = new JButton("Add User");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("View All Users");
        viewButton.setPreferredSize(new Dimension(278, 40));

        // space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(firstnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(firstnameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(lastnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        add(lastNameField, gridBagConstraints);
        //

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(idLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;

        add(idField, gridBagConstraints);
        //
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(departmentLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;

        add(departmentField, gridBagConstraints);
        //


        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = buttonInset;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = buttonInset;

        add(viewButton, gridBagConstraints);
    }

    // getters
    public String getFirstname() {
        return firstnameField.getText();
    }

    public String getLastname() {
        return lastNameField.getText();
    }

    public String getID() {
        return idField.getText();
    }

    public String getDepartment() {
        return departmentField.getText();
    }

    public void submitUsers(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewUsers(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
            firstnameField.setText("");
            lastNameField.setText("");
            idField.setText("");
            departmentField.setText("");
        }
    }
}
