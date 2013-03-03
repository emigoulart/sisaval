package edu.infnet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import edu.infnet.dao.AvalicaoDAOException;


public class ConAvalicaoFactory {

	public static Connection abreConexao() throws AvalicaoDAOException{
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/dbAvaliacao", "postgres","postgres");
		} catch (Exception e) {
			throw new AvalicaoDAOException(e.getMessage()); 
		}
	}
	
	public static void fechaConexao(Connection conn, Statement stmt) throws AvalicaoDAOException {
		fecha(conn, stmt, null);
	}
	
	public static void fechaConexao(Connection conn) throws AvalicaoDAOException {
		fecha(conn, null, null);
	}
	
	public static void fechaConexao(Connection conn, Statement stmt, ResultSet rs) throws AvalicaoDAOException {
		fecha(conn, stmt, rs);
	}
	
	private static void fecha(Connection conn, Statement stmt, ResultSet rs) throws AvalicaoDAOException {  
        if (rs != null) {  
            try {  
                rs.close();  
            } catch (Exception e) {  
                throw new AvalicaoDAOException(e.getMessage());  
            }  
        }  
        if (stmt != null) {  
            try {  
                stmt.close();  
            } catch (Exception e) {  
            	throw new AvalicaoDAOException(e.getMessage()); 
            }  
        }  
        if (conn != null) {  
            try {  
                conn.close();  
            } catch (Exception e) {  
            	throw new AvalicaoDAOException(e.getMessage()); 
            }  
        }  
}  
}
