package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton searchButton, backButton;
    SearchRoom(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(3, 45, 48));
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        add(panel);

        JLabel searchForRoom = new JLabel("Search For Room");
        searchForRoom.setBounds(250, 11,186, 31);
        searchForRoom.setForeground(Color.WHITE);
        searchForRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(searchForRoom);

        JLabel rbt = new JLabel("Room Bed Type");
        rbt.setBounds(50, 65,115, 25);
        rbt.setForeground(Color.WHITE);
        rbt.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(rbt);

        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setBounds(23, 162,115, 25);
        roomNumber.setForeground(Color.WHITE);
        roomNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(roomNumber);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(173, 162,115, 25);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(availability);

        JLabel cleaningStatus = new JLabel("Cleaning Status");
        cleaningStatus.setBounds(306, 162,115, 25);
        cleaningStatus.setForeground(Color.WHITE);
        cleaningStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(cleaningStatus);

        JLabel price = new JLabel("Price");
        price.setBounds(458, 162,115, 25);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(price);

        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(580, 162,115, 25);
        bedType.setForeground(Color.WHITE);
        bedType.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(bedType);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400, 69, 205, 25);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(new Color(3,45,48));
        panel.add(checkBox);

        choice = new Choice();
        choice.add("Single");
        choice.add("Double");
        choice.setBounds(170, 70, 120, 20);
        panel.add(choice);

        table = new JTable();
        table.setBounds(10, 187, 700, 150);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {

            Con con = new Con();
            String query = "SELECT * FROM room";
            ResultSet resultSet = con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e) {
            e.printStackTrace();
        }

        searchButton = new JButton("Search");
        searchButton.setBounds(200, 400, 100, 30);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        searchButton.addActionListener(this);
        panel.add(searchButton);

        backButton = new JButton("Back");
        backButton.setBounds(380, 400, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        panel.add(backButton);


        setUndecorated(true);
        setLayout(null);
        setLocation(500, 200);
        setSize(700,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==searchButton){
            try {

                Con con = new Con();
                String query = "SELECT * FROM room WHERE bed_type = '"+choice.getSelectedItem()+"'";
                if (checkBox.isSelected()){
                    query = query + " AND availability = 'Available'";
                }
                ResultSet resultSet = con.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource()==backButton){
            this.dispose();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
