package edu.infnet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import edu.infnet.dao.AvaliacaoDAO;
import edu.infnet.model.Avaliacao;
import edu.infnet.model.AvaliacaoRespostas;
import edu.infnet.model.Disciplina;
import edu.infnet.model.Questao;
import edu.infnet.model.Usuario;

/**
 * @author Emilene Goulart
 * @since 03/2012
 */

@ManagedBean(name="avaliacaoRespostasBean")
@RequestScoped
public class AvaliacaoRespostasManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;


	private Avaliacao avaliacao;

	@ManagedProperty( value = "#{avaliacaoDao}" )
	private  AvaliacaoDAO avaliacaoDao;

	private List<Avaliacao> lista ;

	private List<AvaliacaoRespostas> avaliacaoRespostas= new ArrayList<AvaliacaoRespostas>();
	
	@ManagedProperty("#{usuarioBean.usuario}") 
	private Usuario aluno;
	

	private Disciplina disciplina= new Disciplina();
	
	private DataModel<Avaliacao> listaAvaliacaoDisciplina;

 
	public AvaliacaoRespostasManagedBean(){

	}
	
	  public DataModel<Avaliacao> getListarDisciplinas() {
		  listaAvaliacaoDisciplina = new ListDataModel<Avaliacao>(lista);
	      return listaAvaliacaoDisciplina;
	    }

	private static Map<String,Object> questoesRespostas;
	
	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}


	static{
		questoesRespostas = new LinkedHashMap<String, Object>();
		questoesRespostas.put("Concordo Totalmente", "1");
		questoesRespostas.put("Concordo", "2");
		questoesRespostas.put("Não Concordo nem Discordo", "3");
		questoesRespostas.put("Discordo", "4");
		questoesRespostas.put("Discordo Totalmente", "5");
		questoesRespostas.put("Não sei Avaliar", "6");
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


	public List<Questao> questoes= new ArrayList<Questao>();

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}


	public AvaliacaoDAO getAvaliacaoDao() {
		return avaliacaoDao;
	}


	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Avaliacao> getLista() {
		listarAvaliacoes(aluno);
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
				setAvaliacao(lista.get(0));//TODO
				setAvaliacaoRespostas(avaliacao.getAvaliacaorespostas());
			}
			setLista(lista);
		}
	}
	
	

	public Map<String, Object> getQuestoesRespostas() {
		return questoesRespostas;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


}
