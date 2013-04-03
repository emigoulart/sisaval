package edu.infnet.util;

public enum GrupoQuestao {
	//1 Geral, 2 Professor, 3 Infraestrutura
	GERAL(1) ,PROFESSOR(2), INFRA(3);
	private Integer grupoAvaliacao;

	GrupoQuestao(Integer grupoAvaliacao) {
		this.grupoAvaliacao= grupoAvaliacao;
	}

	public Integer getGrupoAvaliacao() {
		return grupoAvaliacao;
	}

	public void setGrupoAvaliacao(Integer grupoAvaliacao) {
		this.grupoAvaliacao = grupoAvaliacao;
	}

	@Override
	public String toString() {
		String retorno="";
		if(getGrupoAvaliacao().equals("1")){
			retorno= "Avaliação geral da Pós-Graduação";
		}if(getGrupoAvaliacao().equals("2")){
			retorno= "Avaliação do professor no módulo";
		}

		return retorno;
	}


}
