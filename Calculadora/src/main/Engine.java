package main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Engine extends JFrame {

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
		this.n0 = new JButton();
		this.n1 = new JButton();
		this.n2 = new JButton();
		this.n3 = new JButton();
		this.n4 = new JButton();
		this.n5 = new JButton();
		this.n6 = new JButton();
		this.n7 = new JButton();
		this.n8 = new JButton();
		this.n9 = new JButton();
		this.divide = new JButton();
		this.multiply = new JButton();
		this.subtract = new JButton();
		this.add = new JButton();
		this.equal = new JButton();
		this.reset = new JButton();
		setSettings();
		addActionEvent();
	}
	
	public void setSettings() {
	    // Configuración del marco de la ventana
	    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.frame.setLocation(50, 100);
	    this.frame.setSize(300, 400);
	    this.frame.setLayout(new BorderLayout());

	    // Configuración del panel 
	    this.contentPanel.setLayout(new BorderLayout());
	    this.frame.setContentPane(this.contentPanel);

	    // Configuración de visibilidad
	    this.frame.setVisible(true);
	}
	
	public void setFeaturesButton(JButton _button, ButtonType _type) {
		
	}
	
	public void addActionEvent() {
		
	}
	
	public void operation() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
