package br.com.api.sistema_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.api.sistema_login.model.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Long>{

	
	@Query("SELECT t FROM TaskModel t WHERE t.id = :id AND t.usuario.id = :usuarioId")
	TaskModel buscarPorIdEUsuario(@Param("id") Long id, @Param("usuarioId") Long usuarioId);

}