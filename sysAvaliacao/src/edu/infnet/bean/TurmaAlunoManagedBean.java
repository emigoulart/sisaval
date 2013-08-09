package edu.infnet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import edu.infnet.dao.DisciplinaDAO;
import edu.infnet.dao.TurmaDAO;
import edu.infnet.model.Disciplina;
import edu.infnet.model.Turma;
import edu.infnet.model.Usuario;

/**
 * Sistema de Avaliacão Online - INFNET
 * 
 * @author Aline Carlos
 * @author Eduardo dVargas
 * @author Emilene Goulart
 * @2013
 */

@ManagedBean(name = "turmaAlunoBean")
@SessionScoped
public class TurmaAlunoManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Turma turma;

	private DataModel<Disciplina> listaDisciplina;
	
	private List<Disciplina> listaDisciplinaAluno= new ArrayList<Disciplina>();

	@ManagedProperty("#{usuarioBean.usuario}")
	private Usuario aluno;

	@ManagedProperty(value = "#{turmaDao}")
	private TurmaDAO turmaDAO;

	@ManagedProperty(value = "#{disciplinaDao}")
	private DisciplinaDAO disciplinaDAO;
	
	private Disciplina disciplinaEscolhida = new Disciplina();

	public TurmaAlunoManagedBean() {
		if (turma == null) {
			turma = new Turma();
		}
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplinaEscolhida() {
		return disciplinaEscolhida;
	}

	public void setDisciplinaEscolhida(Disciplina disciplinaEscolhida) {
		this.disciplinaEscolhida = disciplinaEscolhida;
	}

	public TurmaDAO getTurmaDAO() {
		return turmaDAO;
	}

	public void setTurmaDAO(TurmaDAO turmaDAO) {
		this.turmaDAO = turmaDAO;
	}

	public DataModel<Disciplina> getListarDisciplina() {
			listaDisciplinaAluno = getDisciplinaDAO().listarDisciplinasPorAluno(aluno);
			listaDisciplina = new ListDataModel<Disciplina>(
					listaDisciplinaAluno);
			if(listaDisciplinaAluno.get(0)!=null){
			setTurma(listaDisciplinaAluno.get(0).getTurma());
			}
		return listaDisciplina;
	}

	public DisciplinaDAO getDisciplinaDAO() {
		return disciplinaDAO;
	}

	public void setDisciplinaDAO(DisciplinaDAO disciplinaDAO) {
		this.disciplinaDAO = disciplinaDAO;
	}

	public void prepararDadosTurma(ActionEvent actionEvent) {
		this.disciplinaEscolhida = (Disciplina) (listaDisciplina.getRowData());
	}

}
