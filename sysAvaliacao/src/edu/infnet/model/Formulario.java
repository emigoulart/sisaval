package edu.infnet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


/**
 * The persistent class for the formulario database table.
 * 
 */
@Entity
public class Formulario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="frm_id")
	private Integer frmId;

	@Column(name="frm_nome")
	private String frmNome;

	private String observacao;

	//bi-directional many-to-one association to Avaliacao
	@OneToMany(mappedBy="formulario")
	private List<Avaliacao> avaliacaos;

	//bi-directional many-to-many association to Questao
	@ManyToMany(mappedBy="formularios")
	private List<Questao> questoes;

	//bi-directional many-to-one association to Turma
	@OneToMany(mappedBy="formulario")
	private List<Turma> turmas;

	public Formulario() {
	}

	public Integer getFrmId() {
		return frmId;
	}

	public void setFrmId(Integer frmId) {
		this.frmId = frmId;
	}

	public String getFrmNome() {
		return frmNome;
	}

	public void setFrmNome(String frmNome) {
		this.frmNome = frmNome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Avaliacao> getAvaliacaos() {
		return avaliacaos;
	}

	public void setAvaliacaos(List<Avaliacao> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}

	public Avaliacao addAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().add(avaliacao);
		avaliacao.setFormulario(this);

		return avaliacao;
	}

	public Avaliacao removeAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().remove(avaliacao);
		avaliacao.setFormulario(null);

		return avaliacao;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestaos(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setFormulario(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setFormulario(null);

		return turma;
	}

}