package edu.infnet.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="avaliacaorespostas")
public class AvaliacaoRespostas implements Serializable {

	private static final long serialVersionUID = -1381466399715449204L;
	
	@EmbeddedId
	private AvaliacaoRespostasPK id;
	
	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="fk_questao", referencedColumnName="fk_questao",  insertable=false, updatable=false),
		@JoinColumn(name="resposta", referencedColumnName="fk_alternativa",  insertable=false, updatable=false)})
	private Questaoalternativa alternativa;
	
	//@ManyToOne
	//@JoinColumn	(name="resposta", referencedColumnName="alt_id")
	//private Alternativa resposta;

	@ManyToOne
	@JoinColumn	(name="fk_avaliacao",  insertable=false, updatable=false)
	private Avaliacao avaliacao;
	
	public AvaliacaoRespostas(){
	}

	public AvaliacaoRespostasPK getId() {
		return id;
	}

	public void setId(AvaliacaoRespostasPK id) {
		this.id = id;
	}

/*	public Alternativa getResposta() {
		return resposta;
	}

	public void setResposta(Alternativa resposta) {
		this.resposta = resposta;
	}
*/
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Questaoalternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Questaoalternativa alternativa) {
		this.alternativa = alternativa;
	}
	
	

}
