package com.cristian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cristian.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select t from User t where t.username = :username")
	User findByUsername(@Param("username") String username);

}
