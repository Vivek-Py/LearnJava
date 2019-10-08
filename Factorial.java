

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

public class Factorial extends JFrame {

    Factorial(int n) {
        this.setSize(270, 120);
        this.setTitle("Factorial Solver!");

        JPanel panel = new JPanel();
        this.add(panel);

        JTextField nField = new JTextField(11);
        JTextField resultField = new JTextField(18);
        JLabel nLabel = new JLabel();
        nLabel.setText("n = ");
        JLabel resultLabel = new JLabel();
        resultLabel.setText("n! = ");
        JButton calcBtn = new JButton();
        calcBtn.setText("Calculate");

        panel.add(nLabel);
        panel.add(nField);
        panel.add(calcBtn);
        panel.add(resultLabel);
        panel.add(resultField);
        calcBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(nField.getText());
                int fact = 1;
                if (n == 1)
                    fact = 1;
                else
                    for (int i = 1; i <= n; i++) {
                        fact = fact * i;
                    }

                String result = Integer.toString(fact);
                resultField.setText(result);
            }
        });

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Factorial(20);
    }
}
