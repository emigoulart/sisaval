package edu.infnet.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cur_id")
	private Integer curId;

	@Column(name="cur_descricao")
	private String curDescricao;

	@Column(name="cur_nome")
	private String curNome;

	@Column(name="cur_tipo")
	private String curTipo;

	//bi-directional many-to-one association to Turma
	@OneToMany(mappedBy="curso")
	private List<Turma> turmas;

	public Curso() {
	}

	public Integer getCurId() {
		return this.curId;
	}

	public void setCurId(Integer curId) {
		this.curId = curId;
	}

	public String getCurDescricao() {
		return this.curDescricao;
	}

	public void setCurDescricao(String curDescricao) {
		this.curDescricao = curDescricao;
	}

	public String getCurNome() {
		return this.curNome;
	}

	public void setCurNome(String curNome) {
		this.curNome = curNome;
	}

	public String getCurTipo() {
		return this.curTipo;
	}

	public void setCurTipo(String curTipo) {
		this.curTipo = curTipo;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setCurso(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setCurso(null);

		return turma;
	}

}