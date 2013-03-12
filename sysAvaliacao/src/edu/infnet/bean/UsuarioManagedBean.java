package edu.infnet.bean;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.infnet.dao.AvalicaoDAOException;
import edu.infnet.dao.UsuarioDAO;
import edu.infnet.dao.UsuarioDAOImpl;
import edu.infnet.model.Usuario;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable{

	private static final long serialVersionUID = -4350207791581637099L;
	private Usuario usuario = new Usuario();

	private boolean logado;

	private final UsuarioDAO dao = new UsuarioDAOImpl();

	//private Usuario usuarioRetorno = new Usuario();

	//private final List<Usuario> lista = new ArrayList<Usuario>();

	//private List<Usuario> autoComplete = new ArrayList<Usuario>();

	public UsuarioManagedBean(){

		usuario = new Usuario();
	}


	public String efetuarLogin() throws AvalicaoDAOException  {
		System.out.println("Usuario: "+usuario); // Usado para debugar dentro do console.

		try{
			logado= dao.validarLogin(usuario);
		}
		catch(Exception exc){
			throw new AvalicaoDAOException(exc); //Retorna para paranina de Erro do Servidor (500)
		}

		if(logado) {
			return "sucesso"; //Retorna para a pagina de sucesso (Manutencção dos cadastros)
		}
		else {
			return "falhou"; // Retorna par a pagina falhou reporando erro de login/senha incinsistentes
		}
	}


	/*public void doLogin() throws SQLException, AvalicaoDAOException {
	  try {
			this.conn = ConAvalicaoFactory.abreConexao();
	  } catch (Exception e) {
			throw new AvalicaoDAOException("Erro: "+e.getMessage());
	  }

	  try{
		PreparedStatement paswdQuery = conn.prepareStatement("SELECT adm_senha FROM administrador WHERE adm_login=?");
		paswdQuery.setString(1, usuario.getLogin());

		System.out.println(paswdQuery);

		rs = paswdQuery.executeQuery();
		if(!rs.next()) return;
		String armazenaSenha = rs.getString("adm_senha");
		logado = usuario.getSenha().equals(armazenaSenha.trim());
		if(!logado) return;
	  } finally{
		  ConAvalicaoFactory.fechaConexao(conn, null, rs);
	  }
	}*/

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
