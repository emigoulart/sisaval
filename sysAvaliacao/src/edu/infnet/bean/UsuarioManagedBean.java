package edu.infnet.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import edu.infnet.dao.AvaliacaoDAO;
import edu.infnet.dao.AvaliacaoDAOImpl;
import edu.infnet.dao.AvalicaoDAOException;
import edu.infnet.dao.UsuarioDAO;
import edu.infnet.dao.UsuarioDAOImpl;
import edu.infnet.model.Avaliacao;
import edu.infnet.model.Usuario;
import edu.infnet.util.FacesUtils;
import edu.infnet.util.TipoUsuario;

//@RequestScoped
@SessionScoped
@ManagedBean(name="usuarioBean")
public class UsuarioManagedBean implements Serializable{

	private static final long serialVersionUID = -4350207791581637099L;
	private Usuario usuario;

	public UsuarioManagedBean() {
		usuario = new Usuario();
	} 

	@SuppressWarnings("unused")
	private boolean logado=false;


	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}


	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@ManagedProperty( value = "#{usuarioDao}" )
	private UsuarioDAO usuarioDao;

	private List<Usuario> lista = new ArrayList<Usuario>();


	public String efetuarLogin() throws AvalicaoDAOException  {

		String paginaRetorno = "falhou";// Retorna par a pagina falhou reparando
		// erro de login/senha incinsistentes
		try {
			usuario = getUsuarioDao().validarLogin(usuario);
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
				listarAvaliacoes();
				paginaRetorno = "/paginas/avaliacao/listaFormularios";
			}

		}
		return paginaRetorno;
	}


	public void cadastrarUsuario() throws AvalicaoDAOException{
		try{
			usuario.setTipoUsuario(TipoUsuario.ROLE_ALUNO.toString());
			getUsuarioDao().inserir(usuario);
		}catch(Exception exc ){
			throw new AvalicaoDAOException(exc);
		}

		FacesUtils.mensInfo("Cadastro efetuado com Sucesso.");
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public void listar()  {
		lista = usuarioDao.listar();
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
	
	private Avaliacao avaliacao= new Avaliacao();

	private final AvaliacaoDAO daoAvaliacao = new AvaliacaoDAOImpl();

	private List<Avaliacao> listaAvaliacao = new ArrayList<Avaliacao>();
	
	public void listarAvaliacoes(){
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

	
	
	
	
}
