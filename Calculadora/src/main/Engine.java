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
        JButton[] buttons = {
            this.n7, this.n8, this.n9, this.multiply,
            this.n4, this.n5, this.n6, this.subtract,
            this.n1, this.n2, this.n3, this.add,
            this.reset, this.n0, this.equal, this.divide
        };
        
        JButton[] opeButt = {
        	this.multiply, this.reset, this.subtract, 
        	this.divide, this.equal, this.add
        };
        
        JButton[] numButt = {
        	this.n1, this.n2, this.n3, 
        	this.n4, this.n5, this.n6, 
        	this.n7, this.n8, this.n9, 
        	this.n0
        };
        
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
	
	public void setFeaturesButton(JButton _button, ButtonType _type) {
		if(_type == ButtonType.OPERATOR) {
			_button.setBackground(Color.CYAN);
		}else if(_type == ButtonType.REGULAR) {
			_button.setBackground(Color.MAGENTA);
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
	}
	
	public void operation() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
