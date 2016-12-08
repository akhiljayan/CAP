package edu.iss.caps.service;

import java.util.ArrayList;

import edu.iss.caps.model.Loginrole;

public interface LoginroleService {

	ArrayList<Loginrole> findAllRoles();
	
	Loginrole findOneById(int id);
	
}
