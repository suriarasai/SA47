package sg.iss.demo.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.demo.model.Lecturer;
import sg.iss.demo.repo.LecturerRepository;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Resource
	LecturerRepository lrepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#findAllLecturers()
	 */
	@Override
	@Transactional
	public ArrayList<Lecturer> findAllLecturers() {
		return (ArrayList<Lecturer>) lrepo.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#findLecturerById()
	 */
	@Override
	@Transactional
	public Lecturer findLecturerById(String lnric) {
		return lrepo.findById(lnric).get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#findLecturersByCriteria()
	 */
	@Override
	@Transactional
	public ArrayList<Lecturer> findLecturersByCriteria(Lecturer l) {
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#createLecturer(sg.iss.demo.model.
	 * Lecturer)
	 */
	@Override
	@Transactional
	public int createLecturer(Lecturer l) {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#updateLecturer(sg.iss.demo.model.
	 * Lecturer)
	 */
	@Override
	@Transactional
	public int updateLecturer(Lecturer l) {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#removeLecturer(sg.iss.demo.model.
	 * Lecturer)
	 */
	@Override
	@Transactional
	public int removeLecturer(Lecturer l) {
		return 0;
	}

}
