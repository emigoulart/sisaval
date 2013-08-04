package edu.infnet.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the disciplina database table.
 * 
 */
@Entity
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dis_id")
	private Integer disId;

	@Column(name="dis_descricao")
	private String disDescricao;

	@Column(name="dis_nome")
	private String disNome;

	@Temporal(TemporalType.DATE)
	private Date dis_dtainicio;

	@Temporal(TemporalType.DATE)
	private Date dis_dtatermino;
	
	//bi-directional many-to-one association to Turma
	@OneToMany(mappedBy="disciplina")
	private List<Turma> turmas;

	public Disciplina() {
	}

	public Integer getDisId() {
		return this.disId;
	}

	public void setDisId(Integer disId) {
		this.disId = disId;
	}

	public String getDisDescricao() {
		return this.disDescricao;
	}

	public void setDisDescricao(String disDescricao) {
		this.disDescricao = disDescricao;
	}

	public String getDisNome() {
		return this.disNome;
	}

	public void setDisNome(String disNome) {
		this.disNome = disNome;
	}

	
	public Date getDis_dtainicio() {
		return dis_dtainicio;
	}

	public void setDis_dtainicio(Date dis_dtainicio) {
		this.dis_dtainicio = dis_dtainicio;
	}

	public Date getDis_dtatermino() {
		return dis_dtatermino;
	}

	public void setDis_dtatermino(Date dis_dtatermino) {
		this.dis_dtatermino = dis_dtatermino;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setDisciplina(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setDisciplina(null);

		return turma;
	}

}