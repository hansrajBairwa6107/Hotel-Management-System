package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame {
    ManagerInfo(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        panel.add(table);

        try {
            Con con = new Con();
            String managerInfoQuery = "SELECT * FROM employee where job='Manager'";
            ResultSet resultSet = con.statement.executeQuery(managerInfoQuery);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            con.statement.close();
            con.connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(350, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setBounds(41, 11, 70, 19);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(nameLabel);

        JLabel ageLabel = new JLabel("AGE");
        ageLabel.setBounds(161, 11, 70, 19);
        ageLabel.setForeground(Color.WHITE);
        ageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(ageLabel);

        JLabel genderLabel = new JLabel("GENDER ");
        genderLabel.setBounds(281, 11, 70, 19);
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(genderLabel);

        JLabel jobLabel = new JLabel("COMPANY ");
        jobLabel.setBounds(411, 11, 70, 19);
        jobLabel.setForeground(Color.WHITE);
        jobLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(jobLabel);

        JLabel salaryLabel = new JLabel("CAR NAME ");
        salaryLabel.setBounds(531, 11, 70, 19);
        salaryLabel.setForeground(Color.WHITE);
        salaryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(salaryLabel);

        JLabel phoneLabel = new JLabel("PHONE ");
        phoneLabel.setBounds(651, 11, 70, 19);
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(phoneLabel);

        JLabel emailLabel = new JLabel("GMAIL ");
        emailLabel.setBounds(771, 11, 70, 19);
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(emailLabel);

        JLabel aadharLabel = new JLabel("AADHAR ");
        aadharLabel.setBounds(891, 11, 70, 19);
        aadharLabel.setForeground(Color.WHITE);
        aadharLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(aadharLabel);


        setUndecorated(true);
        setLocation(430, 100);
        setLayout(null);
        setSize(1000, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        ManagerInfo managerInfo = new ManagerInfo();
    }
}
