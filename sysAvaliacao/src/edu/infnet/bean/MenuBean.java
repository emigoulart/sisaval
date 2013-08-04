package edu.infnet.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@ManagedBean(name = "menuBean")
@SessionScoped
public class MenuBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private MenuModel model;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioManagedBean usuarioBean;

	public MenuBean() {
		model = new DefaultMenuModel();

		// Menu Inicial
		Submenu submenu = new Submenu();
		submenu.setLabel("Administração");
		MenuItem item = new MenuItem();

		item = new MenuItem();
		item.setValue("Cadastrar Cursos");
		item.setUrl("../cadastro/listarCursos.xhtml");
		submenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Cadastrar Disciplinas");
		item.setUrl("../cadastro/listarDisciplinas.xhtml");
		submenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Listar Formularios");
		item.setUrl("../avaliacao/listaFormularios.xhtml");
		submenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Cadastrar Turmas");
		item.setUrl("../cadastro/listarTurmas.xhtml");
		submenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Cadastrar Usuarios");
		item.setUrl("../cadastro/listarUsuarios.xhtml");
		submenu.getChildren().add(item);

		model.addSubmenu(submenu);

		// Second submenu
		submenu = new Submenu();
		submenu.setLabel("Sistema");
		
		item = new MenuItem();
		item.setValue("Avaliar a Disciplina");
		item.setUrl("../avaliacao/avaliaDisciplina.xhtml");
		submenu.getChildren().add(item);
		
		item = new MenuItem();
		item.setValue("Exporta Dados");
		item.setUrl("../avaliacao/exportacao.xhtml");
		submenu.getChildren().add(item);
		
		item = new MenuItem();
		item.setValue("Logout");
		item.setUrl("../../");
		submenu.getChildren().add(item);

		model.addSubmenu(submenu);
	}

	public MenuModel getModel() {
		return model;
	}

	public void save() {
		addMessage("Salvo");
	}

	public void update() {
		addMessage("Alterado");
	}

	public void delete() {
		addMessage("Removido");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public UsuarioManagedBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioManagedBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}