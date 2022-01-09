package main.java.grafico.janelas;

import java.awt.Dimension;

import javax.swing.JTextField;

public class EntradaValor extends JTextField {
	private static final String REGEX = "[0-9]+";

	public EntradaValor() {
		setPreferredSize(new Dimension(100, 20));
	}

	public boolean checarValidade() {
		if (this.getText().matches(REGEX)) {
			return true;
		} else if (this.getText().equals("")) {
			setText("0");
			return true;
		} else {
			return false;
		}
	}
}
