package edu.infnet.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import edu.infnet.dao.AvalicaoDAOException;
import edu.infnet.dao.DisciplinaDAO;
import edu.infnet.model.Disciplina;
import edu.infnet.util.FacesUtils;

@ManagedBean(name = "cadDisciplinaBean")
@SessionScoped
public class CadastroDisciplinaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private DataModel<Disciplina> disciplinaLista;

	private Disciplina disciplina;

	private Disciplina disciplinaSelecionada;

	@ManagedProperty(value = "#{disciplinaDao}")
	private DisciplinaDAO disciplinaDAO;

	public CadastroDisciplinaManagedBean() {
		if (disciplina== null) {
			disciplina = new Disciplina();
		}

		if (disciplinaSelecionada == null) {
			disciplinaSelecionada = new Disciplina();
		}
	}

	public DataModel<Disciplina> getListarDisciplinas() {
		if (disciplinaLista == null) {
			List<Disciplina> lista = getDisciplinaDAO().listar();
			disciplinaLista = new ListDataModel<Disciplina>(lista);
		}
		return disciplinaLista;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public DisciplinaDAO getDisciplinaDAO() {
		return disciplinaDAO;
	}

	public void setDisciplinaDAO(DisciplinaDAO disciplinaDAO) {
		this.disciplinaDAO = disciplinaDAO;
	}

	public Disciplina getDisciplinaSelecionada() {
		return disciplinaSelecionada;
	}

	public void setDisciplinaSelecionada(Disciplina disciplinaSelecionada) {
		this.disciplinaSelecionada = disciplinaSelecionada;
	}

	public void cadastrarDisciplina() throws AvalicaoDAOException {
		try {
			getDisciplinaDAO().inserir(disciplina);
			FacesUtils.mensInfo("Disciplina cadastrada com Sucesso.");
			disciplinaLista = null;
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}

	}

	public void prepararAlterarDisciplina(ActionEvent actionEvent) {
		disciplinaSelecionada = (Disciplina) (disciplinaLista.getRowData());
	}

	public void alterarDisciplina(ActionEvent actionEvent)
			throws AvalicaoDAOException {
		try {
			disciplinaDAO.atualizar(disciplinaSelecionada);
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}
	}

	public void prepararExcluirDisciplina(ActionEvent actionEvent) {
		disciplinaSelecionada = (Disciplina) (disciplinaLista.getRowData());
	}

	public void excluirDisciplina(ActionEvent actionEvent) {
		disciplinaDAO.excluir(disciplinaSelecionada);
		disciplinaLista = null;
	}

}