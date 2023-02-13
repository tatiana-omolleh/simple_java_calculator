package com.Tatiana;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calc extends JFrame implements ActionListener{
    private JTextField inputField;
    private JFrame calcFrame;
    private JButton btnAC, btnDelete, btnModulus, btnDivide, btnAdd, btnSubtract, btnMultiply, btnPoint, btnEqual, btn0,
            btnNeg;
    private JButton[] numbers = new JButton[10];
    private JPanel panel;
    private char operator;
    private double num1, num2, res;
    Font font = new Font("SF Pro",Font.PLAIN,20);
    public Calc(){
        //Frame
        calcFrame = new JFrame("Calculator");
        calcFrame.setSize(420,400);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setLayout(null);
        //Text Field
        inputField = new JTextField( );
        inputField.setBounds(30,25,360,50);
        inputField.setEditable(false);
        inputField.setFont(font);
        calcFrame.add(inputField);
        //Buttons
        btnAC = new JButton("AC");
        btnAC.addActionListener(this);
        btnAC.setBounds(30,80,85,50);
        btnAC.setFont(font);
        calcFrame.add(btnAC);
        btnNeg = new JButton("(-)");
        btnNeg.addActionListener(this);
        btnNeg.setBounds(120,80,85,50);
        btnNeg.setFont(font);
        calcFrame.add(btnNeg);
        btnDelete = new JButton("<--");
        btnDelete.addActionListener(this);
        btnDelete.setBounds(210,80,85,50);
        btnDelete.setFont(font);
        calcFrame.add(btnDelete);
        btnModulus = new JButton("%");
        btnModulus.addActionListener(this);
        btnModulus.setBounds(300,80,90,50);
        btnModulus.setFont(font);
        calcFrame.add(btnModulus);
        btnAdd = new JButton("+");
        btnAdd.addActionListener(this);
        btnAdd.setBounds(300,135,90,50 );
        btnAdd.setFont(font);
        calcFrame.add(btnAdd);
        btnSubtract = new JButton("-");
        btnSubtract.addActionListener(this);
        btnSubtract.setBounds(300,190,90,50);
        btnSubtract.setFont(font);
        calcFrame.add(btnSubtract);
        btnMultiply = new JButton("*");
        btnMultiply.addActionListener(this);
        btnMultiply.setBounds(300,245,90,50);
        btnMultiply.setFont(font);
        calcFrame.add(btnMultiply);
        btnDivide = new JButton("/");
        btnDivide.addActionListener(this);
        btnDivide.setBounds(300,300,90,50);
        btnDivide.setFont(font);
        calcFrame.add(btnDivide);
        btnEqual = new JButton("=");
        btnEqual.addActionListener(this);
        btnEqual.setBounds(210,300,85,50);
        btnEqual.setFont(font);
        calcFrame.add(btnEqual);
        btnPoint = new JButton(".");
        btnPoint.addActionListener(this);
        btnPoint.setBounds(120,300,85,50);
        btnPoint.setFont(font);
        calcFrame.add(btnPoint);
        btn0  = new JButton("0");
        btn0.addActionListener(this);
        btn0.setBounds(30,300,85,50);
        btn0.setFont(font);
        calcFrame.add(btn0);
        //Number Buttons using For Loops and Arrays
        for(int i = 0; i <= 9; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
        }
        //Panel for number buttons
        panel = new JPanel();
        panel.setBounds(30,135,265,160);
        panel.setLayout(new GridLayout(3,3,5,5));
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        calcFrame.add(panel);
        calcFrame.setVisible(true);
    }
    public static void main(String[]args){
        Calc calc = new Calc();
    }
    public void actionPerformed(ActionEvent e){
        //Using concat to link the numbers(string) together
        for(int i = 0; i <= 9; i++){
            if(e.getSource() == numbers[i]){
                inputField.setText(inputField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == btnPoint){
            inputField.setText(inputField.getText().concat("."));
        }
        if(e.getSource() == btn0){
            inputField.setText(inputField.getText().concat("0"));
        }

        if(e.getSource() == btnAC){
            inputField.setText(" ");
        }
        if(e.getSource() == btnNeg){
            double negative = Double.parseDouble(inputField.getText());
            negative *= -1;
            inputField.setText(String.valueOf(negative));
        }
        if(e.getSource() == btnDelete){
            String string = inputField.getText();
            inputField.setText("");
            for(int i = 0; i < string.length()-1;i++){
                inputField.setText(inputField.getText() + string.charAt(i));
            }

        }
        if(e.getSource() == btnAdd){
            num1 = Double.parseDouble(inputField.getText());
            operator = '+';
            inputField.setText(" ");
        }
        if(e.getSource() == btnSubtract){
            num1 = Double.parseDouble(inputField.getText());
            operator = '-';
            inputField.setText(" ");
        }
        if(e.getSource() == btnMultiply){
            num1 = Double.parseDouble(inputField.getText());
            operator = '*';
            inputField.setText(" ");
        }
        if(e.getSource() == btnDivide){
            num1 = Double.parseDouble(inputField.getText());
            operator = '/';
            inputField.setText(" ");
        }
        if(e.getSource() == btnModulus){
            num1 = Double.parseDouble(inputField.getText());
            operator = '%';
            inputField.setText(" ");
        }
        if(e.getSource() == btnEqual){
            num2 = Double.parseDouble(inputField.getText());
            switch(operator){
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
                case '%':
                    res = num1 % num2;
                    break;
            }
            inputField.setText(String.valueOf(res));
            num1 = res;
        }
    }
}