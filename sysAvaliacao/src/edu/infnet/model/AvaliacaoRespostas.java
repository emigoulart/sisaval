package edu.infnet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="avaliacaorespostas")
public class AvaliacaoRespostas implements Serializable {

	private static final long serialVersionUID = -1381466399715449204L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="avl_resp_id",nullable=false)
	private Integer avlRespId;


	@ManyToOne
	@JoinColumn(name="fk_questao", referencedColumnName="qst_id")
	private Questao questao;

	@Column	(name="resposta")
	private Integer resposta;

	@ManyToOne
	@JoinColumn	(name="fk_avaliacao", referencedColumnName="avl_id")
	private Avaliacao avaliacao;

	public AvaliacaoRespostas(){
	}


	public Integer getAvlRespId() {
		return avlRespId;
	}


	public void setAvlRespId(Integer avlRespId) {
		this.avlRespId = avlRespId;
	}


	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}


	public Integer getResposta() {
		return resposta;
	}

	public void setResposta(Integer resposta) {
		this.resposta = resposta;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}






}
