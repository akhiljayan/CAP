package edu.iss.caps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.caps.model.Lecturer;
import edu.iss.caps.model.Student;
import edu.iss.caps.model.User;
import edu.iss.caps.repository.LecturerRepository;

@Service
public class LecturerServiceImpl implements LecturerService {
	
	@Resource
	private LecturerRepository lect;
	
	/* (non-Javadoc)
	 * @see edu.iss.caps.service.UserService#findAllUsers()
	 */
	@Override
	@Transactional
	public ArrayList<Lecturer> findAllLecturer() {
		ArrayList<Lecturer> llist = (ArrayList<Lecturer>) lect.findAll();
		return llist;
	}
	
	@Override
	@Transactional
	public Lecturer getCourseByLecturerID(int id) {
		Lecturer ulist =  lect.findOne(id);
		return ulist;
	}

	@Override
	@Transactional
	public Lecturer findOneByUserId(User user) {
		Lecturer lecturer = lect.findLecturerByUserId(user);
		return lecturer;
	}
	

}
