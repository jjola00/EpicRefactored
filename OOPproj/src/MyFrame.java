//import for ActionListener and Button design
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements GFrame  {
    JButton button;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton buttonL;

    MyFrame() {
        ImageIcon background = new ImageIcon("C:\\Users\\JJ\\Downloads\\back.png");
        ImageIcon logo = new ImageIcon("C:\\Users\\JJ\\Downloads\\KS.png");

        button = createButton(900, 60, "Discrete Mathematics", new ActionListener() {
            @Override//overriding method in interface to  make button
            public void actionPerformed(ActionEvent e) {
              DM_ID.run();
            }
        }, background);

        button2 = createButton(10, 320, "Computer Organization", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CO_ID.run();
            }
        }, background);

        button3 = createButton(900, 580, "Computer Science", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             CS_ID.run();
            }
        }, background);

        button4 = createButton(900, 320, "Who Wants to be a Millionaire", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QUIZTHREE.run();
            }
        }, background);

        buttonL = new JButton();
        buttonL.setBounds(10, 20, 600, 150);
        buttonL.setFocusable(false);
        buttonL.setIcon(logo);
        buttonL.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        this.add(button);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(buttonL);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.validate();
        this.setVisible(true);
    }
}
