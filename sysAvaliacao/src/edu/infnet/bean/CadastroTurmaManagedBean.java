package edu.infnet.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.log4j.Logger;

import edu.infnet.dao.AvalicaoDAOException;
import edu.infnet.dao.TurmaDAO;
import edu.infnet.model.Turma;
import edu.infnet.util.FacesUtils;

/**
 * Sistema de Avaliacão Online - INFNET
 * 
 * @author Aline Carlos
 * @author Eduardo dVargas
 * @author Emilene Goulart
 * @2013
 */

@ManagedBean(name="cadTurmaBean")
@SessionScoped
public class CadastroTurmaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(CadastroTurmaManagedBean.class);
	
	private Turma turma;
	
	private Turma turmaSelecionada;
	
	private DataModel<Turma> turmaLista;
	
	@ManagedProperty(value = "#{turmaDao}")
	private TurmaDAO turmaDAO;
	
	public CadastroTurmaManagedBean() {
		if(turma == null){
			turma = new Turma();
		}
		
		if(turmaSelecionada == null){
			turmaSelecionada = new Turma();
		}
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Turma getTurmaSelecionada() {
		return turmaSelecionada;
	}

	public void setTurmaSelecionada(Turma turmaSelecionada) {
		this.turmaSelecionada = turmaSelecionada;
	}

	public DataModel<Turma> getTurmaLista() {
		return turmaLista;
	}

	public void setTurmaLista(DataModel<Turma> turmaLista) {
		this.turmaLista = turmaLista;
	}

	public TurmaDAO getTurmaDAO() {
		return turmaDAO;
	}

	public void setTurmaDAO(TurmaDAO turmaDAO) {
		this.turmaDAO = turmaDAO;
	}
	
	public DataModel<Turma> getListarTurmas(){
		if (turmaLista == null){
			List<Turma> lista = getTurmaDAO().listar();
			turmaLista = new ListDataModel<Turma>(lista);
		}
		return turmaLista;
	}

	
	public void cadastrarTurma() throws AvalicaoDAOException {
		try {
			getTurmaDAO().inserir(turma);
			FacesUtils.mensInfo("Turma cadastrada com Sucesso.");
			turmaLista = null;
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}
	}
	
	
	public void prepararAlterarTruma(ActionEvent actionEvent) {
		turmaSelecionada = (Turma) (turmaLista.getRowData());
	}

	public void alterarTurma(ActionEvent actionEvent)
			throws AvalicaoDAOException {
		try {
			turmaDAO.atualizar(turmaSelecionada);
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}
	}

	public void prepararExcluirTurma(ActionEvent actionEvent) {
		turmaSelecionada = (Turma) (turmaLista.getRowData());
	}

	public void excluirTurma(ActionEvent actionEvent) {
		turmaDAO.excluir(turmaSelecionada);
		turmaLista = null;
	}	
	
}
