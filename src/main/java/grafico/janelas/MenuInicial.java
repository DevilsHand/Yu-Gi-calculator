package main.java.grafico.janelas;

import static main.java.calculator.main.CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuInicial extends JPanel implements ActionListener { 
	private final JPanel boxTitulo = new JPanel();
	private final JPanel boxMenu = new JPanel();
	private final JPanel boxRodape = new JPanel();
	private final JLabel titulo = new JLabel("Bem vindo ao  	YuGi Calculator!");
	private final JButton oneVone = new JButton("1 Vs 1");
	private final JButton twoVtwo = new JButton("2 Vs 2");
	private final JButton tag = new JButton("Tag Duel");
	private final JButton btnAjuda = new JButton("Ajuda");
	private final JLabel txtAjuda = new JLabel("Esse texto é um placeholder para a ajuda ;P");

	public MenuInicial() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		oneVone.setActionCommand("DoisJogadores");
		twoVtwo.setActionCommand("QuatroJogadores");
		oneVone.addActionListener(this);
		twoVtwo.addActionListener(this);
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		oneVone.setAlignmentX(LEFT_ALIGNMENT);
		twoVtwo.setAlignmentX(LEFT_ALIGNMENT);
		boxTitulo.add(titulo);
		boxMenu.add(oneVone);
		boxMenu.add(twoVtwo);
		boxMenu.add(btnAjuda);
		add(boxTitulo);	
		add(boxMenu);
	}
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "DoisJogadores":
			CONTROLADOR.doisJogadores();
			break;
		case "QuatroJogadores":
			CONTROLADOR.quatroJogadores();
			break;
		case "Ajuda":
			CONTROLADOR.ajuda();
			break;
		default:
			System.out.println("Erro");
		}		
	}
}

