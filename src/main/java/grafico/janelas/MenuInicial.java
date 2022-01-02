package main.java.grafico.janelas;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuInicial extends JPanel { 
	public MenuInicial() {
		final JLabel titulo = new JLabel("Bem vindo ao\nYuGi Calculator!");
		final JButton oneVone = new JButton("1 Vs 1");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(titulo);
		add(oneVone);		
	}
}

