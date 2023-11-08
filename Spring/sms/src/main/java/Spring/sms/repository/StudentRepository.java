package Spring.sms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Spring.sms.entity.Student;

// primarey key değerimiz Long o yüzden Student sınıfı OBJESİ ve long Türünde
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
