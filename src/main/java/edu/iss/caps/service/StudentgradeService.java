package edu.iss.caps.service;

import java.util.ArrayList;

import edu.iss.caps.model.Studentgrade;

public interface StudentgradeService {

	ArrayList<Studentgrade> findGradeBySid(int studentID);
	
}
