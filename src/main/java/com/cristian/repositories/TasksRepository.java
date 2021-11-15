package com.cristian.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cristian.model.Task;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {
	
	@Query("select t from Task t where t.username = :username")
	List<Task> findAllByUsername(@Param("username") String username);
	
	@Query("select t from Task t where t.username = :username and t.id = :id")
	int deleteByUsernameAndId(@Param("id") Long id, @Param("username") String username);

}
