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
	@ManyToMany
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
	private List<Avaliacao> avaliacaos;

	public Questaoalternativa() {
	}

	public QuestaoalternativaPK getId() {
		return this.id;
	}

	public void setId(QuestaoalternativaPK id) {
		this.id = id;
	}

	public List<Avaliacao> getAvaliacaos() {
		return this.avaliacaos;
	}

	public void setAvaliacaos(List<Avaliacao> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}

}