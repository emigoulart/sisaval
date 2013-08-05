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
import edu.infnet.model.Formulario;
import edu.infnet.model.Questao;
import edu.infnet.model.Usuario;
import edu.infnet.util.EnviaAvaliacaoEmail;

/**
 * @author Emilene Goulart
 * @since 03/2012
 */

@ManagedBean(name = "avaliacaoBean")
@RequestScoped
public class AvaliacaoManagedBean implements Serializable {

	private static final long serialVersionUID = -4917267200847463255L;

	private Avaliacao avaliacao;

	@ManagedProperty(value = "#{avaliacaoDao}")
	private AvaliacaoDAO avaliacaoDao;

	private List<Avaliacao> lista;

	private List<AvaliacaoRespostas> avaliacaoRespostas = new ArrayList<AvaliacaoRespostas>();

	@ManagedProperty("#{usuarioBean.usuario}")
	private Usuario aluno;

	private Disciplina disciplina ;

	private DataModel<Avaliacao> listaAvaliacaoDisciplina;

	private static Map<String, Object> questoesRespostas;

	static {
		questoesRespostas = new LinkedHashMap<String, Object>();
		questoesRespostas.put("Concordo Totalmente", "1");
		questoesRespostas.put("Concordo", "2");
		questoesRespostas.put("N�o Concordo nem Discordo", "3");
		questoesRespostas.put("Discordo", "4");
		questoesRespostas.put("Discordo Totalmente", "5");
		questoesRespostas.put("N�o sei Avaliar", "6");
	}

	public Formulario formulario;

	public List<Questao> questoes = new ArrayList<Questao>();

	public AvaliacaoManagedBean() {
		if(disciplina == null){
		 disciplina= new Disciplina();
		}

	}

	public Usuario getAluno() {
		return aluno;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public AvaliacaoDAO getAvaliacaoDao() {
		return avaliacaoDao;
	}

	public boolean getAvaliacaoDisponivel() {
		boolean disponivel=false;
		Avaliacao avaliacaoDisciplina = avaliacaoDao
				.consultarAvaliacoesDisciplinaAluno(aluno, disciplina);
		if(avaliacaoDisciplina.getAvlDisponivel()!=null){
		disponivel= avaliacaoDisciplina.getAvlDisponivel().equalsIgnoreCase("S");
	  }
	   return disponivel;
	}

	public List<AvaliacaoRespostas> getAvaliacaoRespostas() {
		return avaliacaoRespostas;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public List<Avaliacao> getLista() {
		listarAvaliacoes(aluno);
		return lista;
	}

	public DataModel<Avaliacao> getListarDisciplinas() {
		//lista = avaliacaoDao.consultarAvaliacoesAluno(aluno);
		listaAvaliacaoDisciplina = new ListDataModel<Avaliacao>(getLista());
		return listaAvaliacaoDisciplina;
	}

	public Map<String, Object> getPopulatedQuestoesResposta() {
		return questoesRespostas;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public Map<String, Object> getQuestoesRespostas() {
		return questoesRespostas;
	}
	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setAvaliacaoDao(AvaliacaoDAO avaliacaoDao) {
		this.avaliacaoDao = avaliacaoDao;
	}

	public void setAvaliacaoRespostas(
			List<AvaliacaoRespostas> avaliacaoRespostas) {
		this.avaliacaoRespostas = avaliacaoRespostas;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public void setLista(List<Avaliacao> lista) {
		this.lista = lista;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	private void incluiAvaliacaoRespostas(Avaliacao avaliacao) {
		for (int i = 0; i < formulario.getQuestoes().size(); i++) {
			AvaliacaoRespostas avaliacaoResposta = new AvaliacaoRespostas();
			Questao questao = formulario.getQuestoes().get(i);
			avaliacaoResposta.setQuestao(questao);
			avaliacaoResposta.setResposta(questao.getResposta());
			avaliacaoResposta.setAvaliacao(avaliacao);
			avaliacaoRespostas.add(avaliacaoResposta);

		}
		avaliacao.setAvaliacaorespostas(avaliacaoRespostas);
	}

	public void listarAvaliacoes(Usuario aluno) {
		if (lista == null) {
			lista = avaliacaoDao.consultarAvaliacoesAluno(aluno);
			for (int i = 0; i < lista.size(); i++) {
				formulario = lista.get(i).getFormulario();
				setFormulario(formulario);
				setAvaliacao(lista.get(0));// TODO
				setQuestoes(formulario.getQuestoes());
			}
			setLista(lista);
		}
	}

	public void prepararConsultaDisciplina(ActionEvent actionEvent) {
		disciplina = (Disciplina) (listaAvaliacaoDisciplina.getRowData()
				.getTurmaaluno().getTurma().getDisciplina());
		setDisciplina(disciplina);
		
	}

	public String responderQuestionario() {
		incluiAvaliacaoRespostas(avaliacao);
		if (avaliacaoDao.incluirAvaliacao(avaliacao)) {
			EnviaAvaliacaoEmail ee= new EnviaAvaliacaoEmail();
			try{
				ee.sendEmail(avaliacao);
			} catch (Exception e){
				e.printStackTrace();
			}
			return "sucesso";
		}
		return "falhou";
	}


}
