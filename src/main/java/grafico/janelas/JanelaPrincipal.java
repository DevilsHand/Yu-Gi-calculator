package main.java.grafico.janelas;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.java.calculator.jogo.Jogador;

public class JanelaPrincipal extends JFrame{
	private JPanel painelAtivo;
	
	public JanelaPrincipal() {
		super("YuGi - Calculator");
		setSize(new Dimension(300, 480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void menuInicial() {
		painelAtivo = new MenuInicial();
		getContentPane().add(painelAtivo);
		update(getGraphics());
	}
	private void limparMenu() {
		getContentPane().remove(painelAtivo);
	}
	public void doisJogadores() {
		limparMenu();
		painelAtivo = new FrameJogador(new Jogador("Gabriel"));
		add(painelAtivo);
		revalidate();
		update(getGraphics());
	}
	public void quatroJogadores() {
		limparMenu();
	}
	public void tagDuel() {
		limparMenu();	
	}
	public void ajuda() {
		limparMenu();
		
	}
}
