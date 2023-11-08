package Spring.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Spring.sms.entity.Student;
import Spring.sms.repository.StudentRepository;

@SpringBootApplication
public class app implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(app.class, args);
	}
	
	@Autowired
	private StudentRepository sturepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Student student1= new Student("cabbar", "kuyucu", "cabbabubba@gmail.com");
		sturepo.save(student1);
		
		Student student2= new Student("jamal", "ahham", "jamal@gmail.com");
		sturepo.save(student2);
		
		Student student3= new Student("tony", "stark", "tony@gmail.com");
		sturepo.save(student3);

	}

}
