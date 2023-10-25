package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    JButton backButton, logoutButton;

    Reception(){

        JPanel panel = new JPanel(); // for dividing the window
        panel.setLayout(null);
        panel.setBounds(280, 5, 1238, 820);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 270, 820);
        panel1.setBackground(new Color(3,45,48));
        add(panel1);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logoH.gif"));
        Image i=imageIcon.getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(300,120,500,500);
        panel.add(label);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icons/hhhh.gif"));
        Image i1=imageIcon2.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(i1);
        JLabel label1 = new JLabel(imageIcon3);
        label1.setBounds(5,530,250,250);
        panel1.add(label1);

        JButton btnNcf = new JButton("NEW CUSTOMER FORM");
        btnNcf.setBounds(30,30,200,30);
        btnNcf.setBackground(Color.BLACK);
        btnNcf.setForeground(Color.WHITE);
        panel1.add(btnNcf);
        btnNcf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NewCustomer();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton btnNRoom = new JButton("ROOM");
        btnNRoom.setBounds(30,70,200,30);
        btnNRoom.setBackground(Color.BLACK);
        btnNRoom.setForeground(Color.WHITE);
        panel1.add(btnNRoom);
        btnNRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Room();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton btnDepartment = new JButton("DEPARTMENT");
        btnDepartment.setBounds(30,110,200,30);
        btnDepartment.setBackground(Color.BLACK);
        btnDepartment.setForeground(Color.WHITE);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Department();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton btnAEI = new JButton("ALL EMPLOYEE INFO");
        btnAEI.setBounds(30,150,200,30);
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.WHITE);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Employee();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton btnCusInfo = new JButton("CUSTOMER INFO");
        btnCusInfo.setBounds(30,190,200,30);
        btnCusInfo.setBackground(Color.BLACK);
        btnCusInfo.setForeground(Color.WHITE);
        panel1.add(btnCusInfo);
        btnCusInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CustomerInfo();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton btnManInfo = new JButton("MANAGER INFO");
        btnManInfo.setBounds(30,230,200,30);
        btnManInfo.setBackground(Color.BLACK);
        btnManInfo.setForeground(Color.WHITE);
        panel1.add(btnManInfo);
        btnManInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ManagerInfo();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton btnCheckOut = new JButton("CHECK-OUT");
        btnCheckOut.setBounds(30,270,200,30);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        panel1.add(btnCheckOut);
        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CheckOut();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton btnUpdCheckIn = new JButton("UPDATE CHECK-IN DETAILS");
        btnUpdCheckIn.setBounds(30,310,200,30);
        btnUpdCheckIn.setBackground(Color.BLACK);
        btnUpdCheckIn.setForeground(Color.WHITE);
        panel1.add(btnUpdCheckIn);
        btnUpdCheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateCheck();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton btnUpdRoomSta = new JButton("UPDATE ROOM DETAILS");
        btnUpdRoomSta.setBounds(30,350,200,30);
        btnUpdRoomSta.setBackground(Color.BLACK);
        btnUpdRoomSta.setForeground(Color.WHITE);
        panel1.add(btnUpdRoomSta);
        btnUpdRoomSta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateRoom();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton btnPickupSer = new JButton("PICK-UP SERVICE");
        btnPickupSer.setBounds(30,390,200,30);
        btnPickupSer.setBackground(Color.BLACK);
        btnPickupSer.setForeground(Color.WHITE);
        panel1.add(btnPickupSer);
        btnPickupSer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new PickUp();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton btnSearchRoom = new JButton("SEARCH ROOM");
        btnSearchRoom.setBounds(30,430,200,30);
        btnSearchRoom.setBackground(Color.BLACK);
        btnSearchRoom.setForeground(Color.WHITE);
        panel1.add(btnSearchRoom);
        btnSearchRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new SearchRoom();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        backButton = new JButton("Back");
        backButton.setBounds(140, 470, 95, 33);
        backButton.setFont(new Font("Tahoma",Font.BOLD,14));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
        panel1.add(backButton);
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                Dashboard dashboard = new Dashboard();
                setVisible(false);
            }
        });

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(30, 470, 95, 33);
        logoutButton.setFont(new Font("Tahoma",Font.BOLD,14));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.BLACK);
        panel1.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (JOptionPane.showConfirmDialog(null, "Do you want to logout?") == JOptionPane.OK_OPTION) {
                        Thread.sleep(2000);
                        JOptionPane.showMessageDialog(null, "Logout successfully!");
                        System.exit(500);
                    }

                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(2000, 1090);
        setVisible(true);
    }

    public static void main(String[] args) {
        Reception r = new Reception();
    }
}
