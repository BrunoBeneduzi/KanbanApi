package br.com.api.sistema_login.model;

public enum UsuarioRole {

	ADM("adm"), 
	COLABORADOR("colaborador");
	
	
	private String role;
	
	UsuarioRole(String role) {
		this.role = role;	
	}
	
	public String getRole() {
		return role;
	}
	
}