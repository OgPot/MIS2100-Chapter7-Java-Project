package Gherardi.Joseph.Chapter7.Java.Project;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frame;
	private JTextField fieldDenominator;
	private JTextField fieldNumerator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		fieldDenominator = new JTextField();
		fieldDenominator.setBounds(190, 80, 86, 20);
		frame.getContentPane().add(fieldDenominator);
		fieldDenominator.setColumns(10);
		
		fieldNumerator = new JTextField();
		fieldNumerator.setBounds(190, 38, 86, 20);
		frame.getContentPane().add(fieldNumerator);
		fieldNumerator.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numerator");
		lblNewLabel.setBounds(108, 42, 64, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Denominator");
		lblNewLabel_1.setBounds(104, 83, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.setBounds(189, 114, 89, 23);
		frame.getContentPane().add(calculateButton);
		
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setBounds(138, 147, 187, 14);
		frame.getContentPane().add(resultLabel);
		
		
		calculateButton.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseClicked(MouseEvent e) {
				double numerator = Double.parseDouble(fieldNumerator.getText());
				double denominator = Double.parseDouble(fieldDenominator.getText());
				SimpleMath mathObject = new SimpleMath();
				
				try {
					Double result = mathObject.divide(numerator, denominator);
					 resultLabel.setText(result.toString());
					 
					
				} catch(ArithmeticException ee) {
					resultLabel.setText("Cannot divide by zero.");
				}
			}
			
			
		});
		
	}
}
