package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.regex.Pattern;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldName, textFieldNumber, textFieldCountry, textFieldDeposit;
    JRadioButton r1, r2;
    Choice choice;
    JLabel date;
    JButton add, back;
    ButtonGroup genderButtonGroup = new ButtonGroup();
    NewCustomer(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
        Image img = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(img);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(550, 150, 200, 200);
        panel.add(imglabel);

        JLabel label = new JLabel("NEW CUSTOMER FORM");
        label.setBounds(118, 11, 260, 54);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel labelId = new JLabel("ID : ");
        labelId.setBounds(35, 76, 200, 14);
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelId.setForeground(Color.WHITE);
        panel.add(labelId);

        comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number : ");
        labelNumber.setBounds(35, 111 , 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        textFieldNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
//        textFieldName.setBackground(new Color(3, 45, 48));
        panel.add(textFieldNumber);

        JLabel labelName = new JLabel("Name : ");
        labelName.setBounds(35, 151 , 200, 14);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);
        textFieldName = new JTextField();
        textFieldName.setBounds(271, 151, 150, 20);
        textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 13));
//        textFieldNumber.setBackground(new Color(3, 45, 48));
        panel.add(textFieldName);

        JLabel labelGender = new JLabel("GENDER : ");
        labelGender.setBounds(35, 191 , 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3, 45, 48));
        r1.setBounds(271, 191, 80, 12);
        genderButtonGroup.add(r1);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3, 45, 48));
        r2.setBounds(351, 191, 80, 12);
        genderButtonGroup.add(r2);
        panel.add(r2);


        JLabel labelCountry = new JLabel("COUNTRY : ");
        labelCountry.setBounds(35, 231 , 200, 14);
        labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelCountry.setForeground(Color.WHITE);
        panel.add(labelCountry);
        textFieldCountry = new JTextField();
        textFieldCountry.setBounds(271, 231, 150, 20);
        textFieldCountry.setFont(new Font("Tahoma", Font.PLAIN, 13));
//        textFieldName.setBackground(new Color(3, 45, 48));
        panel.add(textFieldCountry);

        JLabel labelRoom = new JLabel("Allocated Room Number : ");
        labelRoom.setBounds(35, 271 , 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        choice = new Choice();
        try {
            Con con = new Con();
            ResultSet resultSet = con.statement.executeQuery("select * from room");
            while (resultSet.next()){
                choice.addItem(resultSet.getString("roomnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        choice.setBounds(271, 271, 150, 20);
        choice.setFont(new Font("Tahoma", Font.PLAIN, 13));
        choice.setForeground(Color.WHITE);
        choice.setBackground(new Color(3,45,48));
        panel.add(choice);

        JLabel labelCheckIn = new JLabel("Check-In : ");
        labelCheckIn.setBounds(35, 311 , 200, 14);
        labelCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelCheckIn.setForeground(Color.WHITE);
        panel.add(labelCheckIn);

        java.util.Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(271, 311, 180, 20);
        date.setFont(new Font("Tahoma", Font.PLAIN, 13));
        date.setForeground(Color.WHITE);
        panel.add(date);


        JLabel labelDeposit = new JLabel("Deposit : ");
        labelDeposit.setBounds(35, 351 , 200, 17);
        labelDeposit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);
        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271, 351, 150, 20);
        textFieldDeposit.setFont(new Font("Tahoma", Font.PLAIN, 13));
//        textFieldName.setBackground(new Color(3, 45, 48));
        panel.add(textFieldDeposit);

        add = new JButton("ADD");
        add.setBounds(100, 430, 100, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma", Font.BOLD, 16));
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260, 430, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        panel.add(back);



//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setLocation(500, 150);
        setSize(850, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            Con con = new Con();
            String radioButton = "";
            if (r1.isSelected()){
                radioButton="Male";
            } else if (r2.isSelected()) {
                radioButton = "Female";
            }

            String documentField = (String)comboBox.getSelectedItem();
            String nameField = textFieldName.getText();
            String numberField = textFieldNumber.getText();
            String genderField = r1.isSelected() ? "Male" : (r2.isSelected() ? "Female" : "");
            String countryField = textFieldCountry.getText();
            String roomField = choice.getSelectedItem();
            String checkInField = date.getText();
            String depositField = textFieldDeposit.getText();
            
            if (nameField.isEmpty()||numberField.isEmpty()||genderField.isEmpty()||countryField.isEmpty()||depositField.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
                return;
            }
            else if (!Pattern.matches("[a-zA-Z]+", nameField)) {
                // Show a message dialog for invalid name
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetical characters.", "Invalid Name", JOptionPane.ERROR_MESSAGE);
            }
            else if (documentField.equals("Aadhar Card")) {
                if (!Pattern.matches("\\d{12}", documentField)){
                    JOptionPane.showMessageDialog(null, "Aadhar number must be 12 digits.","Invalid Aadhar Number",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            else if (documentField.equals("Passport")) {
                if (!Pattern.matches("[A-Z0-9]{9}", numberField)) {
                    JOptionPane.showMessageDialog(null, "Passport number must be 9 alphanumeric characters.", "Invalid Passport Number", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method early if Passport number is invalid
                }
            } else if (documentField.equals("Voter ID")) {
                if (!Pattern.matches("[A-Z]{3}[0-9]{7}", numberField)) {
                    JOptionPane.showMessageDialog(null, "Voter ID must be 3 uppercase letters followed by 7 digits.", "Invalid Voter ID", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method early if Voter ID is invalid
                }
            } else if (documentField.equals("Driving License")) {
                if (!Pattern.matches("[A-Z]{2}[0-9]{13}", numberField)) {
                    JOptionPane.showMessageDialog(null, "Driving License must be 2 uppercase letters followed by 13 digits.", "Invalid Driving License", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method early if Driving License is invalid
                }
            }


            try {

                String query = "insert into customer values('"+documentField+"', '"+nameField+"', '"+numberField+"', '"+genderField+"', '"+countryField+"', '"+roomField+"', '"+checkInField+"', '"+depositField+"')";
                String updateQuery = "update room set availability = 'Occupied' where roomnumber = "+roomField;
                con.statement.executeUpdate(query);
                con.statement.executeUpdate(updateQuery);
                JOptionPane.showMessageDialog(null, "Customer Added");

            }catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        else if (e.getSource()==back){
            this.dispose();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
