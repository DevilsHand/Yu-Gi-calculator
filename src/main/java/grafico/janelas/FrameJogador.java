package main.java.grafico.janelas;

import static main.java.calculator.main.CONTROLADOR;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.tools.DiagnosticCollector;

import main.java.calculator.jogo.Jogador;

public class FrameJogador extends JPanel implements ActionListener {
	private static final String REGEX = "[0-9]+";
	private final String nome;
	private final Long pontosVida;
	private final Jogador jogador;
	private final JPanel titulo = new JPanel();
	private final JPanel pvEBotoes = new JPanel();
	private final JLabel displayNome;
	private final JLabel displayPV;
	private final JTextField entradaValor;
	private final JButton adicionar = new JButton("< + >");
	private final JButton subtrair = new JButton("< - >");
	private final JButton desfazer = new JButton("Desfazer");
	private JLabel displayHistorico;

	public FrameJogador(Jogador jogador) {
		// carrega as informações do jogador
		this.jogador = jogador;
		nome = this.jogador.getNome();
		pontosVida = this.jogador.acessarVida();
		// inicia os displays
		displayNome = new JLabel(nome);
		displayPV = new JLabel(pontosVida.toString());
		entradaValor = new JTextField();

		iniciarJanela();
	}

	public void actionPerformed(ActionEvent e) {
		if (! entradaValor.getText().matches(REGEX)) {
			return;// Não executa nada caso sejam inseridos caracteres que não sejam numeros
		}
		Long valor = Long.parseLong(entradaValor.getText());
		//Variavel só pq eu não gosto de colocar expressões
		switch (e.getActionCommand()) {
		case "soma":
			jogador.curar(valor);
			break;
		case "subtrair":
			jogador.dano(valor);
			break;
		case "Desfazer":
			jogador.desfazer();
			break;
		}
		entradaValor.setText("0");
		desfazer.setEnabled(jogador.checarHistorico());
		displayPV.setText(jogador.acessarVida().toString());
		revalidate();
		update(getGraphics());
	}

	public void iniciarJanela() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// adiciona os comandos aos botões
		adicionar.setActionCommand("soma");
		subtrair.setActionCommand("subtrair");
		desfazer.setActionCommand("Desfazer");
		adicionar.addActionListener(this);
		subtrair.addActionListener(this);
		desfazer.addActionListener(this);
		// seletor de posicionamento
		titulo.setLayout(new BoxLayout(titulo, BoxLayout.PAGE_AXIS));
		displayNome.setAlignmentX(CENTER_ALIGNMENT);
		displayPV.setAlignmentY(CENTER_ALIGNMENT);
		adicionar.setAlignmentX(LEFT_ALIGNMENT);
		subtrair.setAlignmentX(LEFT_ALIGNMENT);
		desfazer.setAlignmentX(CENTER_ALIGNMENT);
		entradaValor.setText("0");
		// adiciona botoes e pvs aos frames
		titulo.add(displayNome);
		titulo.add(displayPV);
		titulo.add(entradaValor);
		pvEBotoes.add(adicionar);
		pvEBotoes.add(subtrair);
		pvEBotoes.add(desfazer);
		desfazer.setEnabled(false);
		// adiciona os frames
		add(titulo);
		add(pvEBotoes);
	}
	
}
