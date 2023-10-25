package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login2 extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField;

    JButton button1, button2;

    Login2(){
        JLabel label1 = new JLabel("UserName");
        label1.setBounds(40,20,100,30);
        label1.setFont(new Font("Tahoma", Font.BOLD,16));
        label1.setForeground(Color.white);
        add(label1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40,70,100,30);
        label2.setFont(new Font("Tahoma", Font.BOLD,16));
        label2.setForeground(Color.white);
        add(label2);

        textField1 = new JTextField();
        textField1.setBounds(150,20,150,30);
        textField1.setForeground(Color.white);
        textField1.setFont(new Font("Tahoma", Font.PLAIN,15));
        textField1.setBackground(new Color(26,104,110));
        add(textField1);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        passwordField.setForeground(Color.white);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN,15));
        passwordField.setBackground(new Color(26,104,110));
        add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/hhhh.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(318,-8,255,300);
        add(label);

        button1 = new JButton("Login");
        button1.setBounds(40,140,120,30);
        button1.setFont(new Font("serif", Font.BOLD,15));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.white);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Cancel");
        button2.setBounds(180,140,120,30);
        button2.setFont(new Font("serif", Font.BOLD,15));
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.white);
        button2.addActionListener(this);
        add(button2);

        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setLocation(400, 270);
        setSize(600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            try {
                Con c = new Con();
                String username = textField1.getText();
                String password = new String(passwordField.getPassword());

                String q = "select * from login2 where username = '"+username+"' and password = '"+password+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()){
                    Thread.sleep(1200);
                    new Admin();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
        else {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        Login2 login = new Login2();
    }
}
