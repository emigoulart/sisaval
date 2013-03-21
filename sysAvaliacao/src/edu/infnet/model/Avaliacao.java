package edu.infnet.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the avaliacao database table.
 * 
 */
@Entity
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="avl_id")
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

	//bi-directional many-to-one association to TurmaAluno
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="fk_aluno", referencedColumnName="fk_aluno"),
		@JoinColumn(name="fk_turma", referencedColumnName="fk_turma")
		})
	private TurmaAluno turmaaluno;

	//bi-directional many-to-many association to Questaoalternativa
	//@ManyToMany(mappedBy="avaliacaos")
	//private List<Questaoalternativa> questaoalternativas;
	
	@OneToMany(mappedBy="avaliacao")
	private List<AvaliacaoRespostas> avaliacaorespostas;

	public Avaliacao() {
	}

	public Integer getAvlId() {
		return this.avlId;
	}

	public void setAvlId(Integer avlId) {
		this.avlId = avlId;
	}

	public Date getAvlDatafim() {
		return this.avlDatafim;
	}

	public void setAvlDatafim(Date avlDatafim) {
		this.avlDatafim = avlDatafim;
	}

	public Date getAvlDatainicio() {
		return this.avlDatainicio;
	}

	public void setAvlDatainicio(Date avlDatainicio) {
		this.avlDatainicio = avlDatainicio;
	}

	public String getAvlDisponivel() {
		return this.avlDisponivel;
	}

	public void setAvlDisponivel(String avlDisponivel) {
		this.avlDisponivel = avlDisponivel;
	}

	public String getAvlExportada() {
		return this.avlExportada;
	}

	public void setAvlExportada(String avlExportada) {
		this.avlExportada = avlExportada;
	}

	public String getAvlFechada() {
		return this.avlFechada;
	}

	public void setAvlFechada(String avlFechada) {
		this.avlFechada = avlFechada;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Formulario getFormulario() {
		return this.formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public TurmaAluno getTurmaaluno() {
		return this.turmaaluno;
	}

	public void setTurmaaluno(TurmaAluno turmaaluno) {
		this.turmaaluno = turmaaluno;
	}

/*	public List<Questaoalternativa> getQuestaoalternativas() {
		return this.questaoalternativas;
	}

	public void setQuestaoalternativas(List<Questaoalternativa> questaoalternativas) {
		this.questaoalternativas = questaoalternativas;
	}*/

	public List<AvaliacaoRespostas> getAvaliacaorespostas() {
		return avaliacaorespostas;
	}

	public void setAvaliacaorespostas(List<AvaliacaoRespostas> avaliacaorespostas) {
		this.avaliacaorespostas = avaliacaorespostas;
	}


}