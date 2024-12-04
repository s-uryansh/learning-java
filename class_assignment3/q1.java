package class_assignment3;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class q1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise");
        frame.setSize(400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));

        

        panel.add(new JLabel("Investment Amount:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Number of Years:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Annual Interest Rate:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Future Value:"));
        panel.add(new JTextField());

        panel.add(new JLabel(""));
        JButton calculateButton = new JButton("Calculate");
        panel.add(calculateButton);

        frame.add(panel);
    }
}