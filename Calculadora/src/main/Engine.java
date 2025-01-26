package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private JButton ans;
	private JButton raiz;
	private JButton elevar;
	private JButton retroceder;

	// Tipos de boton
	private enum ButtonType {
		REGULAR, OPERATOR, EQUAL
	}

	// Almacenar temporalmente ciertos valores
	private int num1, num2, result;
	private String respuesta;
	private char operation;

	/**
	 * Constructora de la calculadora
	 * 
	 * @param msg
	 */
	public Engine() {
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
		this.ans = new JButton("Ans");
		this.retroceder = new JButton("⌫");
		this.raiz = new JButton("√");
		this.elevar = new JButton("^");

		setSettings();
		addActionEvent(null);
	}

	/**
	 * Este metodo establece la configuracion principal de todos los componentes
	 * visuales de la ventana.
	 */
	public void setSettings() {
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocation(50, 100);
		this.frame.setSize(300, 400);
		this.frame.setLayout(new BorderLayout());

		this.contentPanel.setLayout(new BorderLayout());
		this.contentPanel.setBackground(Color.lightGray);
		this.contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.frame.setContentPane(this.contentPanel);

		this.displayPanel.setLayout(new BorderLayout());
		this.display.setHorizontalAlignment(JTextField.RIGHT);
		this.display.setEditable(false);
		this.display.setFont(new Font("SansSerif", Font.PLAIN, 40));
		this.display.setBackground(Color.LIGHT_GRAY);
		this.displayPanel.add(this.display, BorderLayout.CENTER);

		this.displayPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.displayPanel.setBackground(Color.WHITE);
		this.contentPanel.add(displayPanel, BorderLayout.NORTH);

		this.buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
		this.buttonPanel.setBackground(Color.WHITE);
		this.buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.contentPanel.add(buttonPanel, BorderLayout.CENTER);

		JButton[] buttons = { this.raiz, this.elevar, this.divide, this.retroceder, this.n7, this.n8, this.n9,
				this.multiply, this.n4, this.n5, this.n6, this.subtract, this.n1, this.n2, this.n3, this.add,
				this.reset, this.n0, this.equal, this.ans };

		JButton[] opeButt = { this.multiply, this.reset, this.subtract, this.divide, this.add, this.ans, this.elevar,
				this.raiz, this.retroceder, };

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

	/**
	 * Metodo que recibe un boton y dependiendo del tipo que sea cambia su aspecto
	 * 
	 * @param _button boton que recibe
	 * @param _type   el tipo del boton que recibe
	 */
	public void setFeaturesButton(JButton _button, ButtonType _type) {
		_button.setBorder(BorderFactory.createLineBorder(Color.white));

		if (_type == ButtonType.OPERATOR) {
			_button.setFont(new Font("SansSerif", Font.BOLD, 15));
			_button.setBackground(new Color(159, 222, 253));
		} else if (_type == ButtonType.REGULAR) {
			_button.setFont(new Font("SansSerif", Font.PLAIN, 20));
			_button.setBackground(Color.CYAN);
		} else if (_type == ButtonType.EQUAL) {
			_button.setFont(new Font("SansSerif", Font.BOLD, 20));
			_button.setBackground(new Color(23, 173, 247));
		}
	}

	/**
	 * Este metodo registra los ActionListener para todos los botones de la
	 * aplicacion.
	 * 
	 * @param engine
	 */
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
		this.raiz.addActionListener(this);
		this.elevar.addActionListener(this);
		this.retroceder.addActionListener(this);
		this.ans.addActionListener(this);

	}

	/**
	 * Metodo que comprueba que operacion se tiene que realizar
	 */
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
		case '√':
			this.result = (int) Math.sqrt(num1);
			display.setText(String.valueOf(result));
			break;
		case '^':
			this.result = (int) Math.pow(num1, num2);
			display.setText(String.valueOf(result));
			break;
		}

	}

	/**
	 * Este metodo se encarga de obtener la informacion que haya en el display
	 * (numeros introducidos y operacion que se debe realizar) y llamar al metodo
	 * operation() para ejecutar dicha operacion.
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String input_text = e.getActionCommand();

		try {
			if (source == this.add || source == this.subtract || source == this.divide || source == this.multiply
					|| source == this.elevar) {
				if (source == this.subtract) {
					if (display.getText().isEmpty()
							|| "+x√÷^ ".contains(display.getText().substring(display.getText().length() - 1))) {
						display.setText(display.getText() + "-");
					}else {
						display.setText(display.getText() + " - ");
					}
				} else {
					display.setText(display.getText() + " " + input_text + " ");
				}
			} else if (source == reset) {
				respuesta = display.getText();
				num1 = 0;
				num2 = 0;
				result = 0;
				operation = '\0';
				display.setText("");
			}else if(source == this.ans) {
				display.setText(respuesta);
			}else if (source == this.retroceder) {
				int cadena = display.getText().length();
				String borrar = display.getText().substring(0, cadena - 1);
				display.setText(borrar);
			} else if (source == this.equal || source == this.raiz) {
				String input = display.getText();
				String[] cadPartida = input.split("(?<=\\d)\\s+(?=[+x÷^√-])|(?<=[+x÷^√-])\\s+");				if (cadPartida.length >= 3) {
			        num1 = Integer.parseInt(cadPartida[0]);
			        num2 = Integer.parseInt(cadPartida[2]);
			        operation = cadPartida[1].charAt(0);
			        operation();
			    } else if (cadPartida.length == 2 && source == this.raiz) {
			        num1 = Integer.parseInt(cadPartida[0]);
			        operation = '√';
			        operation();
			    } else {
			        display.setText("Error de formato");
			    }

			} else {
				display.setText(display.getText() + input_text);
			}

		} catch (ArithmeticException zero) {
			result = 0;
			display.setText("Err div x 0");
		} catch (Exception ex) {
			display.setText("Error");
		}
	}
}
