package br.com.api.sistema_login.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "usuario")
@Entity(name = "Usuario")
public class UsuarioModel implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String email;
	private String senha;
	@Enumerated(EnumType.STRING)
	private UsuarioRole role;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TaskModel> task = new ArrayList<>();
	
	public UsuarioModel() {}
	
	
	
	public UsuarioModel(String email, String senha, UsuarioRole role, List<TaskModel> task) {
		this.email = email.toLowerCase();
		this.senha = senha;
		this.role = role;
		this.task = task;
	}
	
	public UsuarioModel(String email, String senha, List<TaskModel> task) {
		this.email = email.toLowerCase();
		this.senha = senha;
		this.task = task;
	}
	
	
	
	public UsuarioModel(String email, String senha, UsuarioRole role) {
		this.email = email.toLowerCase();
		this.senha = senha;
		this.role = role;
	}



	public UsuarioModel(String email, String senha) {
		this.email = email.toLowerCase();
		this.senha = senha;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		if(this.role == UsuarioRole.ADM) {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		}else {
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}
	
	@Override
	public String getPassword() {
	
		return this.senha;
	}
	@Override
	public String getUsername() {
	
		return this.email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsuarioRole getRole() {
		return role;
	}
	public void setRole(UsuarioRole role) {
		this.role = role;
	}
	public List<TaskModel> getTask() {
		return task;
	}
	public void setTask(List<TaskModel> task) {
		this.task = task;
	}
	public Long getId() {
		return id;
	}



	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", email=" + email + ", senha=" + senha + ", role=" + role
				+ "]";
	}
	
	
	
	
}
