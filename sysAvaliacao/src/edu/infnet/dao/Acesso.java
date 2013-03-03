package edu.infnet.dao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "acesso")
@RequestScoped
public class Acesso {

	public String login() {
		return "paginas/login/paginaLogin";
	}
}
