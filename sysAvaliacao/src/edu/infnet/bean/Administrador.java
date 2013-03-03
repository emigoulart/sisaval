package edu.infnet.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="admin")
@RequestScoped
public class Administrador extends Usuario{
	private Integer id;

	 	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	//colocar o metodo salvar.
	public void salvar(){
		endereco = "minha casa";
	}
	
	//<h:inputText value="#{admin.endereco}">
	//<h:commandButton actionListener="#{admin.salvar}"
}
