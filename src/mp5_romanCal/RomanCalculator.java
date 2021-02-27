/*
 * Name: Nidhi Patel
 * Project Name: Machine Problem 5 (Roman Calculator) 
 * Project Description: calulator that converts Roman numbers to int and vice versa.
 */
package mp5_romanCal;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RomanCalculator extends JFrame implements ActionListener{
	//Declare 
	private int sum1, sum2 = 0;
	//Declaring Panels
	private JPanel bigpan = null;
	private JPanel northpan = null;
	private JPanel centerpan = null;
	//Declaring TextFields (Roman)
	private JTextField R1 = null;
	private JTextField R2 = null;
	private JTextField R3 = null;
	//Declaring TextFiels (Interger)
	private JTextField I1 = null;
	private JTextField I2 = null;
	private JTextField I3 = null;
	//Declaring Buttons
	private JButton btn1 = null;
	private JButton btn2 = null;
	private JButton btn3 = null;
	private JButton btn4 = null;
	private JButton btn5 = null;
	private JButton btn6 = null;
	private JButton btn7 = null;
	private JButton btn8 = null;
	//Declaring Arithmetic operations
	private JButton sub = null;
	private JButton add = null;
	private JButton divide = null;
	private JButton percent = null;
	private JButton powerof = null;
	private JButton equals = null;
	boolean plusButtonPressed = false;
	//Constructor to create the Calculator
	public RomanCalculator() {
		//calls a contructor of JFrame, whic sets the title 
		super("Calculator");
		//when 'X' is pressed it exits the program 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//sets the Frame size
		this.setSize(100, 350);
		bigpan = new JPanel(); //creating big panel
		northpan = new JPanel(); //creating north panel
		//setting the layout of north panel to grid (3 rows and 2 columns)
		northpan.setLayout(new GridLayout(3, 2)); 
		//sets the layout of bigpan
		bigpan.setLayout(new BorderLayout());
		//sets the length of the text field (Roman1, Roman2, & Result)
		R1 = new JTextField(10);
		R2 = new JTextField(10);
		R3 = new JTextField(10);
		//sets the length of the text field (Interger1, Integer2, Integer3)
		I1 = new JTextField(10);
		I2 = new JTextField(10);
		I3 = new JTextField(10);
		//setting the text of textfield
		R1.setText("Roman1");
		R2.setText("Roman2");
		R3.setText("Result");
		
		I1.setText("Integer1");
		I1.setBackground(Color.WHITE); //setting the background of text field to white
		I2.setText("Integer2");
		I2.setBackground(Color.WHITE);
		I3.setText("Integer3");
		I3.setBackground(Color.WHITE);
		
		//I1.setEditable(false);
		I2.setEditable(false);
		I3.setEditable(false);
		
		//adding the textfields to northpan (fills the row first)
		northpan.add(R1); 
		northpan.add(I1);
		
		northpan.add(R2);
		northpan.add(I2);
		
		northpan.add(R3);
		northpan.add(I3);
		
		//adding north panel into big panel. (North direction)
		bigpan.add(northpan, BorderLayout.NORTH);
		this.add(bigpan);
		//Creating center panel
		centerpan = new JPanel();
		//setting the layout of centerpanel in to grid (3 rows, 4 columns)
		centerpan.setLayout(new GridLayout(3, 4));
	
		//Creating Buttons
		btn1 = new JButton("I");
		btn2 = new JButton("V");
		btn3 = new JButton("X");
		btn4 = new JButton("L");
		btn5 = new JButton("C");
		btn6 = new JButton("D");
		btn7 = new JButton("M");
		btn8 = new JButton("CE");
		//Creating Arithmetic buttons 
		sub = new JButton("-");
		add = new JButton("+");
		divide = new JButton("/");
		percent = new JButton("%");
		powerof = new JButton("^");
		equals = new JButton("=");
		//adding the buttons to center panel
		centerpan.add(btn1);
		btn1.addActionListener(this); //listens to the button when clicked
		centerpan.add(btn2);
		btn2.addActionListener(this);
		centerpan.add(btn3);
		btn3.addActionListener(this);
		centerpan.add(btn4);
		btn4.addActionListener(this);
		centerpan.add(btn5);
		btn5.addActionListener(this);
		centerpan.add(btn6);
		btn6.addActionListener(this);
		centerpan.add(btn7);
		btn7.addActionListener(this);
		centerpan.add(btn8);
		btn8.addActionListener(this);
		centerpan.add(sub);
		sub.addActionListener(this);
		centerpan.add(add);
		add.addActionListener(this); //adds two sums when clicked 
		centerpan.add(divide);
		divide.addActionListener(this);
		centerpan.add(percent);
		percent.addActionListener(this);
		centerpan.add(powerof);
		powerof.addActionListener(this);
		centerpan.add(equals);
		equals.addActionListener(this);
		
		bigpan.add(centerpan);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//If it contains Roman or Result it will send the text to nothing
		if(R1.getText().contains("Roman") && R2.getText().contains("Roman") && R3.getText().contains("Result")) {
			R1.setText(""); //Emptys the text
			R2.setText("");
			R3.setText("");
		}
		//if it countains integer it will set the text to nothing
		if(I1.getText().contains("Integer") && I2.getText().contains("Integer") && I3.getText().contains("Integer")) {
			I1.setText(""); 
			I2.setText("");
			I3.setText("");
		}
		
			//when CE is pressed on the calc it will clear the calculator
			if(e.getActionCommand().equals("CE")) { //NON NUMBER BUTTONS
				clearCalculator();
		
			} 
			//when a plus button is clicked, and it was not clicked before
			else if(e.getActionCommand().equals("+") && !plusButtonPressed) {
				//convert roman to int
				int result = Roman.convert_Roman_To_Int(R1.getText());
				//put result of that to I1 textfield
				I1.setText(String.valueOf(result));
				plusButtonPressed = true;
			} 
			//when the equal button is clicked
			else if(e.getActionCommand().equals("="))
			{
				// Initializes the sum to 0
				int sum = 0;
				
				//R2 converted to integer and then placed into I2
				int i2 = Roman.convert_Roman_To_Int(R2.getText());
				I2.setText(String.valueOf(i2));
				
				//turns a string to an integer and stores it into variable
				int num1 = Integer.parseInt(I1.getText()); //I1
				int num2 = Integer.parseInt(I2.getText()); //I2
				
				//sums the two int numbers 
				sum = num1 + num2;
				//getting the result in Roman from int
				String romanResult = Roman.convert_Int_to_Roman(sum); 
				//setting the result 
				R3.setText(romanResult);
				I3.setText(String.valueOf(sum));
			} else if(plusButtonPressed) { //when plus button is pressed
				//checks for error
				errorCheck(e, R2);
				//writes the error
				R2.setText(R2.getText() + e.getActionCommand());
			} else {
				//checks for error
				errorCheck(e, R1);
				//writes the error
				R1.setText(R1.getText() + e.getActionCommand());
			}
	}
	public void clearCalculator() {
		//Clears all TextFields
		R1.setText("");
		R2.setText("");
		R3.setText("");
		
		I1.setText("");
		I2.setText("");
		I3.setText("");
		this.plusButtonPressed = false;
		this.sum1 = 0;
		this.sum2 = 0;
	}
	//checks for errors
	public void errorCheck(ActionEvent e, JTextField textField ) {
		if((!textField.getText().equals(""))) {
			//gets text from fields
			String text = textField.getText();
			String previous = String.valueOf(text.charAt(text.length() - 1));
			String current = e.getActionCommand();
			//when previous character is less than the current one pressed, then error
			if((Roman.convert_Roman_To_Int(previous) < Roman.convert_Roman_To_Int(current))) {
				R3.setText("Error!");
			} else {
				R3.setText("");
			}
			
		}
		
	}

}
