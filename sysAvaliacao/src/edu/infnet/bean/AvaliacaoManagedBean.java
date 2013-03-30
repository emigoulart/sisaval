package edu.infnet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.infnet.dao.AvaliacaoDAO;
import edu.infnet.model.Avaliacao;
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

	private List<Avaliacao> lista = new ArrayList<Avaliacao>();

	public AvaliacaoManagedBean(){
		avaliacao= new Avaliacao();
		formulario= new Formulario();
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

	public void listarAvaliacoes(Usuario aluno){
		lista = avaliacaoDao.consultarAvaliacoesAluno(aluno);
		for (int i=0;i<lista.size();i++){
			formulario=lista.get(i).getFormulario();
			setFormulario(formulario);
			setQuestoes(formulario.getQuestoes());
		}
		setLista(lista);

	}

	public void responderQuestionario(){
		avaliacaoDao.incluirAvaliacao(avaliacao);

	}



}
