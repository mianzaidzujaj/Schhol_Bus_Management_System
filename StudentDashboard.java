import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard extends JFrame{

    
    public  StudentDashboard(BusManagementSystem system) {

        Student currentStudent = (Student) system.currentlyLoggedIn;
        JFrame frame = new JFrame("Student Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JLabel contactLabel = new JLabel("Contact Number: " + currentStudent.getContactNumber());
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        contactLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel RollNumberLabel = new JLabel("Roll Number: " + currentStudent.getRollNumber());
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        contactLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        
        JButton addStudentInfoButton = new JButton("Add Student Info");
        addStudentInfoButton.setFont(new Font("Arial", Font.BOLD, 16));
        addStudentInfoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addStudentInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField contactNumberField = new JTextField();
                JTextField rollNumberField = new JTextField();
                
                JPanel inputPanel = new JPanel(new GridLayout(2, 2));
                inputPanel.add(new JLabel("Contact Number:"));
                inputPanel.add(contactNumberField);
                inputPanel.add(new JLabel("Roll Number:"));
                inputPanel.add(rollNumberField);
                
                int result = JOptionPane.showConfirmDialog(
                    frame,
                    inputPanel,
                    "Enter Student Information",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
                );
                
                if (result == JOptionPane.OK_OPTION) {
                    String contactNumber = contactNumberField.getText();
                    
                    String rollNumber = rollNumberField.getText();
                    Student student = new Student(system.currentlyLoggedIn.getName(), system.currentlyLoggedIn.getEmail(), system.currentlyLoggedIn.getPassword(), rollNumber, contactNumber);
                    system.currentlyLoggedIn = student;
                    BusManagementSystem.saveSystemState(system);
                    JOptionPane.showMessageDialog(frame, "Saved successfully");


    
                }
                contactLabel.setText("Contact Number:" + contactNumberField.getText());
                RollNumberLabel.setText("Roll Number:" + rollNumberField.getText());
            }
        });
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        JLabel headingLabel = new JLabel("Student Information");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel nameLabel = new JLabel("Name: "+system.currentlyLoggedIn.getName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel emailLabel = new JLabel("Email: "+system.currentlyLoggedIn.getEmail());
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Student student = (Student)system.currentlyLoggedIn;
        
        JLabel busNumberLabel = new JLabel("Bus Number: " + system.buses.get(2).toString());
        busNumberLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        busNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.RED);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginForm loginForm = new LoginForm(system);
                loginForm.setVisible(true);
                dispose();
            }
        });
        
        panel.add(Box.createVerticalGlue());
        panel.add(headingLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(emailLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(busNumberLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(contactLabel);
        panel.add(RollNumberLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(addStudentInfoButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(logoutButton);
        panel.add(Box.createVerticalGlue());

        
        frame.add(panel);
        frame.setLocationRelativeTo(null); // Center the JFrame on the screen
        frame.setVisible(true);
    }
}