package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	    
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END " +
		       "FROM User u WHERE u.username = :username AND u.password = :password")
		boolean existsByUsernameAndPassword(@Param("username") String username,
		                                    @Param("password") String password);

	}

