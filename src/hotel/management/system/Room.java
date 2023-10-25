package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;
    JButton back;
    Room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        table = new JTable(); // creating table and modification
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            Con con = new Con();
            String roomInfoQuery = "select * from room";
            ResultSet resultSet = con.statement.executeQuery(roomInfoQuery);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            con.statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        back = new JButton("BACK");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
//                Room room = new Room();
                dispose();
            }
        });

        JLabel room = new JLabel("Room No.");
        room.setBounds(12,15,80,19);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        room.setForeground(Color.WHITE);
        panel.add(room);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(112,15,80,19);
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        availability.setForeground(Color.WHITE);
        panel.add(availability);

        JLabel cleaningStatus = new JLabel("Status");
        cleaningStatus.setBounds(212,15,140,19);
        cleaningStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
        cleaningStatus.setForeground(Color.WHITE);
        panel.add(cleaningStatus);

        JLabel price = new JLabel("Price");
        price.setBounds(312,15,80,19);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        price.setForeground(Color.WHITE);
        panel.add(price);

        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(412,15,80,19);
        bedType.setFont(new Font("Tahoma", Font.BOLD, 14));
        bedType.setForeground(Color.WHITE);
        panel.add(bedType);


        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(500, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        Room room = new Room();
    }
}
