package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
	// Panel que contiene la marca y la base en la que estamos
	private JPanel subDisplay;
	// Subpanel de subDisplay izquierdo y derecho
	private JTextField basePanel;
	private JButton casioButton;

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
	private JButton hA;
	private JButton hB;
	private JButton hC;
	private JButton hD;
	private JButton hE;
	private JButton hF;
	private JButton b2;
	private JButton b8;
	private JButton b10;
	private JButton b16;
	private JButton info;
	private JButton owner;
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
		REGULAR, OPERATOR, EQUAL, BASE, HEXLET, CUSTOM
	}

	// Almacenar temporalmente ciertos valores
	private int result, baseActual;
	private String num1, num2, respuesta, base;
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
		this.subDisplay = new JPanel();
		this.basePanel = new JTextField("Elige una base");
		this.casioButton = new JButton("CASIO");
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
		this.hA = new JButton("A");
		this.hB = new JButton("B");
		this.hC = new JButton("C");
		this.hD = new JButton("D");
		this.hE = new JButton("E");
		this.hF = new JButton("F");
		this.b2 = new JButton("B2");
		this.b8 = new JButton("B8");
		this.b10 = new JButton("B10");
		this.b16 = new JButton("B16");
		this.info = new JButton("Info");
		this.owner = new JButton("Owner");
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
		this.frame.setSize(350, 500);
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

		this.subDisplay.setLayout(new BorderLayout());
		this.basePanel.setHorizontalAlignment(JTextField.CENTER);
		this.basePanel.setEditable(false);
		this.basePanel.setBackground(Color.white);
		this.basePanel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		this.basePanel.setBorder(BorderFactory.createEmptyBorder());
		this.subDisplay.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		this.subDisplay.add(this.basePanel, BorderLayout.CENTER);
		this.displayPanel.add(this.subDisplay, BorderLayout.NORTH);

		this.casioButton.setBackground(Color.magenta);
		this.casioButton.setBorderPainted(false);
		this.subDisplay.add(this.casioButton, BorderLayout.EAST);

		this.displayPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.displayPanel.setBackground(Color.WHITE);
		this.contentPanel.add(displayPanel, BorderLayout.NORTH);

		this.buttonPanel.setLayout(new GridLayout(8, 4, 5, 5));
		this.buttonPanel.setBackground(Color.WHITE);
		this.buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.contentPanel.add(buttonPanel, BorderLayout.CENTER);
		// Todos los botones de la calculadora
		JButton[] buttons = { this.b2, this.b8, this.b10, this.b16, this.hA, this.hB, this.hC, this.info, this.hD,
				this.hE, this.hF, this.owner, this.raiz, this.elevar, this.divide, this.retroceder, this.n7, this.n8,
				this.n9, this.multiply, this.n4, this.n5, this.n6, this.subtract, this.n1, this.n2, this.n3, this.add,
				this.reset, this.n0, this.equal, this.ans };
		// botones de operacion
		JButton[] opeButt = { this.multiply, this.reset, this.subtract, this.divide, this.add, this.ans, this.elevar,
				this.raiz, this.retroceder };
		// botones de numeros
		JButton[] numButt = { this.n1, this.n2, this.n3, this.n4, this.n5, this.n6, this.n7, this.n8, this.n9,
				this.n0 };
		// botones de las bases
		JButton[] bases = { this.b2, this.b8, this.b10, this.b16 };
		// botones de las letras para la base hexadecimal
		JButton[] letras = { this.hA, this.hB, this.hC, this.hD, this.hE, this.hF, };
		// botones custom como owner e info
		JButton[] custom = { this.owner, this.info };

		for (JButton butt : opeButt) {
			setFeaturesButton(butt, ButtonType.OPERATOR);
		}
		for (JButton butt : numButt) {
			setFeaturesButton(butt, ButtonType.REGULAR);
		}
		for (JButton butt : bases) {
			setFeaturesButton(butt, ButtonType.BASE);
		}
		for (JButton butt : letras) {
			setFeaturesButton(butt, ButtonType.HEXLET);
		}
		for (JButton butt : custom) {
			setFeaturesButton(butt, ButtonType.CUSTOM);
		}
		setFeaturesButton(this.equal, ButtonType.EQUAL);

		// se añaden todos los botones al buttonPanel
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

		switch (_type) {
		case ButtonType.OPERATOR:
			_button.setFont(new Font("SansSerif", Font.BOLD, 15));
			_button.setBackground(new Color(159, 222, 253));
			break;
		case ButtonType.REGULAR:
			_button.setFont(new Font("SansSerif", Font.PLAIN, 20));
			_button.setBackground(Color.CYAN);
			break;
		case ButtonType.BASE:
			_button.setFont(new Font("SansSerif", Font.PLAIN, 20));
			_button.setBackground(new Color(20, 82, 138));
			_button.setForeground(Color.WHITE);
			break;
		case ButtonType.HEXLET:
			_button.setFont(new Font("SansSerif", Font.PLAIN, 20));
			_button.setBackground(new Color(115, 250, 193));
			break;
		case ButtonType.CUSTOM:
			_button.setFont(new Font("SansSerif", Font.BOLD, 20));
			_button.setBackground(new Color(193, 115, 250));
			break;
		case ButtonType.EQUAL:
			_button.setFont(new Font("SansSerif", Font.BOLD, 20));
			_button.setBackground(new Color(23, 173, 247));
			break;
		default:
			break;

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
		this.casioButton.addActionListener(this);
		this.hA.addActionListener(this);
		this.hB.addActionListener(this);
		this.hC.addActionListener(this);
		this.hD.addActionListener(this);
		this.hE.addActionListener(this);
		this.hF.addActionListener(this);
		this.info.addActionListener(this);
		this.owner.addActionListener(this);
		this.b2.addActionListener(this);
		this.b8.addActionListener(this);
		this.b10.addActionListener(this);
		this.b16.addActionListener(this);

	}
	/**
	 * Metodo que cambia la base actual y actualiza el Panel de la calculadora
	 * @param base
	 */
	public void cambioBase(String base) {
		switch (base) {
		case "B2":
			baseActual = 2;
			this.basePanel.setText("Base: Binaria");
			break;
		case "B8":
			baseActual = 8;
			this.basePanel.setText("Base: Octal");
			break;
		case "B10":
			baseActual = 10;
			this.basePanel.setText("Base: Decimal");
			break;
		case "B16":
			baseActual = 16;
			this.basePanel.setText("Base: Hexadecimal");
			break;
		default:
			baseActual = 10;
			this.basePanel.setText("Base: Decimal");
		}
	}
	/**
	 * 
	 * @param input
	 * @param base
	 * @return numero convertido a decimal
	 */
	public int convertToDecimal(String input, int base) {
		return Integer.parseInt(input.toUpperCase(), base);
	}
	/**
	 * 
	 * @param number
	 * @param base 
	 * @return el numero convertido del decimal a la base indicada
	 */
	public String convertFromDecimal(int number, int base) {
		return Integer.toString(number, base).toUpperCase();
	}

	/**
	 * Metodo que realiza las operaciones
	 * @param num1
	 * @param num2
	 * @param operator
	 * @param base
	 */
	public void operation(String num1, String num2, char operator, int base) {
		int decimal1 = convertToDecimal(num1, base);
		int decimal2 = convertToDecimal(num2, base);
		int result = 0;

		switch (operator) {
		case '+':
			result = decimal1 + decimal2;
			break;
		case '-':
			result = decimal1 - decimal2;
			break;
		case 'x':
			result = decimal1 * decimal2;
			break;
		case '÷':
			if (decimal2 != 0) {
				result = decimal1 / decimal2;
			} else {
				display.setText("Err div x 0");
				return;
			}
			break;
		case '^':
			result = (int) Math.pow(decimal1, decimal2);
			break;
		case '√':
			if (decimal1 >= 0) {
				result = (int) Math.sqrt(decimal1);
			} else {
				display.setText("Err raíz negativa");
				return;
			}
			break;
		default:
			display.setText("Operación inválida");
			return;
		}
		display.setText(convertFromDecimal(result, base));
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
			if (source == this.b2) {
				cambioBase("B2");
			} else if (source == this.b8) {
				cambioBase("B8");
			} else if (source == this.b10) {
				cambioBase("B10");
			} else if (source == this.b16) {
				cambioBase("B16");
			} else if (source == this.add || source == this.subtract || source == this.divide || source == this.multiply
					|| source == this.elevar) {
				if (source == this.subtract) {
					if (display.getText().isEmpty()
							|| "+x√÷^ ".contains(display.getText().substring(display.getText().length() - 1))) {
						display.setText(display.getText() + "-");
					} else {
						display.setText(display.getText() + " - ");
					}
				} else {
					display.setText(display.getText() + " " + input_text + " ");
				}
			} else if (source == this.owner || source == this.info) {
				String mensaje;
				if (source == this.owner) {
					mensaje = "Calculadora desarrollada por David"; 
					new VentanaEmergente(this, mensaje).setVisible(true);
				}else if (source == this.info) {
					mensaje = "Info sobre la calculadora"; 
					new VentanaEmergente(this, mensaje).setVisible(true);
				}
			}else if(source == this.casioButton) {
                try {
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.BROWSE)) {
                        desktop.browse(new URI("https://www.casio.com/es/scientific-calculators/"));
                    }
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
			}
			else if (source == this.reset) {
				respuesta = display.getText();
				num1 = "0";
				num2 = "0";
				result = 0;
				operation = '\0';
				display.setText("");
			} else if (source == this.retroceder) {
				int cadena = display.getText().length();
				if (cadena > 0) {
					String borrar = display.getText().substring(0, cadena - 1);
					display.setText(borrar);
				}
			} else if (source == this.equal || source == this.raiz) {
				String input = display.getText().trim();
				String[] cadPartida = input.split("(?<=\\d)\\s*(?=[+x÷^√-])|(?<=[+x÷^√-])\\s+");

				if (cadPartida.length >= 3) {
					num1 = cadPartida[0];
					operation = cadPartida[1].charAt(0);
					num2 = cadPartida[2];
					operation(num1, num2, operation, baseActual);
				} else if (cadPartida.length == 1 && source == this.raiz) {
					num1 = cadPartida[0];
					operation = '√';
					operation(num1, "0", operation, baseActual);
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
