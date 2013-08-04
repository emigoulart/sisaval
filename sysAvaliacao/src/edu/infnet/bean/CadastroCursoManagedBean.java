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
import edu.infnet.dao.CursoDAO;
import edu.infnet.model.Curso;
import edu.infnet.util.FacesUtils;

/**
 * Sistema de Avaliacão Online - INFNET
 * 
 * @author Aline Carlos
 * @author Eduardo dVargas
 * @author Emilene Goulart
 */

@ManagedBean(name = "cadCursoBean")
@SessionScoped
public class CadastroCursoManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(CadastroCursoManagedBean.class);

	private DataModel<Curso> cursoLista;

	private Curso curso;

	private Curso cursoSelecionado;

	@ManagedProperty(value = "#{cursoDao}")
	private CursoDAO cursoDAO;

	public CadastroCursoManagedBean() {
		if (curso == null) {
			curso = new Curso();
		}

		if (cursoSelecionado == null) {
			cursoSelecionado = new Curso();
		}
	}

	public DataModel<Curso> getListarCursos() {
		if (cursoLista == null) {
			List<Curso> lista = getCursoDAO().listar();
			cursoLista = new ListDataModel<Curso>(lista);
		}
		return cursoLista;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public CursoDAO getCursoDAO() {
		return cursoDAO;
	}

	public void setCursoDAO(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	public Curso getCursoSelecionado() {
		return cursoSelecionado;
	}

	public void setCursoSelecionado(Curso cursoSelecionado) {
		this.cursoSelecionado = cursoSelecionado;
	}

	public void cadastrarCurso() throws AvalicaoDAOException {
		try {
			log.info(curso.getCurNome());
			getCursoDAO().inserir(curso);
			FacesUtils.mensInfo("Curso cadastrado com Sucesso.");
			cursoLista = null;
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}

	}

	public void prepararAlterarCurso(ActionEvent actionEvent) {
		cursoSelecionado = (Curso) (cursoLista.getRowData());
	}

	public void alterarCurso(ActionEvent actionEvent)
			throws AvalicaoDAOException {
		try {
			cursoDAO.atualizar(cursoSelecionado);
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}
	}

	public void prepararExcluirCurso(ActionEvent actionEvent) {
		cursoSelecionado = (Curso) (cursoLista.getRowData());
	}

	public void excluirCurso(ActionEvent actionEvent) {
		// log.info("Em Excluir curso: "+cursoSelecionado.getCurNome());
		cursoDAO.excluir(cursoSelecionado);
		cursoLista = null;
	}

}
