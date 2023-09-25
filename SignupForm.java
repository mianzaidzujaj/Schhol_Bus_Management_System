import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupForm extends JFrame {
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox;

    public SignupForm(BusManagementSystem system) {
        setTitle("Signup Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);


        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(nameLabel);
        nameTextField = new JTextField("", 15);
        add(nameTextField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(emailLabel);
        emailTextField = new JTextField("", 15);
        add(emailTextField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(passwordLabel);
        passwordField = new JPasswordField("", 15);
        add(passwordField);

        JLabel userTypeLabel = new JLabel("User Type:");
        userTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(userTypeLabel);
        userTypeComboBox = new JComboBox<>(new String[]{"Driver", "Student"});
        userTypeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(userTypeComboBox);

        JButton signupButton = new JButton("Signup");
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(signupButton);
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String password = new String(passwordField.getPassword());
                String userType = (String) userTypeComboBox.getSelectedItem();

                if(userType.equals("Driver")){

                    for(Driver driver: system.drivers){
                        if(driver.getEmail().equals(email)){
                            //JOptionPane.showConfirmDialog(null, "This driver is alrady exist");
                            
                            System.out.println("this user ia already exist");
                        }else{
                             driver = new Driver(name, email, password, "", "");
                            system.drivers.add(driver);
                             BusManagementSystem.saveSystemState(system);
                        }
                    }
                    
                } else  {

                    for(Student student:system.students){
                        if(student.getEmail().equals(email)){

                            //JOptionPane.showConfirmDialog(null, "This Student is alrady exist");
                            System.out.println("this user is already exist");
                        }else{
                             student = new Student(name, email, password, "", "");
                            system.students.add(student);
                             BusManagementSystem.saveSystemState(system);

                        }
                    }
                    
                }

                dispose(); // Close the signup form
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(loginButton);
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the signup form
                LoginForm loginForm = new LoginForm(system); // Open the login form
                loginForm.setVisible(true);
            }
        });

        setVisible(true);
    }
}
