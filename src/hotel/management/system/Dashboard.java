package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton add, rec;
    Dashboard(){

        super("Hotel Management System");

        rec = new JButton("Reception");
        rec.setBounds(425, 510, 140, 30);
        rec.setFont(new Font("tahoma", Font.BOLD,15));
        rec.setBackground(new Color(255, 98, 0));
        rec.setForeground(Color.white);
        rec.addActionListener(this);
        add(rec);

        add = new JButton("Admin");
        add.setBounds(880, 510, 140, 30);
        add.setFont(new Font("tahoma", Font.BOLD,15));
        add.setBackground(new Color(255, 98, 0));
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icons/Reception.png"));
        Image i22=i111.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon imageIcon111 = new ImageIcon(i22);
        JLabel label11 = new JLabel(imageIcon111);
        label11.setBounds(400,300,200,195);
        add(label11);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/boss.png"));
        Image i2=i11.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(i2);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(850,300,200,195);
        add(label1);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/Dashboard.gif"));
        Image i1=imageIcon.getImage().getScaledInstance(1950,1090, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0,0,1950,1090);
        add(label);


        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1950, 1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rec){
            try {
                Thread.sleep(1200);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            Reception r = new Reception();
            r.setVisible(true);
            dispose();
        }
        else if(e.getSource()==add){
            try {
                Thread.sleep(1200);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            Login2 login2 = new Login2();
            login2.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        Dashboard d = new Dashboard();
    }
}
