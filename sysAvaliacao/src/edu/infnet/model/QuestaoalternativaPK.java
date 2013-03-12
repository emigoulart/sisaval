package edu.infnet.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the questaoalternativas database table.
 * 
 */
@Embeddable
public class QuestaoalternativaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="fk_questao")
	private Integer fkQuestao;

	@Column(name="fk_alternativa")
	private Integer fkAlternativa;

	public QuestaoalternativaPK() {
	}
	public Integer getFkQuestao() {
		return this.fkQuestao;
	}
	public void setFkQuestao(Integer fkQuestao) {
		this.fkQuestao = fkQuestao;
	}
	public Integer getFkAlternativa() {
		return this.fkAlternativa;
	}
	public void setFkAlternativa(Integer fkAlternativa) {
		this.fkAlternativa = fkAlternativa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QuestaoalternativaPK)) {
			return false;
		}
		QuestaoalternativaPK castOther = (QuestaoalternativaPK)other;
		return 
			this.fkQuestao.equals(castOther.fkQuestao)
			&& this.fkAlternativa.equals(castOther.fkAlternativa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fkQuestao.hashCode();
		hash = hash * prime + this.fkAlternativa.hashCode();
		
		return hash;
	}
}