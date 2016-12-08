package edu.iss.caps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.caps.model.Loginrole;
import edu.iss.caps.repository.LoginroleRepository;

@Service
public class LoginroleServiceImpl implements LoginroleService{
	
	@Resource
	private LoginroleRepository lrepo;
	
	@Override
	@Transactional
	public ArrayList<Loginrole> findAllRoles() {
		ArrayList<Loginrole> rlist = (ArrayList<Loginrole>) lrepo.findAll();
		return rlist;
	}

	@Override
	@Transactional
	public Loginrole findOneById(int id) {
		Loginrole role = lrepo.findOneByRoleId(id);
		return role;
	}
	
}
