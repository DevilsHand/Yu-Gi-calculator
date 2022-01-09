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
	}
	public void curar(Long valor) {
		if (valor == 0) {
			return;
		}
		historico.add(pontosVidaAtuais);
		pontosVidaAtuais = pontosVidaAtuais + valor;
	}
	public void dano(Long valor) {
		if (valor == 0) {
			return;
		}
		historico.add(pontosVidaAtuais);
		pontosVidaAtuais = pontosVidaAtuais - valor;
		
	}
	public void cortarMetade() {
		historico.add(pontosVidaAtuais);
		pontosVidaAtuais = pontosVidaAtuais / 2;
	}
	public void desfazer() {
		pontosVidaAtuais = historico.get(historico.size()-1);
		if(checarHistorico()) {
			historico.remove(historico.size()-1);	
		}
	}
	public void limparHistorico() {
		historico.clear();		
	}
	public Long mostrarHistorico() {
		return historico.get(historico.size()-1);		
	}
	public Long acessarVida() {
		return pontosVidaAtuais;		
	}
	public String getNome() {
		return this.nome;
	}
	public boolean checarHistorico() {
		return historico.size() >= 1;
		
	}

}
