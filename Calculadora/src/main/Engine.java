package main;

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
		this.setLocation(50,100);
		this.setSize(300,400);
		this.setVisible(true);
		this.frame = new JFrame();
		JPanel contentPanel = new JPanel();
		JPanel displayPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JTextField display = new JTextField();
		JButton n0 = new JButton();
		JButton n1 = new JButton();
		JButton n2 = new JButton();
		JButton n3 = new JButton();
		JButton n4 = new JButton();
		JButton n5 = new JButton();
		JButton n6 = new JButton();
		JButton n7 = new JButton();
		JButton n8 = new JButton();
		JButton n9 = new JButton();
		JButton divide = new JButton();
		JButton multiply = new JButton();
		JButton subtract = new JButton();
		JButton add = new JButton();
		JButton equal = new JButton();
		JButton reset = new JButton();
		
	}
	
	public void setSettings() {
		
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
