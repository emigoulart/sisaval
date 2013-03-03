package edu.infnet.dao;

public class AvalicaoDAOException extends Exception {
	

	private static final long serialVersionUID = 1L;

	public AvalicaoDAOException(){
		
	}

    public AvalicaoDAOException(String arg){
		super(arg);
	}
    
   public AvalicaoDAOException(Throwable arg){
	   super(arg);
   }

   public AvalicaoDAOException(String arg, Throwable arg1){
	   super(arg, arg1);
	}
}
