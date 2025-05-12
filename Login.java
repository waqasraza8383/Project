import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import  java.awt.*;


class Login extends JFrame{
Login(){

    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
          add(image);
           JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
         JLabel name = new JLabel("Enter your name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        name.setForeground(new Color(30, 144, 254));
        add(name);
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
}
public static void main(String[] args) {
  new Login();   
}
}