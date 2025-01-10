package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	// Tipos de boton
	private enum ButtonType {
		REGULAR, OPERATOR
	}

	// Almacenar temporalmente ciertos valores
	private int num1, num2, result;
	private char operation;

	/*
	 * Engine(): La constructora debe instanciar, entre otras cosas, los atributos
	 * que se han mencionado anteriormente. Si añades funcionalidad adicional (ya
	 * sean acciones o simplemente algunos elementos de diseño), también debería ser
	 * instanciado en la constructora. Al final de la constructora debe aparecer una
	 * llamada a setSettings() y addActionEvent().
	 */
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

	/*
	 * setSettings(): Este método establece la configuración principal de todos los
	 * componentes visuales de la ventana. Concretamente, se encarga de, entre otras
	 * cosas: poner los layouts de los paneles y añadirlos, añadir los botones y
	 * llamar al método setFeaturesButton(), el display, establecer las
	 * características de los botones, tamaño de la ventana, localización, etc.
	 */
	public void setSettings() {
		// Configuración del marco de la ventana
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocation(50, 100);
		this.frame.setSize(300, 400);
		this.frame.setLayout(new BorderLayout());

		// Configuración del panel general
		this.contentPanel.setLayout(new BorderLayout());
		this.frame.setContentPane(this.contentPanel);

		// Configuración del panel del display (Norte)
		this.displayPanel.setLayout(new BorderLayout());
		this.display.setHorizontalAlignment(JTextField.RIGHT);
		this.display.setEditable(false);
		this.display.setFont(new Font("Arial", Font.BOLD, 40));
		this.displayPanel.add(this.display, BorderLayout.CENTER);
		this.contentPanel.add(this.displayPanel, BorderLayout.NORTH);

		// Configuración del panel de botones (Sur)
		this.buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
		this.contentPanel.add(this.buttonPanel, BorderLayout.CENTER);

		// Creación y adición de los botones
		JButton[] buttons = { this.n7, this.n8, this.n9, this.multiply, this.n4, this.n5, this.n6, this.subtract,
				this.n1, this.n2, this.n3, this.add, this.reset, this.n0, this.equal, this.divide };

		JButton[] opeButt = { this.multiply, this.reset, this.subtract, this.divide, this.equal, this.add };

		JButton[] numButt = { this.n1, this.n2, this.n3, this.n4, this.n5, this.n6, this.n7, this.n8, this.n9,
				this.n0 };

		for (JButton butt : opeButt) {
			setFeaturesButton(butt, ButtonType.OPERATOR);
		}
		for (JButton butt : numButt) {
			setFeaturesButton(butt, ButtonType.REGULAR);
		}

		for (JButton button : buttons) {
			button.setFont(new Font("Arial", Font.BOLD, 20));
			this.buttonPanel.add(button);
		}

		// Configuración de visibilidad
		this.frame.setVisible(true);
	}

	/*
	 * setFeaturesButton(JButton _button, ButtonType _type): Contiene una condición
	 * que permite distinguir si el tipo de botón pasa como parámetro es de tipo
	 * REGULAR u OPERATOR. En función de esto, pintará el botón de un color u otro.
	 * Puedes añadirle (y es algo que se tendrá en cuenta) más características tales
	 * como cambio del tipo de letra, bordes, etc.
	 * 
	 * • _button identifica el botón sobre el que se van a cambiar las carac-
	 * terísticas.
	 * 
	 * • _type identifica de qué tipo es el botón sobre el que se van a cambiar las
	 * características.
	 */
	public void setFeaturesButton(JButton _button, ButtonType _type) {
		if (_type == ButtonType.OPERATOR) {
			_button.setBackground(Color.CYAN);
		} else if (_type == ButtonType.REGULAR) {
			_button.setBackground(Color.MAGENTA);
		}
	}

	/*
	 * addActionEvent(): Este método registra los ActionListener para to- dos los
	 * botones de la aplicación. Es decir, para cada botón, añade un
	 * 
	 * ActionListener que recibe como parámetro el objeto this para poder
	 * identificar el objeto (botón) que se pulsa.
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

	}

	/*
	 * operation(): Comprueba qué operación se debe realizar. En otras palabras:
	 * mira el estado actual del atributo this.operation y, en función de ese valor,
	 * lleva a cabo una operación u otra (con los atributos this.num1 y this.num2,
	 * que representan los dos únicos operando que maneja nuestra calculadora),
	 * modificando el tributo this.result y actualizando el texto en el display.
	 */
	public void operation() {
		switch (this.operation) {
		case '+':
			this.result = this.num1 + this.num2;
			break;
		case '-':
			this.result = this.num1 - this.num2;
			break;
		case 'x':
			this.result = this.num1 * this.num2;
			break;
		case '÷':
			this.result = this.num1 / this.num2;
			break;
		}
	}

	/*
	 * actionPerformed(ActionEvent e): Este método se encarga de obtener la
	 * información que haya en el display (números introducidos y operación que se
	 * debe realizar) y llamar al método operation() para ejecutar dicha operación.
	 * Hay muchas formas de llevar a cabo esta lógica... Piensa cuál podría ser la
	 * mejor manera de hacerlo. Por ejemplo, una manera podría ser identificar el
	 * botón que se ha pulsado y añadir su texto al display y, cuando se pulse sobre
	 * el botón =, entonces hacemos que se ejecute la operación que se haya indicado
	 * con los botones de operación (sumar, restar, multiplicar o dividir). En
	 * cualquier caso e independientemente de la decisión que se tome, lo primero
	 * que debemos hacer en este método es recoger el tipo de botón que se ha
	 * pulsado (para poder hacer la distinción) y el texto asociado a ese botón.
	 */
	public void actionPerformed(ActionEvent e) {
	    Object source = e.getSource(); // Identificar el botón presionado
	    String input_text = e.getActionCommand(); // Obtener el texto del botón

	    // Obtener el texto actual del display
	    String currentText = display.getText();

	    // Si es un botón numérico, agregarlo directamente
	    if (source == n0 || source == n1 || source == n2 || source == n3 || source == n4 ||
	        source == n5 || source == n6 || source == n7 || source == n8 || source == n9) {
	        display.setText(currentText + input_text); // Concatenar número
	    } 
	    // Si es el signo "-", tratarlo según el contexto
	    else if (input_text.equals("-")) {
	        // Permitir "-" como operador de resta si no es el primer carácter
	        if (!currentText.isEmpty() && !currentText.matches(".*[+x÷-]\\s?$")) {
	            display.setText(currentText + " " + input_text + " "); // Agregar operador de resta
	        } 
	        // Permitir "-" como signo negativo al inicio o después de un operador
	        else if (currentText.isEmpty() || currentText.matches(".*[+x÷]\\s?$")) {
	            display.setText(currentText + input_text); // Concatenar signo negativo
	        }
	    } 
	    // Si es un operador (distinto de "-"), agregarlo con validación
	    else if (source == add || source == multiply || source == divide) {
	        // Validar que el texto actual no termine con un operador
	        if (!currentText.isEmpty() && !currentText.matches(".*[+x÷-]\\s?$")) {
	            display.setText(currentText + " " + input_text + " "); // Agregar el operador
	        }
	    } 
	    // Si es el botón igual, calcular el resultado
	    else if (source == equal) {
	        try {
	            // Evaluar la expresión
	            String input = display.getText();
	            if (!input.matches("-?\\d+(\\s[+\\-x÷]\\s-?\\d+)+")) {
	                display.setText("Error"); // Validar que la entrada sea correcta
	                return;
	            }

	            String[] parts = input.split("\\s"); // Dividir por espacios
	            num1 = Integer.parseInt(parts[0]); // Primer número
	            for (int i = 1; i < parts.length; i += 2) {
	                operation = parts[i].charAt(0); // Operador
	                num2 = Integer.parseInt(parts[i + 1]); // Segundo número
	                operation(); // Ejecutar operación
	                num1 = result; // Actualizar num1 para operaciones encadenadas
	            }
	            display.setText(String.valueOf(result)); // Mostrar el resultado
	        } catch (Exception ex) {
	            display.setText("Error"); // Mostrar error si algo falla
	        }
	    } 
	    // Si es el botón reset, limpiar todo
	    else if (source == reset) {
	        num1 = 0;
	        num2 = 0;
	        result = 0;
	        operation = '\0';
	        display.setText(""); // Limpiar el display
	    }
	}
}
