package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBackground(new Color(3,45,48));
        table.setBounds(0, 40, 700, 350);
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            Con con = new Con();
            String departmentInfoQuery = "SELECT * FROM department";
            ResultSet resultSet = con.statement.executeQuery( departmentInfoQuery);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            con.statement.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(400, 410, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel label1 = new JLabel("Department");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        label1.setBounds(125, 11, 105, 20);
        panel.add(label1);

        JLabel label2 = new JLabel("Budget");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.WHITE);
        label2.setBounds(431, 11, 105, 20);
        panel.add(label2);


        setUndecorated(true);
        setLayout(null);
        setLocation(550,150);
        setSize(700, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        Department department = new Department();
    }
}
