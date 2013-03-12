package edu.infnet.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the turmaalunos database table.
 * 
 */
@Embeddable
public class TurmaAlunoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="fk_turma")
	private Integer fkTurma;

	@Column(name="fk_aluno")
	private Integer fkAluno;

	public TurmaAlunoPK() {
	}
	public Integer getFkTurma() {
		return this.fkTurma;
	}
	public void setFkTurma(Integer fkTurma) {
		this.fkTurma = fkTurma;
	}
	public Integer getFkAluno() {
		return this.fkAluno;
	}
	public void setFkAluno(Integer fkAluno) {
		this.fkAluno = fkAluno;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TurmaAlunoPK)) {
			return false;
		}
		TurmaAlunoPK castOther = (TurmaAlunoPK)other;
		return 
			this.fkTurma.equals(castOther.fkTurma)
			&& this.fkAluno.equals(castOther.fkAluno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fkTurma.hashCode();
		hash = hash * prime + this.fkAluno.hashCode();
		
		return hash;
	}
}