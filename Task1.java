/*Task1:Simple Calculator Application
- Objective: Create a basic calculator application in Java.
- Functionality: Your program should be able to perform addition, subtraction, multiplication, and division operations.
- Details: You will need to design a user-friendly interface that allows users to input two numbers and choose the operation they want to perform. The program should display the result of the operation.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Task1 {
    private JFrame frame;
    private JPanel panel;
    private JTextField display;
    private JButton[] buttons;
    private double n1 = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;
    public Task1() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 25));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        buttons = new JButton[16];
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i));
        }
        buttons[10] = new JButton("+");
        buttons[11] = new JButton("-");
        buttons[12] = new JButton("*");
        buttons[13] = new JButton("/");
        buttons[14] = new JButton("C");
        buttons[15] = new JButton("=");
        for (int i = 0; i < 16; i++) {
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            buttons[i].addActionListener(new ButtonClickListener());
        }
        for (int i = 0; i < 16; i++) {
            panel.add(buttons[i]);
        }
        frame.add(display, BorderLayout.NORTH);
        frame.add(panel);

        frame.setVisible(true);
    }
    class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.matches("\\d")) {
                if (isOperatorClicked) {
                    display.setText(command);
                    isOperatorClicked = false;
                } else {
                    display.setText(display.getText() + command);
                }
            } else if (command.equals("C")) {
                display.setText("");
                n1 = 0;
                operator = "";
            } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                if (!operator.isEmpty()) {
                    n1 = performOperation(n1, Double.parseDouble(display.getText()), operator);
                    display.setText(String.valueOf(n1));
                } else {
                    n1 = Double.parseDouble(display.getText());
                }
                operator = command;
                isOperatorClicked = true;
            } else if (command.equals("=")) {
                if (!operator.isEmpty()) {
                    n1 = performOperation(n1, Double.parseDouble(display.getText()), operator);
                    display.setText(String.valueOf(n1));
                    operator = "";
                }
                isOperatorClicked = true;
            }
        }
    }
    private double performOperation(double n1, double n2, String operator) {
        switch (operator) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                if (n2 != 0) {
                    return n1 / n2;
                } else {
                    JOptionPane.showMessageDialog(frame, "Division by zero is not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new t1());
    }
}


               
