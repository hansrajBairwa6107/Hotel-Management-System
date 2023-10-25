package hotel.management.system;

import javax.swing.*;

public class Splash extends JFrame {

    Splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/H2splash.gif"));
        JLabel label = new JLabel(imageIcon); // we cannot directly use images or vid that's why we are using JLable
        label.setBounds(0,0,858,680);
        add(label);

        setLayout(null);// the layout of frame is by default border layout so, we have to pass it null
        setLocation(300,80); // for managing the window opening position
        setSize(858,680);// for setting the size of window screen
        setVisible(true); // for showing frame // the visibility of frame by default is false so, we have to pass it true

        try {
            Thread.sleep(5000);// for closing the frame after five seconds
            setVisible(false);
            Thread.sleep(500);
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Splash obj = new Splash();
    }
}
