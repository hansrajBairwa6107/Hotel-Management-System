package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

    JButton addEmployee, addRoom, addDrivers, logout, back;
    Admin() {

        addEmployee = new JButton("ADD EMPLOYEE");
        addEmployee.setBounds(250,230,200,30);
        addEmployee.setBackground(Color.WHITE);
        addEmployee.setForeground(Color.BLACK);
        addEmployee.setFont(new Font("Tahoma", Font.BOLD,15));
        addEmployee.addActionListener(this);
        add(addEmployee);

        addRoom = new JButton("ADD ROOM");
        addRoom.setBounds(250,380,200,30);
        addRoom.setBackground(Color.WHITE);
        addRoom.setForeground(Color.BLACK);
        addRoom.setFont(new Font("Tahoma", Font.BOLD,15));
        addRoom.addActionListener(this);
        add(addRoom);

        addDrivers = new JButton("ADD DRIVERS");
        addDrivers.setBounds(250,530,200,30);
        addDrivers.setBackground(Color.WHITE);
        addDrivers.setForeground(Color.BLACK);
        addDrivers.setFont(new Font("Tahoma", Font.BOLD,15));
        addDrivers.addActionListener(this);
        add(addDrivers);

        logout = new JButton("Logout");
        logout.setBounds(10,750,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD,15));
        logout.addActionListener(this);
        add(logout);

        back = new JButton("Back");
        back.setBounds(110,750,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD,15));
        back.addActionListener(this);
        add(back);

        ImageIcon l = new ImageIcon(ClassLoader.getSystemResource("icons/employees.png"));
        Image l1 =l.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(l1);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(70,180,120,120);
        add(label);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/room.png"));
        Image image =imageIcon1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(70,340,120,120);
        add(label1);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icons/driver.png"));
        Image image1 =imageIcon2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon12 = new ImageIcon(image1);
        JLabel label2 = new JLabel(imageIcon12);
        label2.setBounds(70,500,120,120);
        add(label2);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icons/hhhh.gif"));
        Image image2 =imageIcon3.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon13 = new ImageIcon(image2);
        JLabel label3 = new JLabel(imageIcon13);
        label3.setBounds(1000,170,400,400);
        add(label3);



        getContentPane().setBackground(new Color(3,44,48));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==addEmployee){
            AddEmployee employee = new AddEmployee();
        }else if (e.getSource()==addRoom){
            AddRoom room = new AddRoom();
        }else if (e.getSource()==addDrivers){
            AddDriver driver = new AddDriver();
        }else if (e.getSource()==logout){
            if (JOptionPane.showConfirmDialog(null, "Do you want to logout?") == JOptionPane.OK_OPTION) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Logout successfully!");
                System.exit(500);
            }
        } else if (e.getSource()==back) {
            new Dashboard();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        Admin admin = new Admin();
    }
}
