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
	private final Long historico;
	private final Jogador jogador;
	private final JPanel titulo = new JPanel();
	private final JPanel pvEBotoes = new JPanel();
	private final JLabel displayNome;
	private final JLabel displayPV;
	private final JLabel displayHistorico;
	private final JTextField entradaValor;
	private final JButton adicionar = new JButton("< + >");
	private final JButton subtrair = new JButton("< - >");
	private final JButton desfazer = new JButton("Desfazer");

	public FrameJogador(Jogador jogador) {
		// carrega as informações do jogador
		this.jogador = jogador;
		nome = this.jogador.getNome();
		pontosVida = this.jogador.acessarVida();
		historico = this.jogador.mostrarHistorico();
		// inicia os displays
		displayNome = new JLabel(nome);
		displayPV = new JLabel(pontosVida.toString());
		displayHistorico = new JLabel(historico.toString());
		entradaValor = new JTextField();

		iniciarJanela();
	}

	public void actionPerformed(ActionEvent e) {
		if (! entradaValor.getText().matches(REGEX)) {
			return;
		}
		Long valor = Long.parseLong(entradaValor.getText());
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
		// adiciona botoes e pvs aos frames
		titulo.add(displayNome);
		titulo.add(displayPV);
		titulo.add(entradaValor);
		pvEBotoes.add(adicionar);
		pvEBotoes.add(subtrair);
		pvEBotoes.add(desfazer);
		// adiciona os frames
		add(titulo);
		add(pvEBotoes);
	}
	
}
