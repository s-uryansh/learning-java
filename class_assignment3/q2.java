package class_assignment3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class q2{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE);
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 4));
        p1.add(new JButton("7"));
        p1.add(new JButton("8"));
        p1.add(new JButton("9"));
        p1.add(new JButton("/"));
        p1.add(new JButton("4"));
        p1.add(new JButton("5"));
        p1.add(new JButton("6"));
        p1.add(new JButton("*"));
        p1.add(new JButton("1"));
        p1.add(new JButton("2"));
        p1.add(new JButton("3"));
        p1.add(new JButton("-"));
        p1.add(new JButton("0"));
        p1.add(new JButton("."));
        p1.add(new JButton("="));
        p1.add(new JButton("+"));

        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(new JTextField("0"),BorderLayout.NORTH);
        p2.add(p1, BorderLayout.CENTER);
        frame.add(p2, BorderLayout.CENTER);
        }
    }
