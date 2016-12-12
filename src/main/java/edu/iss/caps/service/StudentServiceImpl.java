package edu.iss.caps.service;


import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.caps.model.Student;
import edu.iss.caps.model.User;
import edu.iss.caps.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentRepository studRepo;
	
	/* (non-Javadoc)
	 * @see edu.iss.cats.service.StudentService#findAllUsers()
	 */
	@Override
	@Transactional
	public ArrayList<Student> findAllStudents() {
		ArrayList<Student> sl = (ArrayList<Student>) studRepo.findAll();
		return sl;
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.cats.service.StudentService#findAllUsers()
	 */
	@Override
	@Transactional
	public ArrayList<Student> findStudentsBySearch(String value) {
		String val = value+'%';
		ArrayList<Student> sl = (ArrayList<Student>) studRepo.findSearch(val);
		return sl;
	}

	@Override
	@Transactional
	public Student createStudent(Student student) {
		return studRepo.saveAndFlush(student);
	}

	@Override
	@Transactional
	public Student findOneStudent(int id) {
		return studRepo.findOne(id);
	}

	@Override
	@Transactional
	public Student changeStudent(Student student) {
		return studRepo.saveAndFlush(student);
	}

	@Override
	@Transactional
	public void removeStudent(Student student) {
		studRepo.delete(student.getStudentID());
	}

	@Override
	@Transactional
	public Student findOneByUserId(User user) {
		Student stud = studRepo.findStudentByUserId(user);
		return stud;
	}
}
