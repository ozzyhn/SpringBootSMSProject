package Spring.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Spring.sms.entity.Student;
import Spring.sms.repository.StudentRepository;
import Spring.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	
	//Dependency İnjection
	@Autowired
	private StudentRepository repo;
	
	//Constructor cagırıp içine enject ettik parametre ınjection
	public StudentServiceImpl(StudentRepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public List<Student> getAllStudents() {
		
		//Bütün Studentleri listeler
		return repo.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		
		return repo.save(student);
	}


	@Override
	public Student updateStudent(Student student) {
		
		return repo.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		
		return repo.findById(id).get();
	}


	@Override
	public void deleteStudentByıd(Long id) {
		
		repo.deleteById(id);
		
		
	}
	
	
	
	

}
