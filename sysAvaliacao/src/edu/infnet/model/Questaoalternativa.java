package edu.infnet.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the questaoalternativas database table.
 * 
 */
@Entity
@Table(name="questaoalternativas")
public class Questaoalternativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuestaoalternativaPK id;

	//bi-directional many-to-many association to Avaliacao
/*	@ManyToMany
	@JoinTable(
		name="avaliacaorespostas"
		, joinColumns={
			@JoinColumn(name="fk_questao", referencedColumnName="fk_questao"),
			@JoinColumn(name="resposta", referencedColumnName="fk_alternativa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fk_avaliacao")
			}
		)
	private List<Avaliacao> avaliacaos;*/

	@ManyToOne
	@JoinColumn(name="fk_questao", insertable=false, updatable=false)
	private Questao questao;	
	
	@ManyToOne
	@JoinColumn(name="fk_alternativa", insertable=false, updatable=false)
	private Alternativa alternativa;	
	
	
	@OneToMany
	@JoinTable(
		name="avaliacaorespostas"
		, joinColumns={
			@JoinColumn(name="fk_questao", referencedColumnName="fk_questao"),
			@JoinColumn(name="resposta", referencedColumnName="fk_alternativa")
			}
		
		)
	private List<AvaliacaoRespostas> avaliacaorespostas;

	public Questaoalternativa() {
	}

	public QuestaoalternativaPK getId() {
		return this.id;
	}

	public void setId(QuestaoalternativaPK id) {
		this.id = id;
	}

	public List<AvaliacaoRespostas> getAvaliacaoRespostas() {
		return this.avaliacaorespostas;
	}

	public void setAvaliacaos(List<AvaliacaoRespostas> avaliacaorespostas) {
		this.avaliacaorespostas = avaliacaorespostas;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}

	public List<AvaliacaoRespostas> getAvaliacaorespostas() {
		return avaliacaorespostas;
	}

	public void setAvaliacaorespostas(List<AvaliacaoRespostas> avaliacaorespostas) {
		this.avaliacaorespostas = avaliacaorespostas;
	}
	
	

}