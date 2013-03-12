package edu.infnet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the turma database table.
 * 
 */
@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tur_id")
	private Integer turId;

	@Column(name="fk_professor")
	private Integer fkProfessor;

	@Temporal(TemporalType.DATE)
	private Date prazofinal;

	@Temporal(TemporalType.DATE)
	private Date prazoinicial;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="fk_curso")
	private Curso curso;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="fk_disciplina")
	private Disciplina disciplina;

	//bi-directional many-to-one association to Formulario
	@ManyToOne
	@JoinColumn(name="fk_formulario")
	private Formulario formulario;

	//bi-directional many-to-one association to TurmaAluno
	@OneToMany(mappedBy="turma")
	private List<TurmaAluno> turmaalunos;

	public Turma() {
	}

	public Integer getTurId() {
		return turId;
	}

	public void setTurId(Integer turId) {
		this.turId = turId;
	}

	public Integer getFkProfessor() {
		return fkProfessor;
	}

	public void setFkProfessor(Integer fkProfessor) {
		this.fkProfessor = fkProfessor;
	}

	public Date getPrazofinal() {
		return prazofinal;
	}

	public void setPrazofinal(Date prazofinal) {
		this.prazofinal = prazofinal;
	}

	public Date getPrazoinicial() {
		return prazoinicial;
	}

	public void setPrazoinicial(Date prazoinicial) {
		this.prazoinicial = prazoinicial;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public List<TurmaAluno> getTurmaalunos() {
		return turmaalunos;
	}

	public void setTurmaalunos(List<TurmaAluno> turmaalunos) {
		this.turmaalunos = turmaalunos;
	}

	public TurmaAluno addTurmaaluno(TurmaAluno turmaaluno) {
		getTurmaalunos().add(turmaaluno);
		turmaaluno.setTurma(this);

		return turmaaluno;
	}

	public TurmaAluno removeTurmaaluno(TurmaAluno turmaaluno) {
		getTurmaalunos().remove(turmaaluno);
		turmaaluno.setTurma(null);

		return turmaaluno;
	}

}