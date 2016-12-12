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
	private LecturerRepository lecRepo;
	
	/* (non-Javadoc)
	 * @see edu.iss.caps.service.UserService#findAllUsers()
	 */
	@Override
	@Transactional
	public ArrayList<Lecturer> findAllLecturer() {
		ArrayList<Lecturer> llist = (ArrayList<Lecturer>) lecRepo.findAll();
		return llist;
	}
	
	@Override
	@Transactional
	public Lecturer getCourseByLecturerID(int id) {
		Lecturer ulist =  lecRepo.findOne(id);
		return ulist;
	}

	@Override
	@Transactional
	public Lecturer findOneByUserId(User user) {
		Lecturer lecturer = lecRepo.findLecturerByUserId(user);
		return lecturer;
	}

	@Override
	public Lecturer findOneByLectId(int id) {
		return lecRepo.findOne(id);
	}
	
	@Override
	@Transactional
	public ArrayList<Lecturer> findAllEmployedLecturers()
	{
		ArrayList<Lecturer> ul = (ArrayList<Lecturer>) lecRepo.findAllEmployedLecturers();
		return ul;
	}
	
	@Override
	@Transactional
	public ArrayList<Integer> findAllLecturerIDs()
	{
		ArrayList<Integer> ul = (ArrayList<Integer>) lecRepo.findAllLecturerIDs(); 
		return ul;
	}



	@Override
	@Transactional
	public Lecturer createLecturer(Lecturer lecturer) {
		return lecRepo.saveAndFlush(lecturer);
	}


	@Override
	public Lecturer findLecturer(int id) {
		return lecRepo.findOne(id);
	}


	@Override
	public Lecturer changeLecturer(Lecturer lecturer) {
		return lecRepo.saveAndFlush(lecturer);
	}
}
