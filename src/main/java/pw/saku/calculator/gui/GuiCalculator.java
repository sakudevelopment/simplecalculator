package pw.saku.calculator.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GuiCalculator extends JFrame {

    JLabel labelNumber1;
    JLabel labelNumber2;
    JLabel labelSolution;
    JLabel labelOperator;

    JTextField fieldNumber1;
    JTextField fieldNumber2;

    private JButton buttonCalculate;

    private String operator;

    public GuiCalculator(String title, String operator) {
        this.operator = operator;

        this.setTitle(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(250, 125);
        this.setResizable(false);
        this.initComponents();
        this.add(labelNumber1);
        this.add(labelNumber2);
        this.add(fieldNumber1);
        this.add(labelOperator);
        this.add(fieldNumber2);
        this.add(buttonCalculate);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {
        labelNumber1 = new JLabel("           Number 1");
        labelNumber2 = new JLabel("Number 2           ");
        labelOperator = new JLabel(operator);

        fieldNumber1 = new JTextField(8);
        fieldNumber2 = new JTextField(8);

        buttonCalculate = new JButton("Calculate!");
        buttonCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double number1 = Integer.parseInt(fieldNumber1.getText());
                    double number2 = Integer.parseInt(fieldNumber2.getText());
                    double solution;

                    String strSolution = "";
                    if (operator.equals("+")) {
                        solution = number1 + number2;
                        strSolution = solution + "";
                    } else if (operator.equals("-")) {
                        solution = number1 - number2;
                        strSolution = solution + "";
                    } else if (operator.equals("/")) {
                        solution = number1 / number2;
                        strSolution = solution + "";
                    } else if (operator.equals("-")) {
                        solution = number1 - number2;
                        strSolution = solution + "";
                    } else {
                        strSolution = "Please enter a valid Number!";
                    }

                    if (strSolution.equalsIgnoreCase("Please enter a valid Number!")) {
                        JOptionPane.showMessageDialog(GuiCalculator.this, strSolution, "Error", JOptionPane.ERROR_MESSAGE);
                        fieldNumber1.setText("");
                        fieldNumber2.setText("");
                    } else {
                        JOptionPane.showMessageDialog(GuiCalculator.this, "Solution: " + strSolution, "Solution calculated!", JOptionPane.INFORMATION_MESSAGE);
                        fieldNumber1.setText("");
                        fieldNumber2.setText("");
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(GuiCalculator.this, "Thats not a valid Number!", "Error", JOptionPane.ERROR_MESSAGE);
                    fieldNumber1.setText("");
                    fieldNumber2.setText("");
                }
            }
        });
    }
}
