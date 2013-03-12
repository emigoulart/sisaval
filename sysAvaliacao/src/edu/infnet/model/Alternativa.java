package edu.infnet.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the alternativa database table.
 * 
 */
@Entity
public class Alternativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="alt_id")
	private Integer altId;

	@Column(name="alt_alternativa")
	private String altAlternativa;

	//bi-directional many-to-many association to Questao
	@ManyToMany(mappedBy="alternativas")
	private List<Questao> questaos;

	public Alternativa() {
	}

	public Integer getAltId() {
		return this.altId;
	}

	public void setAltId(Integer altId) {
		this.altId = altId;
	}

	public String getAltAlternativa() {
		return this.altAlternativa;
	}

	public void setAltAlternativa(String altAlternativa) {
		this.altAlternativa = altAlternativa;
	}

	public List<Questao> getQuestaos() {
		return this.questaos;
	}

	public void setQuestaos(List<Questao> questaos) {
		this.questaos = questaos;
	}

}