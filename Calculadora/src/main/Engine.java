package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;

public class Engine extends JFrame implements ActionListener {

	// Marco de la ventana
	private JFrame frame;
	// Panel general que ocupa toda la ventana
	private JPanel contentPanel;
	// Panel norte que contiene el display
	private JPanel displayPanel;
	// Panel sur que contiene los botones
	private JPanel buttonPanel;
	// Display
	private JTextField display;
	// Botones
	private JButton n0;
	private JButton n1;
	private JButton n2;
	private JButton n3;
	private JButton n4;
	private JButton n5;
	private JButton n6;
	private JButton n7;
	private JButton n8;
	private JButton n9;
	private JButton divide;
	private JButton multiply;
	private JButton subtract;
	private JButton add;
	private JButton equal;
	private JButton reset;

	// Tipos de boton
	private enum ButtonType {
		REGULAR, OPERATOR, EQUAL
	}

	// Almacenar temporalmente ciertos valores
	private int num1, num2, result;
	private char operation;

	public Engine(String msg) {
		super(msg);

		this.frame = new JFrame();
		this.contentPanel = new JPanel();
		this.displayPanel = new JPanel();
		this.buttonPanel = new JPanel();
		this.display = new JTextField();
		this.n0 = new JButton("0");
		this.n1 = new JButton("1");
		this.n2 = new JButton("2");
		this.n3 = new JButton("3");
		this.n4 = new JButton("4");
		this.n5 = new JButton("5");
		this.n6 = new JButton("6");
		this.n7 = new JButton("7");
		this.n8 = new JButton("8");
		this.n9 = new JButton("9");
		this.divide = new JButton("÷");
		this.multiply = new JButton("x");
		this.subtract = new JButton("-");
		this.add = new JButton("+");
		this.equal = new JButton("=");
		this.reset = new JButton("C");

		setSettings();
		addActionEvent(null);
	}

	public void setSettings() {
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocation(50, 100);
		this.frame.setSize(300, 400);
		this.frame.setLayout(new BorderLayout());

		this.contentPanel.setLayout(new BorderLayout());
		this.contentPanel.setBackground(Color.lightGray); // Color de fondo visible como marco
		this.contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espacio visible en el borde
		this.frame.setContentPane(this.contentPanel);

		this.displayPanel.setLayout(new BorderLayout());
		this.display.setHorizontalAlignment(JTextField.RIGHT);
		this.display.setEditable(false);
		this.display.setFont(new Font("SansSerif", Font.PLAIN, 40));
		this.display.setBackground(Color.LIGHT_GRAY);
		this.displayPanel.add(this.display, BorderLayout.CENTER);

		JPanel displayContainer = new JPanel(new BorderLayout());
		displayContainer.add(this.displayPanel, BorderLayout.CENTER);
		displayContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		displayContainer.setBackground(Color.WHITE);
		this.contentPanel.add(displayContainer, BorderLayout.NORTH);

		this.buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
		this.buttonPanel.setBackground(Color.WHITE); // Fondo del panel de botones

		JPanel buttonContainer = new JPanel(new BorderLayout());
		buttonContainer.add(this.buttonPanel, BorderLayout.CENTER);
		buttonContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.contentPanel.add(buttonContainer, BorderLayout.CENTER);

		JButton[] buttons = { this.n7, this.n8, this.n9, this.multiply, this.n4, this.n5, this.n6, this.subtract,
				this.n1, this.n2, this.n3, this.add, this.reset, this.n0, this.equal, this.divide };

		JButton[] opeButt = { this.multiply, this.reset, this.subtract, this.divide, this.add };

		JButton[] numButt = { this.n1, this.n2, this.n3, this.n4, this.n5, this.n6, this.n7, this.n8, this.n9,
				this.n0 };

		for (JButton butt : opeButt) {
			setFeaturesButton(butt, ButtonType.OPERATOR);
		}
		for (JButton butt : numButt) {
			setFeaturesButton(butt, ButtonType.REGULAR);
		}
		
		setFeaturesButton(this.equal, ButtonType.EQUAL);

		for (JButton button : buttons) {
			this.buttonPanel.add(button);
		}

		this.frame.setVisible(true);
	}

	public void setFeaturesButton(JButton _button, ButtonType _type) {
		_button.setBorder(BorderFactory.createLineBorder(Color.white));
		
		if (_type == ButtonType.OPERATOR) {
			_button.setFont(new Font("SansSerif", Font.PLAIN, 25));
			_button.setBackground(new Color(159, 222, 253));
		} else if (_type == ButtonType.REGULAR) {
			_button.setFont(new Font("SansSerif", Font.PLAIN, 20));
			_button.setBackground(Color.CYAN);
		}else if (_type == ButtonType.EQUAL) {
			_button.setFont(new Font("SansSerif", Font.BOLD, 20));
			_button.setBackground(new Color(23,173,247));
		}
	}

	public void addActionEvent(Engine engine) {
		this.n0.addActionListener(this);
		this.n1.addActionListener(this);
		this.n2.addActionListener(this);
		this.n3.addActionListener(this);
		this.n4.addActionListener(this);
		this.n5.addActionListener(this);
		this.n6.addActionListener(this);
		this.n7.addActionListener(this);
		this.n8.addActionListener(this);
		this.n9.addActionListener(this);
		this.add.addActionListener(this);
		this.subtract.addActionListener(this);
		this.divide.addActionListener(this);
		this.multiply.addActionListener(this);
		this.equal.addActionListener(this);
		this.reset.addActionListener(this);

	}

	public void operation() {

		switch (this.operation) {
		case '+':
			this.result = this.num1 + this.num2;
			display.setText(String.valueOf(result));
			break;
		case '-':
			this.result = this.num1 - this.num2;
			display.setText(String.valueOf(result));
			break;
		case 'x':
			this.result = this.num1 * this.num2;
			display.setText(String.valueOf(result));
			break;
		case '÷':
			this.result = this.num1 / this.num2;
			display.setText(String.valueOf(result));
			break;
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String input_text = e.getActionCommand();

		String currentText = display.getText();

		if (source == n0 || source == n1 || source == n2 || source == n3 || source == n4 || source == n5 || source == n6
				|| source == n7 || source == n8 || source == n9) {
			display.setText(currentText + input_text);
		}
		else if (input_text.equals("-")) {
			if (!currentText.isEmpty() && !currentText.matches(".*[+x÷-]\\s?$")) {
				display.setText(currentText + " " + input_text + " ");
			}
			else if (currentText.isEmpty() || currentText.matches(".*[+x÷]\\s?$")) {
				display.setText(currentText + input_text); 
			}
		}
		else if (source == add || source == multiply || source == divide) {
			if (!currentText.isEmpty() && !currentText.matches(".*[+x÷-]\\s?$")) {
				display.setText(currentText + " " + input_text + " "); 
			}
		}
		else if (source == equal) {
			try {
				String input = display.getText();
				if (!input.matches("-?\\d+(\\s[+\\-x÷]\\s-?\\d+)+")) {
					display.setText("Error"); 
					return;
				}

				String[] parts = input.split("\\s"); 
				num1 = Integer.parseInt(parts[0]); 
				for (int i = 1; i < parts.length; i += 2) {
					operation = parts[i].charAt(0); 
					num2 = Integer.parseInt(parts[i + 1]); 
					operation(); 
					num1 = result; 
				}
			} catch (ArithmeticException zero) {
				result = 0;
				display.setText("Err div x 0");
			} catch (Exception ex) {
				display.setText("Error");
			}
		}
		else if (source == reset) {
			num1 = 0;
			num2 = 0;
			result = 0;
			operation = '\0';
			display.setText(""); 
		}
	}
}
