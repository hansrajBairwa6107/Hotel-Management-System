package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {
    CustomerInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            Con con = new Con();
            String query = "SELECT * FROM customer";
            ResultSet resultSet = con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            con.statement.close();
            con.connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(31, 11, 46, 14);
        idLabel.setForeground(Color.WHITE);
        idLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(idLabel);

        JLabel numberLabel = new JLabel("NAME");
        numberLabel.setBounds(150, 11, 46, 14);
        numberLabel.setForeground(Color.WHITE);
        numberLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(numberLabel);

        JLabel nameLabel = new JLabel("ID NUMBER");
        nameLabel.setBounds(240, 11, 90, 14);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(nameLabel);

        JLabel genderLabel = new JLabel("GENDER");
        genderLabel.setBounds(370, 11, 70, 14);
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(genderLabel);

        JLabel countryLabel = new JLabel("COUNTRY");
        countryLabel.setBounds(470, 11, 80, 14);
        countryLabel.setForeground(Color.WHITE);
        countryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(countryLabel);

        JLabel roomLabel = new JLabel("ROOM");
        roomLabel.setBounds(600, 11, 46, 14);
        roomLabel.setForeground(Color.WHITE);
        roomLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(roomLabel);

        JLabel checkInLabel = new JLabel("CHECK-IN");
        checkInLabel.setBounds(690, 11, 90, 14);
        checkInLabel.setForeground(Color.WHITE);
        checkInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(checkInLabel);

        JLabel depositLabel = new JLabel("DEPOSIT");
        depositLabel.setBounds(800 , 11, 90, 14);
        depositLabel.setForeground(Color.WHITE);
        depositLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(depositLabel);


        JButton backButton = new JButton("BACK");
        backButton.setBounds(700, 510, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(backButton);


        setUndecorated(true);
        setSize(900, 600);
        setLocation(500, 100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
