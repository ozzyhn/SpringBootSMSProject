package Spring.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import Spring.sms.entity.Student;
import Spring.sms.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	private StudentController(StudentService service) {
		super();
		this.service=service;
	}
	
	//exc handle 
	@GetMapping("/student")
	public String listStudents(Model model) {
		
		model.addAttribute("students", service.getAllStudents());
		
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("students", student);
		return "create_student";
		
	}
	//post atarken model attribute ile eşleme yapıyoruz
	@PostMapping("/students")
	public String SaveStudent(@ModelAttribute("student") Student student) {
		
		service.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("students", service.getStudentById(id));
		return "edit_student";
		
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student ,Model model) {
		
		
		//Stundentı databaseden ıd ye göre almak
		Student existingStudent= service.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save update student object
		service.updateStudent(existingStudent);
		
		return "redirect:/students";
		
	}
	
	// delete buttonun handler metodu
	@GetMapping("/students/{id}")
	public String DeleteStudent(@PathVariable Long id ) { 

		service.deleteStudentByıd(id);
		
		return "redirect/students";
		
		
	}
}
