package edu.iss.caps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.caps.model.Loginrole;

public interface LoginroleRepository extends JpaRepository<Loginrole,Integer>{
	
	@Query("SELECT r FROM Loginrole r WHERE r.roleID=:id")
	Loginrole findOneByRoleId(@Param("id") Integer id);
	
}
