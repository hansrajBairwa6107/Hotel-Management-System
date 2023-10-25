package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class AddDriver extends JFrame implements ActionListener {

    JTextField nameField, ageField, carCompanyField, carNameField, locationField;
    JRadioButton genderButtonMale, genderButtonFemale;
    JComboBox availableField;
    JButton addButton, backButton;
    ButtonGroup genderButtonGroup = new ButtonGroup();

    AddDriver(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("ADD DRIVERS");
        label.setBounds(120,20,170,22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        panel.add(label);

        JLabel name = new JLabel("NAME");
        name.setBounds(64,70,100,22);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameField = new JTextField(20);
        nameField.setBounds(174,70,156,20);
        nameField.setForeground(Color.WHITE);
        nameField.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameField.setBackground(new Color(16, 108, 115));
        panel.add(nameField);


        JLabel age = new JLabel("AGE");
        age.setBounds(64,110,100,22);
        age.setFont(new Font("Tahoma", Font.BOLD, 14));
        age.setForeground(Color.WHITE);
        panel.add(age);
        ageField = new JTextField();
        ageField.setBounds(174,110,156,20);
        ageField.setForeground(Color.WHITE);
        ageField.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageField.setBackground(new Color(16, 108, 115));
        panel.add(ageField);


        JLabel gender = new JLabel("GENDER");
        gender.setBounds(64,150,100,22);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        genderButtonMale = new JRadioButton("MALE");
        genderButtonMale.setBounds(170, 150, 70, 27);
        genderButtonMale.setBackground(new Color(3,45,48));
        genderButtonMale.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        genderButtonMale.setForeground(Color.WHITE);
        genderButtonGroup.add(genderButtonMale);
        panel.add(genderButtonMale);

        genderButtonFemale = new JRadioButton("FEMALE");
        genderButtonFemale.setBounds(250, 150, 100, 27);
        genderButtonFemale.setBackground(new Color(3,45,48));
        genderButtonFemale.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        genderButtonFemale.setForeground(Color.WHITE);
        genderButtonGroup.add(genderButtonFemale);
        panel.add(genderButtonFemale);


        JLabel carCompany = new JLabel("CAR COMPANY");
        carCompany.setBounds(64,190,110,22);
        carCompany.setFont(new Font("Tahoma", Font.BOLD, 14));
        carCompany.setForeground(Color.WHITE);
        panel.add(carCompany);
        carCompanyField = new JTextField();
        carCompanyField.setBounds(174,190,156,20);
        carCompanyField.setForeground(Color.WHITE);
        carCompanyField.setFont(new Font("Tahoma", Font.BOLD, 14));
        carCompanyField.setBackground(new Color(16, 108, 115));
        panel.add(carCompanyField);


        JLabel carName = new JLabel("CAR NAME");
        carName.setBounds(64,230,100,22);
        carName.setFont(new Font("Tahoma", Font.BOLD, 14));
        carName.setForeground(Color.WHITE);
        panel.add(carName);
        carNameField = new JTextField();
        carNameField.setBounds(174,230,156,20);
        carNameField.setForeground(Color.WHITE);
        carNameField.setFont(new Font("Tahoma", Font.BOLD, 14));
        carNameField.setBackground(new Color(16, 108, 115));
        panel.add(carNameField);


        JLabel available = new JLabel("AVAILABLE");
        available.setBounds(64,270,152,22);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        availableField = new JComboBox(new String[] {"-Choose Availability-","Yes", "No"});
        availableField.setBounds(176,270,156,20);
        availableField.setFont(new Font("Tahoma",Font.PLAIN,14));
        availableField.setForeground(Color.WHITE);
        availableField.setBackground(new Color(16,108,115));
        panel.add(availableField);


        JLabel location = new JLabel("LOCATION");
        location.setBounds(64,310,100,22);
        location.setFont(new Font("Tahoma", Font.BOLD, 14));
        location.setForeground(Color.WHITE);
        panel.add(location);
        locationField = new JTextField();
        locationField.setBounds(174,310,156,20);
        locationField.setForeground(Color.WHITE);
        locationField.setFont(new Font("Tahoma", Font.BOLD, 14));
        locationField.setBackground(new Color(16, 108, 115));
        panel.add(locationField);

        addButton = new JButton("ADD");
        addButton.setBounds(64,380,111,33);
        addButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(Color.BLACK);
        addButton.addActionListener(this);
        panel.add(addButton);

        backButton = new JButton("BACK");
        backButton.setBounds(200,380,111,33);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
        backButton.addActionListener(this);
        panel.add(backButton);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/license.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500,60,300,300);
        panel.add(label1);



        setUndecorated(true);
        setLocation(20,200); // where the window will open
        setSize(900, 500);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String age = ageField.getText();
            String gender = genderButtonMale.isSelected() ? "Male" : (genderButtonFemale.isSelected() ? "Female" : "");
            String carCompany = carCompanyField.getText();
            String carName = carNameField.getText();
            String available = (String) availableField.getSelectedItem();
            String location = locationField.getText();

            // all fields are required if fields were empty then throw error
            if (name.equals("") || age.equals("") || carCompany.equals("") || carName.equals("") || available.equals("") || location.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all fields");
                return;
            }
            else if (!Pattern.matches("[a-zA-Z]+", name)){
                JOptionPane.showMessageDialog(null, "Name must be a alphabetic value.","Invalid Name", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (!Pattern.matches("\\d+", age)){
                JOptionPane.showMessageDialog(null, "Age must be a numeric value.","Invalid Age", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int driverAge = Integer.parseInt(age); // Convert age to an integer
                if (driverAge < 18 || driverAge > 100) {
                    // Age is outside the valid range
                    JOptionPane.showMessageDialog(null, "Driver Age must be greater than 18 and minimum than 60.", "Invalid Age", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            try {
                Con con = new Con();
                String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+carCompany+"','"+carName+"','"+available+"','"+location+"')";
                con.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver added successfully");

            }catch (Exception exception){
                exception.printStackTrace();
            }
        } else if (e.getSource() == backButton) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        AddDriver driver = new AddDriver();
    }
}
