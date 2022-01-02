package main.java.calculator.jogo;

import java.util.ArrayList;

public class Jogador {
	private String nome;
	private Long pontosVidaAtuais;
	private ArrayList<Long> historico;
	
	public Jogador(String nome) {
		this.nome = nome;
		historico = new ArrayList<Long>();
		pontosVidaAtuais = 8000L;
		historico.add(pontosVidaAtuais);	
	}
	public void curar(Long valor) {
		pontosVidaAtuais = pontosVidaAtuais + valor;
		historico.add(pontosVidaAtuais);
	}
	public void dano(Long valor) {
		pontosVidaAtuais = pontosVidaAtuais - valor;
		historico.add(pontosVidaAtuais);
	}
	public void cortarMetade() {
		pontosVidaAtuais = pontosVidaAtuais / 2;
		historico.add(pontosVidaAtuais);
	}
	public void desfazer() {
		pontosVidaAtuais = historico.get(historico.size());
		historico.remove(historico.size());
	}
	public void limparHistorico() {
		historico.clear();		
	}
	public String mostrarHistorico() {
		return historico.get(historico.size()).toString();		
	}
	public long acessarVida() {
		return pontosVidaAtuais;		
	}

}
