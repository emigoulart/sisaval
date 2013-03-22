package edu.infnet.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@ManagedBean(name="menuBean")
public class MenuBean {

	private MenuModel model;

	public MenuBean() {
		model = new DefaultMenuModel();

		// Menu Inicial
		Submenu submenu = new Submenu();
		submenu.setLabel("Adminitração");

		MenuItem item = new MenuItem();
		item.setValue("Cadastra Usuarios");
		item.setUrl("../cadastro/cadastrarUsuario.jsf");
		submenu.getChildren().add(item);
		
		item = new MenuItem();
		item.setValue("Lista Formularios");
		item.setUrl("../avaliacao/listaFormularios.jsf");
		submenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Avalia a Disciplina");
		item.setUrl("../avaliacao/avaliaDisciplina.jsf");
		submenu.getChildren().add(item);
		
		model.addSubmenu(submenu);

		// Second submenu
        submenu = new Submenu();
		submenu.setLabel("Sistema");

		item = new MenuItem();
		item.setValue("Logout");
		item.setUrl("../../");
		submenu.getChildren().add(item);

//		item = new MenuItem();
//		item.setValue("Dynamic Menuitem 2.2");
//		item.setUrl("#");
//		submenu.getChildren().add(item);

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
}