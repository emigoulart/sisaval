package edu.infnet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the avaliacao database table.
 * 
 */
@Entity
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="avl_id",nullable=false)
	private Integer avlId;

	@Temporal(TemporalType.DATE)
	@Column(name="avl_datafim")
	private Date avlDatafim;

	@Temporal(TemporalType.DATE)
	@Column(name="avl_datainicio")
	private Date avlDatainicio;

	@Column(name="avl_disponivel")
	private String avlDisponivel;

	@Column(name="avl_exportada")
	private String avlExportada;

	@Column(name="avl_fechada")
	private String avlFechada;

	private String observacao;

	//bi-directional many-to-one association to Formulario
	@ManyToOne
	@JoinColumn(name="fk_formulario")
	private Formulario formulario;
	
	@ManyToOne
	@JoinColumn(name="fk_disciplina",nullable=false)
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name="fk_aluno",nullable=false)
	private Usuario aluno;
	
	@ManyToOne
	@JoinColumn(name="fk_turma",nullable=false)
	private Turma turma;

	@OneToMany(mappedBy="avaliacao", cascade = CascadeType.ALL)
	private List<AvaliacaoRespostas> avaliacaorespostas;

	public Avaliacao() {
	}

	public Integer getAvlId() {
		return avlId;
	}

	public void setAvlId(Integer avlId) {
		this.avlId = avlId;
	}

	public Date getAvlDatafim() {
		return avlDatafim;
	}

	public void setAvlDatafim(Date avlDatafim) {
		this.avlDatafim = avlDatafim;
	}

	public Date getAvlDatainicio() {
		return avlDatainicio;
	}

	public void setAvlDatainicio(Date avlDatainicio) {
		this.avlDatainicio = avlDatainicio;
	}

	public String getAvlDisponivel() {
		return avlDisponivel;
	}

	public void setAvlDisponivel(String avlDisponivel) {
		this.avlDisponivel = avlDisponivel;
	}

	public String getAvlExportada() {
		return avlExportada;
	}

	public void setAvlExportada(String avlExportada) {
		this.avlExportada = avlExportada;
	}

	public String getAvlFechada() {
		return avlFechada;
	}

	public void setAvlFechada(String avlFechada) {
		this.avlFechada = avlFechada;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}


	public List<AvaliacaoRespostas> getAvaliacaorespostas() {
		return avaliacaorespostas;
	}

	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setAvaliacaorespostas(List<AvaliacaoRespostas> avaliacaorespostas) {
		this.avaliacaorespostas = avaliacaorespostas;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


}