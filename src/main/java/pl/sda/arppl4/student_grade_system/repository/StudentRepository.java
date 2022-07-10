package pl.sda.arppl4.student_grade_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arppl4.student_grade_system.model.Student;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
