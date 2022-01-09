package main.java.grafico.janelas;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.java.calculator.jogo.Jogador;

public class JanelaPrincipal extends JFrame{
	private static final JTextField ENTRADA_VALOR = new JTextField();
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
		//cria os jogadores
		JPanel jogadorUm = new FrameJogador(new Jogador("Jogador 1"));
		JPanel jogadorDois = new FrameJogador(new Jogador("Jogador 2"));
		JPanel campoJogadores = new JPanel();
		JPanel campoEntrada = new JPanel();
		//posiciona os campos
		ENTRADA_VALOR.setText("0");
		campoJogadores.setLayout(new BoxLayout(campoJogadores, BoxLayout.LINE_AXIS));
		campoEntrada.add(ENTRADA_VALOR);
		campoJogadores.add(jogadorUm);
		campoJogadores.add(jogadorDois);
		//limpa o painel e adiciona os jogadores
		painelAtivo = new JPanel();
		painelAtivo.setLayout(new BoxLayout(painelAtivo, BoxLayout.PAGE_AXIS));
		painelAtivo.add(campoJogadores);
		painelAtivo.add(campoEntrada);
		add(painelAtivo);
		revalidate();
		pack();
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
	public String acessarValor() {
		return ENTRADA_VALOR.getText();
	}
	public void colocarValor(String valor) {
		ENTRADA_VALOR.setText(valor);
		
		
	}
}
