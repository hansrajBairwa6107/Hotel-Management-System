package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {
    CheckOut(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5 , 790, 390);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 150, 30);
        label.setFont(new Font("Tahoma", Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel labelId = new JLabel("Customer-Id");
        labelId.setBounds(30, 80, 150, 30);
        labelId.setFont(new Font("Tahoma", Font.BOLD,14));
        labelId.setForeground(Color.WHITE);
        panel.add(labelId);

        Choice customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        customer.setBackground(new Color(3,45,48));
        customer.setForeground(Color.WHITE);
        panel.add(customer);

        JLabel labelRoomNum = new JLabel("Room Number");
        labelRoomNum.setBounds(30, 130, 150, 30);
        labelRoomNum.setFont(new Font("Tahoma", Font.BOLD,14));
        labelRoomNum.setForeground(Color.WHITE);
        panel.add(labelRoomNum);

        JLabel labelRoomNumber = new JLabel();
        labelRoomNumber.setBounds(200, 130, 150, 30);
        labelRoomNumber.setFont(new Font("Tahoma", Font.BOLD,14));
        labelRoomNumber.setForeground(Color.WHITE);
        panel.add(labelRoomNumber);

        JLabel labelCheckInTime = new JLabel("Check-In Time");
        labelCheckInTime.setBounds(30, 180, 150, 30);
        labelCheckInTime.setFont(new Font("Tahoma", Font.BOLD,14));
        labelCheckInTime.setForeground(Color.WHITE);
        panel.add(labelCheckInTime);

        JLabel labelCIT = new JLabel();
        labelCIT.setBounds(200, 180, 200, 30);
        labelCIT.setFont(new Font("Tahoma", Font.BOLD,14));
        labelCIT.setForeground(Color.WHITE);
        panel.add(labelCIT);

        JLabel labelCheckOut = new JLabel("Check-Out Time");
        labelCheckOut.setBounds(30, 230, 150, 30);
        labelCheckOut.setFont(new Font("Tahoma", Font.BOLD,14));
        labelCheckOut.setForeground(Color.WHITE);
        panel.add(labelCheckOut);

        Date date = new Date();

        JLabel labelCO = new JLabel(date+"");
        labelCO.setBounds(200, 230, 200, 30);
        labelCO.setFont(new Font("Tahoma", Font.BOLD,14));
        labelCO.setForeground(Color.WHITE);
        panel.add(labelCO);

        try {
            Con con = new Con();
            ResultSet resultSet = con.statement.executeQuery("select  * from customer");
            while (resultSet.next()){
                customer.add(resultSet.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JButton checkOutButton = new JButton("Check-Out");
        checkOutButton.setBounds(30,300, 100, 20);
        checkOutButton.setForeground(Color.WHITE);
        checkOutButton.setBackground(Color.BLACK);
        panel.add(checkOutButton);
        checkOutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Con con = new Con();
                    con.statement.executeQuery("delete from customer where number = '"+customer.getSelectedItem()+"'");
                    con.statement.executeUpdate("update room set availability = 'Available' where roomnumber = '"+labelRoomNumber.getText()+"'");
                    JOptionPane.showConfirmDialog(null,"Done");
                    setVisible(false);
                }catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        });


        JButton checkButton = new JButton("Check");
        checkButton.setBounds(300,300, 100, 20);
        checkButton.setForeground(Color.WHITE);
        checkButton.setBackground(Color.BLACK);
        panel.add(checkButton);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Con con = new Con();
                    ResultSet resultSet = con.statement.executeQuery("select * from customer where number = '"+customer.getSelectedItem()+"'");
                    while (resultSet.next()){
                        labelRoomNumber.setText(resultSet.getString("room"));
                        labelCIT.setText(resultSet.getString("checkintime"));
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(170,300, 100, 20);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setLayout(null);
        setSize(800, 400);
        setLocation(500, 210);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
