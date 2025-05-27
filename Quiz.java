import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame  {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    Quiz(String name){
        this.name=name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/quiz.jpg"));
         JLabel image = new JLabel(i1);
         image.setBounds(0, 0, 1440, 392);
         add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);



        setSize(1200, 500);
         setLocation(350, 200);
          setVisible(true);
    }
}
