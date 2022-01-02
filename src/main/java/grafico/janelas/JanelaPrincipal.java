package main.java.grafico.janelas;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame{
	private final int WIDTH = 480;
	private final int HEIGHT = 420;
	
	public JanelaPrincipal() {
		super("YuGi - Calculator");
		final MenuInicial inicio = new MenuInicial();
		setSize(WIDTH, HEIGHT);
		getContentPane().add(inicio);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
