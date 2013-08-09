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
import edu.infnet.dao.QuestaoDAO;
import edu.infnet.model.Questao;
import edu.infnet.util.FacesUtils;

/**
 * Sistema de Avaliacão Online - INFNET
 * 
 * @author Aline Carlos
 * @author Eduardo dVargas
 * @author Emilene Goulart
 */

@ManagedBean(name = "cadQuestaoBean")
@SessionScoped
public class CadastroQuestaoManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger
			.getLogger(CadastroCursoManagedBean.class);

	private DataModel<Questao> questaoLista;

	private Questao questao;

	private Questao questaoSelecionada;

	@ManagedProperty(value = "#{questaoDao}")
	private QuestaoDAO questaoDAO;

	public CadastroQuestaoManagedBean() {
		if (questao == null) {
			questao = new Questao();
		}

		if (questaoSelecionada == null) {
			questaoSelecionada = new Questao();
		}
	}

	// Carrega as questões do banco para o dataTable do form do crud
	public DataModel<Questao> getListarQuestoes() {
		if (questaoLista == null) {
			log.debug("Antes do List");
			List<Questao> lista = getQuestaoDAO().listar();
			log.debug("Depois do List");
			questaoLista = new ListDataModel<Questao>(lista);
		}
		return questaoLista;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Questao getQuestaoSelecionada() {
		return questaoSelecionada;
	}

	public void setQuestaoSelecionada(Questao questaoSelecionada) {
		this.questaoSelecionada = questaoSelecionada;
	}

	public QuestaoDAO getQuestaoDAO() {
		return questaoDAO;
	}

	public void setQuestaoDAO(QuestaoDAO questaoDAO) {
		this.questaoDAO = questaoDAO;
	}
	
	public void cadastrarQuestao() throws AvalicaoDAOException {
		try {
			log.info(questao.getQstQuestao());
			getQuestaoDAO().inserir(questao);
			FacesUtils.mensInfo("Questao cadastrada com Sucesso.");
			questaoLista = null;
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}

	}

	public void prepararAlterarQuestao(ActionEvent actionEvent) {
		questaoSelecionada = (Questao) (questaoLista.getRowData());
	}

	public void alterarQuestao(ActionEvent actionEvent)
			throws AvalicaoDAOException {
		try {
			questaoDAO.atualizar(questaoSelecionada);
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}
	}

	public void prepararExcluirQuestao(ActionEvent actionEvent) {
		questaoSelecionada = (Questao) (questaoLista.getRowData());
	}

	public void excluirQuestao(ActionEvent actionEvent) {
		// log.info("Em Excluir questao: "+questaoSelecionado.getCurNome());
		questaoDAO.excluir(questaoSelecionada);
		questaoLista = null;
	}

}
