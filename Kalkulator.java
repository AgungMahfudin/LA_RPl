/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agung_50420069;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Agung.M Laptop
 */
public class Kalkulator extends JFrame implements ActionListener {
     private static JFrame frame;
    private static JTextField textField;
    private String input = "";
    private String operator = "";
    private double num1, num2, result;

    // Membuat konstruktor
    public Kalkulator() {
        // Membuat frame
        frame = new JFrame("Kalkulator");

        // Membuat text field
        textField = new JTextField();

        // Membuat tombol
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton eqButton = new JButton("=");
        JButton clrButton = new JButton("C");

        // Menambahkan action listener ke tombol
        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(this);
        }

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        clrButton.addActionListener(this);

        // Menentukan posisi
        textField.setBounds(30, 40, 280, 30);
        addButton.setBounds(40, 100, 50, 40);
        subButton.setBounds(110, 100, 50, 40);
        mulButton.setBounds(180, 100, 50, 40);
        divButton.setBounds(250, 100, 50, 40);
        eqButton.setBounds(120, 170, 120, 40);
        clrButton.setBounds(120, 240, 120, 40);

        // Menambahkan ke frame
        frame.add(textField);

        for (int i = 0; i < 10; i++) {
            frame.add(numberButtons[i]);
        }

        frame.add(addButton);
        frame.add(subButton);
        frame.add(mulButton);
        frame.add(divButton);
        frame.add(eqButton);
        frame.add(clrButton);

        // Mengatur properti frame
        frame.setLayout(null);
        frame.setSize(350, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Kalkulator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
            input += command;
            textField.setText(input);
        } else if (command.charAt(0) == 'C') {
            input = "";
            textField.setText(input);
        } else if (command.charAt(0) == '=') {
            num2 = Double.parseDouble(input);

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
            input = "";
        } else {
            if (!input.isEmpty()) {
                num1 = Double.parseDouble(input);
                operator = command;
                input = "";
            }
        }
    }
}