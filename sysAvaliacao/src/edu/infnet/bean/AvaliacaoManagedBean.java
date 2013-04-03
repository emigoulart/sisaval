package edu.infnet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.infnet.dao.AvaliacaoDAO;
import edu.infnet.model.Avaliacao;
import edu.infnet.model.AvaliacaoRespostas;
import edu.infnet.model.Formulario;
import edu.infnet.model.Questao;
import edu.infnet.model.Usuario;

@ManagedBean(name="avaliacaoBean")
@RequestScoped
public class AvaliacaoManagedBean implements Serializable {

	private static final long serialVersionUID = -4917267200847463255L;

	private Avaliacao avaliacao;

	@ManagedProperty( value = "#{avaliacaoDao}" )
	private  AvaliacaoDAO avaliacaoDao;

	private List<Avaliacao> lista ;

	private List<AvaliacaoRespostas> avaliacaoRespostas= new ArrayList<AvaliacaoRespostas>();

	public AvaliacaoManagedBean(){

	}


	private static Map<String,Object> questoesRespostas;
	static{
		questoesRespostas = new LinkedHashMap<String, Object>();
		questoesRespostas.put("Concordo Totalmente", "1");
		questoesRespostas.put("Concordo", "2");
		questoesRespostas.put("N�o Concordo nem Discordo", "3");
		questoesRespostas.put("Discordo", "4");
		questoesRespostas.put("Discordo Totalmente", "5");
		questoesRespostas.put("N�o sei Avaliar", "6");
	}

	public Map<String,Object> getPopulatedQuestoesResposta() {
		return questoesRespostas;
	}


	public void setAvaliacaoDao(AvaliacaoDAO avaliacaoDao) {
		this.avaliacaoDao = avaliacaoDao;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public Formulario formulario;

	public List<Questao> questoes;

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public AvaliacaoDAO getAvaliacaoDao() {
		return avaliacaoDao;
	}


	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Avaliacao> getLista() {
		return lista;
	}

	public void setLista(List<Avaliacao> lista) {
		this.lista = lista;
	}


	public void setAvaliacaoRespostas(List<AvaliacaoRespostas> avaliacaoRespostas) {
		this.avaliacaoRespostas = avaliacaoRespostas;
	}



	public List<AvaliacaoRespostas> getAvaliacaoRespostas() {
		return avaliacaoRespostas;
	}

	public void listarAvaliacoes(Usuario aluno){
		if(lista == null){
			lista = avaliacaoDao.consultarAvaliacoesAluno(aluno);
			for (int i=0;i<lista.size();i++){
				formulario=lista.get(i).getFormulario();
				setFormulario(formulario);
				if(formulario.getAvaliacaos().size()>0){
					setAvaliacao(formulario.getAvaliacaos().get(0));//TODO teste para pegar a primeira avaliacao
				}
			}
			setLista(lista);
		}
	}

	public void responderQuestionario(){
		avaliacaoDao.incluirAvaliacao(avaliacao);

	}


	public Map<String, Object> getQuestoesRespostas() {
		return questoesRespostas;
	}



}
