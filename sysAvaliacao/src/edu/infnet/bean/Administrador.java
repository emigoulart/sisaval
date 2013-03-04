package edu.infnet.bean;


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
