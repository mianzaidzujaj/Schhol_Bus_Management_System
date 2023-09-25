import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField emailTextField;
    private JPasswordField passwordField;

    public LoginForm(BusManagementSystem system) {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JLabel emailLabel = new JLabel("Email:");
        add(emailLabel);
        emailTextField = new JTextField("", 15);
        add(emailTextField);

        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel);
        passwordField = new JPasswordField("", 15);
        add(passwordField);

        JButton submitButton = new JButton("Submit");
        add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                String password = new String(passwordField.getPassword());
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                boolean isLoggedIn = false;

                if(email.equals("admin") && password.equals("admin")){
                    dispose();
                    AdminDashboard adminDashboard = new AdminDashboard(system);

                    //adminDashboard.setVisible(true);
                }

                for (Driver driver : system.drivers) {
                    if (email.equals(driver.getEmail())) {
                        if (password.equals(driver.getPassword())) {
                            isLoggedIn = true;
                            System.out.println("Logged in");
                            system.currentlyLoggedIn = driver;
                            dispose();
                            DriverDashboard driverDashboard = new DriverDashboard(system);
                            //driverDashboard.setVisible(true);
                        }
                    }
                }
                for (Student student : system.students) {
                    if (email.equals(student.getEmail())) {
                        if (password.equals(student.getPassword())) {
                            isLoggedIn = true;
                            System.out.println("Logged in");
                            system.currentlyLoggedIn = student;
                            dispose();
                            StudentDashboard studentDashboard = new StudentDashboard(system);
                            //studentDashboard.setVisible(true);
                        }
                    }
                }

                if (!isLoggedIn) {
                    System.out.println("Cannot login.");
                }
            }
        });

        JButton signupButton = new JButton("Signup");
        add(signupButton);
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the login form
                SignupForm signupForm = new SignupForm(system); // Open the signup form
                signupForm.setVisible(true);
            }
        });

        setVisible(true);
    }
}
