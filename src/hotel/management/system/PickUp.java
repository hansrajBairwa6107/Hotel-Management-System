package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {
    PickUp(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(3, 45, 48));
        panel.setBounds(5, 5, 790, 590);
        panel.setLayout(null);
        add(panel);

        JLabel lblPickUp = new JLabel("PICK-UP SERVICE");
        lblPickUp.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPickUp.setForeground(Color.WHITE);
        lblPickUp.setBounds(100, 10, 200, 40);
        panel.add(lblPickUp);

        JLabel typeOfCar = new JLabel("TYPE OF CAR ");
        typeOfCar.setFont(new Font("Tahoma", Font.BOLD, 14));
        typeOfCar.setForeground(Color.WHITE);
        typeOfCar.setBounds(32, 97, 110, 25);
        panel.add(typeOfCar);

        Choice choice = new Choice();
        choice.setBounds(143, 99, 150, 25);
        panel.add(choice);

        try {
            Con con = new Con();
            String query = "SELECT * FROM driver";
            ResultSet rs = con.statement.executeQuery(query);
            while (rs.next()) {
                choice.add(rs.getString("carname"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10, 233, 800, 250);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            Con con = new Con();
            String query = "SELECT * FROM driver";
            ResultSet resultSet = con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setBounds(24, 208, 46, 14);
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);

        JLabel ageLabel = new JLabel("AGE");
        ageLabel.setBounds(140, 208, 46, 14);
        ageLabel.setForeground(Color.WHITE);
        panel.add(ageLabel);

        JLabel genderLabel = new JLabel("GENDER");
        genderLabel.setBounds(250, 208, 60, 14);
        genderLabel.setForeground(Color.WHITE);
        panel.add(genderLabel);

        JLabel companyLabel = new JLabel("COMPANY");
        companyLabel.setBounds(360, 208, 70, 14);
        companyLabel.setForeground(Color.WHITE);
        panel.add(companyLabel);

        JLabel carLabel = new JLabel("CAR NAME");
        carLabel.setBounds(480, 208, 80, 14);
        carLabel.setForeground(Color.WHITE);
        panel.add(carLabel);

        JLabel availableLabel = new JLabel("AVAILABILITY");
        availableLabel.setBounds(595, 208, 80, 14);
        availableLabel.setForeground(Color.WHITE);
        panel.add(availableLabel);

        JLabel locationLabel = new JLabel("LOCATION");
        locationLabel.setBounds(700, 208, 70, 14);
        locationLabel.setForeground(Color.WHITE);
        panel.add(locationLabel);

        JButton displayButton = new JButton("DISPLAY");
        displayButton.setBounds(200, 500, 100, 30);
        displayButton.setBackground(Color.BLACK);
        displayButton.setForeground(Color.WHITE);
        panel.add(displayButton);
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "SELECT * FROM driver WHERE carname = '" +choice.getSelectedItem()+"'";
                    Con con = new Con();
                    ResultSet resultSet = con.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });



        JButton backButton = new JButton("BACK");
        backButton.setBounds(420, 500, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   setVisible(false);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });


        setUndecorated(true);
        setLayout(null);
        setSize(800, 600);
        setLocation(500, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PickUp();
    }
}
