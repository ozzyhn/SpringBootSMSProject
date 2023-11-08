package Spring.sms.service;

import java.util.List;

import Spring.sms.entity.Student;

public interface StudentService {

	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentByıd(Long id);
		
}
