package edu.infnet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.infnet.dao.AvaliacaoDAO;
import edu.infnet.dao.AvaliacaoDAOImpl;
import edu.infnet.model.Avaliacao;
import edu.infnet.model.Usuario;

@ManagedBean(name="avaliacaoBean")
@SessionScoped
public class AvaliacaoManagedBean implements Serializable {

	private static final long serialVersionUID = -4917267200847463255L;
	
	private Avaliacao avaliacao= new Avaliacao();

	private final AvaliacaoDAO dao = new AvaliacaoDAOImpl();

	private List<Avaliacao> lista = new ArrayList<Avaliacao>();
		
	public AvaliacaoManagedBean(){

		//setAvaliacao(new Avaliacao());
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
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
		setLista(dao.consultarAvaliacoesAluno(aluno));
		
	}
	
	public void responderQuestionario(){
		dao.incluirAvaliacao(avaliacao);
		
	}
	

}
