import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];

    JLabel qno, question, timerLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    int timer = 15;
    int count = 0;
    int score = 0;
    boolean lifelineUsed = false;

    Timer quizTimer;
    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(100, 100, 1200, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1200, 200);
        add(image);

        qno = new JLabel();
        qno.setBounds(50, 250, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(qno);

        question = new JLabel();
        question.setBounds(100, 250, 1000, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(question);

        opt1 = new JRadioButton();
        opt1.setBounds(100, 300, 800, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(100, 340, 800, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(100, 380, 800, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(100, 420, 800, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(100, 500, 100, 30);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(250, 500, 150, 30);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(450, 500, 100, 30);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        timerLabel = new JLabel("Time left: 15 sec");
        timerLabel.setBounds(1000, 250, 200, 30);
        timerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        timerLabel.setForeground(Color.RED);
        add(timerLabel);

        setQuestions();
        start(count);
        startTimer();

        setVisible(true);
    }

    public void setQuestions() {
        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";
        answers[0][1] = "JDB";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";
        answers[1][1] = "int";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";
        answers[2][1] = "java.util package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";
        answers[3][1] = "Marker Interface";

        questions[4][0] = "In which memory a String is stored using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";
        answers[4][1] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";
        answers[5][1] = "Remote interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";
        answers[6][1] = "import";

        questions[7][0] = "In java, JAR stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";
        answers[7][1] = "Java Archive";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";
        answers[8][1] = "java.lang.StringBuilder";

        questions[9][0] = "Which option leads to portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "Applet makes Java secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
         answers[9][1] = "Bytecode is executed by JVM";
    }

    public void start(int count) {
        qno.setText((count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public void startTimer() {
        quizTimer = new Timer(1000, e -> {
            timer--;
            timerLabel.setText("Time left: " + timer + " sec");
            if (timer <= 0) {
                quizTimer.stop();
                nextQuestion();
            }
        });
        quizTimer.start();
    }

    public void nextQuestion() {
        String ans = "";
        if (groupoptions.getSelection() != null) {
            ans = groupoptions.getSelection().getActionCommand();
        }
        useranswers[count][0] = ans;

        count++;
        if (count == questions.length - 1) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }

        if (count < questions.length) {
            timer = 15;
            start(count);
            quizTimer.restart();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            quizTimer.stop();
            nextQuestion();
        } else if (ae.getSource() == lifeline && !lifelineUsed) {
            if (count % 2 == 0) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifelineUsed = true;
        } else if (ae.getSource() == submit) {
            quizTimer.stop();

            String ans = "";
            if (groupoptions.getSelection() != null) {
                ans = groupoptions.getSelection().getActionCommand();
            }
            useranswers[count][0] = ans;

            for (int i = 0; i < questions.length; i++) {
                if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }

            JOptionPane.showMessageDialog(this, "Your Score: " + score);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
