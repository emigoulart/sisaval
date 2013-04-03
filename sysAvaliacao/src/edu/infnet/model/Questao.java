package edu.infnet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;


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

	@Column(name="grupo_questao")
	private Integer grupoQuestao;

	@Transient
	private Integer resposta;

	@Transient
	private String tituloGrupo;

	public String getTituloGrupo() {

		if(getGrupoQuestao()!=null){
			//tituloGrupo=
			//GrupoQuestao.valueOf(getGrupoQuestao().toString()).toString();
		}
		return tituloGrupo;
	}

	public void setTituloGrupo(String tituloGrupo) {
		this.tituloGrupo = tituloGrupo;
	}

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

	public Questao() {
	}

	public Integer getQstId() {
		return qstId;
	}

	public void setQstId(Integer qstId) {
		this.qstId = qstId;
	}

	public String getQstQuestao() {
		return qstQuestao;
	}

	public void setQstQuestao(String qstQuestao) {
		this.qstQuestao = qstQuestao;
	}

	public List<Formulario> getFormularios() {
		return formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}

	public Integer getGrupoQuestao() {
		return grupoQuestao;
	}

	public void setGrupoQuestao(Integer grupoQuestao) {
		this.grupoQuestao = grupoQuestao;
	}

	public Integer getResposta() {
		return resposta;
	}

	public void setResposta(Integer resposta) {
		this.resposta = resposta;
	}

}