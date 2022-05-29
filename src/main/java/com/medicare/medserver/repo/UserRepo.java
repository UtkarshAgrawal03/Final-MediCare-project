package com.medicare.medserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medicare.medserver.modules.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.username=:username")
	public User findbyusername(@Param("username") String username);

}
