package edu.infnet.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import edu.infnet.dao.AvalicaoDAOException;
import edu.infnet.dao.UsuarioDAO;
import edu.infnet.model.Avaliacao;
import edu.infnet.model.Usuario;
import edu.infnet.util.FacesUtils;


@ManagedBean(name = "cadastroBean")
@RequestScoped
public class CadastroUsuarioManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(CadastroUsuarioManagedBean.class);

	
	private Usuario novoUsuario;
	
	@ManagedProperty(value = "#{usuarioDao}")
	private UsuarioDAO usuarioDao;


	public CadastroUsuarioManagedBean() {
		
		if(novoUsuario == null){
			novoUsuario= new Usuario();
		}
	}
	
	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	
	public void cadastrarUsuario() throws AvalicaoDAOException{
		try {
			log.debug(novoUsuario.toString());
			System.out.println(novoUsuario.getNome());
			getUsuarioDao().inserir(novoUsuario);
			FacesUtils.mensInfo("Cadastro efetuado com Sucesso.");
		} catch (Exception exc) {
			throw new AvalicaoDAOException(exc);
		}
		
	}
	

	public Usuario getNovoUsuario() {
		return novoUsuario;
	}

	public void setNovoUsuario(Usuario novoUsuario) {
		this.novoUsuario = novoUsuario;
	}


	private Avaliacao avaliacao = new Avaliacao();


	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

}