package edu.infnet.util;

public enum TipoUsuario {
	//1 Administrador, 2 Aluno, 3 Professor
	ROLE_ADMIN("1"), ROLE_ALUNO("2"), ROLE_PROFESSOR("3");
	private String tipoUsuario;

	TipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return tipoUsuario;
	}

}
