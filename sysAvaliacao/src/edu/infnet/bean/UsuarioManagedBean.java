package edu.infnet.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.transaction.annotation.Transactional;

import edu.infnet.dao.AvalicaoDAOException;
import edu.infnet.dao.UsuarioDAO;
import edu.infnet.dao.UsuarioDAOImpl;
import edu.infnet.model.Usuario;
import edu.infnet.util.FacesUtils;
import edu.infnet.util.TipoUsuario;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable{

	private static final long serialVersionUID = -4350207791581637099L;
	private Usuario usuario;
	@SuppressWarnings("unused")
	private boolean logado;

	private final UsuarioDAO dao;

	private List<Usuario> lista = new ArrayList<Usuario>();


	public UsuarioManagedBean(){
		usuario = new Usuario();
		dao=  new UsuarioDAOImpl();
	}


	public String efetuarLogin() throws AvalicaoDAOException  {

		String paginaRetorno = "falhou";// Retorna par a pagina falhou reparando
		// erro de login/senha incinsistentes
		try {
			usuario = dao.validarLogin(usuario);
		} catch (Exception exc) {
			logado=false;
			throw new AvalicaoDAOException(exc);
		}

		if (usuario!=null) {
			logado=true;
			// return "sucesso"; //Retorna para a pagina de sucesso (Manutencção
			// dos cadastros)
			if (usuario.getTipoUsuario().equalsIgnoreCase(
					TipoUsuario.ROLE_ADMIN.toString())) {
				usuario= new Usuario();//
				paginaRetorno = "/paginas/cadastro/menuAdmin";
			} else {

				paginaRetorno = "/paginas/avaliacao/listaFormularios";
			}

		}
		return paginaRetorno;
	}

	@Transactional
	public void cadastrarUsuario() throws AvalicaoDAOException{
		try{
			usuario.setTipoUsuario(TipoUsuario.ROLE_ALUNO.toString());
			dao.inserir(usuario);
		}catch(Exception exc ){
			throw new AvalicaoDAOException(exc);
		}

		FacesUtils.mensInfo("Cadastro efetuado com Sucesso.");
	}

	public List<Usuario> getLista() {
		System.out.println("Listagem");
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		System.out.println("Listagem2");
		this.lista = lista;
	}


	public void listar()  {
		System.out.println("Listagem 3");
		lista = dao.listar();
	}


	public Usuario getUsuario(){
		return usuario;
	}

	public void setUsuario(Usuario usuario)	{
		this.usuario = usuario;
	}

	public String logout(){
		logado = false;
		return "paginaLogin";
	}
}
