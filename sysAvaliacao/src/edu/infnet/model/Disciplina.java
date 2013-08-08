package edu.infnet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


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
	
	@ManyToOne
	@JoinColumn(name="fk_turma")
	private Turma turma;
	
	@Transient
	private boolean disponivel;
	
	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}


	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

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

}