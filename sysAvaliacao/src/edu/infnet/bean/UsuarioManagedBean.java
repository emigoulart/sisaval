package edu.infnet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.log4j.Logger;

import edu.infnet.dao.AvaliacaoDAO;
import edu.infnet.dao.AvaliacaoDAOImpl;
import edu.infnet.dao.AvalicaoDAOException;
import edu.infnet.dao.UsuarioDAO;
import edu.infnet.model.Avaliacao;
import edu.infnet.model.Usuario;
import edu.infnet.util.FacesUtils;
import edu.infnet.util.TipoUsuario;

/** Sistema de Avaliacão Online - INFNET
 * @author Aline Carlos
 * @author Eduardo dVargas
 * @author Emilene Goulart
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(UsuarioManagedBean.class);

	private Usuario usuario;
	
	private Usuario usuarioAlteracao= new Usuario();
		
	@ManagedProperty(value = "#{usuarioDao}")
	private UsuarioDAO usuarioDao;
	
	private DataModel<Usuario> listaUsuarios;

	public UsuarioManagedBean() {
		if (usuario == null) {
			usuario = new Usuario();
		}
	
	}
	
	  public DataModel<Usuario> getListarUsuarios() {
	        List<Usuario> lista = getUsuarioDao().listar();
	        listaUsuarios = new ListDataModel<Usuario>(lista);
	        return listaUsuarios;
	    }
	  
	  public void excluirUsuarios (ActionEvent actionEvent) {
		  	        Usuario usuarioTemp = (Usuario)(listaUsuarios.getRowData());
	        usuarioDao.excluir(usuarioTemp);
	 
	    }

	public String efetuarLogin() throws AvalicaoDAOException {

		String paginaRetorno = logout();

		try {
			usuario = getUsuarioDao().validarLogin(usuario);
		} catch (Exception exc) {
			log.error(exc);
  			FacesUtils.mensErro("Erro inesperado"); 
			
		}

		if (usuario.getTipoUsuario()!= null) {
			if (usuario.getTipoUsuario().equalsIgnoreCase(
					TipoUsuario.ROLE_ADMIN.toString())) {
				log.info("logado como ADMIN");
				paginaRetorno = "/paginas/cadastro/paginaAdmin";
			} else {
				log.info("logado como ALUNO");
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
	
	  public void prepararAlterarUsuario(ActionEvent actionEvent){
	        usuarioAlteracao = (Usuario)(listaUsuarios.getRowData());
	    }


	
	public void alterarUsuario(ActionEvent actionEvent) throws AvalicaoDAOException{
		try {
			usuarioDao.atualizar(usuarioAlteracao);
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

	public Usuario getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public String toString() {
		return "UsuarioManagedBean [usuario=" + usuario + "]";
	}

	
	

}
