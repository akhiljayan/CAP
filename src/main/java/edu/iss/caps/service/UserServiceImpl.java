package edu.iss.caps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.caps.model.User;
import edu.iss.caps.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see edu.iss.caps.service.UserService#findAllUsers()
	 */
	@Override
	@Transactional
	public ArrayList<User> findAllUsers() {
		ArrayList<User> ulist = (ArrayList<User>) userRepository.findAll();
		return ulist;
	}
	
	@Transactional
	public User findOneById(int id) {
		User u = userRepository.findUserById(id);
		return u;
	}
	
	@Transactional
	public User authenticate(String uname, String pwd) {
		User u = userRepository.findUserByNamePwd(uname, pwd);
		return u;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public User changeUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public void removeUser(User user) {
		userRepository.delete(user);
	}
}
