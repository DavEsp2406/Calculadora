package main;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicButtonUI;

public class VentanaEmergente extends JDialog {
    public VentanaEmergente(JFrame parent, String mensaje) {
        super(parent, "Ventana de información", true);
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Mensaje principal
        JLabel label = new JLabel(mensaje);
        label.setFont(new Font("Arial", Font.PLAIN, 14));

        // Panel principal
        JPanel panel = new JPanel();
        panel.add(label);

        // Agregar un botón solo si es el botón info
        if (mensaje == "Info sobre la calculadora") {
            JButton botonExtra = new JButton("Github");
            botonExtra.addActionListener(e -> {
                try {
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.BROWSE)) {
                        desktop.browse(new URI("https://github.com/DavEsp2406/Calculadora"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace(); // Para depurar si ocurre algún error
                }
            });
            panel.add(botonExtra);
        }

        add(panel);
        setLocationRelativeTo(parent);
    }
}
