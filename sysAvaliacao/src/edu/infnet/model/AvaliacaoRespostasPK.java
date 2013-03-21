package edu.infnet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AvaliacaoRespostasPK implements Serializable {

	private static final long serialVersionUID = 7179798942474853515L;
	
	@Column(name="fk_avaliacao")
	private Integer fkAvaliacao;

	@Column(name="fk_questao")
	private Integer fkQuestao;
	
	public AvaliacaoRespostasPK(){
	}

	public Integer getFkAvaliacao() {
		return fkAvaliacao;
	}

	public void setFkAvaliacao(Integer fkAvaliacao) {
		this.fkAvaliacao = fkAvaliacao;
	}

	public Integer getFkQuestao() {
		return fkQuestao;
	}

	public void setFkQuestao(Integer fkQuestao) {
		this.fkQuestao = fkQuestao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fkAvaliacao == null) ? 0 : fkAvaliacao.hashCode());
		result = prime * result
				+ ((fkQuestao == null) ? 0 : fkQuestao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoRespostasPK other = (AvaliacaoRespostasPK) obj;
		if (fkAvaliacao == null) {
			if (other.fkAvaliacao != null)
				return false;
		} else if (!fkAvaliacao.equals(other.fkAvaliacao))
			return false;
		if (fkQuestao == null) {
			if (other.fkQuestao != null)
				return false;
		} else if (!fkQuestao.equals(other.fkQuestao))
			return false;
		return true;
	}

	
	


}
