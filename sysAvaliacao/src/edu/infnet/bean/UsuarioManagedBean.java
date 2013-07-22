package edu.infnet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import edu.infnet.dao.AvaliacaoDAO;
import edu.infnet.dao.AvaliacaoDAOImpl;
import edu.infnet.dao.AvalicaoDAOException;
import edu.infnet.dao.UsuarioDAO;
import edu.infnet.dao.UsuarioDAOImpl;
import edu.infnet.model.Avaliacao;
import edu.infnet.model.Usuario;
import edu.infnet.util.FacesUtils;
import edu.infnet.util.TipoUsuario;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(UsuarioManagedBean.class);

	private Usuario usuario;

	@ManagedProperty(value = "#{usuarioDao}")
	private UsuarioDAO usuarioDao;

	private List<Usuario> lista = new ArrayList<Usuario>();

	public UsuarioManagedBean() {
		 usuario = new Usuario();
	}

	public String efetuarLogin() throws AvalicaoDAOException {

		String paginaRetorno = logout();

		try {
			usuario = getUsuarioDao().validarLogin(usuario);
		} catch (Exception exc) {
			//TODO
  			FacesUtils.mensErro("Erro inesperado"); 
			
		}

		if (usuario.getLogin()!= null) {
			if (usuario.getTipoUsuario().equalsIgnoreCase(
					TipoUsuario.ROLE_ADMIN.toString())) {
				paginaRetorno = "/paginas/cadastro/paginaAdmin";
			} else {
				listarAvaliacoes();
				paginaRetorno = "/paginas/avaliacao/listaFormularios";
			}

		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"", "Login ou senha inválidos"));
		}
		
		return paginaRetorno;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public void cadastrarUsuario() throws AvalicaoDAOException{
		try {
			usuario.setTipoUsuario(TipoUsuario.ROLE_ADMIN.toString());
			getUsuarioDao().inserir(usuario);
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}

		FacesUtils.mensInfo("Cadastro efetuado com Sucesso.");
		
	}
	
	public void alterarUsuario() throws AvalicaoDAOException{
		try {
			//TODO implementar ???
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}
	}
	
	public void excluirUsuario() throws AvalicaoDAOException{
		try {
			usuarioDao.excluir(usuario);
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}
	}
	
	public List<Usuario> getLista() {
		UsuarioDAOImpl udao = new UsuarioDAOImpl();
		try{
			lista = udao.todos();
		} catch (Exception e){
			Logger.getLogger(UsuarioManagedBean.class.getName()).log(Level.DEBUG, null, e);
		}
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public void listar()  {
		lista = usuarioDao.listar();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String logout() {
		return "/paginas/login/paginaLogin";
	}

	private Avaliacao avaliacao = new Avaliacao();

	private final AvaliacaoDAO daoAvaliacao = new AvaliacaoDAOImpl();

	private List<Avaliacao> listaAvaliacao = new ArrayList<Avaliacao>();

	public void listarAvaliacoes() {
		setListaAvaliacao(daoAvaliacao.consultarAvaliacoesAluno(usuario));

	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Avaliacao> getListaAvaliacao() {
		return listaAvaliacao;
	}

	public void setListaAvaliacao(List<Avaliacao> listaAvaliacao) {
		this.listaAvaliacao = listaAvaliacao;
	}

	public String toString() {
		return "UsuarioManagedBean [usuario=" + usuario + "]";
	}
	
	

}
