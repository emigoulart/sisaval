package edu.infnet.bean;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.infnet.dao.AvalicaoDAOException;
import edu.infnet.util.ConAvalicaoFactory;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable{
	
	private static final long serialVersionUID = -4350207791581637099L;
	private Connection conn;
	private ResultSet rs; 
	private Usuario usuario;
	private boolean logado;

	public UsuarioManagedBean(){
		
		usuario = new Usuario();
	}
	
	public String efetuarLogin() throws AvalicaoDAOException {
		System.out.println("Usuario: "+usuario); // Usado para debugar dentro do console.
	
		try{
			doLogin();
		}
		 catch(SQLException sqle){
			 return "ErroInterno"; //Retorna para paranina de Erro do Servidor (500)
		 }
				
		if(logado)
			return "sucesso"; //Retorna para a pagina de sucesso (Manutencção dos cadastros)
		else
			return "falhou"; // Retorna par a pagina falhou reporando erro de login/senha incinsistentes	
	}
	
	public void doLogin() throws SQLException, AvalicaoDAOException {
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
