package edu.infnet.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the questao database table.
 * 
 */
@Entity
public class Questao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="qst_id")
	private Integer qstId;

	@Column(name="qst_questao")
	private String qstQuestao;

	//bi-directional many-to-many association to Formulario
	@ManyToMany
	@JoinTable(
		name="formularioquestoes"
		, joinColumns={
			@JoinColumn(name="fk_questao")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fk_formulario")
			}
		)
	private List<Formulario> formularios;

	//bi-directional many-to-many association to Alternativa
	@ManyToMany
	@JoinTable(
		name="questaoalternativas"
		, joinColumns={
			@JoinColumn(name="fk_questao")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fk_alternativa")
			}
		)
	private List<Alternativa> alternativas;

	public Questao() {
	}

	public Integer getQstId() {
		return this.qstId;
	}

	public void setQstId(Integer qstId) {
		this.qstId = qstId;
	}

	public String getQstQuestao() {
		return this.qstQuestao;
	}

	public void setQstQuestao(String qstQuestao) {
		this.qstQuestao = qstQuestao;
	}

	public List<Formulario> getFormularios() {
		return this.formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}

	public List<Alternativa> getAlternativas() {
		return this.alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

}