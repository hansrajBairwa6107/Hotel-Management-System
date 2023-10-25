package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.regex.Pattern;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField nameField, ageField, salaryField, phoneField, aadharField, emailField;
    JRadioButton genderButtonMale, genderButtonFemale;
    JComboBox comboBox;
    JButton addButton, backButton;
    ButtonGroup genderButtonGroup = new ButtonGroup();
    AddEmployee(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 490);
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(3, 45, 48));
        add(panel);

        JLabel name = new JLabel("NAME");
        name.setFont(new java.awt.Font("serif", Font.BOLD, 17));
        name.setBounds(60, 30, 150, 27);
        name.setForeground(Color.white);
        panel.add(name);
        nameField = new JTextField();
        nameField.setBounds(220, 30, 150, 27);
        nameField.setBackground(new Color(16,108,115));
        nameField.setForeground(Color.white);
        nameField.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(nameField);


        JLabel age = new JLabel("AGE");
        age.setFont(new java.awt.Font("serif", Font.BOLD, 17));
        age.setBounds(60, 80, 150, 27);
        age.setForeground(Color.white);
        panel.add(age);
        ageField = new JTextField();
        ageField.setBounds(220, 80, 150, 27);
        ageField.setBackground(new Color(16,108,115));
        ageField.setForeground(Color.white);
        ageField.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(ageField);


        JLabel gender = new JLabel("GENDER");
        gender.setFont(new java.awt.Font("serif", Font.BOLD, 17));
        gender.setBounds(60, 130, 150, 27);
        gender.setForeground(Color.white);
        panel.add(gender);

        genderButtonMale = new JRadioButton("MALE");
        genderButtonMale.setBounds(218, 130, 70, 27);
        genderButtonMale.setBackground(new Color(3,45,48));
        genderButtonMale.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        genderButtonMale.setForeground(Color.WHITE);
        genderButtonGroup.add(genderButtonMale);
        panel.add(genderButtonMale);

        genderButtonFemale = new JRadioButton("FEMALE");
        genderButtonFemale.setBounds(290, 130, 100, 27);
        genderButtonFemale.setBackground(new Color(3,45,48));
        genderButtonFemale.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        genderButtonFemale.setForeground(Color.WHITE);
        genderButtonGroup.add(genderButtonFemale);
        panel.add(genderButtonFemale);


        JLabel job = new JLabel("JOB");
        job.setFont(new java.awt.Font("serif", Font.BOLD, 17));
        job.setBounds(60, 180, 150, 27);
        job.setForeground(Color.white);
        panel.add(job);

        comboBox = new JComboBox(new String[]{"----Select Job----","Front Desk", "Housekeeping", "Kitchen Staff", "Room Service", "Manager", "Chef"});
        comboBox.setBounds(220, 180, 150, 27);
        comboBox.setBackground(new Color(16,108,115));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(comboBox);


        JLabel salary = new JLabel("SALARY");
        salary.setFont(new java.awt.Font("serif", Font.BOLD, 17));
        salary.setBounds(60, 230, 150, 27);
        salary.setForeground(Color.white);
        panel.add(salary);
        salaryField = new JTextField();
        salaryField.setBounds(220, 230, 150, 27);
        salaryField.setBackground(new Color(16,108,115));
        salaryField.setForeground(Color.white);
        salaryField.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(salaryField);


        JLabel phone = new JLabel("PHONE");
        phone.setFont(new java.awt.Font("serif", Font.BOLD, 17));
        phone.setBounds(60, 280, 150, 27);
        phone.setForeground(Color.white);
        panel.add(phone);
        phoneField = new JTextField();
        phoneField.setBounds(220, 280, 150, 27);
        phoneField.setBackground(new Color(16,108,115));
        phoneField.setForeground(Color.white);
        phoneField.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(phoneField);


        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setFont(new java.awt.Font("serif", Font.BOLD, 17));
        aadhar.setBounds(60, 330, 150, 27);
        aadhar.setForeground(Color.white);
        panel.add(aadhar);
        aadharField = new JTextField();
        aadharField.setBounds(220, 330, 150, 27);
        aadharField.setBackground(new Color(16,108,115));
        aadharField.setForeground(Color.white);
        aadharField.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(aadharField);


        JLabel email = new JLabel("EMAIL");
        email.setFont(new java.awt.Font("serif", Font.BOLD, 17));
        email.setBounds(60, 380, 150, 27);
        email.setForeground(Color.white);
        panel.add(email);
        emailField = new JTextField();
        emailField.setBounds(220, 380, 150, 27);
        emailField.setBackground(new Color(16,108,115));
        emailField.setForeground(Color.white);
        emailField.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(emailField);


        JLabel addEmployeeDetails = new JLabel("ADD EMPLOYEE DETAILS");
        addEmployeeDetails.setFont(new java.awt.Font("Tahoma", Font.BOLD, 31));
        addEmployeeDetails.setBounds(450, 24, 450, 35);
        addEmployeeDetails.setForeground(Color.white);
        panel.add(addEmployeeDetails);

        addButton = new JButton("ADD");
        addButton.setBounds(60, 420, 100, 30);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.white);
//        addButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        addButton.addActionListener(this);
        panel.add(addButton);

        backButton = new JButton("BACK");
        backButton.setBounds(220, 420, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.white);
//        backButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        backButton.addActionListener(this);
        panel.add(backButton);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 100, 300, 300);
        panel.add(label);


        setUndecorated(true);
        setLocation(60, 160);
        setSize(900, 500); // frame size
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            String name = nameField.getText();
            String age = ageField.getText();
            String gender = genderButtonMale.isSelected() ? "Male" : (genderButtonFemale.isSelected() ? "Female" : "");
            String job = comboBox.getSelectedItem().toString();
            String salary = salaryField.getText();
            String phone = phoneField.getText();
            String aadhar = aadharField.getText();
            String email = emailField.getText();
            if (name.isEmpty() || gender.isEmpty() || job.isEmpty() || salary.isEmpty() || phone.isEmpty() || aadhar.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
                return;
            }
            else if (!Pattern.matches("[a-zA-Z]+", name)){
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetical characters.","Invalid Name",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (!Pattern.matches("\\d+", age)){
                JOptionPane.showMessageDialog(null, "Age must contain only digits","Invalid Age",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (gender.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select gender","Invalid Gender",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (!Pattern.matches("\\d+",salary)){
                JOptionPane.showMessageDialog(null, "Salary must be in digits only.","Invalid Salary",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (!Pattern.matches("\\d{10}", phone)){
                JOptionPane.showMessageDialog(null, "Phone number must be 10 digits.","Invalid Phone Number",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", email)){
                JOptionPane.showMessageDialog(null, "Invalid email address.","Invalid Email",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (!Pattern.matches("\\d{12}", aadhar)){
                JOptionPane.showMessageDialog(null, "Aadhar number must be 12 digits.","Invalid Aadhar Number",JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Con con = new Con();
//                String existingRecords="select aadhar from employee";
//                ResultSet rs = con.statement.executeQuery(existingRecords);
//                while (rs.next()) {
//                    if (rs.getString("aadhar") == aadhar){
//                        JOptionPane.showMessageDialog(null, "Aadhar already exists");
//                    }
//                }
                String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
                con.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee added successfully");

            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        AddEmployee addEmployee = new AddEmployee();
    }
}
