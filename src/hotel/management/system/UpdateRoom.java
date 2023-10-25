package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {
    UpdateRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(3, 45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Room Status");
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

        JLabel label4 = new JLabel("Availability :");
        label4.setBounds(25, 174, 100, 15);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(248, 174, 140, 20);
        panel.add(textFieldName);

        JLabel label5 = new JLabel("Cleaning Status :");
        label5.setBounds(25, 216, 120, 15);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldCheck = new JTextField();
        textFieldCheck.setBounds(248, 216, 140, 20);
        panel.add(textFieldCheck);


        JButton updateButton = new JButton("Update");
        updateButton.setBounds(120, 315, 89, 20);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        panel.add(updateButton);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Con con = new Con();
                     String status = textFieldCheck.getText();
                     if (JOptionPane.showConfirmDialog(null, "Do you want to update?")==JOptionPane.OK_OPTION){
                         con.statement.executeUpdate("UPDATE room set cleaning_status = '" + status + "' WHERE roomnumber = '" + textFieldRoom.getText() + "'");
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
        backButton.setBounds(180, 355, 89, 20);
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
        checkButton.setBounds(60, 355, 89, 20);
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
                    }

                    ResultSet resultSet2 = con.statement.executeQuery("select * from room where roomnumber = '" + textFieldRoom.getText() + "'");
                    while (resultSet2.next()) {
                        textFieldName.setText(resultSet2.getString("availability"));
                        textFieldCheck.setText(resultSet2.getString("cleaning_status"));
                    }

                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });



        setUndecorated(true);
        setLayout(null);
        setSize(950, 450);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
