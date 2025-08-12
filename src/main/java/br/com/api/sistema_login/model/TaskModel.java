package br.com.api.sistema_login.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class TaskModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private String responsavel;
	@Enumerated(EnumType.STRING)
	private StatusModel status;
	private LocalDate dataDeEntrega;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private UsuarioModel usuario;

	public TaskModel() {}

	public TaskModel(String titulo, String descricao, String responsavel, StatusModel  status, LocalDate dataDeEntrega,UsuarioModel usuario) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.responsavel = responsavel;
		this.status = status;
		this.dataDeEntrega = dataDeEntrega;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public StatusModel  getStatus() {
		return status;
	}

	public void setStatus(StatusModel status) {
		this.status = status;
	}

	public LocalDate getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(LocalDate dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "TaskModel [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", responsavel="
				+ responsavel + ", status=" + status + ", dataDeEntrega=" + dataDeEntrega + ", usuario=" + usuario
				+ "]";
	}
	
	
	
	
	
}