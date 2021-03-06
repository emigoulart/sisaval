package edu.infnet.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the turmaalunos database table.
 * 
 */
@Entity
@Table(name="turmaalunos")
public class TurmaAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TurmaAlunoPK id;

	//bi-directional many-to-one association to Avaliacao
	//@OneToMany(mappedBy="turmaaluno")
	//private List<Avaliacao> avaliacaos;

	@ManyToOne
	@JoinColumn(name="fk_turma", insertable=false, updatable=false)
	private Turma turma;
	
	@ManyToOne
	@JoinColumn(name="fk_aluno", insertable=false, updatable=false)
	private Usuario aluno;
	
	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public TurmaAluno() {
	}

	public TurmaAlunoPK getId() {
		return id;
	}

	public void setId(TurmaAlunoPK id) {
		this.id = id;
	}

/*	public List<Avaliacao> getAvaliacaos() {
		return avaliacaos;
	}

	public void setAvaliacaos(List<Avaliacao> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}*/

/*	public Avaliacao addAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().add(avaliacao);
		//avaliacao.setTurmaaluno(this);

		return avaliacao;
	}

	public Avaliacao removeAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().remove(avaliacao);
		//avaliacao.setTurmaaluno(null);
*/
	/*	return avaliacao;
	}
*/
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}