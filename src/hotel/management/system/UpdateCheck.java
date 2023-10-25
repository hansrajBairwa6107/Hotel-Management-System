package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCheck extends JFrame {

    UpdateCheck(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(3, 45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Check-In Details");
        label1.setBounds(124, 10, 222, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 = new JLabel("ID :");
        label2.setBounds(25, 88, 40, 15);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);


        Choice choice = new Choice();
        choice.setBounds(248, 85, 140, 20);
        panel.add(choice);

        try {
            Con con = new Con();
            String query = "select * from customer";
            ResultSet resultSet = con.statement.executeQuery(query);
            while (resultSet.next()) {
                choice.addItem(resultSet.getString("number"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25, 129, 110, 15);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldRoom = new JTextField();
        textFieldRoom.setBounds(248, 129, 140, 20);
        panel.add(textFieldRoom);

        JLabel label4 = new JLabel("Name :");
        label4.setBounds(25, 174, 100, 15);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(248, 174, 140, 20);
        panel.add(textFieldName);

        JLabel label5 = new JLabel("Checked-In :");
        label5.setBounds(25, 216, 100, 15);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldCheck = new JTextField();
        textFieldCheck.setBounds(248, 216, 140, 20);
        panel.add(textFieldCheck);

        JLabel label6 = new JLabel("Amount Paid (Rs) :");
        label6.setBounds(25, 261, 150, 15);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 261, 140, 20);
        panel.add(textFieldAmount);

        JLabel label7 = new JLabel("Pending Amount (Rs) :");
        label7.setBounds(25, 302, 150, 15);
        label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JTextField textFieldPendingAmount = new JTextField();
        textFieldPendingAmount.setBounds(248, 302, 140, 20);
        panel.add(textFieldPendingAmount);


        JButton updateButton = new JButton("Update");
        updateButton.setBounds(60, 370, 89, 20);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        panel.add(updateButton);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Con con = new Con();
                    String number = choice.getSelectedItem();
                    String room = textFieldRoom.getText();
                    String name = textFieldName.getText();
                    String check = textFieldCheck.getText();
                    String amount = textFieldAmount.getText();
                    // if all the fields are empty then show error


                    if (JOptionPane.showConfirmDialog(null,"Do you want to update?") == JOptionPane.OK_OPTION){
                        con.statement.executeUpdate("UPDATE customer SET room = '" +room+"', name = '"+name+"', checkintime = '"+check+"', deposit = '"+amount+"' WHERE number = '"+number+"'");
                        JOptionPane.showMessageDialog(null, "Updated Successfully");
                        setVisible(false);
                    }
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(180, 370, 89, 20);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton checkButton = new JButton("Check");
        checkButton.setBounds(300, 370, 89, 20);
        checkButton.setBackground(Color.BLACK);
        checkButton.setForeground(Color.WHITE);
        panel.add(checkButton);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id =choice.getSelectedItem();
                    String query = "select * from customer where number = '" + id + "'";
                    Con con = new Con();
                    ResultSet  resultSet = con.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textFieldRoom.setText(resultSet.getString("room"));
                        textFieldName.setText(resultSet.getString("name"));
                        textFieldCheck.setText(resultSet.getString("checkintime"));
                        textFieldAmount.setText(resultSet.getString("deposit"));
                    }

                    ResultSet resultSet2 = con.statement.executeQuery("select * from room where roomnumber = '" + textFieldRoom.getText() + "'");
                    while (resultSet2.next()) {
                        String price = resultSet2.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPendingAmount.setText(""+amountPaid);
                    }

                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });



        setUndecorated(true);
        setLayout(null);
        setSize(950, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
